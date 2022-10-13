package com.codedisaster.steamworks;

public strictfp interface SteamNetworkingCallback {
    void onP2PSessionConnectFail(SteamID p0, SteamNetworking.P2PSessionError p1);

    void onP2PSessionRequest(SteamID p0);
}
