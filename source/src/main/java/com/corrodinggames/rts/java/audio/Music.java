package com.corrodinggames.rts.java.audio;

public strictfp interface Music {
    void play();

    void pause();

    void stop();

    boolean isPlaying();

    void setLooping(boolean p0);

    boolean isLooping();

    void setVolume(float p0);

    float getVolume();

    void setPan(float p0, float p1);

    void setPosition(float p0);

    float getPosition();

    void dispose();

    void setOnCompletionListener(OnCompletionListener p0);

    strictfp interface OnCompletionListener {
        void onCompletion(Music p0);
    }
}
