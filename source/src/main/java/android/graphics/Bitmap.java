package android.graphics;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.DisplayMetrics;
import rwij.annotations.Additional;

import java.io.OutputStream;
import java.nio.Buffer;

public final class Bitmap implements Parcelable {
    public static final int DENSITY_NONE = 0;

    public static final android.os.Parcelable.Creator CREATOR = null;

    Bitmap() {
        super();
    }

    public int getDensity() {
        return 0;
    }

    public void setDensity(int p0) {
    }

    public void recycle() {
    }

    public final boolean isRecycled() {
        return false;
    }

    public int getGenerationId() {
        return 0;
    }

    public void copyPixelsToBuffer(Buffer p0) {
    }

    public void copyPixelsFromBuffer(Buffer p0) {
    }

    public Bitmap copy(android.graphics.Bitmap.Config p0, boolean p1) {
        return null;
    }

    public static Bitmap createScaledBitmap(Bitmap p0, int p1, int p2, boolean p3) {
        return null;
    }

    public static Bitmap createBitmap(Bitmap p0) {
        return null;
    }

    public static Bitmap createBitmap(Bitmap p0, int p1, int p2, int p3, int p4) {
        return null;
    }

    public static Bitmap createBitmap(Bitmap p0, int p1, int p2, int p3, int p4, Matrix p5,
            boolean p6) {
        return null;
    }

    public static Bitmap createBitmap(int p0, int p1, android.graphics.Bitmap.Config p2) {
        return null;
    }

    public static Bitmap createBitmap(DisplayMetrics p0, int p1, int p2,
            android.graphics.Bitmap.Config p3) {
        return null;
    }

    public static Bitmap createBitmap(int[] p0, int p1, int p2, int p3, int p4,
            android.graphics.Bitmap.Config p5) {
        return null;
    }

    public static Bitmap createBitmap(DisplayMetrics p0, int[] p1, int p2, int p3, int p4, int p5,
            android.graphics.Bitmap.Config p6) {
        return null;
    }

    public static Bitmap createBitmap(int[] p0, int p1, int p2, android.graphics.Bitmap.Config p3) {
        return null;
    }

    public static Bitmap createBitmap(DisplayMetrics p0, int[] p1, int p2, int p3,
            android.graphics.Bitmap.Config p4) {
        return null;
    }

    public byte[] getNinePatchChunk() {
        return null;
    }

    public boolean compress(android.graphics.Bitmap.CompressFormat p0, int p1, OutputStream p2) {
        return false;
    }

    public final boolean isMutable() {
        return false;
    }

    public final boolean isPremultiplied() {
        return false;
    }

    public final int getWidth() {
        return 0;
    }

    public final int getHeight() {
        return 0;
    }

    public int getScaledWidth(Canvas p0) {
        return 0;
    }

    public int getScaledHeight(Canvas p0) {
        return 0;
    }

    public int getScaledWidth(DisplayMetrics p0) {
        return 0;
    }

    public int getScaledHeight(DisplayMetrics p0) {
        return 0;
    }

    public int getScaledWidth(int p0) {
        return 0;
    }

    public int getScaledHeight(int p0) {
        return 0;
    }

    public final int getRowBytes() {
        return 0;
    }

    public final int getByteCount() {
        return 0;
    }

    public final android.graphics.Bitmap.Config getConfig() {
        return null;
    }

    public final boolean hasAlpha() {
        return false;
    }

    public void setHasAlpha(boolean p0) {
    }

    public final boolean hasMipMap() {
        return false;
    }

    public final void setHasMipMap(boolean p0) {
    }

    public void eraseColor(int p0) {
    }

    public int getPixel(int p0, int p1) {
        return 0;
    }

    public void getPixels(int[] p0, int p1, int p2, int p3, int p4, int p5, int p6) {
    }

    public void setPixel(int p0, int p1, int p2) {
    }

    public void setPixels(int[] p0, int p1, int p2, int p3, int p4, int p5, int p6) {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel p0, int p1) {
    }

    public Bitmap extractAlpha() {
        return null;
    }

    public Bitmap extractAlpha(Paint p0, int[] p1) {
        return null;
    }

    public boolean sameAs(Bitmap p0) {
        return false;
    }

    public void prepareToDraw() {
    }

    /**
     * Rename from: android.graphics.Bitmap#1
     */
    static final class Bitmap40 implements android.os.Parcelable.Creator {
        Bitmap40() {
            super();
        }

        public Bitmap a(Parcel p0) {
            return null;
        }

        public Bitmap[] a(int p0) {
            return null;
        }

        @Override
        public Object[] newArray(int p0) {
            return null;
        }

        @Override
        public Object createFromParcel(Parcel p0) {
            return null;
        }
    }

    public enum CompressFormat {
        JPEG,

        PNG,

        WEBP,

        $VALUES;

        private CompressFormat(String p0, int p1) {
        }

        @Additional
        CompressFormat() {

        }
    }

    public enum Config {
        ALPHA_8,

        ARGB_4444,

        ARGB_8888,

        RGB_565,

        $VALUES;

        private Config(String p0, int p1) {
        }

        @Additional
        Config() {

        }
    }
}
