package android.util;

import java.text.SimpleDateFormat;

public final class Log {
    public static final int VERBOSE = 0;

    public static final int DEBUG = 0;

    public static final int INFO = 0;

    public static final int WARN = 0;

    public static final int ERROR = 0;

    public static final int ASSERT = 0;

    Log() {
        super();
    }

    public static int v(String p0, String p1) {
        return 0;
    }

    public static int v(String p0, String p1, Throwable p2) {
        return 0;
    }

    public static int d(String p0, String p1) {
        return 0;
    }

    public static int d(String p0, String p1, Throwable p2) {
        return 0;
    }

    public static int i(String p0, String p1) {
        return 0;
    }

    public static int i(String p0, String p1, Throwable p2) {
        return 0;
    }

    public static int w(String p0, String p1) {
        return 0;
    }

    public static int w(String p0, String p1, Throwable p2) {
        return 0;
    }

    public static native boolean isLoggable(String p0, int p1);

    public static int w(String p0, Throwable p1) {
        return 0;
    }

    public static int e(String p0, String p1) {
        return 0;
    }

    public static int e(String p0, String p1, Throwable p2) {
        return 0;
    }

    public static int wtf(String p0, String p1) {
        return 0;
    }

    public static int wtf(String p0, Throwable p1) {
        return 0;
    }

    public static int wtf(String p0, String p1, Throwable p2) {
        return 0;
    }

    public static String getStackTraceString(Throwable p0) {
        return null;
    }

    public static int println(int p0, String p1, String p2) {
        return 0;
    }

    /**
     * Rename from: android.util.Log#1
     */
    static final class Log47 extends ThreadLocal {
        Log47() {
            super();
        }

        protected SimpleDateFormat a() {
            return null;
        }

        @Override
        protected Object initialValue() {
            return null;
        }
    }

    public interface TerribleFailureHandler {
    }
}
