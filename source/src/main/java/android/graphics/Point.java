package android.graphics;

import android.os.Parcel;
import android.os.Parcelable;

public class Point implements Parcelable {
    public static final Parcelable.Creator CREATOR = null;

    public int x;

    public int y;

    public Point() {
        super();
    }

    public Point(int p0, int p1) {
        super();
    }

    public Point(Point p0) {
        super();
    }

    public void set(int p0, int p1) {
    }

    public final void negate() {
    }

    public final void offset(int p0, int p1) {
    }

    public final boolean equals(int p0, int p1) {
        return false;
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
     * Rename from: android.graphics.Point#1
     */
    static final class Point42 implements Parcelable.Creator {
        Point42() {
            super();
        }

        public Point a(Parcel p0) {
            return null;
        }

        public Point[] a(int p0) {
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
