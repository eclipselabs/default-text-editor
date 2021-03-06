Default Text Editor plug-in for Eclipse
=======================================

[![Build Status](https://travis-ci.org/eclipselabs/default-text-editor.svg?branch=master)](https://travis-ci.org/eclipselabs/default-text-editor)

_**NOTE.** The functionality of the Default Text Editor plugin has been implemented in the Eclipse Platform with the Neon release. Check the [release notes](https://www.eclipse.org/eclipse/news/4.6/platform.php#text-editor-selection-strategy) for details._

Makes the internal text editor in Eclipse to be the default editor for unknown files.

If there is no editor associated with the file being opened then Eclipse consults the operating system if there is an external editor available for this file. If positive then the file is opened in the system editor outside of Eclipse. This may not be the desired behavior for some users who want to keep opening all text files in Eclipse even if it is done just in the plain text editor.

This plugin overrides the default open file behavior of Eclipse and will avoid opening text files in external editors.

Requirements
------------

* Eclipse Juno (4.2, 3.8) or newer

Installation
------------

#### Eclipse Marketplace

Drag this button to your Eclipse workbench to install:

[![Drag to your running Eclipse workspace to install Default Text Editor](https://marketplace.eclipse.org/sites/all/themes/solstice/_themes/solstice_marketplace/public/images/btn-install.png)](http://marketplace.eclipse.org/marketplace-client-intro?mpc_install=2299057)

#### Update site

Or install this plugin by using ```Help > Install New Software...``` and add the update site:
<pre>https://dl.bintray.com/kaloyan-raev/default-text-editor/</pre>

License
-------

This is open source software under the Eclipse Public License. See the [LICENSE](LICENSE) file for details.
