package android.graphics;

import rwij.annotations.Additional;

public class Matrix {
    public static final int MSCALE_X = 0;

    public static final int MSKEW_X = 0;

    public static final int MTRANS_X = 0;

    public static final int MSKEW_Y = 0;

    public static final int MSCALE_Y = 0;

    public static final int MTRANS_Y = 0;

    public static final int MPERSP_0 = 0;

    public static final int MPERSP_1 = 0;

    public static final int MPERSP_2 = 0;

    public Matrix() {
        super();
    }

    public Matrix(Matrix p0) {
        super();
    }

    public boolean isIdentity() {
        return false;
    }

    public boolean rectStaysRect() {
        return false;
    }

    public void set(Matrix p0) {
    }

    public void reset() {
    }

    public void setTranslate(float p0, float p1) {
    }

    public void setScale(float p0, float p1, float p2, float p3) {
    }

    public void setScale(float p0, float p1) {
    }

    public void setRotate(float p0, float p1, float p2) {
    }

    public void setRotate(float p0) {
    }

    public void setSinCos(float p0, float p1, float p2, float p3) {
    }

    public void setSinCos(float p0, float p1) {
    }

    public void setSkew(float p0, float p1, float p2, float p3) {
    }

    public void setSkew(float p0, float p1) {
    }

    public boolean setConcat(Matrix p0, Matrix p1) {
        return false;
    }

    public boolean preTranslate(float p0, float p1) {
        return false;
    }

    public boolean preScale(float p0, float p1, float p2, float p3) {
        return false;
    }

    public boolean preScale(float p0, float p1) {
        return false;
    }

    public boolean preRotate(float p0, float p1, float p2) {
        return false;
    }

    public boolean preRotate(float p0) {
        return false;
    }

    public boolean preSkew(float p0, float p1, float p2, float p3) {
        return false;
    }

    public boolean preSkew(float p0, float p1) {
        return false;
    }

    public boolean preConcat(Matrix p0) {
        return false;
    }

    public boolean postTranslate(float p0, float p1) {
        return false;
    }

    public boolean postScale(float p0, float p1, float p2, float p3) {
        return false;
    }

    public boolean postScale(float p0, float p1) {
        return false;
    }

    public boolean postRotate(float p0, float p1, float p2) {
        return false;
    }

    public boolean postRotate(float p0) {
        return false;
    }

    public boolean postSkew(float p0, float p1, float p2, float p3) {
        return false;
    }

    public boolean postSkew(float p0, float p1) {
        return false;
    }

    public boolean postConcat(Matrix p0) {
        return false;
    }

    public boolean setRectToRect(RectF p0, RectF p1, ScaleToFit p2) {
        return false;
    }

    public boolean setPolyToPoly(float[] p0, int p1, float[] p2, int p3, int p4) {
        return false;
    }

    public boolean invert(Matrix p0) {
        return false;
    }

    public void mapPoints(float[] p0, int p1, float[] p2, int p3, int p4) {
    }

    public void mapVectors(float[] p0, int p1, float[] p2, int p3, int p4) {
    }

    public void mapPoints(float[] p0, float[] p1) {
    }

    public void mapVectors(float[] p0, float[] p1) {
    }

    public void mapPoints(float[] p0) {
    }

    public void mapVectors(float[] p0) {
    }

    public boolean mapRect(RectF p0, RectF p1) {
        return false;
    }

    public boolean mapRect(RectF p0) {
        return false;
    }

    public float mapRadius(float p0) {
        return 0f;
    }

    public void getValues(float[] p0) {
    }

    public void setValues(float[] p0) {
    }

    public String toShortString() {
        return null;
    }

    @Override
    protected void finalize() throws Throwable {
    }

    /**
     * Rename from: android.graphics.Matrix#1
     */
    static final class Matrix41 extends Matrix {
        Matrix41() {
            super();
        }

        void b() {
        }

        public void a() {
        }

        public void a(float p0, float p1, float p2) {
        }

        public boolean a(float p0, float p1) {
            return false;
        }

        public boolean b(float p0, float p1) {
            return false;
        }
    }

    public enum ScaleToFit {
        CENTER,

        END,

        FILL,

        START,

        $VALUES;

        private ScaleToFit(String p0, int p1) {
        }

        @Additional
        ScaleToFit() {

        }
    }
}
