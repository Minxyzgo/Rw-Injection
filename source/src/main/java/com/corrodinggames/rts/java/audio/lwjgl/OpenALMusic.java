package com.corrodinggames.rts.java.audio.lwjgl;

import com.corrodinggames.rts.java.audio.Music;
import com.corrodinggames.rts.java.audio.a.a;
import com.corrodinggames.rts.java.audio.a.b;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;

public abstract class OpenALMusic implements Music {
    private static final int bufferSize = 0;

    private static final int bufferCount = 0;

    private static final int bytesPerSample = 0;

    private static final byte[] tempBytes = null;

    private static final ByteBuffer tempBuffer = null;

    private b renderedSecondsQueue;

    private final OpenALAudio audio = null;

    private IntBuffer buffers;

    private int sourceID;

    private int format;

    private int sampleRate;

    private boolean isLooping;

    private boolean isPlaying;

    private float volume;

    private float pan;

    private float renderedSeconds;

    private float maxSecondsPerBuffer;

    protected final a file = null;

    protected int bufferOverhead;

    private Music.OnCompletionListener onCompletionListener;

    public OpenALMusic(OpenALAudio p0, a p1) {
        super();
    }

    protected void setup(int p0, int p1) {
    }

    public void playWhenReady() {
    }

    @Override
    public void play() {
    }

    @Override
    public void stop() {
    }

    @Override
    public void pause() {
    }

    @Override
    public boolean isPlaying() {
        return false;
    }

    @Override
    public void setLooping(boolean p0) {
    }

    @Override
    public boolean isLooping() {
        return false;
    }

    @Override
    public void setVolume(float p0) {
    }

    @Override
    public float getVolume() {
        return 0f;
    }

    @Override
    public void setPan(float p0, float p1) {
    }

    @Override
    public void setPosition(float p0) {
    }

    @Override
    public float getPosition() {
        return 0f;
    }

    public abstract int read(byte[] p0);

    public void reset() {
    }

    protected void loop() {
    }

    public int getChannels() {
        return 0;
    }

    public int getRate() {
        return 0;
    }

    public void backgroundUpdate() {
    }

    public void update() {
    }

    private boolean fill(int p0) {
        return false;
    }

    @Override
    public void dispose() {
    }

    @Override
    public void setOnCompletionListener(Music.OnCompletionListener p0) {
    }

    public int getSourceId() {
        return 0;
    }
}
