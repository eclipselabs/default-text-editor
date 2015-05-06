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

import static org.eclipse.ui.editors.text.EditorsUI.DEFAULT_TEXT_EDITOR_ID;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;

import org.eclipse.core.runtime.content.IContentType;
import org.eclipse.ui.IEditorDescriptor;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IURIEditorInput;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IEditorAssociationOverride;

/**
 * Overrides the default editor of text files, which have no editor association,
 * with the default text editor. This way it is avoided to open text files with
 * the system editor outside of the IDE.
 */
public class EditorAssociationOverride implements IEditorAssociationOverride {

    public IEditorDescriptor[] overrideEditors(IEditorInput editorInput,
            IContentType contentType, IEditorDescriptor[] editorDescriptors) {
        return editorDescriptors;
    }

    public IEditorDescriptor[] overrideEditors(String fileName,
            IContentType contentType, IEditorDescriptor[] editorDescriptors) {
        return editorDescriptors;
    }

    public IEditorDescriptor overrideDefaultEditor(IEditorInput editorInput,
            IContentType contentType, IEditorDescriptor editorDescriptor) {
        // Override with default text editor only if no association is found yet
        if (editorDescriptor == null) {
            IURIEditorInput uriEditorInput = (IURIEditorInput) editorInput;
            URI uri = uriEditorInput.getURI();
            if (uri != null) {
                InputStream is = null;
                try {
                    is = uri.toURL().openStream();
                    if (TextFileDetector.isTextFile(is)) {
                        return getTextEditorDescriptor();
                    }
                } catch (IOException e) {
                    // Problem reading the editor input - avoid overriding
                } finally {
                    // Make sure the input stream is closed
                    close(is);
                }
            }
        }
        return editorDescriptor;
    }

    public IEditorDescriptor overrideDefaultEditor(String fileName,
            IContentType contentType, IEditorDescriptor editorDescriptor) {
        // Override with default text editor only if no association is found yet
        if (editorDescriptor == null) {
            FileInputStream fis = null;
            try {
                fis = new FileInputStream(fileName);
                if (TextFileDetector.isTextFile(fis)) {
                    return getTextEditorDescriptor();
                }
            } catch (IOException e) {
                // Problem reading the editor input - avoid overriding
            } finally {
                // Make sure the file input stream is closed
                close(fis);
            }
        }
        return editorDescriptor;
    }

    private IEditorDescriptor getTextEditorDescriptor() {
        return PlatformUI.getWorkbench().getEditorRegistry()
                .findEditor(DEFAULT_TEXT_EDITOR_ID);
    }

    private void close(InputStream is) {
        if (is != null) {
            try {
                is.close();
            } catch (IOException e) {
                // Error closing the file input stream - ignore it
            }
        }
    }

}
