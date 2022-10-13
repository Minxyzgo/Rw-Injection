package com.corrodinggames.rts.java.audio;

public strictfp interface AudioDevice {
    boolean isMono();

    void writeSamples(short[] p0, int p1, int p2);

    void writeSamples(float[] p0, int p1, int p2);

    int getLatency();

    void dispose();

    void setVolume(float p0);
}
