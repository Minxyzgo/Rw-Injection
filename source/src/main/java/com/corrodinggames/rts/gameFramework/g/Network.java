package com.corrodinggames.rts.gameFramework.g;

import android.app.Notification;
import android.app.NotificationManager;
import com.corrodinggames.rts.game.e;
import com.corrodinggames.rts.game.Team;
import com.corrodinggames.rts.gameFramework.d.a.i;
import com.corrodinggames.rts.gameFramework.e25;
import com.corrodinggames.rts.gameFramework.GameEngine;
import rwij.annotations.RenameFrom;

import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentLinkedQueue;

@RenameFrom(oldName = "ad")
public final strictfp class Network {
    public static final boolean a = false;

    public static boolean b;

    public static boolean aB;

    public static ResponsePacket bE;

    public ac c;

    public int d;

    ArrayList e;

    public boolean f;

    public int g;

    public boolean h;

    public float i;

    public float j;

    public boolean k;

    public int l;

    public String m;

    public boolean n;

    public boolean o;

    public boolean p;

    public boolean q;

    public int r;

    public String s;

    public boolean t;

    public long u;

    public boolean v;

    public String w;

    private boolean bG;

    public Team x;

    public boolean y;

    private boolean bH;

    public volatile boolean z;

    public boolean A;

    public boolean B;

    public String C;

    public boolean D;

    public boolean E;

    public boolean F;

    public int G;

    private volatile float bI;

    public volatile float H;

    public Float I;

    public String J;

    public boolean K;

    public int L;

    public int M;

    public int N;

    public int O;

    public String P;

    public int Q;

    public int R;

    public boolean S;

    public float T;

    boolean U;

    public float V;

    public float W;

    public boolean X;

    public float Y;

    public boolean Z;

    public boolean aa;

    public int ab;

    public int ac;

    public boolean ad;

    public boolean ae;

    public boolean af;

    public long ag;

    public ArrayList ah;

    public CheckSumData ai;

    public CheckSumData aj;

    public CheckSumData ak;

    public CheckSumData al;

    public CheckSumData am;

    public CheckSumData an;

    public CheckSumData ao;

    public CheckSumData ap;

    public CheckSumData aq;

    public CheckSumData ar;

    public CheckSumData as;

    public CheckSumData at;

    public CheckSumData au;

    public CheckSumData av;

    public CheckSumData aw;

    public boolean ax;

    public boolean ay;

    public int az;

    public int aA;

    float aC;

    long aD;

    public boolean aE;

    public int aF;

    public int aG;

    public ServerData aH;

    public String aI;

    public GameInputStream aJ;

    public GameInputStream aK;

    public a aL;

    Thread aM;

    am aN;

    Thread aO;

    am aP;

    Timer aQ;

    HeartBeatPacker aR;

    Thread aS;

    ServerStarterSocket aT;

    Connection aU;

    public ConcurrentLinkedQueue aV;

    ConcurrentLinkedQueue aW;

    boolean aX;

    volatile int aY;

    Object aZ;

    String ba;

    String bb;

    public String bc;

    public Boolean bd;

    public Boolean be;

    public boolean bf;

    public boolean bg;

    public boolean bh;

    public boolean bi;

    public boolean bj;

    public boolean bk;

    public String bl;

    public ConcurrentLinkedQueue bm;

    public e bn;

    public e bo;

    public final Object bp = null;

    public boolean bq;

    float br;

    float bs;

    int bt;

    int bu;

    boolean bv;

    boolean bw;

    public Socket bx;

    public String by;

    public boolean bz;

    boolean bA;

    boolean bB;

    final Object bC = null;

    Timer bD;

    al bF;

    public Network() {
        super();
    }

    public String a(String p0) {
        return null;
    }

    public void a(float p0, String p1) {
    }

    public float a() {
        return 0f;
    }

    public void b() {
    }

    public void a(GameOutputStream p0) {
    }

    public void a(GameInputStream p0) {
    }

    public ServerData c() {
        return null;
    }

    public void d() {
    }

    public void a(ServerData p0) {
    }

    private void b(ServerData p0) {
    }

    public String e() {
        return null;
    }

    public String a(int p0) {
        return null;
    }

    public String b(int p0) {
        return null;
    }

    public String c(int p0) {
        return null;
    }

    public String f() {
        return null;
    }

    public ArrayList g() {
        return null;
    }

    public String d(int p0) {
        return null;
    }

    public String h() {
        return null;
    }

    public final int i() {
        return 0;
    }

    public int e(int p0) {
        return 0;
    }

    public boolean j() {
        return false;
    }

    public boolean k() {
        return false;
    }

    public void a(boolean p0, String p1, Boolean p2) {
    }

    void a(g p0) {
    }

    public long l() {
        return 0;
    }

    public void m() {
    }

    public void n() {
    }

    public void o() {
    }

    public void a(boolean p0) {
    }

    public void p() {
    }

    public void b(String p0) {
    }

    public void q() {
    }

    public void a(Connection p0) {
    }

    private void ap() {
    }

    void a(byte[] p0, Connection p1) {
    }

    public void r() {
    }

    public void s() {
    }

    private void c(float p0) {
    }

    private void aq() {
    }

    private void n(String p0) {
    }

    public long t() {
        return 0;
    }

    public long u() {
        return 0;
    }

    public void a(long p0) {
    }

    public boolean a(boolean p0, int p1) {
        return false;
    }

    public int v() {
        return 0;
    }

    public int w() {
        return 0;
    }

    public int x() {
        return 0;
    }

    public void c(String p0) {
    }

    public static void d(String p0) {
    }

    public void e(String p0) {
    }

    public static void f(String p0) {
    }

    public static void g(String p0) {
    }

    public static void a(String p0, boolean p1) {
    }

    public static void a(String p0, String p1) {
    }

    public void y() {
    }

    public void a(e25 p0) {
    }

    public void z() {
    }

    public void A() {
    }

    public void B() {
    }

    public void a(float p0) {
    }

    public void b(float p0) {
    }

    public boolean C() {
        return false;
    }

    public void a(float p0, boolean p1) {
    }

    public void a(PacketData p0) {
    }

    public boolean b(PacketData p0) {
        return false;
    }

    public void c(PacketData p0) {
    }

    private String o(String p0) {
        return null;
    }

    public void D() {
    }

    public void b(String p0, String p1) {
    }

    public void E() {
    }

    public void b(Connection p0) {
    }

    public void a(Connection p0, String p1) {
    }

    public void c(Connection p0) {
    }

    public void F() {
    }

    public void G() {
    }

    public void H() {
    }

    public void I() {
    }

    public void d(Connection p0) {
    }

    public boolean J() {
        return false;
    }

    public boolean K() {
        return false;
    }

    public boolean b(boolean p0) {
        return false;
    }

    public void c(boolean p0) {
    }

    public boolean L() {
        return false;
    }

    public al a(String p0, boolean p1, Runnable p2) {
        return null;
    }

    public static Socket b(String p0, boolean p1) {
        return null;
    }

    public void M() {
    }

    public boolean N() {
        return false;
    }

    public boolean a(Socket p0) {
        return false;
    }

    public Connection a(Team p0) {
        return null;
    }

    public Connection b(Team p0) {
        return null;
    }

    public Connection O() {
        return null;
    }

    public void d(PacketData p0) {
    }

    private void i(PacketData p0) {
    }

    public void e(PacketData p0) {
    }

    public void f(PacketData p0) {
    }

    public void g(PacketData p0) {
    }

    public void h(PacketData p0) {
    }

    public void a(Connection p0, PacketData p1) {
    }

    public void P() {
    }

    public void Q() {
    }

    public String R() {
        return null;
    }

    public void S() {
    }

    public String T() {
        return null;
    }

    public String U() {
        return null;
    }

    public void e(Connection p0) {
    }

    public void f(Connection p0) {
    }

    public void g(Connection p0) {
    }

    public String f(int p0) {
        return null;
    }

    public void V() {
    }

    public void h(String p0) {
    }

    public void i(String p0) {
    }

    public void j(String p0) {
    }

    public void k(String p0) {
    }

    public void a(Connection p0, Team p1, String p2, String p3) {
    }

    public void a(Connection p0, Team p1, String p2, String p3, Connection p4) {
    }

    public static String l(String p0) {
        return null;
    }

    public static String c(String p0, String p1) {
        return null;
    }

    private void a(Connection p0, int p1, String p2, String p3) {
    }

    public void a(Connection p0, byte[] p1, boolean p2, boolean p3) {
    }

    public void a(boolean p0, boolean p1, boolean p2) {
    }

    public boolean W() {
        return false;
    }

    public boolean a(Connection p0, boolean p1) {
        return false;
    }

    public void X() {
    }

    private void ar() {
    }

    private void as() {
    }

    public String Y() {
        return null;
    }

    public String Z() {
        return null;
    }

    public ArrayList aa() {
        return null;
    }

    public String ab() {
        return null;
    }

    public ArrayList d(boolean p0) {
        return null;
    }

    InetAddress ac() {
        return null;
    }

    public void d(String p0, String p1) {
    }

    public void ad() {
    }

    private void a(Notification.Builder p0, String p1) {
    }

    private void a(NotificationManager p0) {
    }

    private void a(NotificationManager p0, String p1, String p2) {
    }

    private void at() {
    }

    private void g(int p0) {
    }

    public int ae() {
        return 0;
    }

    public int af() {
        return 0;
    }

    public void c(Team p0) {
    }

    public void d(Team p0) {
    }

    public void ag() {
    }

    public boolean ah() {
        return false;
    }

    public void a(Team p0, int p1) {
    }

    private void c(Team p0, int p1) {
    }

    public void a(ak p0) {
    }

    private void b(ak p0) {
    }

    public void a(Team p0, int p1, Integer p2) {
    }

    public void b(Team p0, int p1) {
    }

    public void e(Team p0) {
    }

    public void f(Team p0) {
    }

    public void g(Team p0) {
    }

    public void ai() {
    }

    public void aj() {
    }

    public String ak() {
        return null;
    }

    public String al() {
        return null;
    }

    public String am() {
        return null;
    }

    public boolean an() {
        return false;
    }

    public void a(String p0, Connection p1) {
    }

    public boolean b(Connection p0, Team p1, String p2, String p3) {
        return false;
    }

    public static void a(ResponsePacket p0) {
    }

    public ArrayList ao() {
        return null;
    }

    public void e(boolean p0) {
    }

    public void h(Connection p0) {
    }

    public void i(Connection p0) {
    }

    public Connection a(Connection p0, int p1, String p2) {
        return null;
    }

    public Connection a(Connection p0, int p1) {
        return null;
    }

    public static String m(String p0) {
        return null;
    }

    public void a(ArrayList p0, boolean p1) {
    }

    /**
     * Rename from: com.corrodinggames.rts.gameFramework.g.ad#1
     */
    static final strictfp class ad230 extends ResponsePacket {
        final Object a = null;

        ad230(Object p0) {
            super();
        }

        @Override
        public void a(String p0) {
        }

        @Override
        public void a() {
        }
    }

    /**
     * Rename from: com.corrodinggames.rts.gameFramework.g.ad#2
     */
    static final strictfp class ad231 extends w {
        final Object d = null;

        ad231(Object p0) {
            super();
        }

        @Override
        public void a(String p0) {
        }

        @Override
        public void a(String p0, x p1, Exception p2) {
        }
    }

    /**
     * Rename from: com.corrodinggames.rts.gameFramework.g.ad#3
     */
    static strictfp class ad232 extends i {
        final com.corrodinggames.rts.gameFramework.d.a.e a = null;

        final Network b = null;

        ad232(Network p0, com.corrodinggames.rts.gameFramework.d.a.e p1) {
            super();
        }

        @Override
        public boolean a(com.corrodinggames.rts.gameFramework.d.a.c p0) {
            return false;
        }
    }

    /**
     * Rename from: com.corrodinggames.rts.gameFramework.g.ad#4
     */
    static strictfp class ad233 extends i {
        final com.corrodinggames.rts.gameFramework.d.a.e a = null;

        final Network b = null;

        ad233(Network p0, com.corrodinggames.rts.gameFramework.d.a.e p1) {
            super();
        }

        @Override
        public boolean a(com.corrodinggames.rts.gameFramework.d.a.c p0) {
            return false;
        }
    }

    /**
     * Rename from: com.corrodinggames.rts.gameFramework.g.ad#5
     */
    static strictfp class ad234 extends i {
        final com.corrodinggames.rts.gameFramework.d.a.e a = null;

        final GameEngine b = null;

        final Network c = null;

        ad234(Network p0, com.corrodinggames.rts.gameFramework.d.a.e p1, GameEngine p2) {
            super();
        }

        @Override
        public boolean a(com.corrodinggames.rts.gameFramework.d.a.c p0) {
            return false;
        }

        /**
         * Rename from: com.corrodinggames.rts.gameFramework.g.ad#ad234#1
         */
        static strictfp class ad234291 implements Runnable {
            final ad234 a = null;

            ad234291(ad234 p0) {
                super();
            }

            @Override
            public void run() {
            }
        }
    }

    /**
     * Rename from: com.corrodinggames.rts.gameFramework.g.ad#6
     */
    static strictfp class ad235 extends TimerTask {
        final Network a = null;

        ad235(Network p0) {
            super();
        }

        @Override
        public void run() {
        }
    }

    /**
     * Rename from: com.corrodinggames.rts.gameFramework.g.ad#7
     */
    static final strictfp class ad236 implements Runnable {
        final ResponsePacket a = null;

        ad236(ResponsePacket p0) {
            super();
        }

        @Override
        public void run() {
        }
    }

    /**
     * Rename from: com.corrodinggames.rts.gameFramework.g.ad#8
     */
    static strictfp class ad237 implements Runnable {
        final boolean a = false;

        final Network b = null;

        ad237(Network p0, boolean p1) {
            super();
        }

        @Override
        public void run() {
        }
    }
}
