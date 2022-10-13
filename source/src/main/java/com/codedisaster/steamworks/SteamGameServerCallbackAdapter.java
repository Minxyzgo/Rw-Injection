package com.codedisaster.steamworks;

class SteamGameServerCallbackAdapter extends SteamCallbackAdapter {
    SteamGameServerCallbackAdapter(SteamGameServerCallback p0) {
        super(null);
    }

    void onValidateAuthTicketResponse(long p0, int p1, long p2) {
    }

    void onSteamServersConnected() {
    }

    void onSteamServerConnectFailure(int p0, boolean p1) {
    }

    void onSteamServersDisconnected(int p0) {
    }

    void onClientApprove(long p0, long p1) {
    }

    void onClientDeny(long p0, int p1, String p2) {
    }

    void onClientKick(long p0, int p1) {
    }

    void onClientGroupStatus(long p0, long p1, boolean p2, boolean p3) {
    }

    void onAssociateWithClanResult(int p0) {
    }

    void onComputeNewPlayerCompatibilityResult(int p0, int p1, int p2, int p3, long p4) {
    }
}
