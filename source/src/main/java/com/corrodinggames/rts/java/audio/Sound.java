package com.corrodinggames.rts.java.audio;

public strictfp interface Sound {
    long play();

    long play(float p0);

    long play(float p0, float p1, float p2);

    long loop();

    long loop(float p0);

    long loop(float p0, float p1, float p2);

    void stop();

    void pause();

    void resume();

    void dispose();

    void stop(long p0);

    void pause(long p0);

    void resume(long p0);

    void setLooping(long p0, boolean p1);

    void setPitch(long p0, float p1);

    void setVolume(long p0, float p1);

    void setPan(long p0, float p1, float p2);

    int getBytesUsed();
}
