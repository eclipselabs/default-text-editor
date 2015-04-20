# Default Text Editor plug-in for Eclipse
Makes the internal text editor in Eclipse to be the default editor for unknown files.

If there is no editor associated with the file being opened then Eclipse consults the operating system if there is an external editor available for this file. If positive then the file is opened in the system editor outside of Eclipse. This may not be the desired behavior for some users who want to keep opening all text files in Eclipse even if it is done just in the plain text editor.

This plugin overrides the default open file behavior of Eclipse and will avoid opening text files in external editors.