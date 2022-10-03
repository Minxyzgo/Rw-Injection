package android.graphics;

import android.os.Parcel;
import android.os.Parcelable;

public final class Rect implements Parcelable {
    public static final Parcelable.Creator CREATOR = null;

    public int left;

    public int top;

    public int right;

    public int bottom;

    public Rect() {
        super();
    }

    public Rect(int p0, int p1, int p2, int p3) {
        super();
    }

    public Rect(Rect p0) {
        super();
    }

    public String toShortString() {
        return null;
    }

    public String flattenToString() {
        return null;
    }

    public static Rect unflattenFromString(String p0) {
        return null;
    }

    public final boolean isEmpty() {
        return false;
    }

    public final int width() {
        return 0;
    }

    public final int height() {
        return 0;
    }

    public final int centerX() {
        return 0;
    }

    public final int centerY() {
        return 0;
    }

    public final float exactCenterX() {
        return 0f;
    }

    public final float exactCenterY() {
        return 0f;
    }

    public void setEmpty() {
    }

    public void set(int p0, int p1, int p2, int p3) {
    }

    public void set(Rect p0) {
    }

    public void offset(int p0, int p1) {
    }

    public void offsetTo(int p0, int p1) {
    }

    public void inset(int p0, int p1) {
    }

    public boolean contains(int p0, int p1) {
        return false;
    }

    public boolean contains(int p0, int p1, int p2, int p3) {
        return false;
    }

    public boolean contains(Rect p0) {
        return false;
    }

    public boolean intersect(int p0, int p1, int p2, int p3) {
        return false;
    }

    public boolean intersect(Rect p0) {
        return false;
    }

    public boolean setIntersect(Rect p0, Rect p1) {
        return false;
    }

    public boolean intersects(int p0, int p1, int p2, int p3) {
        return false;
    }

    public static boolean intersects(Rect p0, Rect p1) {
        return false;
    }

    public void union(int p0, int p1, int p2, int p3) {
    }

    public void union(Rect p0) {
    }

    public void union(int p0, int p1) {
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
}
