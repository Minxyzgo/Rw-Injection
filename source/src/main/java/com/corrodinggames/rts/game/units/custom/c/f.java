package com.corrodinggames.rts.game.units.custom.c;

import com.corrodinggames.rts.game.m;
import com.corrodinggames.rts.game.units.af;
import com.corrodinggames.rts.game.units.f.i;
import com.corrodinggames.rts.game.units.r;

public strictfp class f extends i {
    public c a;

    public a b;

    public af c;

    public float d;

    public f() {
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
