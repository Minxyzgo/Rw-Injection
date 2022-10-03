package com.corrodinggames.rts.java.audio.lwjgl;

import java.io.InputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class ThreadedWrappingAudioInputStream extends InputStream {
    InputStream source;

    PipedInputStream bufferInputStream;

    PipedOutputStream bufferOutputStream;

    byte[] transferBuffer;

    boolean isClosed;

    boolean sourceEnded;

    final int bufferSize = 0;

    int totalBytesRead;

    public ThreadedWrappingAudioInputStream(InputStream p0) {
        super();
    }

    public void backgroundFillBuffer() {
    }

    @Override
    public int read() {
        return 0;
    }

    @Override
    public int read(byte[] p0, int p1, int p2) {
        return 0;
    }

    @Override
    public int read(byte[] p0) {
        return 0;
    }

    @Override
    public void close() {
    }
}
