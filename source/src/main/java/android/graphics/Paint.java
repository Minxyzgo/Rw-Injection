package android.graphics;

import rwij.annotations.Additional;

import java.util.Locale;

public class Paint {
    public static final int ANTI_ALIAS_FLAG = 0;

    public static final int FILTER_BITMAP_FLAG = 0;

    public static final int DITHER_FLAG = 0;

    public static final int UNDERLINE_TEXT_FLAG = 0;

    public static final int STRIKE_THRU_TEXT_FLAG = 0;

    public static final int FAKE_BOLD_TEXT_FLAG = 0;

    public static final int LINEAR_TEXT_FLAG = 0;

    public static final int SUBPIXEL_TEXT_FLAG = 0;

    public static final int DEV_KERN_TEXT_FLAG = 0;

    public static final int HINTING_OFF = 0;

    public static final int HINTING_ON = 0;

    public Paint() {
        super();
    }

    public Paint(int p0) {
        super();
    }

    public Paint(Paint p0) {
        super();
    }

    public void reset() {
    }

    public void set(Paint p0) {
    }

    public native int getFlags();

    public native void setFlags(int p0);

    public native int getHinting();

    public native void setHinting(int p0);

    public final boolean isAntiAlias() {
        return false;
    }

    public native void setAntiAlias(boolean p0);

    public final boolean isDither() {
        return false;
    }

    public native void setDither(boolean p0);

    public final boolean isLinearText() {
        return false;
    }

    public native void setLinearText(boolean p0);

    public final boolean isSubpixelText() {
        return false;
    }

    public native void setSubpixelText(boolean p0);

    public final boolean isUnderlineText() {
        return false;
    }

    public native void setUnderlineText(boolean p0);

    public final boolean isStrikeThruText() {
        return false;
    }

    public native void setStrikeThruText(boolean p0);

    public final boolean isFakeBoldText() {
        return false;
    }

    public native void setFakeBoldText(boolean p0);

    public final boolean isFilterBitmap() {
        return false;
    }

    public native void setFilterBitmap(boolean p0);

    public Style getStyle() {
        return null;
    }

    public void setStyle(Style p0) {
    }

    public native int getColor();

    public native void setColor(int p0);

    public native int getAlpha();

    public native void setAlpha(int p0);

    public void setARGB(int p0, int p1, int p2, int p3) {
    }

    public native float getStrokeWidth();

    public native void setStrokeWidth(float p0);

    public native float getStrokeMiter();

    public native void setStrokeMiter(float p0);

    public Cap getStrokeCap() {
        return null;
    }

    public void setStrokeCap(Cap p0) {
    }

    public Join getStrokeJoin() {
        return null;
    }

    public void setStrokeJoin(Join p0) {
    }

    public boolean getFillPath(Path p0, Path p1) {
        return false;
    }

    public Shader getShader() {
        return null;
    }

    public Shader setShader(Shader p0) {
        return null;
    }

    public ColorFilter getColorFilter() {
        return null;
    }

    public ColorFilter setColorFilter(ColorFilter p0) {
        return null;
    }

    public Xfermode getXfermode() {
        return null;
    }

    public Xfermode setXfermode(Xfermode p0) {
        return null;
    }

    public PathEffect getPathEffect() {
        return null;
    }

    public PathEffect setPathEffect(PathEffect p0) {
        return null;
    }

    public MaskFilter getMaskFilter() {
        return null;
    }

    public MaskFilter setMaskFilter(MaskFilter p0) {
        return null;
    }

    public Typeface getTypeface() {
        return null;
    }

    public Typeface setTypeface(Typeface p0) {
        return null;
    }

    public Rasterizer getRasterizer() {
        return null;
    }

    public Rasterizer setRasterizer(Rasterizer p0) {
        return null;
    }

    public void setShadowLayer(float p0, float p1, float p2, int p3) {
    }

    public void clearShadowLayer() {
    }

    public Align getTextAlign() {
        return null;
    }

    public void setTextAlign(Align p0) {
    }

    public Locale getTextLocale() {
        return null;
    }

    public void setTextLocale(Locale p0) {
    }

    public native float getTextSize();

    public native void setTextSize(float p0);

    public native float getTextScaleX();

    public native void setTextScaleX(float p0);

    public native float getTextSkewX();

    public native void setTextSkewX(float p0);

    public native float ascent();

    public native float descent();

    public native float getFontMetrics(FontMetrics p0);

    public FontMetrics getFontMetrics() {
        return null;
    }

    public native int getFontMetricsInt(FontMetricsInt p0);

    public FontMetricsInt getFontMetricsInt() {
        return null;
    }

    public float getFontSpacing() {
        return 0f;
    }

    public float measureText(char[] p0, int p1, int p2) {
        return 0f;
    }

    public float measureText(String p0, int p1, int p2) {
        return 0f;
    }

    public float measureText(String p0) {
        return 0f;
    }

    public float measureText(CharSequence p0, int p1, int p2) {
        return 0f;
    }

    public int breakText(char[] p0, int p1, int p2, float p3, float[] p4) {
        return 0;
    }

    public int breakText(CharSequence p0, int p1, int p2, boolean p3, float p4, float[] p5) {
        return 0;
    }

    public int breakText(String p0, boolean p1, float p2, float[] p3) {
        return 0;
    }

    public int getTextWidths(char[] p0, int p1, int p2, float[] p3) {
        return 0;
    }

    public int getTextWidths(CharSequence p0, int p1, int p2, float[] p3) {
        return 0;
    }

    public int getTextWidths(String p0, int p1, int p2, float[] p3) {
        return 0;
    }

    public int getTextWidths(String p0, float[] p1) {
        return 0;
    }

    public void getTextPath(char[] p0, int p1, int p2, float p3, float p4, Path p5) {
    }

    public void getTextPath(String p0, int p1, int p2, float p3, float p4, Path p5) {
    }

    public void getTextBounds(String p0, int p1, int p2, Rect p3) {
    }

    public void getTextBounds(char[] p0, int p1, int p2, Rect p3) {
    }

    @Override
    protected void finalize() throws Throwable {
    }

    public enum Align {
        CENTER,

        LEFT,

        RIGHT,

        $VALUES;

        private Align(String p0, int p1) {
        }

        @Additional
        Align() {

        }
    }

    public enum Cap {
        BUTT,

        ROUND,

        SQUARE,

        $VALUES;

        private Cap(String p0, int p1) {
        }

        @Additional
        Cap() {

        }
    }

    public static class FontMetrics {
        public float top;

        public float ascent;

        public float descent;

        public float bottom;

        public float leading;

        public FontMetrics() {
            super();
        }
    }

    public static class FontMetricsInt {
        public int top;

        public int ascent;

        public int descent;

        public int bottom;

        public int leading;

        public FontMetricsInt() {
            super();
        }
    }

    public enum Join {
        BEVEL,

        MITER,

        ROUND,

        $VALUES;

        private Join(String p0, int p1) {
        }

        @Additional
        Join() {

        }
    }

    public enum Style {
        FILL,

        FILL_AND_STROKE,

        STROKE,

        $VALUES;

        private Style(String p0, int p1) {
        }

        @Additional
        Style() {

        }
    }
}
