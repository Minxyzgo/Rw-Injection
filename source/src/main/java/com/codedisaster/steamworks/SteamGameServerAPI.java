package com.codedisaster.steamworks;

import rwij.annotations.Additional;

public class SteamGameServerAPI {
    private static boolean isRunning;

    public SteamGameServerAPI() {
        super();
    }

    public static boolean init(int p0, short p1, short p2, short p3, ServerMode p4, String p5) {
        return false;
    }

    public static boolean init(String p0, int p1, short p2, short p3, short p4, ServerMode p5,
            String p6) {
        return false;
    }

    public static void shutdown() {
    }

    public static SteamID getSteamID() {
        return null;
    }

    private static native boolean nativeInit(int p0, short p1, short p2, short p3, int p4,
            String p5);

    private static native void nativeShutdown();

    public static native void runCallbacks();

    public static native boolean isSecure();

    private static native long nativeGetSteamID();

    static native long getSteamGameServerPointer();

    static native long getSteamGameServerNetworkingPointer();

    static native long getSteamGameServerStatsPointer();

    static native long getSteamGameServerHTTPPointer();

    public enum ServerMode {
        Invalid,

        NoAuthentication,

        Authentication,

        AuthenticationAndSecure,

        $VALUES;

        private ServerMode(String p0, int p1) {
        }

        @Additional
        ServerMode() {

        }
    }
}
