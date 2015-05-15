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

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Enumeration of all known file extensions of text-based files.
 */
public enum KnownTextBasedFileExtensions {

    /** Active Server Page */
    ASP,
    /** Active Server Page Extended File */
    ASPX,
    /** Microsoft ASF Redirector File */
    ASX,
    /** DOS Batch File */
    BAT,
    /** C/C++ Source Code File */
    C,
    /** Internet Security Certificate */
    CER,
    /** Configuration File */
    CFG,
    /** ColdFusion Markup File */
    CFM,
    /** Common Gateway Interface Script */
    CGI,
    /** C++ Source Code File */
    CPP,
    /** Visual C# Source Code File */
    CS,
    /** Cascading Style Sheet */
    CSS,
    /** Certificate Signing Request File */
    CSR,
    /** Comma Separated Values File */
    CSV,
    /** Document Type Definition File */
    DTD,
    /** Drawing Exchange Format File */
    DXF,
    /** E-Mail Message */
    EML,
    /** GEDCOM Genealogy Data File */
    GED,
    /** GPS Exchange File */
    GPX,
    /** C/C++/Objective-C Header File */
    H,
    /** C++ Header File */
    HPP,
    /** Hypertext Markup Language File */
    HTM,
    /** Hypertext Markup Language File */
    HTML,
    /** Calendar File */
    ICS,
    /** Windows Initialization File */
    INI,
    /** Java Source Code File */
    JAVA,
    /** JavaScript File */
    JS,
    /** Java Server Page */
    JSP,
    /** Keyhole Markup Language File */
    KML,
    /** Log File */
    LOG,
    /** Lua Source File */
    LUA,
    /** Objective-C Implementation File */
    M,
    /** Markdown Documentation File */
    MARKDOWN,
    /** Markdown Documentation File */
    MD,
    /** Markdown Documentation File */
    MDOWN,
    /** Media Playlist File */
    M3U,
    /** PHP Source Code File */
    PHP,
    /** Perl Script */
    PL,
    /** Python Script */
    PY,
    /** Rich Site Summary */
    RSS,
    /** Standard Data File */
    SDF,
    /** Bash Shell Script */
    SH,
    /** Visual Studio Solution File */
    SLN,
    /** Structured Query Language Data File */
    SQL,
    /** SubRip Subtitle File */
    SRT,
    /** Subtitle File */
    SUB,
    /** Scalable Vector Graphics File */
    SVG,
    /** Swift Source Code File */
    SWIFT,
    /** LaTeX Source Document */
    TEX,
    /** Plain Text File */
    TXT,
    /** Visual Basic Project File */
    VBP,
    /** Visual Studio Visual Basic Project */
    VBPROJ,
    /** vCard File */
    VCF,
    /** Visual C++ Project */
    VCXPROJ,
    /** Windows Script File */
    WSF,
    /** Xcode Project */
    XCODEPROJ,
    /** Extensible Hypertext Markup Language File */
    XHTML,
    /** XML File */
    XML,
    /** YAML Document */
    YML;

    private static Set<String> cached = null;
    
    /**
     * Returns the enumeration as a set.
     * 
     * @return an unmodifiable set.
     */
    public static Set<String> set() {
        if (cached == null) {
            Set<String> set = new HashSet<String>();

            for (KnownTextBasedFileExtensions v : values()) {
                set.add(v.toString());
            }

            cached = Collections.unmodifiableSet(set);
        }

        return cached;
    }

    @Override
    public String toString() {
        String name = name();
        return name.startsWith("_") ? name.substring(1) : name;
    }

}
