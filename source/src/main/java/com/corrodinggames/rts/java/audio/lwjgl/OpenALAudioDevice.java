package com.corrodinggames.rts.java.audio.lwjgl;

import com.corrodinggames.rts.java.audio.AudioDevice;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;

public class OpenALAudioDevice implements AudioDevice {
    private static final int bytesPerSample = 0;

    private final OpenALAudio audio = null;

    private final int channels = 0;

    private IntBuffer buffers;

    private int sourceID;

    private int format;

    private int sampleRate;

    private boolean isPlaying;

    private float volume;

    private float renderedSeconds;

    private float secondsPerBuffer;

    private byte[] bytes;

    private final int bufferSize = 0;

    private final int bufferCount = 0;

    private final ByteBuffer tempBuffer = null;

    public OpenALAudioDevice(OpenALAudio p0, int p1, boolean p2, int p3, int p4) {
        super();
    }

    @Override
    public void writeSamples(short[] p0, int p1, int p2) {
    }

    @Override
    public void writeSamples(float[] p0, int p1, int p2) {
    }

    public void writeSamples(byte[] p0, int p1, int p2) {
    }

    private int fillBuffer(byte[] p0, int p1, int p2) {
        return 0;
    }

    public void stop() {
    }

    public boolean isPlaying() {
        return false;
    }

    @Override
    public void setVolume(float p0) {
    }

    public float getPosition() {
        return 0f;
    }

    public void setPosition(float p0) {
    }

    public int getChannels() {
        return 0;
    }

    public int getRate() {
        return 0;
    }

    @Override
    public void dispose() {
    }

    @Override
    public boolean isMono() {
        return false;
    }

    @Override
    public int getLatency() {
        return 0;
    }
}
