package com.corrodinggames.rts.java.audio.lwjgl;

import com.corrodinggames.rts.java.audio.a.a;
import java.io.FilterInputStream;

public class Wav {
    public Wav() {
        super();
    }

    public static class Music extends OpenALMusic {
        private WavInputStream input;

        public Music(OpenALAudio p0, a p1) {
            super(null,null);
        }

        @Override
        public int read(byte[] p0) {
            return 0;
        }

        @Override
        public void reset() {
        }
    }

    public static class Sound extends OpenALSound {
        public Sound(OpenALAudio p0, a p1) {
            super(null);
        }
    }

    public static class WavInputStream extends FilterInputStream {
        public int channels;

        public int sampleRate;

        public int dataRemaining;

        public WavInputStream(a p0) {
            super(null);
        }

        private int seekToChunk(char p0, char p1, char p2, char p3) {
            return 0;
        }

        private void skipFully(int p0) {
        }

        @Override
        public int read(byte[] p0) {
            return 0;
        }
    }
}
