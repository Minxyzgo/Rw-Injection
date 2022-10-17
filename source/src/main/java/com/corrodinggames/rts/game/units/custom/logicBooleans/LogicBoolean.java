package com.corrodinggames.rts.game.units.custom.logicBooleans;

import com.corrodinggames.rts.game.Team;
import com.corrodinggames.rts.game.units.af;
import com.corrodinggames.rts.game.units.ah;
import com.corrodinggames.rts.game.units.ao;
import com.corrodinggames.rts.game.units.custom.c.a;
import com.corrodinggames.rts.game.units.custom.d.a11;
import com.corrodinggames.rts.game.units.custom.g;
import com.corrodinggames.rts.game.units.custom.h;
import com.corrodinggames.rts.game.units.custom.k;
import com.corrodinggames.rts.game.units.custom.l;
import com.corrodinggames.rts.game.units.f.i;
import com.corrodinggames.rts.game.units.r;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.HashMap;

public abstract class LogicBoolean implements Cloneable {
    public static final boolean not = false;

    public static final StaticBoolean trueBoolean = null;

    public static final StaticBoolean falseBoolean = null;

    static CallContext_self callContext_self;

    static CallContext_selfAndTarget callContext_selfAndTarget;

    static HashMap booleans;

    static final HashMap parameterMappings = null;

    boolean locked;

    public LogicBoolean() {
        super();
    }

    static void addBooleanType(LogicBoolean p0, String[] p1) {
    }

    public void setArgumentsRaw(String p0) {
    }

    public LogicBoolean lock() {
        return null;
    }

    public void forMeta(l p0) {
    }

    public LogicBoolean with(String p0) {
        return null;
    }

    public LogicBoolean with(l p0, String p1) {
        return null;
    }

    public static LogicBoolean convertAlwaysTrueToNull(LogicBoolean p0) {
        return null;
    }

    public static boolean isStaticFalse(LogicBoolean p0) {
        return false;
    }

    public static boolean isStaticTrue(LogicBoolean p0) {
        return false;
    }

    public static LogicBoolean create(l p0, String p1) {
        return null;
    }

    public static LogicBoolean create(l p0, String p1, LogicBoolean p2) {
        return null;
    }

    public void validateArguments(String p0, String p1, String p2) {
    }

    public abstract boolean read(k p0);

    public abstract String getMatchFailReasonForPlayer(k p0);

    public String getDebugDetails(k p0) {
        return null;
    }

    public abstract static class AbstractNumberBoolean extends LogicBoolean {
        @Parameter
        public boolean full;

        @Parameter
        public boolean empty;

        @Parameter
        public float greaterThan;

        @Parameter
        public float lessThan;

        public AbstractNumberBoolean() {
            super();
        }

        @Parameter
        public void equalTo(float p0) {
        }

        @Override
        public void validateArguments(String p0, String p1, String p2) {
        }

        public abstract String getName();

        public abstract float getValue(k p0);

        public abstract float getMaxValue(k p0);

        @Override
        public String getMatchFailReasonForPlayer(k p0) {
            return null;
        }

        @Override
        public boolean read(k p0) {
            return false;
        }
    }

    public static final class AmmoBoolean extends AbstractNumberBoolean {
        public AmmoBoolean() {
            super();
        }

        @Override
        public String getName() {
            return null;
        }

        @Override
        public float getValue(k p0) {
            return 0f;
        }

        @Override
        public float getMaxValue(k p0) {
            return 0f;
        }
    }

    public static final class AmmoIncludingQueuedBoolean extends AbstractNumberBoolean {
        public AmmoIncludingQueuedBoolean() {
            super();
        }

        @Override
        public String getName() {
            return null;
        }

        @Override
        public float getValue(k p0) {
            return 0f;
        }

        @Override
        public float getMaxValue(k p0) {
            return 0f;
        }
    }

    public static final class AndBoolean extends JoinerBoolean {
        public AndBoolean() {
            super();
        }

        @Override
        public String type() {
            return null;
        }

        @Override
        public boolean read(k p0) {
            return false;
        }
    }

    public static class CallContext {
        public CallContext() {
            super();
        }
    }

    public static class CallContext_self extends CallContext {
        public k self;

        public CallContext_self() {
            super();
        }
    }

    public static class CallContext_selfAndTarget extends CallContext_self {
        public af target;

        public CallContext_selfAndTarget() {
            super();
        }
    }

    public static final class CustomTimerBoolean extends TimeBoolean {
        public CustomTimerBoolean() {
            super();
        }

        @Override
        public String getName() {
            return null;
        }

        @Override
        public int getTime(k p0) {
            return 0;
        }
    }

    public static final class EnergyBoolean extends AbstractNumberBoolean {
        public EnergyBoolean() {
            super();
        }

        @Override
        public String getName() {
            return null;
        }

        @Override
        public float getValue(k p0) {
            return 0f;
        }

        @Override
        public float getMaxValue(k p0) {
            return 0f;
        }
    }

    public static final class EnergyIncludingQueuedBoolean extends AbstractNumberBoolean {
        public EnergyIncludingQueuedBoolean() {
            super();
        }

        @Override
        public String getName() {
            return null;
        }

        @Override
        public float getValue(k p0) {
            return 0f;
        }

        @Override
        public float getMaxValue(k p0) {
            return 0f;
        }
    }

    public static class GameModeBoolean extends LogicBoolean {
        @Parameter
        public boolean nukesEnabled;

        public GameModeBoolean() {
            super();
        }

        @Override
        public boolean read(k p0) {
            return false;
        }

        @Override
        public String getMatchFailReasonForPlayer(k p0) {
            return null;
        }
    }

    public static class HasActiveWaypoint extends LogicBoolean {
        ao type;

        public HasActiveWaypoint() {
            super();
        }

        @Parameter
        public void type(String p0) {
        }

        @Override
        public boolean read(k p0) {
            return false;
        }

        @Override
        public String getMatchFailReasonForPlayer(k p0) {
            return null;
        }
    }

    public static class HasFlagBoolean extends LogicBoolean {
        public int flagMask;

        public int flagId;

        public HasFlagBoolean() {
            super();
        }

        @Parameter
        public void id(int p0) {
        }

        public static boolean isFlagSet(int p0, int p1) {
            return false;
        }

        public static byte setFlag(int p0, int p1) {
            return 0;
        }

        public static byte unsetFlag(int p0, int p1) {
            return 0;
        }

        @Override
        public String getMatchFailReasonForPlayer(k p0) {
            return null;
        }

        @Override
        public boolean read(k p0) {
            return false;
        }
    }

    public static final class HasParent extends LogicBoolean {
        public h _withTag;

        public HasParent() {
            super();
        }

        @Parameter
        public void withTag(String p0) {
        }

        @Override
        public boolean read(k p0) {
            return false;
        }

        @Override
        public String getMatchFailReasonForPlayer(k p0) {
            return null;
        }
    }

    public static final class HasResourcesBoolean extends LogicBoolean {
        g requiredResources;

        l meta;

        public HasResourcesBoolean() {
            super();
        }

        @Override
        public void forMeta(l p0) {
        }

        @Override
        public void setArgumentsRaw(String p0) {
        }

        @Override
        public boolean read(k p0) {
            return false;
        }

        @Override
        public String getMatchFailReasonForPlayer(k p0) {
            return null;
        }
    }

    public static class HasTakenDamage extends TimeBoolean {
        public HasTakenDamage() {
            super();
        }

        @Override
        public int getTime(k p0) {
            return 0;
        }

        @Override
        public String getName() {
            return null;
        }
    }

    public static class HeightBoolean extends LogicBoolean {
        @Parameter
        public boolean underwater;

        @Parameter
        public boolean ground;

        @Parameter
        public boolean flying;

        public HeightBoolean() {
            super();
        }

        @Override
        public String getMatchFailReasonForPlayer(k p0) {
            return null;
        }

        @Override
        public boolean read(k p0) {
            return false;
        }
    }

    public static final class HeightValueBoolean extends AbstractNumberBoolean {
        public HeightValueBoolean() {
            super();
        }

        @Override
        public String getName() {
            return null;
        }

        @Override
        public float getValue(k p0) {
            return 0f;
        }

        @Override
        public float getMaxValue(k p0) {
            return 0f;
        }
    }

    public static final class HpBoolean extends AbstractNumberBoolean {
        public HpBoolean() {
            super();
        }

        @Override
        public String getName() {
            return null;
        }

        @Override
        public float getValue(k p0) {
            return 0f;
        }

        @Override
        public float getMaxValue(k p0) {
            return 0f;
        }
    }

    public static class IsAttackingBoolean extends LogicBoolean {
        public IsAttackingBoolean() {
            super();
        }

        @Override
        public boolean read(k p0) {
            return false;
        }

        @Override
        public String getMatchFailReasonForPlayer(k p0) {
            return null;
        }
    }

    public static class IsControlledByAI extends LogicBoolean {
        public IsControlledByAI() {
            super();
        }

        @Override
        public boolean read(k p0) {
            return false;
        }

        @Override
        public String getMatchFailReasonForPlayer(k p0) {
            return null;
        }
    }

    public static class IsGameFrameBoolean extends LogicBoolean {
        @Parameter
        public int mod;

        @Parameter
        public int equalTo;

        @Parameter
        public boolean offset;

        public IsGameFrameBoolean() {
            super();
        }

        @Parameter
        public void mod(int p0) {
        }

        @Override
        public boolean read(k p0) {
            return false;
        }

        @Override
        public String getMatchFailReasonForPlayer(k p0) {
            return null;
        }
    }

    public static class IsOnTeam extends LogicBoolean {
        int teamId;

        public IsOnTeam() {
            super();
        }

        @Parameter
        public void team(int p0) {
        }

        @Override
        public void validateArguments(String p0, String p1, String p2) {
        }

        @Override
        public String getMatchFailReasonForPlayer(k p0) {
            return null;
        }

        @Override
        public boolean read(k p0) {
            return false;
        }
    }

    public static final class IsResourceLargerThan extends LogicBoolean {
        l meta;

        a11 source;

        a11 compareTarget;

        @Parameter
        public float byMoreThan;

        @Parameter
        public float multiplyTargetBy;

        public IsResourceLargerThan() {
            super();
        }

        @Override
        public void forMeta(l p0) {
        }

        @Parameter
        public void source(String p0) {
        }

        @Parameter
        public void compareTarget(String p0) {
        }

        @Override
        public void validateArguments(String p0, String p1, String p2) {
        }

        @Override
        public boolean read(k p0) {
            return false;
        }

        @Override
        public String getMatchFailReasonForPlayer(k p0) {
            return null;
        }
    }

    public static class isTransportUnloading extends LogicBoolean {
        public isTransportUnloading() {
            super();
        }

        @Override
        public boolean read(k p0) {
            return false;
        }

        @Override
        public String getMatchFailReasonForPlayer(k p0) {
            return null;
        }
    }

    public abstract static class JoinerBoolean extends LogicBoolean {
        LogicBoolean[] children;

        public JoinerBoolean() {
            super();
        }

        public abstract String type();

        public static LogicBoolean createJoiner(String p0, LogicBoolean[] p1) {
            return null;
        }

        @Override
        public String getMatchFailReasonForPlayer(k p0) {
            return null;
        }

        @Override
        public String getDebugDetails(k p0) {
            return null;
        }
    }

    public static final class KillsBoolean extends AbstractNumberBoolean {
        public KillsBoolean() {
            super();
        }

        @Override
        public String getName() {
            return null;
        }

        @Override
        public float getValue(k p0) {
            return 0f;
        }

        @Override
        public float getMaxValue(k p0) {
            return 0f;
        }
    }

    public static final class LastConvertedBoolean extends TimeBoolean {
        public LastConvertedBoolean() {
            super();
        }

        @Override
        public String getName() {
            return null;
        }

        @Override
        public int getTime(k p0) {
            return 0;
        }
    }

    public static class MovingBoolean extends LogicBoolean {
        public MovingBoolean() {
            super();
        }

        @Override
        public boolean read(k p0) {
            return false;
        }

        @Override
        public String getMatchFailReasonForPlayer(k p0) {
            return null;
        }
    }

    public static final class NotBoolean extends LogicBoolean {
        LogicBoolean child;

        public NotBoolean(LogicBoolean p0) {
            super();
        }

        @Override
        public boolean read(k p0) {
            return false;
        }

        @Override
        public String getMatchFailReasonForPlayer(k p0) {
            return null;
        }
    }

    public static final class NumberOfAttachedUnitsBoolean extends AbstractNumberBoolean {
        public h _withTag;

        short attachmentId;

        l meta;

        public NumberOfAttachedUnitsBoolean() {
            super();
        }

        @Override
        public void forMeta(l p0) {
        }

        @Parameter
        public void withTag(String p0) {
        }

        @Parameter
        public void slot(String p0) {
        }

        @Override
        public String getName() {
            return null;
        }

        @Override
        public float getValue(k p0) {
            return 0f;
        }

        @Override
        public float getMaxValue(k p0) {
            return 0f;
        }
    }

    public static final class NumberOfConnectionsBoolean extends AbstractNumberBoolean {
        l meta;

        a connectionMetadata;

        public NumberOfConnectionsBoolean() {
            super();
        }

        @Override
        public void forMeta(l p0) {
        }

        @Parameter
        public void name(String p0) {
        }

        @Override
        public void validateArguments(String p0, String p1, String p2) {
        }

        @Override
        public String getName() {
            return null;
        }

        @Override
        public float getValue(k p0) {
            return 0f;
        }

        @Override
        public float getMaxValue(k p0) {
            return 0f;
        }
    }

    public static final class NumberOfUnitsInEnemyOrAllyTeam extends AbstractNumberBoolean {
        public static final HandleCallbackCountEnemies handleCallbackCountEnemies = null;

        public static final HandleCallbackCountAlly handleCallbackCountAlly = null;

        public h _withTag;

        @Parameter
        public float withinRange;

        public float withinRangeSq;

        @Parameter
        public boolean incompleteBuildings;

        @Parameter
        public boolean factoryQueue;

        @Parameter
        public boolean ally;

        public NumberOfUnitsInEnemyOrAllyTeam() {
            super();
        }

        @Parameter
        public void withTag(String p0) {
        }

        @Override
        public void validateArguments(String p0, String p1, String p2) {
        }

        @Override
        public String getName() {
            return null;
        }

        @Override
        public float getValue(k p0) {
            return 0f;
        }

        @Override
        public float getMaxValue(k p0) {
            return 0f;
        }

        public static class HandleCallbackCountAlly extends i {
            public Team ally;

            public h tag;

            public int count;

            public float withinRangeSq;

            public boolean incompleteBuildings;

            public HandleCallbackCountAlly() {
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

        public static class HandleCallbackCountEnemies extends i {
            public h tag;

            public int count;

            public float withinRangeSq;

            public boolean incompleteBuildings;

            public HandleCallbackCountEnemies() {
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
    }

    public static final class NumberOfUnitsInTeam extends AbstractNumberBoolean {
        public static final HandleCallbackCount handleCallbackCount = null;

        public h _withTag;

        @Parameter
        public float withinRange;

        public float withinRangeSq;

        @Parameter
        public boolean incompleteBuildings;

        @Parameter
        public boolean factoryQueue;

        @Parameter
        public boolean neutralTeam;

        public boolean useAggressiveTeamInsteadOfNeutralTeam;

        public NumberOfUnitsInTeam() {
            super();
        }

        @Parameter
        public void aggressiveTeam(boolean p0) {
        }

        @Parameter
        public void withTag(String p0) {
        }

        @Override
        public void validateArguments(String p0, String p1, String p2) {
        }

        @Override
        public String getName() {
            return null;
        }

        @Override
        public float getValue(k p0) {
            return 0f;
        }

        @Override
        public float getMaxValue(k p0) {
            return 0f;
        }

        public static class HandleCallbackCount extends i {
            public h tag;

            public int count;

            public float withinRangeSq;

            public boolean incompleteBuildings;

            public Team targetTeam;

            public HandleCallbackCount() {
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
    }

    public static final class OrBoolean extends JoinerBoolean {
        public OrBoolean() {
            super();
        }

        @Override
        public String type() {
            return null;
        }

        @Override
        public boolean read(k p0) {
            return false;
        }
    }

    public static class OverCliftBoolean extends LogicBoolean {
        public OverCliftBoolean() {
            super();
        }

        @Override
        public boolean read(k p0) {
            return false;
        }

        @Override
        public String getMatchFailReasonForPlayer(k p0) {
            return null;
        }
    }

    public static class OverLiquidBoolean extends LogicBoolean {
        public OverLiquidBoolean() {
            super();
        }

        @Override
        public boolean read(k p0) {
            return false;
        }

        @Override
        public String getMatchFailReasonForPlayer(k p0) {
            return null;
        }
    }

    public static class OverPassableTileBoolean extends LogicBoolean {
        ah movementType;

        public OverPassableTileBoolean() {
            super();
        }

        @Parameter
        public void type(String p0) {
        }

        @Override
        public boolean read(k p0) {
            return false;
        }

        @Override
        public String getMatchFailReasonForPlayer(k p0) {
            return null;
        }
    }

    public static class OverWaterBoolean extends LogicBoolean {
        public OverWaterBoolean() {
            super();
        }

        @Override
        public boolean read(k p0) {
            return false;
        }

        @Override
        public String getMatchFailReasonForPlayer(k p0) {
            return null;
        }
    }

    @Retention(RetentionPolicy.RUNTIME)
    public @interface Parameter {
    }

    public static final class QueueSize extends AbstractNumberBoolean {
        public QueueSize() {
            super();
        }

        @Override
        public String getName() {
            return null;
        }

        @Override
        public float getValue(k p0) {
            return 0f;
        }

        @Override
        public float getMaxValue(k p0) {
            return 0f;
        }
    }

    public static final class ResourceCountBoolean extends AbstractNumberBoolean {
        l meta;

        a11 type;

        public ResourceCountBoolean() {
            super();
        }

        @Override
        public void forMeta(l p0) {
        }

        @Parameter
        public void type(String p0) {
        }

        @Override
        public void validateArguments(String p0, String p1, String p2) {
        }

        @Override
        public String getName() {
            return null;
        }

        @Override
        public float getValue(k p0) {
            return 0f;
        }

        @Override
        public float getMaxValue(k p0) {
            return 0f;
        }
    }

    public static final class ShieldBoolean extends AbstractNumberBoolean {
        public ShieldBoolean() {
            super();
        }

        @Override
        public String getName() {
            return null;
        }

        @Override
        public float getValue(k p0) {
            return 0f;
        }

        @Override
        public float getMaxValue(k p0) {
            return 0f;
        }
    }

    public static class SpeedBoolean extends LogicBoolean {
        @Parameter
        public boolean atTopSpeed;

        public SpeedBoolean() {
            super();
        }

        @Override
        public boolean read(k p0) {
            return false;
        }

        @Override
        public String getMatchFailReasonForPlayer(k p0) {
            return null;
        }
    }

    public abstract static class StaticBoolean extends LogicBoolean {
        public StaticBoolean() {
            super();
        }

        @Override
        public LogicBoolean with(String p0) {
            return null;
        }
    }

    public static final class StaticBooleanFalse extends StaticBoolean {
        public StaticBooleanFalse() {
            super();
        }

        @Override
        public String getMatchFailReasonForPlayer(k p0) {
            return null;
        }

        @Override
        public boolean read(k p0) {
            return false;
        }
    }

    public static final class StaticBooleanTrue extends StaticBoolean {
        public StaticBooleanTrue() {
            super();
        }

        @Override
        public String getMatchFailReasonForPlayer(k p0) {
            return null;
        }

        @Override
        public boolean read(k p0) {
            return false;
        }
    }

    public static class TagsBoolean extends LogicBoolean {
        public h includesTag;

        public TagsBoolean() {
            super();
        }

        @Parameter
        public void includes(String p0) {
        }

        @Override
        public String getMatchFailReasonForPlayer(k p0) {
            return null;
        }

        @Override
        public boolean read(k p0) {
            return false;
        }
    }

    public static class TeamTagBoolean extends LogicBoolean {
        public h includesTag;

        public TeamTagBoolean() {
            super();
        }

        @Parameter
        public void includes(String p0) {
        }

        @Override
        public String getMatchFailReasonForPlayer(k p0) {
            return null;
        }

        @Override
        public boolean read(k p0) {
            return false;
        }
    }

    public static final class TimeAliveBoolean extends TimeBoolean {
        public TimeAliveBoolean() {
            super();
        }

        @Override
        public String getName() {
            return null;
        }

        @Override
        public int getTime(k p0) {
            return 0;
        }
    }

    public abstract static class TimeBoolean extends LogicBoolean {
        @Parameter
        public float laterThanSeconds;

        @Parameter
        public float withinSeconds;

        public TimeBoolean() {
            super();
        }

        public abstract String getName();

        public abstract int getTime(k p0);

        @Override
        public void validateArguments(String p0, String p1, String p2) {
        }

        @Override
        public String getMatchFailReasonForPlayer(k p0) {
            return null;
        }

        private String msToSecondsString(float p0) {
            return null;
        }

        @Override
        public boolean read(k p0) {
            return false;
        }
    }

    public static class TouchWaterBoolean extends LogicBoolean {
        public TouchWaterBoolean() {
            super();
        }

        @Override
        public boolean read(k p0) {
            return false;
        }

        @Override
        public String getMatchFailReasonForPlayer(k p0) {
            return null;
        }
    }

    public static class TransportingCountBoolean extends AbstractNumberBoolean {
        public h _withTag;

        public boolean filtered;

        @Parameter
        public int slot;

        public TransportingCountBoolean() {
            super();
        }

        @Override
        public String getName() {
            return null;
        }

        @Parameter
        public void withTag(String p0) {
        }

        @Override
        public void validateArguments(String p0, String p1, String p2) {
        }

        @Override
        public float getValue(k p0) {
            return 0f;
        }

        @Override
        public float getMaxValue(k p0) {
            return 0f;
        }
    }

    public static class TransportingUnitWithTagsBoolean extends LogicBoolean {
        public h includesTag;

        public TransportingUnitWithTagsBoolean() {
            super();
        }

        @Parameter
        public void includes(String p0) {
        }

        @Override
        public String getMatchFailReasonForPlayer(k p0) {
            return null;
        }

        @Override
        public boolean read(k p0) {
            return false;
        }
    }
}
