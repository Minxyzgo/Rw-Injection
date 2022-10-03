package com.codedisaster.steamworks;

import java.io.File;
import java.io.InputStream;
import java.util.zip.CRC32;

class SteamSharedLibraryLoader {
    static boolean alreadyLoaded;

    static File librarySystemPath;

    private static final String extractSubFolder = null;

    private final String libraryPath = null;

    private SteamSharedLibraryLoader(String p0) {
        super();
    }

    private String getLibNameWindows(String p0, boolean p1) {
        return null;
    }

    private String getLibNameLinux(String p0, boolean p1) {
        return null;
    }

    private String getLibNameMac(String p0) {
        return null;
    }

    private void loadLibraries(String[] p0) {
    }

    private String extractLibrary(File p0, String p1) {
        return null;
    }

    private String crc(CRC32 p0, InputStream p1) {
        return null;
    }

    static boolean loadLibraries(String p0) {
        return false;
    }

    private static File discoverExtractLocation(String p0, String p1) {
        return null;
    }

    private static boolean canWrite(File p0) {
        return false;
    }

    private static boolean canExecute(File p0) {
        return false;
    }
}
