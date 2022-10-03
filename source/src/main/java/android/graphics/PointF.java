package android.graphics;

import android.os.Parcel;
import android.os.Parcelable;

public class PointF implements Parcelable {
    public static final Parcelable.Creator CREATOR = null;

    public float x;

    public float y;

    public PointF() {
        super();
    }

    public PointF(float p0, float p1) {
        super();
    }

    public PointF(Point p0) {
        super();
    }

    public final void set(float p0, float p1) {
    }

    public final void set(PointF p0) {
    }

    public final void negate() {
    }

    public final void offset(float p0, float p1) {
    }

    public final boolean equals(float p0, float p1) {
        return false;
    }

    public final float length() {
        return 0f;
    }

    public static float length(float p0, float p1) {
        return 0f;
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
