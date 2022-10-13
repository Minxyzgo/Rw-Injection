package com.codedisaster.steamworks;

import rwij.annotations.Additional;

/**
 * lost enum classes:
 */
public enum SteamUniverse {
    Invalid,

    Public,

    Beta,

    Internal,

    Dev,

    value,

    values,

    $VALUES;

    private SteamUniverse(String p0, int p1, int p2) {
    }

    @Additional
    SteamUniverse() {

    }

    static SteamUniverse byValue(int p0) {
        return null;
    }
}
