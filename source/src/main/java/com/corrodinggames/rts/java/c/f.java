package com.corrodinggames.rts.java.c;

import com.codedisaster.steamworks.SteamID;
import com.codedisaster.steamworks.SteamNetworking;
import com.codedisaster.steamworks.SteamNetworkingCallback;

public class f implements SteamNetworkingCallback {
    b a;

    public f(b p0) {
        super();
    }

    @Override
    public void onP2PSessionConnectFail(SteamID p0, SteamNetworking.P2PSessionError p1) {
    }

    @Override
    public void onP2PSessionRequest(SteamID p0) {
    }
}
