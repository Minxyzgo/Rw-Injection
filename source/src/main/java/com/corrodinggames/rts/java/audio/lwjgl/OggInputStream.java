package com.corrodinggames.rts.java.audio.lwjgl;

import com.jcraft.jogg.Packet;
import com.jcraft.jogg.Page;
import com.jcraft.jogg.StreamState;
import com.jcraft.jogg.SyncState;
import com.jcraft.jorbis.Block;
import com.jcraft.jorbis.Comment;
import com.jcraft.jorbis.DspState;
import com.jcraft.jorbis.Info;
import java.io.InputStream;

public class OggInputStream extends InputStream {
    private static final int BUFFER_SIZE = 0;

    private int convsize;

    private byte[] convbuffer;

    private InputStream input;

    private Info oggInfo;

    private boolean endOfStream;

    private SyncState syncState;

    private StreamState streamState;

    private Page page;

    private Packet packet;

    private Comment comment;

    private DspState dspState;

    private Block vorbisBlock;

    byte[] buffer;

    int bytes;

    boolean bigEndian;

    boolean endOfBitStream;

    boolean inited;

    private int readIndex;

    private byte[] outBuffer;

    private int outIndex;

    private int total;

    public OggInputStream(InputStream p0) {
        super();
    }

    public OggInputStream(InputStream p0, OggInputStream p1) {
        super();
    }

    public int getLength() {
        return 0;
    }

    public int getChannels() {
        return 0;
    }

    public int getSampleRate() {
        return 0;
    }

    private void init() {
    }

    @Override
    public int available() {
        return 0;
    }

    private void initVorbis() {
    }

    private boolean getPageAndPacket() {
        return false;
    }

    private void readPCM() {
    }

    @Override
    public int read() {
        return 0;
    }

    public boolean atEnd() {
        return false;
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
