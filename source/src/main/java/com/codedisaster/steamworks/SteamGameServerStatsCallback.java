package com.codedisaster.steamworks;

public strictfp interface SteamGameServerStatsCallback {
    void onStatsReceived(SteamResult p0, SteamID p1);

    void onStatsStored(SteamResult p0, SteamID p1);

    void onStatsUnloaded(SteamID p0);
}
