package com.codedisaster.steamworks;

import rwij.annotations.Additional;

import java.nio.Buffer;

public class SteamGameServer extends SteamInterface {
    public SteamGameServer(SteamGameServerCallback p0) {
        super(0);
    }

    public void setProduct(String p0) {
    }

    public void setGameDescription(String p0) {
    }

    public void setModDir(String p0) {
    }

    public void setDedicatedServer(boolean p0) {
    }

    public void logOn(String p0) {
    }

    public void logOnAnonymous() {
    }

    public void logOff() {
    }

    public boolean isLoggedOn() {
        return false;
    }

    public boolean isSecure() {
        return false;
    }

    public SteamID getSteamID() {
        return null;
    }

    public boolean wasRestartRequested() {
        return false;
    }

    public void setMaxPlayerCount(int p0) {
    }

    public void setBotPlayerCount(int p0) {
    }

    public void setServerName(String p0) {
    }

    public void setMapName(String p0) {
    }

    public void setPasswordProtected(boolean p0) {
    }

    public void setSpectatorPort(short p0) {
    }

    public void setSpectatorServerName(String p0) {
    }

    public void clearAllKeyValues() {
    }

    public void setKeyValue(String p0, String p1) {
    }

    public void setGameTags(String p0) {
    }

    public void setGameData(String p0) {
    }

    public void setRegion(String p0) {
    }

    public SteamID sendUserConnectAndAuthenticate(int p0, Buffer p1, int p2, SteamID p3) {
        return null;
    }

    public SteamID createUnauthenticatedUserConnection() {
        return null;
    }

    public void sendUserDisconnect(SteamID p0) {
    }

    public boolean updateUserData(SteamID p0, String p1, int p2) {
        return false;
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

    public boolean requestUserGroupStatus(SteamID p0, SteamID p1) {
        return false;
    }

    public int getPublicIP() {
        return 0;
    }

    public boolean handleIncomingPacket(Buffer p0, int p1, short p2) {
        return false;
    }

    public int getNextOutgoingPacket(Buffer p0, int[] p1, short[] p2) {
        return 0;
    }

    public void enableHeartbeats(boolean p0) {
    }

    public void setHeartbeatInterval(int p0) {
    }

    public void forceHeartbeat() {
    }

    public SteamAPICall associateWithClan(SteamID p0) {
        return null;
    }

    public SteamAPICall computeNewPlayerCompatibility(SteamID p0) {
        return null;
    }

    private static native long createCallback(SteamGameServerCallbackAdapter p0);

    private static native void setProduct(long p0, String p1);

    private static native void setGameDescription(long p0, String p1);

    private static native void setModDir(long p0, String p1);

    private static native void setDedicatedServer(long p0, boolean p1);

    private static native void logOn(long p0, String p1);

    private static native void logOnAnonymous(long p0);

    private static native void logOff(long p0);

    private static native boolean isLoggedOn(long p0);

    private static native boolean isSecure(long p0);

    private static native long getSteamID(long p0);

    private static native boolean wasRestartRequested(long p0);

    private static native void setMaxPlayerCount(long p0, int p1);

    private static native void setBotPlayerCount(long p0, int p1);

    private static native void setServerName(long p0, String p1);

    private static native void setMapName(long p0, String p1);

    private static native void setPasswordProtected(long p0, boolean p1);

    private static native void setSpectatorPort(long p0, short p1);

    private static native void setSpectatorServerName(long p0, String p1);

    private static native void clearAllKeyValues(long p0);

    private static native void setKeyValue(long p0, String p1, String p2);

    private static native void setGameTags(long p0, String p1);

    private static native void setGameData(long p0, String p1);

    private static native void setRegion(long p0, String p1);

    private static native boolean sendUserConnectAndAuthenticate(long p0, int p1, Buffer p2, int p3,
            long[] p4);

    private static native long createUnauthenticatedUserConnection(long p0);

    private static native void sendUserDisconnect(long p0, long p1);

    private static native boolean updateUserData(long p0, long p1, String p2, int p3);

    private static native int getAuthSessionTicket(long p0, Buffer p1, int p2, int[] p3);

    private static native int beginAuthSession(long p0, Buffer p1, int p2, long p3);

    private static native void endAuthSession(long p0, long p1);

    private static native void cancelAuthTicket(long p0, int p1);

    private static native int userHasLicenseForApp(long p0, long p1, int p2);

    private static native boolean requestUserGroupStatus(long p0, long p1, long p2);

    private static native int getPublicIP(long p0);

    private static native boolean handleIncomingPacket(long p0, Buffer p1, int p2, int p3,
            short p4);

    private static native int getNextOutgoingPacket(long p0, Buffer p1, int p2, int[] p3,
            short[] p4);

    private static native void enableHeartbeats(long p0, boolean p1);

    private static native void setHeartbeatInterval(long p0, int p1);

    private static native void forceHeartbeat(long p0);

    private static native long associateWithClan(long p0, long p1);

    private static native long computeNewPlayerCompatibility(long p0, long p1);

    @Override
    public void dispose() {
    }

    public enum DenyReason {
        Invalid,

        InvalidVersion,

        Generic,

        NotLoggedOn,

        NoLicense,

        Cheater,

        LoggedInElseWhere,

        UnknownText,

        IncompatibleAnticheat,

        MemoryCorruption,

        IncompatibleSoftware,

        SteamConnectionLost,

        SteamConnectionError,

        SteamResponseTimedOut,

        SteamValidationStalled,

        SteamOwnerLeftGuestUser,

        values,

        $VALUES;

        private DenyReason(String p0, int p1) {
        }

        @Additional
        DenyReason() {

        }

        static DenyReason byOrdinal(int p0) {
            return null;
        }
    }
}
