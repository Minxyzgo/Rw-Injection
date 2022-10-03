package com.corrodinggames.rts.game.units.custom.logicBooleans;

import com.corrodinggames.rts.game.units.a.b;
import com.corrodinggames.rts.game.units.a.s;
import com.corrodinggames.rts.game.units.af;
import com.corrodinggames.rts.game.units.custom.k;

public class LogicBooleanActionFilter extends b {
    LogicBoolean logicBoolean;

    k target;

    public LogicBooleanActionFilter(LogicBoolean p0, k p1) {
        super();
    }

    @Override
    public boolean isAvailable(s p0, af p1) {
        return false;
    }
}
