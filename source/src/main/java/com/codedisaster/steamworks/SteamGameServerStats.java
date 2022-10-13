package com.codedisaster.steamworks;

public class SteamGameServerStats extends SteamInterface {
    public SteamGameServerStats(SteamGameServerStatsCallback p0) {
        super(0);
    }

    public SteamAPICall requestUserStats(SteamID p0) {
        return null;
    }

    public int getUserStatI(SteamID p0, String p1, int p2) {
        return 0;
    }

    public float getUserStatF(SteamID p0, String p1, float p2) {
        return 0f;
    }

    public boolean getUserAchievement(SteamID p0, String p1, boolean p2) {
        return false;
    }

    public boolean setUserStatI(SteamID p0, String p1, int p2) {
        return false;
    }

    public boolean setUserStatF(SteamID p0, String p1, float p2) {
        return false;
    }

    public boolean updateUserAvgRateStat(SteamID p0, String p1, float p2, double p3) {
        return false;
    }

    public boolean setUserAchievement(SteamID p0, String p1) {
        return false;
    }

    public boolean clearUserAchievement(SteamID p0, String p1) {
        return false;
    }

    public SteamAPICall storeUserStats(SteamID p0) {
        return null;
    }

    private static native long createCallback(SteamGameServerStatsCallbackAdapter p0);

    private static native long requestUserStats(long p0, long p1);

    private static native boolean getUserStat(long p0, long p1, String p2, int[] p3);

    private static native boolean getUserStat(long p0, long p1, String p2, float[] p3);

    private static native boolean getUserAchievement(long p0, long p1, String p2, boolean[] p3);

    private static native boolean setUserStat(long p0, long p1, String p2, int p3);

    private static native boolean setUserStat(long p0, long p1, String p2, float p3);

    private static native boolean updateUserAvgRateStat(long p0, long p1, String p2, float p3,
            double p4);

    private static native boolean setUserAchievement(long p0, long p1, String p2);

    private static native boolean clearUserAchievement(long p0, long p1, String p2);

    private static native long storeUserStats(long p0, long p1);

    @Override
    public void dispose() {
    }
}
