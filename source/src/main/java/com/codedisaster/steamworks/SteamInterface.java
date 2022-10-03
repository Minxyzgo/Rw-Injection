package com.codedisaster.steamworks;

abstract class SteamInterface {
    protected final long pointer = 0;

    protected long callback;

    SteamInterface(long p0) {
        super();
    }

    SteamInterface(long p0, long p1) {
        super();
    }

    void setCallback(long p0) {
    }

    public void dispose() {
    }

    protected static native void deleteCallback(long p0);
}
