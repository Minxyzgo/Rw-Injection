package com.codedisaster.steamworks;

public strictfp interface SteamGameServerCallback {
    void onValidateAuthTicketResponse(SteamID p0, SteamAuth.AuthSessionResponse p1, SteamID p2);

    void onSteamServersConnected();

    void onSteamServerConnectFailure(SteamResult p0, boolean p1);

    void onSteamServersDisconnected(SteamResult p0);

    void onClientApprove(SteamID p0, SteamID p1);

    void onClientDeny(SteamID p0, SteamGameServer.DenyReason p1, String p2);

    void onClientKick(SteamID p0, SteamGameServer.DenyReason p1);

    void onClientGroupStatus(SteamID p0, SteamID p1, boolean p2, boolean p3);

    void onAssociateWithClanResult(SteamResult p0);

    void onComputeNewPlayerCompatibilityResult(SteamResult p0, int p1, int p2, int p3, SteamID p4);
}
