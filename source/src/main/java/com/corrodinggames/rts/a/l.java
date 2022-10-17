package com.corrodinggames.rts.a;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Handler;
import android.widget.EditText;
import com.corrodinggames.rts.gameFramework.g.ResponsePacket;

public class l extends b {
    public static l b;

    public static boolean d;

    static ResponsePacket f;

    static AlertDialog g;

    final Handler c = null;

    public boolean e;

    private Handler h;

    private Runnable i;

    private Runnable j;

    public static boolean j() {
        return false;
    }

    public static void c(String p0) {
    }

    public static void a(String p0, String p1) {
    }

    public static void k() {
    }

    public static void l() {
    }

    public static void m() {
    }

    public static void n() {
    }

    public static void a(ResponsePacket p0) {
    }

    /**
     * Rename from: com.corrodinggames.rts.a.l#1
     */
    static final class l76 implements Runnable {
        final l a = null;

        final String b = null;

        l76(l p0, String p1) {
            super();
        }

        @Override
        public void run() {
        }
    }

    /**
     * Rename from: com.corrodinggames.rts.a.l#2
     */
    static final class l77 implements DialogInterface.OnClickListener {
        final EditText a = null;

        final ResponsePacket b = null;

        l77(EditText p0, ResponsePacket p1) {
            super();
        }

        @Override
        public void onClick(DialogInterface p0, int p1) {
        }
    }

    /**
     * Rename from: com.corrodinggames.rts.a.l#3
     */
    static final class l78 implements DialogInterface.OnClickListener {
        final ResponsePacket a = null;

        l78(ResponsePacket p0) {
            super();
        }

        @Override
        public void onClick(DialogInterface p0, int p1) {
        }
    }

    /**
     * Rename from: com.corrodinggames.rts.a.l#4
     */
    static final class l79 implements DialogInterface.OnCancelListener {
        final ResponsePacket a = null;

        l79(ResponsePacket p0) {
            super();
        }

        @Override
        public void onCancel(DialogInterface p0) {
        }
    }
}
