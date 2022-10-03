package com.corrodinggames.rts.java.c;

import com.codedisaster.steamworks.SteamID;
import com.codedisaster.steamworks.SteamMatchmaking;
import com.codedisaster.steamworks.SteamMatchmakingCallback;
import com.codedisaster.steamworks.SteamResult;

public class e implements SteamMatchmakingCallback {
    b a;

    public e(b p0) {
        super();
    }

    @Override
    public void onFavoritesListChanged(int p0, int p1, int p2, int p3, int p4, boolean p5, int p6) {
    }

    @Override
    public void onLobbyInvite(SteamID p0, SteamID p1, long p2) {
    }

    @Override
    public void onLobbyEnter(SteamID p0, int p1, boolean p2,
            SteamMatchmaking.ChatRoomEnterResponse p3) {
    }

    @Override
    public void onLobbyDataUpdate(SteamID p0, SteamID p1, boolean p2) {
    }

    @Override
    public void onLobbyChatUpdate(SteamID p0, SteamID p1, SteamID p2,
            SteamMatchmaking.ChatMemberStateChange p3) {
    }

    @Override
    public void onLobbyChatMessage(SteamID p0, SteamID p1, SteamMatchmaking.ChatEntryType p2,
            int p3) {
    }

    @Override
    public void onLobbyGameCreated(SteamID p0, SteamID p1, int p2, short p3) {
    }

    @Override
    public void onLobbyMatchList(int p0) {
    }

    @Override
    public void onLobbyKicked(SteamID p0, SteamID p1, boolean p2) {
    }

    @Override
    public void onLobbyCreated(SteamResult p0, SteamID p1) {
    }

    @Override
    public void onFavoritesListAccountsUpdated(SteamResult p0) {
    }
}
