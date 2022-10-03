package com.corrodinggames.rts.game.units;

import com.corrodinggames.rts.game.m;
import com.corrodinggames.rts.game.units.f.i;

public strictfp class v extends i {
    public float a;

    public float b;

    public com.corrodinggames.rts.game.units.custom.i c;

    public float d;

    public af e;

    public boolean f;

    public boolean g;

    public v() {
        super();
    }

    @Override
    public void setup(r p0, float p1) {
    }

    @Override
    public int excludeTeam(r p0) {
        return 0;
    }

    @Override
    public m onlyEnemiesOfTeam(r p0) {
        return null;
    }

    @Override
    public m onlyTeam(r p0) {
        return null;
    }

    @Override
    public void callback(r p0, float p1, af p2) {
    }
}
