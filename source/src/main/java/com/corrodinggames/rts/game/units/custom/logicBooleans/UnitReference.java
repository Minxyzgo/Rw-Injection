package com.corrodinggames.rts.game.units.custom.logicBooleans;

import com.corrodinggames.rts.game.units.af;
import com.corrodinggames.rts.game.units.al;
import com.corrodinggames.rts.game.units.custom.k;
import com.corrodinggames.rts.game.units.custom.l;
import com.corrodinggames.rts.game.units.custom.t;
import com.corrodinggames.rts.gameFramework.utility.ModIniLoader;
import java.util.HashMap;

public abstract class UnitReference implements Cloneable {
    public static final UnitReference nullReference = null;

    public static final SelfUnitReference selfUnitReference = null;

    static HashMap referenceTypes;

    static final HashMap parameterMappings = null;

    boolean locked;

    public UnitReference() {
        super();
    }

    public final af get(af p0) {
        return null;
    }

    public final af get(k p0) {
        return null;
    }

    public abstract af getSingleRaw(k p0);

    public void forMeta(l p0) {
    }

    static void addUnitReferenceType(UnitReference p0, String[] p1) {
    }

    public static UnitReferenceOrUnitType parseUnitTypeOrReferenceFromConf(l p0, ModIniLoader p1, String p2,
                                                                           String p3, UnitReferenceOrUnitType p4) {
        return null;
    }

    public static UnitReferenceOrUnitType parseUnitTypeOrReference(l p0, String p1, String p2,
            String p3, UnitReferenceOrUnitType p4) {
        return null;
    }

    public static UnitReference parseUnitReferenceFromConf(l p0, ModIniLoader p1, String p2, String p3,
                                                           UnitReference p4) {
        return null;
    }

    public static UnitReference parseUnitReference(l p0, String p1, String p2, String p3,
            UnitReference p4, boolean p5) {
        return null;
    }

    public static UnitReference parseUnitReferenceBlock(l p0, String p1) {
        return null;
    }

    public void setArgumentsRaw(String p0) {
    }

    public UnitReference with(String p0) {
        return null;
    }

    public UnitReference with(l p0, String p1) {
        return null;
    }

    public static class AttachmentUnitReference extends UnitReference {
        l meta;

        short attachmentId;

        public AttachmentUnitReference() {
            super();
        }

        @Override
        public void forMeta(l p0) {
        }

        @LogicBoolean.Parameter
        public void slot(String p0) {
        }

        @Override
        public af getSingleRaw(k p0) {
            return null;
        }
    }

    public static class LockedUnitReference extends UnitReference {
        af target;

        public LockedUnitReference(af p0) {
            super();
        }

        @Override
        public af getSingleRaw(k p0) {
            return null;
        }
    }

    public static class ParentUnitReference extends UnitReference {
        public ParentUnitReference() {
            super();
        }

        @Override
        public af getSingleRaw(k p0) {
            return null;
        }
    }

    public static class SelfUnitReference extends UnitReference {
        public SelfUnitReference() {
            super();
        }

        @Override
        public af getSingleRaw(k p0) {
            return null;
        }
    }

    public static class TransportingUnitReference extends UnitReference {
        l meta;

        @LogicBoolean.Parameter
        public int slot;

        public TransportingUnitReference() {
            super();
        }

        @Override
        public void forMeta(l p0) {
        }

        @Override
        public af getSingleRaw(k p0) {
            return null;
        }
    }

    public static class UnitReferenceOrUnitType {
        t unitType;

        UnitReference unitReference;

        UnitReferenceOrUnitType(t p0) {
            super();
        }

        UnitReferenceOrUnitType(UnitReference p0) {
            super();
        }

        public af getUnitOrSharedUnit(af p0) {
            return null;
        }

        public af getUnitReferenceOrNull(af p0) {
            return null;
        }

        public al getTypeOrNull(af p0) {
            return null;
        }
    }
}
