package com.corrodinggames.rts.game.units.custom;

import com.corrodinggames.rts.game.m;
import com.corrodinggames.rts.game.units.af;
import com.corrodinggames.rts.game.units.f.i;
import com.corrodinggames.rts.game.units.r;

public class ak extends i {
    public float a;

    public float b;

    public al c;

    public int d;

    public ak() {
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
