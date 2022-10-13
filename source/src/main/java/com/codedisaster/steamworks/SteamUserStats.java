package com.codedisaster.steamworks;

import rwij.annotations.Additional;

public class SteamUserStats extends SteamInterface {
    public SteamUserStats(SteamUserStatsCallback p0) {
        super(0);
    }

    public boolean requestCurrentStats() {
        return false;
    }

    public int getStatI(String p0, int p1) {
        return 0;
    }

    public boolean setStatI(String p0, int p1) {
        return false;
    }

    public float getStatF(String p0, float p1) {
        return 0f;
    }

    public boolean setStatF(String p0, float p1) {
        return false;
    }

    public boolean isAchieved(String p0, boolean p1) {
        return false;
    }

    public boolean setAchievement(String p0) {
        return false;
    }

    public boolean clearAchievement(String p0) {
        return false;
    }

    public boolean storeStats() {
        return false;
    }

    public boolean indicateAchievementProgress(String p0, int p1, int p2) {
        return false;
    }

    public int getNumAchievements() {
        return 0;
    }

    public String getAchievementName(int p0) {
        return null;
    }

    public boolean resetAllStats(boolean p0) {
        return false;
    }

    public SteamAPICall findOrCreateLeaderboard(String p0, LeaderboardSortMethod p1,
            LeaderboardDisplayType p2) {
        return null;
    }

    public SteamAPICall findLeaderboard(String p0) {
        return null;
    }

    public String getLeaderboardName(SteamLeaderboardHandle p0) {
        return null;
    }

    public int getLeaderboardEntryCount(SteamLeaderboardHandle p0) {
        return 0;
    }

    public LeaderboardSortMethod getLeaderboardSortMethod(SteamLeaderboardHandle p0) {
        return null;
    }

    public LeaderboardDisplayType getLeaderboardDisplayType(SteamLeaderboardHandle p0) {
        return null;
    }

    public SteamAPICall downloadLeaderboardEntries(SteamLeaderboardHandle p0,
            LeaderboardDataRequest p1, int p2, int p3) {
        return null;
    }

    public boolean getDownloadedLeaderboardEntry(SteamLeaderboardEntriesHandle p0, int p1,
            SteamLeaderboardEntry p2, int[] p3) {
        return false;
    }

    public SteamAPICall uploadLeaderboardScore(SteamLeaderboardHandle p0,
            LeaderboardUploadScoreMethod p1, int p2, int[] p3) {
        return null;
    }

    public SteamAPICall requestGlobalStats(int p0) {
        return null;
    }

    public long getGlobalStat(String p0, long p1) {
        return 0;
    }

    public double getGlobalStat(String p0, double p1) {
        return 0d;
    }

    public int getGlobalStatHistory(String p0, long[] p1) {
        return 0;
    }

    public int getGlobalStatHistory(String p0, double[] p1) {
        return 0;
    }

    private static native long createCallback(SteamUserStatsCallbackAdapter p0);

    private static native boolean requestCurrentStats(long p0);

    private static native boolean getStat(long p0, String p1, int[] p2);

    private static native boolean setStat(long p0, String p1, int p2);

    private static native boolean getStat(long p0, String p1, float[] p2);

    private static native boolean setStat(long p0, String p1, float p2);

    private static native boolean getAchievement(long p0, String p1, boolean[] p2);

    private static native boolean setAchievement(long p0, String p1);

    private static native boolean clearAchievement(long p0, String p1);

    private static native boolean storeStats(long p0);

    private static native boolean indicateAchievementProgress(long p0, String p1, int p2, int p3);

    private static native int getNumAchievements(long p0);

    private static native String getAchievementName(long p0, int p1);

    private static native boolean resetAllStats(long p0, boolean p1);

    private static native long findOrCreateLeaderboard(long p0, long p1, String p2, int p3, int p4);

    private static native long findLeaderboard(long p0, long p1, String p2);

    private static native String getLeaderboardName(long p0, long p1);

    private static native int getLeaderboardEntryCount(long p0, long p1);

    private static native int getLeaderboardSortMethod(long p0, long p1);

    private static native int getLeaderboardDisplayType(long p0, long p1);

    private static native long downloadLeaderboardEntries(long p0, long p1, long p2, int p3, int p4,
            int p5);

    private static native boolean getDownloadedLeaderboardEntry(long p0, long p1, int p2,
            SteamLeaderboardEntry p3, int[] p4, int p5);

    private static native boolean getDownloadedLeaderboardEntry(long p0, long p1, int p2,
            SteamLeaderboardEntry p3);

    private static native long uploadLeaderboardScore(long p0, long p1, long p2, int p3, int p4,
            int[] p5, int p6);

    private static native long uploadLeaderboardScore(long p0, long p1, long p2, int p3, int p4);

    private static native long requestGlobalStats(long p0, long p1, int p2);

    private static native boolean getGlobalStat(long p0, String p1, long[] p2);

    private static native boolean getGlobalStat(long p0, String p1, double[] p2);

    private static native int getGlobalStatHistory(long p0, String p1, long[] p2, int p3);

    private static native int getGlobalStatHistory(long p0, String p1, double[] p2, int p3);

    @Override
    public void dispose() {
    }

    public enum LeaderboardDataRequest {
        Global,

        GlobalAroundUser,

        Friends,

        Users,

        $VALUES;

        private LeaderboardDataRequest(String p0, int p1) {
        }

        @Additional
        LeaderboardDataRequest() {

        }
    }

    public enum LeaderboardDisplayType {
        None,

        Numeric,

        TimeSeconds,

        TimeMilliSeconds,

        $VALUES;

        private LeaderboardDisplayType(String p0, int p1) {
        }

        @Additional
        LeaderboardDisplayType() {

        }
    }

    public enum LeaderboardSortMethod {
        None,

        Ascending,

        Descending,

        $VALUES;

        private LeaderboardSortMethod(String p0, int p1) {
        }

        @Additional
        LeaderboardSortMethod() {

        }
    }

    public enum LeaderboardUploadScoreMethod {
        None,

        KeepBest,

        ForceUpdate,

        $VALUES;

        private LeaderboardUploadScoreMethod(String p0, int p1) {
        }

        @Additional
        LeaderboardUploadScoreMethod() {

        }
    }
}
