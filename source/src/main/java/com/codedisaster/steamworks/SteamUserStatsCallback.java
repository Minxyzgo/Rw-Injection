package com.codedisaster.steamworks;

public strictfp interface SteamUserStatsCallback {
    void onUserStatsReceived(long p0, SteamID p1, SteamResult p2);

    void onUserStatsStored(long p0, SteamResult p1);

    void onUserStatsUnloaded(SteamID p0);

    void onUserAchievementStored(long p0, boolean p1, String p2, int p3, int p4);

    void onLeaderboardFindResult(SteamLeaderboardHandle p0, boolean p1);

    void onLeaderboardScoresDownloaded(SteamLeaderboardHandle p0, SteamLeaderboardEntriesHandle p1,
            int p2);

    void onLeaderboardScoreUploaded(boolean p0, SteamLeaderboardHandle p1, int p2, boolean p3,
            int p4, int p5);

    void onGlobalStatsReceived(long p0, SteamResult p1);
}
