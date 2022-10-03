package com.codedisaster.steamworks;

public class SteamID extends SteamNativeHandle {
    private static final long InvalidSteamID = 0;

    public SteamID() {
        super(0);
    }

    public SteamID(SteamID p0) {
        super(0);
    }

    SteamID(long p0) {
        super(0);
    }

    public boolean isValid() {
        return false;
    }

    public int getAccountID() {
        return 0;
    }

    public static SteamID createFromNativeHandle(long p0) {
        return null;
    }

    private static native boolean isValid(long p0);

    private static native long getInvalidSteamID();
}
