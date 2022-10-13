package com.corrodinggames.rts.game.units.custom.a.a;

import com.corrodinggames.rts.game.p;
import com.corrodinggames.rts.game.units.af;
import com.corrodinggames.rts.game.units.f.i;
import com.corrodinggames.rts.game.units.r;
import com.corrodinggames.rts.gameFramework.utility.m;

public class c extends i {
    public boolean a;

    public com.corrodinggames.rts.game.units.custom.i b;

    public float c;

    public boolean d;

    public p e;

    public boolean f;

    public m g;

    public af h;

    public c() {
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
    public com.corrodinggames.rts.game.m onlyEnemiesOfTeam(r p0) {
        return null;
    }

    @Override
    public com.corrodinggames.rts.game.m onlyTeam(r p0) {
        return null;
    }

    @Override
    public void callback(r p0, float p1, af p2) {
    }
}
