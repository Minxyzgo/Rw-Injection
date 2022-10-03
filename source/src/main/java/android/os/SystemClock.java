package android.os;

public final class SystemClock {
    SystemClock() {
        super();
    }

    public static void sleep(long p0) {
    }

    public static native boolean setCurrentTimeMillis(long p0);

    public static native long uptimeMillis();

    public static native long elapsedRealtime();

    public static native long elapsedRealtimeNanos();

    public static native long currentThreadTimeMillis();
}
