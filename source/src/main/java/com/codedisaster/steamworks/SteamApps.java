package com.codedisaster.steamworks;

public class SteamApps extends SteamInterface {
    public SteamApps() {
        super(0);
    }

    public boolean isSubscribedApp(int p0) {
        return false;
    }

    public String getCurrentGameLanguage() {
        return null;
    }

    public String getAvailableGameLanguages() {
        return null;
    }

    public SteamID getAppOwner() {
        return null;
    }

    public int getAppBuildId() {
        return 0;
    }

    private static native boolean isSubscribedApp(long p0, int p1);

    private static native String getCurrentGameLanguage(long p0);

    private static native String getAvailableGameLanguages(long p0);

    private static native long getAppOwner(long p0);

    private static native int getAppBuildId(long p0);

    @Override
    public void dispose() {
    }
}
