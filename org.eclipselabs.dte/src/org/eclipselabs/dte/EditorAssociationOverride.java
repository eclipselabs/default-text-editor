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

import org.eclipse.core.runtime.content.IContentType;
import org.eclipse.ui.IEditorDescriptor;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IURIEditorInput;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IEditorAssociationOverride;
import org.eclipselabs.dte.preferences.PreferenceConstants;

/**
 * Overrides the default editor of text files, which have no editor association,
 * with the default text editor. This way it is avoided to open text files with
 * the system editor outside of the IDE.
 */
public class EditorAssociationOverride implements IEditorAssociationOverride {

    @Override
    public IEditorDescriptor[] overrideEditors(IEditorInput editorInput,
            IContentType contentType, IEditorDescriptor[] editorDescriptors) {
        return editorDescriptors;
    }

    @Override
    public IEditorDescriptor[] overrideEditors(String fileName,
            IContentType contentType, IEditorDescriptor[] editorDescriptors) {
        return editorDescriptors;
    }

    @Override
    public IEditorDescriptor overrideDefaultEditor(IEditorInput editorInput,
            IContentType contentType, IEditorDescriptor editorDescriptor) {
        // Override with default text editor only if no association is found yet
        if (editorDescriptor == null && editorInput != null
                && editorInput instanceof IURIEditorInput
                && isOverrideEnabled()
                && TextFileDetector.isTextFile((IURIEditorInput) editorInput)) {
            return getTextEditorDescriptor();
        }
        return editorDescriptor;
    }

    @Override
    public IEditorDescriptor overrideDefaultEditor(String fileName,
            IContentType contentType, IEditorDescriptor editorDescriptor) {
        // Override with default text editor only if no association is found yet
        if (editorDescriptor == null && fileName != null && isOverrideEnabled()
                && TextFileDetector.isTextFile(fileName)) {
            return getTextEditorDescriptor();
        }
        return editorDescriptor;
    }

    private IEditorDescriptor getTextEditorDescriptor() {
        return PlatformUI.getWorkbench().getEditorRegistry()
                .findEditor(DEFAULT_TEXT_EDITOR_ID);
    }

    private boolean isOverrideEnabled() {
        return Activator.getDefault().getPreferenceStore()
                .getBoolean(PreferenceConstants.ENABLED);
    }

}
