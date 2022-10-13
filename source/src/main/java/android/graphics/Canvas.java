package android.graphics;

import rwij.annotations.Additional;

public class Canvas {
    public static final int MATRIX_SAVE_FLAG = 0;

    public static final int CLIP_SAVE_FLAG = 0;

    public static final int HAS_ALPHA_LAYER_SAVE_FLAG = 0;

    public static final int FULL_COLOR_LAYER_SAVE_FLAG = 0;

    public static final int CLIP_TO_LAYER_SAVE_FLAG = 0;

    public static final int ALL_SAVE_FLAG = 0;

    public Canvas() {
        super();
    }

    public Canvas(Bitmap p0) {
        super();
    }

    public boolean isHardwareAccelerated() {
        return false;
    }

    public void setBitmap(Bitmap p0) {
    }

    public native boolean isOpaque();

    public native int getWidth();

    public native int getHeight();

    public int getDensity() {
        return 0;
    }

    public void setDensity(int p0) {
    }

    public int getMaximumBitmapWidth() {
        return 0;
    }

    public int getMaximumBitmapHeight() {
        return 0;
    }

    public native int save();

    public native int save(int p0);

    public int saveLayer(RectF p0, Paint p1, int p2) {
        return 0;
    }

    public int saveLayer(float p0, float p1, float p2, float p3, Paint p4, int p5) {
        return 0;
    }

    public int saveLayerAlpha(RectF p0, int p1, int p2) {
        return 0;
    }

    public int saveLayerAlpha(float p0, float p1, float p2, float p3, int p4, int p5) {
        return 0;
    }

    public native void restore();

    public native int getSaveCount();

    public native void restoreToCount(int p0);

    public native void translate(float p0, float p1);

    public native void scale(float p0, float p1);

    public final void scale(float p0, float p1, float p2, float p3) {
    }

    public native void rotate(float p0);

    public final void rotate(float p0, float p1, float p2) {
    }

    public native void skew(float p0, float p1);

    public void concat(Matrix p0) {
    }

    public void setMatrix(Matrix p0) {
    }

    @Deprecated
    public void getMatrix(Matrix p0) {
    }

    @Deprecated
    public final Matrix getMatrix() {
        return null;
    }

    public boolean clipRect(RectF p0, Region.Op p1) {
        return false;
    }

    public boolean clipRect(Rect p0, Region.Op p1) {
        return false;
    }

    public native boolean clipRect(RectF p0);

    public native boolean clipRect(Rect p0);

    public boolean clipRect(float p0, float p1, float p2, float p3, Region.Op p4) {
        return false;
    }

    public native boolean clipRect(float p0, float p1, float p2, float p3);

    public native boolean clipRect(int p0, int p1, int p2, int p3);

    public boolean clipPath(Path p0, Region.Op p1) {
        return false;
    }

    public boolean clipPath(Path p0) {
        return false;
    }

    public boolean clipRegion(Region p0, Region.Op p1) {
        return false;
    }

    public boolean clipRegion(Region p0) {
        return false;
    }

    public DrawFilter getDrawFilter() {
        return null;
    }

    public void setDrawFilter(DrawFilter p0) {
    }

    public boolean quickReject(RectF p0, EdgeType p1) {
        return false;
    }

    public boolean quickReject(Path p0, EdgeType p1) {
        return false;
    }

    public boolean quickReject(float p0, float p1, float p2, float p3, EdgeType p4) {
        return false;
    }

    public boolean getClipBounds(Rect p0) {
        return false;
    }

    public final Rect getClipBounds() {
        return null;
    }

    public void drawRGB(int p0, int p1, int p2) {
    }

    public void drawARGB(int p0, int p1, int p2, int p3) {
    }

    public void drawColor(int p0) {
    }

    public void drawColor(int p0, PorterDuff.Mode p1) {
    }

    public void drawPaint(Paint p0) {
    }

    public native void drawPoints(float[] p0, int p1, int p2, Paint p3);

    public void drawPoints(float[] p0, Paint p1) {
    }

    public native void drawPoint(float p0, float p1, Paint p2);

    public void drawLine(float p0, float p1, float p2, float p3, Paint p4) {
    }

    public native void drawLines(float[] p0, int p1, int p2, Paint p3);

    public void drawLines(float[] p0, Paint p1) {
    }

    public void drawRect(RectF p0, Paint p1) {
    }

    public void drawRect(Rect p0, Paint p1) {
    }

    public void drawRect(float p0, float p1, float p2, float p3, Paint p4) {
    }

    public void drawOval(RectF p0, Paint p1) {
    }

    public void drawCircle(float p0, float p1, float p2, Paint p3) {
    }

    public void drawArc(RectF p0, float p1, float p2, boolean p3, Paint p4) {
    }

    public void drawRoundRect(RectF p0, float p1, float p2, Paint p3) {
    }

    public void drawPath(Path p0, Paint p1) {
    }

    public void drawBitmap(Bitmap p0, float p1, float p2, Paint p3) {
    }

    public void drawBitmap(Bitmap p0, Rect p1, RectF p2, Paint p3) {
    }

    public void drawBitmap(Bitmap p0, Rect p1, Rect p2, Paint p3) {
    }

    public void drawBitmap(int[] p0, int p1, int p2, float p3, float p4, int p5, int p6, boolean p7,
            Paint p8) {
    }

    public void drawBitmap(int[] p0, int p1, int p2, int p3, int p4, int p5, int p6, boolean p7,
            Paint p8) {
    }

    public void drawBitmap(Bitmap p0, Matrix p1, Paint p2) {
    }

    public void drawBitmapMesh(Bitmap p0, int p1, int p2, float[] p3, int p4, int[] p5, int p6,
            Paint p7) {
    }

    public void drawVertices(VertexMode p0, int p1, float[] p2, int p3, float[] p4, int p5,
            int[] p6, int p7, short[] p8, int p9, int p10, Paint p11) {
    }

    public void drawText(char[] p0, int p1, int p2, float p3, float p4, Paint p5) {
    }

    public void drawText(String p0, float p1, float p2, Paint p3) {
    }

    public void drawText(String p0, int p1, int p2, float p3, float p4, Paint p5) {
    }

    public void drawText(CharSequence p0, int p1, int p2, float p3, float p4, Paint p5) {
    }

    @Deprecated
    public void drawPosText(char[] p0, int p1, int p2, float[] p3, Paint p4) {
    }

    @Deprecated
    public void drawPosText(String p0, float[] p1, Paint p2) {
    }

    public void drawTextOnPath(char[] p0, int p1, int p2, Path p3, float p4, float p5, Paint p6) {
    }

    public void drawTextOnPath(String p0, Path p1, float p2, float p3, Paint p4) {
    }

    public void drawPicture(Picture p0) {
    }

    public void drawPicture(Picture p0, RectF p1) {
    }

    public void drawPicture(Picture p0, Rect p1) {
    }

    public enum EdgeType {
        AA,

        BW,

        $VALUES;

        private EdgeType(String p0, int p1) {
        }

        @Additional
        EdgeType() {

        }
    }

    public enum VertexMode {
        TRIANGLES,

        TRIANGLE_FAN,

        TRIANGLE_STRIP,

        $VALUES;

        private VertexMode(String p0, int p1) {
        }

        @Additional
        VertexMode() {

        }
    }
}
