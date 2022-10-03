package com.corrodinggames.rts.java.audio.lwjgl;

import com.corrodinggames.rts.java.audio.Audio;
import com.corrodinggames.rts.java.audio.AudioDevice;
import com.corrodinggames.rts.java.audio.AudioRecorder;
import com.corrodinggames.rts.java.audio.Music;
import com.corrodinggames.rts.java.audio.Sound;
import com.corrodinggames.rts.java.audio.a.a;
import com.corrodinggames.rts.java.audio.a.d;
import com.corrodinggames.rts.java.audio.a.e;
import com.corrodinggames.rts.java.audio.a.i;
import com.corrodinggames.rts.java.audio.a.o;
import java.util.ArrayList;

public class OpenALAudio implements Audio {
    private final int deviceBufferSize = 0;

    private final int deviceBufferCount = 0;

    private d idleSources;

    private d allSources;

    private i soundIdToSource;

    private e sourceToSoundId;

    private long nextSoundId;

    private o extensionToSoundClass;

    private o extensionToMusicClass;

    private OpenALSound[] recentSounds;

    private int mostRecetSound;

    ArrayList music;

    boolean noDevice;

    public OpenALAudio() {
        super();
    }

    public OpenALAudio(int p0, int p1, int p2) {
        super();
    }

    public void registerSound(String p0, Class p1) {
    }

    public void registerMusic(String p0, Class p1) {
    }

    @Override
    public OpenALSound newSound(a p0) {
        return null;
    }

    @Override
    public OpenALMusic newMusic(a p0) {
        return null;
    }

    int obtainSource(boolean p0) {
        return 0;
    }

    void freeSource(int p0) {
    }

    void freeBuffer(int p0) {
    }

    void stopSourcesWithBuffer(int p0) {
    }

    void pauseSourcesWithBuffer(int p0) {
    }

    void resumeSourcesWithBuffer(int p0) {
    }

    public void backgroundUpdate() {
    }

    public boolean hasDevice() {
        return false;
    }

    public void update() {
    }

    public long getSoundId(int p0) {
        return 0;
    }

    public void stopSound(long p0) {
    }

    public void pauseSound(long p0) {
    }

    public void resumeSound(long p0) {
    }

    public void setSoundGain(long p0, float p1) {
    }

    public void setSoundLooping(long p0, boolean p1) {
    }

    public void setSoundPitch(long p0, float p1) {
    }

    public void setSoundPan(long p0, float p1, float p2) {
    }

    public void dispose() {
    }

    @Override
    public AudioDevice newAudioDevice(int p0, boolean p1) {
        return null;
    }

    @Override
    public AudioRecorder newAudioRecorder(int p0, boolean p1) {
        return null;
    }

    protected void retain(OpenALSound p0, boolean p1) {
    }

    public void forget(OpenALSound p0) {
    }

    /**
     * Rename from: com.corrodinggames.rts.java.audio.lwjgl.OpenALAudio#1
     */
    class OpenALAudio272 implements AudioDevice {
        final boolean val$isMono = false;

        OpenALAudio272(OpenALAudio p0, boolean p1) {
            super();
        }

        @Override
        public void writeSamples(float[] p0, int p1, int p2) {
        }

        @Override
        public void writeSamples(short[] p0, int p1, int p2) {
        }

        @Override
        public void setVolume(float p0) {
        }

        @Override
        public boolean isMono() {
            return false;
        }

        @Override
        public int getLatency() {
            return 0;
        }

        @Override
        public void dispose() {
        }
    }

    /**
     * Rename from: com.corrodinggames.rts.java.audio.lwjgl.OpenALAudio#2
     */
    class OpenALAudio273 implements AudioRecorder {
        OpenALAudio273(OpenALAudio p0) {
            super();
        }

        @Override
        public void read(short[] p0, int p1, int p2) {
        }

        @Override
        public void dispose() {
        }
    }
}
