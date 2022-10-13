package com.codedisaster.steamworks;

public abstract class SteamNativeHandle {
    long handle;

    SteamNativeHandle(long p0) {
        super();
    }

    public static long getNativeHandle(SteamNativeHandle p0) {
        return 0;
    }
}
