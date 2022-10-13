package com.corrodinggames.rts.java.audio;

public strictfp interface AudioRecorder {
    void read(short[] p0, int p1, int p2);

    void dispose();
}
