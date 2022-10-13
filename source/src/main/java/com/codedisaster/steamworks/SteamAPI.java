package com.codedisaster.steamworks;

import java.io.PrintStream;

public class SteamAPI {
    private static boolean isRunning;

    public SteamAPI() {
        super();
    }

    public static boolean init() {
        return false;
    }

    public static boolean init(String p0) {
        return false;
    }

    public static void shutdown() {
    }

    public static boolean isSteamRunning() {
        return false;
    }

    public static boolean isSteamRunning(boolean p0) {
        return false;
    }

    public static void printDebugInfo(PrintStream p0) {
    }

    public static native boolean restartAppIfNecessary(int p0);

    public static native void releaseCurrentThreadMemory();

    private static native boolean nativeInit();

    private static native void nativeShutdown();

    public static native void runCallbacks();

    private static native boolean isSteamRunningNative();

    static native long getSteamAppsPointer();

    static native long getSteamControllerPointer();

    static native long getSteamFriendsPointer();

    static native long getSteamHTTPPointer();

    static native long getSteamMatchmakingPointer();

    static native long getSteamNetworkingPointer();

    static native long getSteamRemoteStoragePointer();

    static native long getSteamUGCPointer();

    static native long getSteamUserPointer();

    static native long getSteamUserStatsPointer();

    static native long getSteamUtilsPointer();
}
