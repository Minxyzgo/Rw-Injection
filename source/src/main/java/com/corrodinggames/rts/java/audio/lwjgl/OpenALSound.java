package com.corrodinggames.rts.java.audio.lwjgl;

import com.corrodinggames.rts.java.audio.Sound;

public class OpenALSound implements Sound {
    private int bufferID;

    private final OpenALAudio audio = null;

    private float duration;

    private int bytesUsed;

    public OpenALSound(OpenALAudio p0) {
        super();
    }

    void setup(byte[] p0, int p1, int p2) {
    }

    @Override
    public int getBytesUsed() {
        return 0;
    }

    @Override
    public long play() {
        return 0;
    }

    @Override
    public long play(float p0) {
        return 0;
    }

    @Override
    public long loop() {
        return 0;
    }

    @Override
    public long loop(float p0) {
        return 0;
    }

    @Override
    public void stop() {
    }

    @Override
    public void dispose() {
    }

    @Override
    public void stop(long p0) {
    }

    @Override
    public void pause() {
    }

    @Override
    public void pause(long p0) {
    }

    @Override
    public void resume() {
    }

    @Override
    public void resume(long p0) {
    }

    @Override
    public void setPitch(long p0, float p1) {
    }

    @Override
    public void setVolume(long p0, float p1) {
    }

    @Override
    public void setLooping(long p0, boolean p1) {
    }

    @Override
    public void setPan(long p0, float p1, float p2) {
    }

    @Override
    public long play(float p0, float p1, float p2) {
        return 0;
    }

    @Override
    public long loop(float p0, float p1, float p2) {
        return 0;
    }

    public float duration() {
        return 0f;
    }
}
