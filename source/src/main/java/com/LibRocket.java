package com;

import java.util.ArrayList;
import java.util.HashMap;

public class LibRocket {
    String currentDocumentPath;

    ElementDocument currentDocument;

    String[] activeDocumentCss;

    int reloadSkip;

    public boolean debug;

    ArrayList lastDocuments;

    long longLastModified;

    long longLastModifiedNewestCss;

    public String documentPrefix;

    protected boolean queueExtraUpdate;

    public int lastMouseX;

    public int lastMouseY;

    ArrayList compiledGeometryList;

    ArrayList textureHolderList;

    public LibRocket() {
        super();
    }

    public native void setup();

    private native ElementDocument loadDocument(String p0);

    private native void loadDocumentWithContainer(String p0, ElementDocument p1);

    public native void loadFont(String p0, String p1);

    public native void update();

    public native void render();

    public native void setDimensions(int p0, int p1);

    public native void processMouseMove(int p0, int p1, int p2);

    public native void processMouseButtonDown(int p0, int p1);

    public native void processMouseButtonUp(int p0, int p1);

    public native void processMouseWheel(int p0, int p1);

    public native void processTextInput(String p0);

    public native void processTextInputChar(int p0);

    public native void processKeyDown(int p0, int p1);

    public native void processKeyUp(int p0, int p1);

    public void backToLastDocument() {
    }

    public void clearHistory() {
    }

    public ElementDocument setDocument(String p0) {
        return null;
    }

    public ElementDocument setDocument(String p0, HashMap p1) {
        return null;
    }

    public ElementDocument setDocument(String p0, HashMap p1, boolean p2) {
        return null;
    }

    public void newDocumentLoaded(ElementDocument p0) {
    }

    public void newDocumentShown(ElementDocument p0) {
    }

    public ElementDocument createPopup(String p0, Object p1) {
        return null;
    }

    public void closeDocument(ElementDocument p0) {
    }

    public void closeActiveDocument() {
    }

    public ElementDocument getActiveDocument() {
        return null;
    }

    public HashMap getActiveDocumentMetadata() {
        return null;
    }

    public Element getActiveElementById(String p0) {
        return null;
    }

    public String[] getActiveDocumentCss() {
        return null;
    }

    public long getFileLastModified(String p0) {
        return 0;
    }

    public long getLastModifiedNewestCss() {
        return 0;
    }

    public long getLastModified() {
        return 0;
    }

    public void detectChangesAndReload() {
    }

    public String getDocumentPath(String p0) {
        return null;
    }

    public void loadFont(String p0) {
    }

    public void postUpdate() {
    }

    public void mouseMove(int p0, int p1, int p2) {
    }

    public void RenderGeometry(float[] p0, float[] p1, int[] p2, int[] p3, int p4, float p5,
            float p6) {
    }

    public void RenderGeometryPossiblyCompiled(float[] p0, float[] p1, int[] p2, int[] p3, int p4,
            float p5, float p6, CompiledGeometry p7) {
    }

    public int CompileGeometry(float[] p0, float[] p1, int[] p2, int[] p3, int p4) {
        return 0;
    }

    public void RenderCompiledGeometry(int p0, float p1, float p2) {
    }

    public void ReleaseCompiledGeometry(int p0) {
    }

    public void ReleaseCompiledGeometryForTexture(int p0) {
    }

    public void EnableScissorRegion(boolean p0) {
    }

    public void SetScissorRegion(int p0, int p1, int p2, int p3) {
    }

    public boolean LoadTexture(int p0, String p1) {
        return false;
    }

    public boolean GenerateTexture(int p0, byte[] p1) {
        return false;
    }

    public void ReleaseTexture(int p0) {
    }

    public void HandleEvent(String p0) {
    }

    public String TranslateString(String p0) {
        return null;
    }

    private void callback(String p0) {
    }

    public static void test() {
    }

    public static void main(String[] p0) {
    }

    public TextureHolder getNewTextureHolder() {
        return null;
    }

    public TextureHolder findTextureHolder(int p0) {
        return null;
    }

    public boolean removeTextureHolder(int p0) {
        return false;
    }

    public TextureHolder getFromTextureHolderFactory() {
        return null;
    }

    public static void log(String p0) {
    }

    public static void warn(String p0) {
    }

    public class CompiledGeometry {
        public int f325id;

        public float[] verticesXY;

        public float[] verticesUV;

        public int[] verticesColors;

        public int[] indices;

        public int textureId;

        public Object bbox;

        public CompiledGeometry(LibRocket p0) {
            super();
        }
    }

    public class TextureHolder {
        public int index;

        public int width;

        public int height;

        public TextureHolder(LibRocket p0) {
            super();
        }

        public void remove() {
        }
    }
}
