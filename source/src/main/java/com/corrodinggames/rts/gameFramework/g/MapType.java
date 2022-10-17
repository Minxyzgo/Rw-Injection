package com.corrodinggames.rts.gameFramework.g;

import rwij.annotations.Additional;
import rwij.annotations.Fixed;
import rwij.annotations.RenameFrom;

/**
 * lost enum classes:
 * com.corrodinggames.rts.gameFramework.g.ai#1 : ai239
 * com.corrodinggames.rts.gameFramework.g.ai#2 : ai240
 * com.corrodinggames.rts.gameFramework.g.ai#3 : ai241
 */
@RenameFrom(oldName = "ai")
public strictfp enum MapType {
    a,

    b,

    c,

    d;

    private MapType(String p0, int p1) {
    }

    MapType(String p0, int p1, Network.ad230 p2) {
    }

    @Additional
    MapType() {

    }

    /** modifiers: abstract */
    @Fixed
    public String a() {
        return "";
    }
}
