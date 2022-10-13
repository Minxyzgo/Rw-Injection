package android.os;

import android.util.Printer;

public class Handler {
    public Handler() {
        super();
    }

    public Handler(Callback p0) {
        super();
    }

    public Handler(Looper p0) {
        super();
    }

    public Handler(Looper p0, Callback p1) {
        super();
    }

    public void handleMessage(Message p0) {
    }

    public void dispatchMessage(Message p0) {
    }

    public String getMessageName(Message p0) {
        return null;
    }

    public final Message obtainMessage() {
        return null;
    }

    public final Message obtainMessage(int p0) {
        return null;
    }

    public final Message obtainMessage(int p0, Object p1) {
        return null;
    }

    public final Message obtainMessage(int p0, int p1, int p2) {
        return null;
    }

    public final Message obtainMessage(int p0, int p1, int p2, Object p3) {
        return null;
    }

    public final boolean post(Runnable p0) {
        return false;
    }

    public final boolean postAtTime(Runnable p0, long p1) {
        return false;
    }

    public final boolean postAtTime(Runnable p0, Object p1, long p2) {
        return false;
    }

    public final boolean postDelayed(Runnable p0, long p1) {
        return false;
    }

    public final boolean postAtFrontOfQueue(Runnable p0) {
        return false;
    }

    public final void removeCallbacks(Runnable p0) {
    }

    public final void removeCallbacks(Runnable p0, Object p1) {
    }

    public final boolean sendMessage(Message p0) {
        return false;
    }

    public final boolean sendEmptyMessage(int p0) {
        return false;
    }

    public final boolean sendEmptyMessageDelayed(int p0, long p1) {
        return false;
    }

    public final boolean sendEmptyMessageAtTime(int p0, long p1) {
        return false;
    }

    public final boolean sendMessageDelayed(Message p0, long p1) {
        return false;
    }

    public boolean sendMessageAtTime(Message p0, long p1) {
        return false;
    }

    public final boolean sendMessageAtFrontOfQueue(Message p0) {
        return false;
    }

    public final void removeMessages(int p0) {
    }

    public final void removeMessages(int p0, Object p1) {
    }

    public final void removeCallbacksAndMessages(Object p0) {
    }

    public final boolean hasMessages(int p0) {
        return false;
    }

    public final boolean hasMessages(int p0, Object p1) {
        return false;
    }

    public final Looper getLooper() {
        return null;
    }

    public final void dump(Printer p0, String p1) {
    }

    public strictfp interface Callback {
        boolean handleMessage(Message p0);
    }
}
