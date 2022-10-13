package com.codedisaster.steamworks;

import java.nio.Buffer;

public class SteamUser extends SteamInterface {
    public SteamUser(SteamUserCallback p0) {
        super(0);
    }

    public SteamID getSteamID() {
        return null;
    }

    public SteamAuthTicket getAuthSessionTicket(Buffer p0, int[] p1) {
        return null;
    }

    public SteamAuth.BeginAuthSessionResult beginAuthSession(Buffer p0, SteamID p1) {
        return null;
    }

    public void endAuthSession(SteamID p0) {
    }

    public void cancelAuthTicket(SteamAuthTicket p0) {
    }

    public SteamAuth.UserHasLicenseForAppResult userHasLicenseForApp(SteamID p0, int p1) {
        return null;
    }

    private static native long createCallback(SteamUserCallbackAdapter p0);

    private static native long getSteamID(long p0);

    private static native int getAuthSessionTicket(long p0, Buffer p1, int p2, int[] p3);

    private static native int beginAuthSession(long p0, Buffer p1, int p2, long p3);

    private static native void endAuthSession(long p0, long p1);

    private static native void cancelAuthTicket(long p0, int p1);

    private static native int userHasLicenseForApp(long p0, long p1, int p2);

    @Override
    public void dispose() {
    }
}
