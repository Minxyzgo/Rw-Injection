package com.corrodinggames.rts.game.units.custom;

import com.corrodinggames.rts.game.f;
import com.corrodinggames.rts.game.Team;
import com.corrodinggames.rts.game.units.af;
import com.corrodinggames.rts.game.units.f.i;
import com.corrodinggames.rts.game.units.r;

public class ao extends i {
    f a;

    ap b;

    af c;

    f d;

    af e;

    public ao() {
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
