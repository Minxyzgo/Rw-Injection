package com.corrodinggames.rts.gameFramework;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Handler;
import com.corrodinggames.rts.game.b.MapLoader;
import com.corrodinggames.rts.game.Team;
import com.corrodinggames.rts.game.units.af;
import com.corrodinggames.rts.game.units.custom.ag;
import com.corrodinggames.rts.gameFramework.a.e;
import com.corrodinggames.rts.gameFramework.b.c;
import com.corrodinggames.rts.gameFramework.d.f;
import com.corrodinggames.rts.gameFramework.d.k;
import com.corrodinggames.rts.gameFramework.f.a;
import com.corrodinggames.rts.gameFramework.g.GameInputStream;
import com.corrodinggames.rts.gameFramework.g.Network;
import com.corrodinggames.rts.gameFramework.g.MapType;
import com.corrodinggames.rts.gameFramework.h.h;
import com.corrodinggames.rts.gameFramework.j.l;
import com.corrodinggames.rts.gameFramework.utility.d;
import com.corrodinggames.rts.gameFramework.utility.i;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentLinkedQueue;
import rwij.annotations.RenameFrom;

@RenameFrom(oldName = "l33")
public abstract strictfp class GameEngine {
    protected static GameEngine ag;

    public static boolean an;

    public static boolean ao;

    public static boolean ap;

    public static Throwable aq;

    @RenameFrom(oldName = "ar")
    public static boolean logColor;

    @RenameFrom(oldName = "as")
    public static boolean noBackGround;

    public static boolean at;

    public static boolean au;

    public static boolean av;

    @RenameFrom(oldName = "aw")
    public static boolean printUnits;

    @RenameFrom(oldName = "ax")
    public static boolean outputUnitImage;

    @RenameFrom(oldName = "ay")
    public static boolean oldReplay;

    @RenameFrom(oldName = "az")
    public static boolean steam;

    @RenameFrom(oldName = "aA")
    public static boolean sandBox;

    @RenameFrom(oldName = "aB")
    public static boolean noMods;

    public static String aC;

    public static boolean aD;

    public static boolean aE;

    public static boolean aF;

    public static boolean aG;

    public static boolean aH;

    public static boolean aI;

    public static boolean aJ;

    public static String aK;

    public static boolean aL;

    public static boolean aM;

    public static boolean aN;

    public static boolean aO;

    public static boolean aP;

    public static Class aQ;

    public static l aR;

    public static Point bR;

    public static o df;

    public static String dg;

    public static boolean dv;

    static byte[] dw;

    static byte[] dx;

    static d dy;

    static boolean dz;

    static int dA;

    static boolean dB;

    static u dC;

    static boolean dD;

    static boolean dE;

    public Context ah;

    public Context ai;

    public com.corrodinggames.rts.a.d aj;

    public com.corrodinggames.rts.a.d ak;

    public boolean al;

    public boolean am;

    public boolean aS;

    public boolean aT;

    public boolean aU;

    public boolean aV;

    public boolean aW;

    public boolean aX;

    public boolean aY;

    public boolean aZ;

    public boolean ba;

    public Team bb;

    public float bc;

    public float bd;

    public boolean be;

    public boolean bf;

    public int bg;

    public int bh;

    public int bi;

    public int bj;

    public int bk;

    public int bl;

    public boolean bm;

    public boolean bn;

    public volatile boolean bo;

    public volatile boolean bp;

    public volatile boolean bq;

    public volatile boolean br;

    public i bs;

    public MapLoader bt;

    public e bu;

    public am bv;

    public l bw;

    public a20 bx;

    public SettingsEngine by;

    public c bz;

    public f bA;

    public ac bB;

    public h bC;

    public aa bD;

    public k bE;

    public Network bF;

    public bg bG;

    public a bH;

    public y bI;

    public ba bJ;

    public com.corrodinggames.rts.game.units.f.c bK;

    public bj bL;

    public com.corrodinggames.rts.gameFramework.k.f bM;

    public c22 bN;

    public boolean bO;

    public float bP;

    public float bQ;

    public float bS;

    public float bT;

    public float bU;

    public float bV;

    public float bW;

    public float bX;

    public float bY;

    public float bZ;

    public boolean ca;

    public int cb;

    public int cc;

    public float cd;

    public float ce;

    public float cf;

    public float cg;

    public float ch;

    public float ci;

    public float cj;

    public float ck;

    public float cl;

    public float cm;

    public float cn;

    public float co;

    public float cp;

    public float cq;

    public final Rect cr = null;

    public final Rect cs = null;

    public final RectF ct = null;

    public final Rect cu = null;

    public final RectF cv = null;

    public final RectF cw = null;

    public final Rect cx = null;

    public boolean cy;

    public boolean cz;

    public float cA;

    public boolean cB;

    public float cC;

    public boolean cD;

    public float cE;

    public float cF;

    public boolean cG;

    public float cH;

    public float cI;

    public boolean cJ;

    public boolean cK;

    public boolean cL;

    public boolean cM;

    public boolean cN;

    public float cO;

    public float cP;

    public boolean cQ;

    protected z cR;

    public String cS;

    public GameInputStream cT;

    public Paint cU;

    public Paint cV;

    public Paint cW;

    public boolean cX;

    public boolean cY;

    public float cZ;

    public boolean da;

    public boolean db;

    public boolean dc;

    public int dd;

    public float de;

    float dh;

    boolean di;

    ArrayList dj;

    final Handler dk = null;

    public String dl;

    private Runnable a;

    public String dm;

    public String dn;

    private Runnable b;

    @RenameFrom(
            oldName = "do"
    )
    public n do0;

    String dp;

    Object dq;

    String dr;

    String ds;

    public boolean[] dt;

    protected ConcurrentLinkedQueue du;

    private boolean[] c;

    private boolean[] d;

    private int e;

    public byte dF;

    public byte dG;

    public final q dH = null;

    public final q dI = null;

    public final q dJ = null;

    public GameEngine(Context p0) {
        super();
    }

    public static boolean b(Context p0) {
        return false;
    }

    public boolean t() {
        return false;
    }

    public static final GameEngine u() {
        return null;
    }

    public static final boolean v() {
        return false;
    }

    public static final boolean w() {
        return false;
    }

    public void c(Context p0) {
    }

    public static GameEngine a(Context p0, n p1) {
        return null;
    }

    @Override
    protected void finalize() {
    }

    public boolean x() {
        return false;
    }

    public abstract void a(Context p0);

    public void y() {
    }

    public abstract boolean a();

    public abstract boolean a(boolean p0);

    public abstract void a(Activity p0, com.corrodinggames.rts.a.d p1, boolean p2);

    public abstract void b(int p0, int p1);

    public abstract int c(boolean p0);

    public abstract boolean j();

    public abstract boolean l();

    public abstract boolean k();

    public abstract String h();

    public abstract String i();

    public abstract String m();

    public abstract String n();

    public abstract String o();

    public String z() {
        return null;
    }

    public String A() {
        return null;
    }

    public abstract void a(boolean p0, boolean p1, s p2);

    public abstract void a(boolean p0, s p1);

    public abstract void c();

    public abstract void q();

    public abstract void a(float p0, int p1);

    public abstract void b(float p0, int p1);

    public boolean B() {
        return false;
    }

    public void C() {
    }

    public void D() {
    }

    public void E() {
    }

    public boolean F() {
        return false;
    }

    public boolean G() {
        return false;
    }

    public boolean H() {
        return false;
    }

    public boolean I() {
        return false;
    }

    public void J() {
    }

    public void a(float p0, float p1) {
    }

    public void b(float p0, float p1) {
    }

    public static boolean d(Context p0) {
        return false;
    }

    public void K() {
    }

    public void L() {
    }

    public static void a(String p0, Exception p1) {
    }

    public static String a(String p0, String p1) {
        return null;
    }

    public static void a(String p0) {
    }

    public static void b(String p0) {
    }

    public static void a(String p0, Throwable p1) {
    }

    public static void c(String p0) {
    }

    public static void d(String p0) {
    }

    public static void b(String p0, String p1) {
    }

    public static void e(String p0) {
    }

    public static void M() {
    }

    public static void f(String p0) {
    }

    public static long N() {
        return 0;
    }

    public static final boolean a(long p0, long p1) {
        return false;
    }

    public float O() {
        return 0f;
    }

    public int e(float p0) {
        return 0;
    }

    public int a(int p0) {
        return 0;
    }

    public void P() {
    }

    protected void Q() {
    }

    public void a(Paint p0) {
    }

    public void a(Paint p0, float p1) {
    }

    public void g(String p0) {
    }

    public void a(String p0, boolean p1) {
    }

    public void R() {
    }

    public void h(String p0) {
    }

    public void a(String p0, int p1) {
    }

    public void a(String p0, ag p1) {
    }

    public void c(String p0, String p1) {
    }

    public void S() {
    }

    public void d(String p0, String p1) {
    }

    public boolean T() {
        return false;
    }

    public void U() {
    }

    public int V() {
        return 0;
    }

    public float W() {
        return 0f;
    }

    public float X() {
        return 0f;
    }

    public float b(int p0) {
        return 0f;
    }

    public float c(int p0) {
        return 0f;
    }

    public int d(int p0) {
        return 0;
    }

    public boolean e(int p0) {
        return false;
    }

    public int f(int p0) {
        return 0;
    }

    public boolean g(int p0) {
        return false;
    }

    public boolean h(int p0) {
        return false;
    }

    public boolean a(int p0, boolean p1) {
        return false;
    }

    public boolean i(int p0) {
        return false;
    }

    public static String j(int p0) {
        return null;
    }

    public int Y() {
        return 0;
    }

    public boolean c(int p0, int p1) {
        return false;
    }

    public void b(int p0, boolean p1) {
    }

    public void k(int p0) {
    }

    public int Z() {
        return 0;
    }

    protected void aa() {
    }

    public static String i(String p0) {
        return null;
    }

    public static String j(String p0) {
        return null;
    }

    public static Integer k(String p0) {
        return null;
    }

    public static String l(String p0) {
        return null;
    }

    public String ab() {
        return null;
    }

    public String ac() {
        return null;
    }

    public String ad() {
        return null;
    }

    public MapType ae() {
        return null;
    }

    public static String a(Throwable p0) {
        return null;
    }

    public static String b(Throwable p0) {
        return null;
    }

    public static void e(String p0, String p1) {
    }

    public static void af() {
    }

    public static void ag() {
    }

    public abstract int s();

    public boolean ah() {
        return false;
    }

    public boolean ai() {
        return false;
    }

    public static void m(String p0) {
    }

    public static boolean aj() {
        return false;
    }

    public static boolean ak() {
        return false;
    }

    public static boolean al() {
        return false;
    }

    public static boolean am() {
        return false;
    }

    public static boolean an() {
        return false;
    }

    public boolean ao() {
        return false;
    }

    public void a(af p0, float p1) {
    }

    public abstract int b();

    public static void ap() {
    }

    public Context aq() {
        return null;
    }

    public static void f(String p0, String p1) {
    }

    public static void a(u p0, Throwable p1) {
    }

    public void ar() {
    }

    public void as() {
    }

    public void a(Runnable p0) {
    }

    public final boolean a(float p0, float p1, float p2) {
        return false;
    }

    /**
     * Rename from: com.corrodinggames.rts.gameFramework.l33#1
     */
    static class l33258 implements Runnable {
        final GameEngine a = null;

        l33258(GameEngine p0) {
            super();
        }

        @Override
        public void run() {
        }
    }

    /**
     * Rename from: com.corrodinggames.rts.gameFramework.l33#2
     */
    static class l33259 implements Runnable {
        final GameEngine a = null;

        l33259(GameEngine p0) {
            super();
        }

        @Override
        public void run() {
        }

        /**
         * Rename from: com.corrodinggames.rts.gameFramework.l33#l33259#1
         */
        static class l33259292 implements DialogInterface.OnClickListener {
            final l33259 a = null;

            l33259292(l33259 p0) {
                super();
            }

            @Override
            public void onClick(DialogInterface p0, int p1) {
            }
        }

        /**
         * Rename from: com.corrodinggames.rts.gameFramework.l33#l33259#2
         */
        static class l33259293 implements DialogInterface.OnCancelListener {
            final l33259 a = null;

            l33259293(l33259 p0) {
                super();
            }

            @Override
            public void onCancel(DialogInterface p0) {
            }
        }
    }

    /**
     * Rename from: com.corrodinggames.rts.gameFramework.l33#3
     */
    static strictfp class l33260 extends Thread {
        final GameEngine a = null;

        l33260(GameEngine p0) {
            super();
        }

        @Override
        public void run() {
        }
    }

    /**
     * Rename from: com.corrodinggames.rts.gameFramework.l33#4
     */
    static final strictfp class l33261 implements com.corrodinggames.rts.gameFramework.utility.e {
        l33261() {
            super();
        }

        @Override
        public void a(com.corrodinggames.rts.gameFramework.utility.a p0) {
        }
    }
}
