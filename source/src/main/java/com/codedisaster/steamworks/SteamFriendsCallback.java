package com.codedisaster.steamworks;

public strictfp interface SteamFriendsCallback {
    void onSetPersonaNameResponse(boolean p0, boolean p1, SteamResult p2);

    void onPersonaStateChange(SteamID p0, SteamFriends.PersonaChange p1);

    void onGameOverlayActivated(boolean p0);

    void onGameLobbyJoinRequested(SteamID p0, SteamID p1);

    void onAvatarImageLoaded(SteamID p0, int p1, int p2, int p3);

    void onFriendRichPresenceUpdate(SteamID p0, int p1);

    void onGameRichPresenceJoinRequested(SteamID p0, String p1);
}
