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
 * Enumeration of all known file extensions of binary files.
 */
public enum KnownBinaryFileExtensions {

    /** Rhino 3D Model */
    _3DM,
    /** 3D Studio Scene */
    _3DS,
    /** 3GPP2 Multimedia File */
    _3G2,
    /** 3GPP Multimedia File */
    _3GP,
    /** 7-Zip Compressed File */
    _7Z,
    /** Access 2007 Database File */
    ACCDB,
    /** WinAce Compressed File */
    ACE,
    /** Adobe Illustrator File */
    AI,
    /** Audio Interchange File Format */
    AIF,
    /** Audio Interchange File Format */
    AIFF,
    /** Adaptive Multi-Rate Codec File */
    AMR,
    /** Android Package File */
    APK,
    /** Mac OS X Application */
    APP,
    /** Advanced Systems Format File */
    ASF,
    /** Audio Video Interleave File */
    AVI,
    /** Binary Disc Image */
    BIN,
    /** Bitmap Image File */
    BMP,
    /** Windows Cabinet File */
    CAB,
    /** Comic Book RAR Archive */
    CBR,
    /** CD Audio Track Shortcut */
    CDA,
    /** CorelDRAW Image File */
    CDR,
    /** Compiled HTML Help File */
    CHM,
    /** Java Class File */
    CLASS,
    /** DOS Command File */
    COM,
    /** Windows Control Panel Item */
    CPL,
    /** Chrome Extension */
    CRX,
    /** Cue Sheet File */
    CUE,
    /** Windows Cursor */
    CUR,
    /** Database File */
    DB,
    /** Database File */
    DBF,
    /** DirectDraw Surface */
    DDS,
    /** Debian Software Package */
    DEB,
    /** DivX-Encoded Movie File */
    DIVX,
    /** Dynamic Link Library */
    DLL,
    /** Mac OS X Disk Image */
    DMG,
    /** Windows Memory Dump */
    DMP,
    /** Microsoft Word Document */
    DOC,
    /** Microsoft Word Open XML Document */
    DOCX,
    /** Device Driver */
    DRV,
    /** Digital Speech Standard File */
    DSS,
    /** Sony Digital Voice File */
    DVF,
    /** AutoCAD Drawing Database File */
    DWG,
    /** Encapsulated PostScript File */
    EPS,
    /** Windows Executable File */
    EXE,
    /** Adobe Flash Animation */
    FLA,
    /** Flash Video File */
    FLV,
    /** Windows Font File */
    FNT,
    /** Generic Font File */
    FON,
    /** Windows Gadget */
    GADGET,
    /** Saved Game File */
    GAM,
    /** Graphical Interchange Format File */
    GIF,
    /** Gnu Zipped Archive */
    GZ,
    /** BinHex 4.0 Encoded File */
    HQX,
    /** Mac OS X Icon Resource File */
    ICNS,
    /** Interchange File Format */
    IFF,
    /** DVD-Video Disc Information File */
    IFO,
    /** Adobe InDesign Document */
    INDD,
    /** Disc Image File */
    ISO,
    /** Java Archive File */
    JAR,
    /** JPEG Image */
    JPEG,
    /** JPEG Image */
    JPG,
    /** Keynote Presentation */
    KEY,
    /** Mac OS X Keychain File */
    KEYCHAIN,
    /** Google Earth Placemark File */
    KMZ,
    /** Windows File Shortcut */
    LNK,
    /** MPEG-4 Audio File */
    M4A,
    /** MPEG-4 Audio Book File */
    M4B,
    /** iTunes Music Store Audio File */
    M4P,
    /** iTunes Video File */
    M4V,
    /** 3ds Max Scene File */
    MAX,
    /** Microsoft Access Database */
    MDB,
    /** Media Disc Image File */
    MDF,
    /** MIDI File */
    MID,
    /** Apple QuickTime Movie */
    MOV,
    /** MPEG Layer II Compressed Audio File */
    MP2,
    /** MP3 Audio File */
    MP3,
    /** MPEG-4 Video File */
    MP4,
    /** MPEG-2 Audio File */
    MPA,
    /** MPEG Movie */
    MPEG,
    /** MPEG Video File */
    MPG,
    /** Outlook Mail Message */
    MSG,
    /** Windows Installer Package */
    MSI,
    /** Nintendo (NES) ROM File */
    NES,
    /** Wavefront 3D Object File */
    OBJ,
    /** OpenDocument Text Document */
    ODT,
    /** Ogg Vorbis Audio File */
    OGG,
    /** OpenType Font */
    OTF,
    /** Pages Document */
    PAGES,
    /** Picture File */
    PCT,
    /** Program Database */
    PDB,
    /** Portable Document Format File */
    PDF,
    /** Mac OS X Installer Package */
    PKG,
    /** Portable Network Graphic */
    PNG,
    /** PowerPoint Slide Show */
    PPS,
    /** PowerPoint Presentation */
    PPT,
    /** PowerPoint Open XML Presentation */
    PPTX,
    /** Outlook Profile File */
    PRF,
    /** PostScript File */
    PS,
    /** Adobe Photoshop Document */
    PSD,
    /** PaintShop Pro Image */
    PSPIMAGE,
    /** Outlook Personal Information Store File */
    PST,
    /** Microsoft Publisher Document */
    PUB,
    /** QuickBooks Backup File */
    QBB,
    /** QuickBooks Data File */
    QBW,
    /** QuarkXPress Document */
    QXD,
    /** Real Audio File */
    RA,
    /** Real Audio Metadata File */
    RAM,
    /** WinRAR Compressed Archive */
    RAR,
    /** Real Media File */
    RM,
    /** RealMedia Variable Bit Rate File */
    RMVB,
    /** N64 Game ROM File */
    ROM,
    /** Red Hat Package Manager File */
    RPM,
    /** Rich Text Format File */
    RTF,
    /** Saved Game */
    SAV,
    /** Self-Extracting Archive */
    SEA,
    /** StuffIt Archive */
    SIT,
    /** StuffIt X Archive */
    SITX,
    /** Shockwave Flash Movie */
    SWF,
    /** Windows System File */
    SYS,
    /** Consolidated Unix File Archive */
    TAR,
    /** Targa Graphic */
    TGA,
    /** Gzipped Tar File */
    TGZ,
    /** Thumbnail Image File */
    THM,
    /** Tagged Image File */
    TIF,
    /** Tagged Image File Format */
    TIFF,
    /** Toast Disc Image */
    TOAST,
    /** BitTorrent File */
    TORRENT,
    /** TrueType Font */
    TTF,
    /** Virtual CD */
    VCD,
    /** DVD Video Object File */
    VOB,
    /** WAVE Audio File */
    WAV,
    /** Windows Media Audio File */
    WMA,
    /** Windows Media Video File */
    WMV,
    /** WordPerfect Document */
    WPD,
    /** Microsoft Works Word Processor Document */
    WPS,
    /** Works Spreadsheet */
    XLR,
    /** Excel Spreadsheet */
    XLS,
    /** Microsoft Excel Open XML Spreadsheet */
    XLSX,
    /** YUV Encoded Image File */
    YUV,
    /** Zipped File */
    ZIP,
    /** Extended Zip File */
    ZIPX;

    private static Set<String> cached = null;

    /**
     * Returns the enumeration as a set.
     * 
     * @return an unmodifiable set.
     */
    public static Set<String> set() {
        if (cached == null) {
            Set<String> set = new HashSet<String>();

            for (KnownBinaryFileExtensions v : values()) {
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
