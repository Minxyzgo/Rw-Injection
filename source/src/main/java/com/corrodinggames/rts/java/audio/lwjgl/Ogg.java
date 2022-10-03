package com.corrodinggames.rts.java.audio.lwjgl;

import com.corrodinggames.rts.java.audio.a.a;

public class Ogg {
    public Ogg() {
        super();
    }

    public static class Music extends OpenALMusic {
        private OggInputStream input;

        private OggInputStream previousInput;

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

        @Override
        protected void loop() {
        }
    }

    public static class MusicWithThreadedLoader extends OpenALMusic {
        private OggInputStream input;

        private OggInputStream previousInput;

        ThreadedWrappingAudioInputStream backgroundInput;

        public MusicWithThreadedLoader(OpenALAudio p0, a p1) {
            super(null,null);
        }

        @Override
        public int read(byte[] p0) {
            return 0;
        }

        @Override
        public void backgroundUpdate() {
        }

        @Override
        public void reset() {
        }

        @Override
        protected void loop() {
        }
    }

    public static class Sound extends OpenALSound {
        public Sound(OpenALAudio p0, a p1) {
            super(null);
        }
    }
}
