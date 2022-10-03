package android.os;

public final class Message implements Parcelable {
    public static final Parcelable.Creator CREATOR = null;

    public int what;

    public int arg1;

    public int arg2;

    public Object obj;

    public Messenger replyTo;

    public Message() {
        super();
    }

    public static Message obtain() {
        return null;
    }

    public static Message obtain(Message p0) {
        return null;
    }

    public static Message obtain(Handler p0) {
        return null;
    }

    public static Message obtain(Handler p0, Runnable p1) {
        return null;
    }

    public static Message obtain(Handler p0, int p1) {
        return null;
    }

    public static Message obtain(Handler p0, int p1, Object p2) {
        return null;
    }

    public static Message obtain(Handler p0, int p1, int p2, int p3) {
        return null;
    }

    public static Message obtain(Handler p0, int p1, int p2, int p3, Object p4) {
        return null;
    }

    public void recycle() {
    }

    public void copyFrom(Message p0) {
    }

    public long getWhen() {
        return 0;
    }

    public void setTarget(Handler p0) {
    }

    public Handler getTarget() {
        return null;
    }

    public Runnable getCallback() {
        return null;
    }

    public Bundle getData() {
        return null;
    }

    public Bundle peekData() {
        return null;
    }

    public void setData(Bundle p0) {
    }

    public void sendToTarget() {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel p0, int p1) {
    }

    /**
     * Rename from: android.os.Message#1
     */
    static final class Message46 implements Parcelable.Creator {
        Message46() {
            super();
        }

        public Message a(Parcel p0) {
            return null;
        }

        public Message[] a(int p0) {
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
