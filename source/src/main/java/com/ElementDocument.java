package com;

import java.util.ArrayList;
import java.util.HashMap;

public class ElementDocument extends Element {
    public static final int NONE = 0;

    public static final int FOCUS = 0;

    public static final int MODAL = 0;

    public String documentPath;

    public HashMap metadata;

    public boolean translatedToUnicode;

    public ArrayList pageTimers;

    public ElementDocument() {
        super();
    }

    public native void show(int p0);

    @Override
    public native void hide();

    private native void close();

    public native void pullToFront();

    public native void pushToBack();

    @Override
    public void show() {
    }

    public void closeDocument() {
    }

    public Object getMetadata(String p0) {
        return null;
    }

    public Object getMetadata(String p0, Object p1) {
        return null;
    }

    public Float getMetadataFloat(String p0) {
        return null;
    }

    public void setMetadata(String p0, Object p1) {
    }

    public void setMetadataFloat(String p0, Float p1) {
    }

    public HashMap getMetadataMap() {
        return null;
    }
}
