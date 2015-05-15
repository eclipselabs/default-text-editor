/*******************************************************************************
 * Copyright (c) 2015 Kaloyan Raev.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Kaloyan Raev - initial API and implementation
 *******************************************************************************/
package org.eclipselabs.dte;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;

import org.apache.commons.io.FilenameUtils;
import org.eclipse.ui.IURIEditorInput;

import com.ibm.icu.text.CharsetDetector;
import com.ibm.icu.text.CharsetMatch;

/**
 * Utility class for detecting if file is text or binary.
 */
public class TextFileDetector {

    /**
     * Checks if a file is text or binary.
     * 
     * <p>
     * This method will first check if the file extension is known to be for a
     * binary or a text-based file. If the file extension is unknown then it
     * will try to analyze the file content.
     * </p>
     * 
     * @param input
     *            an editor input of the file
     * @return <code>true</code> if the file is more likely to be text file than
     *         binary file, <code>false</code> otherwise.
     */
    public static boolean isTextFile(IURIEditorInput input) {
        if (input == null)
            return false;

        String extension = FilenameUtils.getExtension(input.getName())
                .toUpperCase();

        if (KnownTextBasedFileExtensions.set().contains(extension))
            return true;

        if (KnownBinaryFileExtensions.set().contains(extension))
            return false;

        URI uri = input.getURI();
        if (uri != null) {
            InputStream is = null;
            try {
                is = uri.toURL().openStream();
                return TextFileDetector.isTextFile(is);
            } catch (IOException e) {
                // Problem reading the editor input - avoid overriding
            } finally {
                // Make sure the input stream is closed
                close(is);
            }
        }

        return false;
    }

    /**
     * Checks if a file is text or binary.
     * 
     * <p>
     * This method will first check if the file extension is known to be for a
     * binary or a text-based file. If the file extension is unknown then it
     * will try to analyze the file content.
     * </p>
     * 
     * @param fileName
     *            a file name
     * @return <code>true</code> if the file is more likely to be text file than
     *         binary file, <code>false</code> otherwise.
     */
    public static boolean isTextFile(String fileName) {
        if (fileName == null)
            return false;

        String extension = FilenameUtils.getExtension(fileName).toUpperCase();

        if (KnownTextBasedFileExtensions.set().contains(extension))
            return true;

        if (KnownBinaryFileExtensions.set().contains(extension))
            return false;

        BufferedInputStream is = null;
        try {
            is = new BufferedInputStream(new FileInputStream(fileName));
            return isTextFile(is);
        } catch (IOException e) {
            // Problem reading the editor input - avoid overriding
        } finally {
            // Make sure the input streams are closed
            close(is);
        }

        return false;
    }

    /**
     * Checks if a file is text or binary.
     * 
     * <p>
     * The provided input stream will not be closed and the position in the
     * stream will be unchanged after leaving this method.
     * </p>
     * 
     * @param is
     *            input stream of the file
     * @return <code>true</code> if the file is more likely to be text file than
     *         binary file, <code>false</code> otherwise.
     * @throws IOException
     *             in case of error while reading from the stream
     */
    public static boolean isTextFile(InputStream is) throws IOException {
        if (is == null)
            return false;

        CharsetDetector detector = new CharsetDetector();
        detector.setText(is);
        CharsetMatch match = detector.detect();

        // The file is text if a charset with confidence of at least 10 (out
        // of 100) is detected. Empty files have confidence 10 for UTF-8.
        return match.getConfidence() >= 10;
    }


    /**
     * Closes the input stream.
     * 
     * @param is
     *            an input stream.
     */
    private static void close(InputStream is) {
        if (is != null) {
            try {
                is.close();
            } catch (IOException e) {
                // Error closing the file input stream - ignore it
            }
        }
    }
}
