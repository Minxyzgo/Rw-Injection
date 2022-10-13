package com.corrodinggames.rts.java.audio.lwjgl;

import com.corrodinggames.rts.java.audio.AudioRecorder;
import javax.sound.sampled.TargetDataLine;

public class JavaSoundAudioRecorder implements AudioRecorder {
    private TargetDataLine line;

    private byte[] buffer;

    public JavaSoundAudioRecorder(int p0, boolean p1) {
        super();
    }

    @Override
    public void read(short[] p0, int p1, int p2) {
    }

    @Override
    public void dispose() {
    }
}
