package com.codedisaster.steamworks;

public class SteamAuthTicket extends SteamNativeHandle {
    static final long AuthTicketInvalid = 0;

    SteamAuthTicket(long p0) {
        super(0);
    }

    public boolean isValid() {
        return false;
    }
}
