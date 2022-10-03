package com.corrodinggames.rts.game.units.f;

import com.corrodinggames.rts.game.m;
import com.corrodinggames.rts.game.units.af;
import com.corrodinggames.rts.game.units.r;

public abstract class i extends j {
    public i() {
        super();
    }

    public abstract int excludeTeam(r p0);

    public abstract m onlyEnemiesOfTeam(r p0);

    public m onlyTeam(r p0) {
        return null;
    }

    public void setup(r p0, float p1) {
    }

    public af getResult() {
        return null;
    }
}
