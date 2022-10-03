package com.corrodinggames.rts.game.units.custom;

import android.graphics.LightingColorFilter;
import com.corrodinggames.rts.gameFramework.b.e;
import com.corrodinggames.rts.gameFramework.b.g;
import com.corrodinggames.rts.gameFramework.b.h;
import com.corrodinggames.rts.gameFramework.utility.ab;
import com.corrodinggames.rts.gameFramework.w;
import java.util.ArrayList;

public class ad {
    public static final ad defaultEffectTemplate = null;

    public static ArrayList fields;

    public String name;

    private ae builtInEffect;

    public g imageStrip;

    public boolean createWhenOffscreen;

    public boolean createWhenZoomedOut;

    public boolean createWhenOverLiquid;

    public boolean createWhenOverLand;

    public float spawnChance;

    x ifSpawnFailsEmitEffects;

    public float life;

    public float lifeRandom;

    public boolean showInFog;

    public float xOffsetRelative;

    public float yOffsetRelative;

    public float hOffset;

    public boolean alwayStartDirAtZero;

    public float dirOffset;

    public float xOffsetRelativeRandom;

    public float yOffsetRelativeRandom;

    public float hOffsetRandom;

    public float dirOffsetRandom;

    public float xOffsetAbsolute;

    public float yOffsetAbsolute;

    public float xOffsetAbsoluteRandom;

    public float yOffsetAbsoluteRandom;

    public float xSpeedRelative;

    public float ySpeedRelative;

    public float hSpeed;

    public float dirSpeed;

    public float xSpeedRelativeRandom;

    public float ySpeedRelativeRandom;

    public float hSpeedRandom;

    public float dirSpeedRandom;

    public float xSpeedAbsolute;

    public float ySpeedAbsolute;

    public float xSpeedAbsoluteRandom;

    public float ySpeedAbsoluteRandom;

    public h priority;

    public float scaleTo;

    public float scaleFrom;

    public float alpha;

    public int color;

    public LightingColorFilter cachedLightingColorFilter;

    public float teamColorRatio;

    public boolean shadow;

    public short drawLayer;

    public float fadeInTime;

    public boolean fadeOut;

    public float delayedStartTimer;

    public float delayedStartTimerRandom;

    public int frameIndex;

    public int frameIndexRandom;

    public int stripIndex;

    public boolean attachedToUnit;

    public boolean liveAfterAttachedDies;

    public boolean atmospheric;

    public boolean physics;

    public float physicsGravity;

    public int animateFrameStart;

    public int animateFrameEnd;

    public int animateFrameStartRandomAdd;

    public boolean animateFramePingPong;

    public boolean animateFrameLooping;

    public float animateFrameSpeed;

    public float animateFrameSpeedRandom;

    public x alsoEmitEffects;

    public x alsoEmitEffectsOnDeath;

    public aq alsoPlaySound;

    public ad(ae p0) {
        super();
    }

    ad(String p0) {
        super();
    }

    public e a(float p0, float p1, float p2, float p3, w p4, int p5, short p6) {
        return null;
    }

    public final float a(float p0) {
        return 0f;
    }

    public final float a(float p0, float p1) {
        return 0f;
    }

    public void a(l p0, ab p1, String p2) {
    }
}
