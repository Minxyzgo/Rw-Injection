package com.corrodinggames.rts.game.units.custom.a.a;

import com.corrodinggames.rts.game.Team;
import com.corrodinggames.rts.game.p;
import com.corrodinggames.rts.game.units.af;
import com.corrodinggames.rts.game.units.f.i;
import com.corrodinggames.rts.game.units.r;
import com.corrodinggames.rts.gameFramework.utility.m;

public class l extends i {
    public com.corrodinggames.rts.game.units.custom.i a;

    public float b;

    public boolean c;

    public p d;

    public m e;

    public l() {
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
    public Team onlyEnemiesOfTeam(r p0) {
        return null;
    }

    @Override
    public Team onlyTeam(r p0) {
        return null;
    }

    @Override
    public void callback(r p0, float p1, af p2) {
    }
}
