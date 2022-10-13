package android.graphics;

import android.os.Parcel;
import android.os.Parcelable;

public class RectF implements Parcelable {
    public static final Parcelable.Creator CREATOR = null;

    public float left;

    public float top;

    public float right;

    public float bottom;

    public RectF() {
        super();
    }

    public RectF(float p0, float p1, float p2, float p3) {
        super();
    }

    public RectF(RectF p0) {
        super();
    }

    public RectF(Rect p0) {
        super();
    }

    public String toShortString() {
        return null;
    }

    public final boolean isEmpty() {
        return false;
    }

    public final float width() {
        return 0f;
    }

    public final float height() {
        return 0f;
    }

    public final float centerX() {
        return 0f;
    }

    public final float centerY() {
        return 0f;
    }

    public void setEmpty() {
    }

    public void set(float p0, float p1, float p2, float p3) {
    }

    public void set(RectF p0) {
    }

    public void set(Rect p0) {
    }

    public void offset(float p0, float p1) {
    }

    public void offsetTo(float p0, float p1) {
    }

    public void inset(float p0, float p1) {
    }

    public boolean contains(float p0, float p1) {
        return false;
    }

    public boolean contains(float p0, float p1, float p2, float p3) {
        return false;
    }

    public boolean contains(RectF p0) {
        return false;
    }

    public boolean intersect(float p0, float p1, float p2, float p3) {
        return false;
    }

    public boolean intersect(RectF p0) {
        return false;
    }

    public boolean setIntersect(RectF p0, RectF p1) {
        return false;
    }

    public boolean intersects(float p0, float p1, float p2, float p3) {
        return false;
    }

    public static boolean intersects(RectF p0, RectF p1) {
        return false;
    }

    public void round(Rect p0) {
    }

    public void roundOut(Rect p0) {
    }

    public void union(float p0, float p1, float p2, float p3) {
    }

    public void union(RectF p0) {
    }

    public void union(float p0, float p1) {
    }

    public void sort() {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel p0, int p1) {
    }

    public void readFromParcel(Parcel p0) {
    }

    /**
     * Rename from: android.graphics.RectF#1
     */
    static final class RectF43 implements Parcelable.Creator {
        RectF43() {
            super();
        }

        public RectF a(Parcel p0) {
            return null;
        }

        public RectF[] a(int p0) {
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
}
