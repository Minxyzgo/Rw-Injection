package com.codedisaster.steamworks;

public strictfp interface SteamMatchmakingCallback {
    void onFavoritesListChanged(int p0, int p1, int p2, int p3, int p4, boolean p5, int p6);

    void onLobbyInvite(SteamID p0, SteamID p1, long p2);

    void onLobbyEnter(SteamID p0, int p1, boolean p2, SteamMatchmaking.ChatRoomEnterResponse p3);

    void onLobbyDataUpdate(SteamID p0, SteamID p1, boolean p2);

    void onLobbyChatUpdate(SteamID p0, SteamID p1, SteamID p2,
            SteamMatchmaking.ChatMemberStateChange p3);

    void onLobbyChatMessage(SteamID p0, SteamID p1, SteamMatchmaking.ChatEntryType p2, int p3);

    void onLobbyGameCreated(SteamID p0, SteamID p1, int p2, short p3);

    void onLobbyMatchList(int p0);

    void onLobbyKicked(SteamID p0, SteamID p1, boolean p2);

    void onLobbyCreated(SteamResult p0, SteamID p1);

    void onFavoritesListAccountsUpdated(SteamResult p0);
}
