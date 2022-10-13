package com.codedisaster.steamworks;

import rwij.annotations.Additional;

import java.nio.ByteBuffer;

public class SteamUtils extends SteamInterface {
    private SteamUtilsCallbackAdapter callbackAdapter;

    public SteamUtils(SteamUtilsCallback p0) {
        super(0);
    }

    public int getSecondsSinceAppActive() {
        return 0;
    }

    public int getSecondsSinceComputerActive() {
        return 0;
    }

    public SteamUniverse getConnectedUniverse() {
        return null;
    }

    public int getServerRealTime() {
        return 0;
    }

    public int getImageWidth(int p0) {
        return 0;
    }

    public int getImageHeight(int p0) {
        return 0;
    }

    public boolean getImageRGBA(int p0, ByteBuffer p1, int p2) {
        return false;
    }

    public int getAppID() {
        return 0;
    }

    public void setOverlayNotificationPosition(NotificationPosition p0) {
    }

    public boolean isAPICallCompleted(SteamAPICall p0, boolean[] p1) {
        return false;
    }

    public SteamAPICallFailure getAPICallFailureReason(SteamAPICall p0) {
        return null;
    }

    public void setWarningMessageHook(SteamAPIWarningMessageHook p0) {
    }

    public boolean isOverlayEnabled() {
        return false;
    }

    private static native long createCallback(SteamUtilsCallbackAdapter p0);

    private static native int getSecondsSinceAppActive(long p0);

    private static native int getSecondsSinceComputerActive(long p0);

    private static native int getConnectedUniverse(long p0);

    private static native int getServerRealTime(long p0);

    private static native String getIPCountry(long p0);

    private static native int getImageWidth(long p0, int p1);

    private static native int getImageHeight(long p0, int p1);

    private static native boolean getImageRGBA(long p0, int p1, ByteBuffer p2, int p3);

    private static native int getAppID(long p0);

    private static native void setOverlayNotificationPosition(long p0, int p1);

    private static native boolean isAPICallCompleted(long p0, long p1, boolean[] p2);

    private static native int getAPICallFailureReason(long p0, long p1);

    private static native void enableWarningMessageHook(long p0, boolean p1);

    private static native boolean isOverlayEnabled(long p0);

    @Override
    public void dispose() {
    }

    public enum NotificationPosition {
        TopLeft,

        TopRight,

        BottomLeft,

        BottomRight,

        $VALUES;

        private NotificationPosition(String p0, int p1) {
        }

        @Additional
        NotificationPosition() {

        }
    }

    public enum SteamAPICallFailure {
        None,

        SteamGone,

        NetworkFailure,

        InvalidHandle,

        MismatchedCallback,

        code,

        values,

        $VALUES;

        private SteamAPICallFailure(String p0, int p1, int p2) {
        }

        @Additional
        SteamAPICallFailure() {

        }

        static SteamAPICallFailure byValue(int p0) {
            return null;
        }
    }
}
