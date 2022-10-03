package com.corrodinggames.rts.java.audio;

import com.corrodinggames.rts.java.audio.a.a;

public strictfp interface Audio {
    AudioDevice newAudioDevice(int p0, boolean p1);

    AudioRecorder newAudioRecorder(int p0, boolean p1);

    Sound newSound(a p0);

    Music newMusic(a p0);
}
