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

import java.io.IOException;
import java.io.InputStream;

import com.ibm.icu.text.CharsetDetector;
import com.ibm.icu.text.CharsetMatch;

public class TextFileDetector {

    /**
     * Checks if a file is text or binary.
     * 
     * @param is
     *            input stream of the file
     * @return <code>true</code> if the file is more likely to be text file than
     *         binary file, <code>false</code> otherwise.
     * @throws IOException
     */
    public static boolean isTextFile(InputStream is) throws IOException {
        CharsetDetector detector = new CharsetDetector();
        detector.setText(is);
        CharsetMatch match = detector.detect();

        // The file is text if a charset with confidence of at least 10 (out
        // of 100) is detected. Empty files have confidence 10 for UTF-8.
        return match.getConfidence() >= 10;
    }

}
