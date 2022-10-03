package com.codedisaster.steamworks;

public strictfp interface SteamUserCallback {
    void onValidateAuthTicket(SteamID p0, SteamAuth.AuthSessionResponse p1, SteamID p2);

    void onMicroTxnAuthorization(int p0, long p1, boolean p2);
}
