package com.corrodinggames.rts.java;

import com.corrodinggames.rts.gameFramework.g.ac;
import com.corrodinggames.rts.gameFramework.g.Network;
import com.corrodinggames.rts.gameFramework.g.ResponsePacket;
import com.corrodinggames.rts.gameFramework.g.Connection;
import com.corrodinggames.rts.gameFramework.n;
import com.corrodinggames.rts.gameFramework.utility.ah;
import com.corrodinggames.rts.java.b.a;
import rwij.annotations.RenameFrom;

import java.util.concurrent.Semaphore;

public class Main extends ac {
    public static boolean a;

    public static boolean b;

    public static String c = "Rusted Warfare";

    static Main m;

    public d37 d;

    public String e = "$28";

    ah f;

    boolean g;

    public Network h;

    a i;

    @RenameFrom(oldName = "j")
    public GameController controller;

    GameScene k;

    String[] l;

    int n;

    long o;

    com.corrodinggames.rts.java.d.a p;

    n q;

    Thread r;

    boolean s;

    Object t;

    public boolean u;

    public int v;

    Main() {
        super();
    }

    public static void main(String[] p0) {
    }

    public static void a(String p0) {
    }

    public void f() {
    }

    public void g() {
    }

    public void a(String[] p0) {
    }

    public void b(String p0) {
    }

    public void h() {
    }

    @Override
    public void b() {
    }

    public void a(float p0) {
    }

    public void a(boolean p0) {
    }

    @Override
    public boolean a(Connection p0, String p1, String p2) {
        return false;
    }

    @Override
    public void b(Connection p0, String p1, String p2) {
    }

    @Override
    public void c() {
    }

    @Override
    public void a(int p0, String p1, String p2, Connection p3) {
    }

    public void a(Connection p0, String p1, String p2, boolean p3) {
    }

    @Override
    public String a(Connection p0, String p1) {
        return null;
    }

    @Override
    public void c(Connection p0, String p1, String p2) {
    }

    @Override
    public void b(Connection p0, String p1) {
    }

    public void i() {
    }

    @Override
    public void d() {
    }

    @Override
    public void a(ResponsePacket p0) {
    }

    /**
     * Rename from: com.corrodinggames.rts.java.Main#1
     */
    static final class Main278 implements Runnable {
        Main278() {
            super();
        }

        @Override
        public void run() {
        }
    }

    /**
     * Rename from: com.corrodinggames.rts.java.Main#2
     */
    static class Main279 implements Runnable {
        final Semaphore a = null;

        final Main b = null;

        Main279(Main p0, Semaphore p1) {
            super();
        }

        @Override
        public void run() {
        }
    }

    /**
     * Rename from: com.corrodinggames.rts.java.Main#3
     */
    static class Main280 implements Runnable {
        final Main a = null;

        Main280(Main p0) {
            super();
        }

        @Override
        public void run() {
        }
    }

    /**
     * Rename from: com.corrodinggames.rts.java.Main#4
     */
    static class Main281 implements Runnable {
        final int a = 0;

        final String b = null;

        final String c = null;

        final Connection d = null;

        final Main e = null;

        Main281(Main p0, int p1, String p2, String p3, Connection p4) {
            super();
        }

        @Override
        public void run() {
        }
    }
}
