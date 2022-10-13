package com.codedisaster.steamworks;

class SteamUtilsCallbackAdapter extends SteamCallbackAdapter {
    private SteamAPIWarningMessageHook messageHook;

    SteamUtilsCallbackAdapter(SteamUtilsCallback p0) {
        super(null);
    }

    void setWarningMessageHook(SteamAPIWarningMessageHook p0) {
    }

    void onWarningMessage(int p0, String p1) {
    }

    void onSteamShutdown() {
    }
}
