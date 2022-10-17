package com.corrodinggames.rts.gameFramework.utility;

import rwij.annotations.RenameFrom;

import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.InputStream;

@RenameFrom(oldName = "j")
public class FileInputStreamPackage extends InputStream {
    InputStream a;

    String b;

    String c;

    private FileInputStreamPackage() {
        super();
    }

    public FileInputStreamPackage(InputStream p0, String p1, String p2) {
        super();
    }

    public FileInputStreamPackage(FileInputStream p0, String p1) {
        super();
    }

    public FileInputStreamPackage(InputStream p0, String p1) {
        super();
    }

    public boolean a() {
        return false;
    }

    public FileDescriptor b() {
        return null;
    }

    public long c() {
        return 0;
    }

    public String d() {
        return null;
    }

    @Override
    public int available() {
        return 0;
    }

    @Override
    public void close() {
    }

    @Override
    public void mark(int p0) {
    }

    @Override
    public boolean markSupported() {
        return false;
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
    public void reset() {
    }

    @Override
    public long skip(long p0) {
        return 0;
    }
}
