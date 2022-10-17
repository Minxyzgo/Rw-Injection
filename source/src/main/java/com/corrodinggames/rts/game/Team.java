package com.corrodinggames.rts.game;

import android.graphics.Paint;
import com.corrodinggames.rts.game.units.af;
import com.corrodinggames.rts.game.units.custom.d.a11;
import com.corrodinggames.rts.game.units.custom.d.d;
import com.corrodinggames.rts.game.units.custom.h;
import com.corrodinggames.rts.game.units.custom.i;
import com.corrodinggames.rts.gameFramework.bi;
import com.corrodinggames.rts.gameFramework.g.GameOutputStream;
import com.corrodinggames.rts.gameFramework.g.GameInputStream;
import rwij.annotations.RenameFrom;

import java.util.ArrayList;

@RenameFrom(oldName = "m")
public abstract strictfp class Team extends bi implements Comparable {
    @RenameFrom(oldName = "a")
    public static int maxPlayerCount = 10;

    public static int b;

    @RenameFrom(oldName = "c")
    public static int maxTeamIdCount;

    public static int d;

    public static final Team e = null;

    public static final Team f = null;

    public static final Team g = null;

    private static Team[] ab;

    public static Team h;

    static int[] V;

    static String[] W;

    static int Y;

    public int i;

    public final String j = null;

    public boolean k;

    public boolean l;

    public int m;

    public int n;

    public int o;

    public boolean p;

    public String q;

    public boolean r;

    public int s;

    public boolean t;

    private boolean ac;

    private int ad;

    public boolean u;

    private int ae;

    public boolean v;

    public boolean w;

    public boolean x;

    public boolean y;

    public boolean z;

    public int A;

    public int B;

    public byte[][] C;

    public String D;

    public String E;

    public int F;

    public int G;

    public boolean H;

    public r I;

    public boolean J;

    public byte K;

    public int L;

    public long M;

    public long N;

    public int O;

    public boolean P;

    public boolean Q;

    public int R;

    int S;

    public Paint T;

    public Paint U;

    int X;

    i Z;

    d aa;

    public Team() {
        super();
    }

    public Team(int p0) {
        super();
    }

    public Team(int p0, boolean p1) {
        super();
    }

    public int a(Team p0) {
        return 0;
    }

    public void b(GameOutputStream p0) {
    }

    public void c(GameOutputStream p0) {
    }

    public void a(GameInputStream p0) {
    }

    public void b(GameInputStream p0) {
    }

    public void a(GameInputStream p0, boolean p1) {
    }

    @Override
    public void a(GameOutputStream p0) {
    }

    public void c(GameInputStream p0) {
    }

    public void d(GameOutputStream p0) {
    }

    public void d(GameInputStream p0) {
    }

    public void a() {
    }

    public boolean b() {
        return false;
    }

    public static ArrayList a(boolean p0) {
        return null;
    }

    public static ArrayList c() {
        return null;
    }

    public static ArrayList b(boolean p0) {
        return null;
    }

    public static ArrayList d() {
        return null;
    }

    public static int a(int p0, boolean p1) {
        return 0;
    }

    public static int e() {
        return 0;
    }

    public static void b(int p0, boolean p1) {
    }

    public static String a(int p0) {
        return null;
    }

    public String f() {
        return null;
    }

    public void g() {
    }

    public boolean h() {
        return false;
    }

    public boolean i() {
        return false;
    }

    public void j() {
    }

    public boolean k() {
        return false;
    }

    public static int b(int p0) {
        return 0;
    }

    public static int c(int p0) {
        return 0;
    }

    public static void l() {
    }

    public static void d(int p0) {
    }

    public static void e(int p0) {
    }

    public boolean b(Team p0) {
        return false;
    }

    public boolean m() {
        return false;
    }

    public boolean n() {
        return false;
    }

    public void c(boolean p0) {
    }

    public boolean o() {
        return false;
    }

    public final int a(boolean p0, boolean p1) {
        return 0;
    }

    public final int p() {
        return 0;
    }

    public final int a(h p0, boolean p1, boolean p2) {
        return 0;
    }

    public boolean q() {
        return false;
    }

    private r e(boolean p0) {
        return null;
    }

    public void d(boolean p0) {
    }

    public int r() {
        return 0;
    }

    public int a(a11 p0) {
        return 0;
    }

    public int s() {
        return 0;
    }

    public int t() {
        return 0;
    }

    public String u() {
        return null;
    }

    public String v() {
        return null;
    }

    public int w() {
        return 0;
    }

    public boolean x() {
        return false;
    }

    public abstract void a(float p0);

    public final int y() {
        return 0;
    }

    public final float z() {
        return 0f;
    }

    public final float A() {
        return 0f;
    }

    public final void f(int p0) {
    }

    public final void g(int p0) {
    }

    public final void h(int p0) {
    }

    public static void B() {
    }

    public static e a(String p0) {
        return null;
    }

    public static e b(String p0) {
        return null;
    }

    public static int C() {
        return 0;
    }

    public static int D() {
        return 0;
    }

    public void E() {
    }

    public void i(int p0) {
    }

    public void c(int p0, boolean p1) {
    }

    public boolean j(int p0) {
        return false;
    }

    public boolean k(int p0) {
        return false;
    }

    public final boolean c(Team p0) {
        return false;
    }

    public final boolean d(Team p0) {
        return false;
    }

    public int F() {
        return 0;
    }

    public static void G() {
    }

    private static void d(String p0) {
    }

    private static void e(String p0) {
    }

    public int H() {
        return 0;
    }

    public static int l(int p0) {
        return 0;
    }

    public static int m(int p0) {
        return 0;
    }

    public String I() {
        return null;
    }

    public static com.corrodinggames.rts.gameFramework.j.e[] a(
            com.corrodinggames.rts.gameFramework.j.e p0) {
        return null;
    }

    public static com.corrodinggames.rts.gameFramework.j.e[] a(
            com.corrodinggames.rts.gameFramework.j.e p0, n p1, boolean p2) {
        return null;
    }

    public static com.corrodinggames.rts.gameFramework.j.e[] a(
            com.corrodinggames.rts.gameFramework.j.e p0, n p1) {
        return null;
    }

    public static com.corrodinggames.rts.gameFramework.j.e[] b(
            com.corrodinggames.rts.gameFramework.j.e p0, n p1) {
        return null;
    }

    public static void a(com.corrodinggames.rts.gameFramework.j.e p0,
            com.corrodinggames.rts.gameFramework.j.e[] p1, int[] p2) {
    }

    public static void a(com.corrodinggames.rts.gameFramework.j.e p0,
            com.corrodinggames.rts.gameFramework.j.e[] p1, int[] p2, int[] p3) {
    }

    public static void b(com.corrodinggames.rts.gameFramework.j.e p0,
            com.corrodinggames.rts.gameFramework.j.e[] p1, int[] p2) {
    }

    public static Team n(int p0) {
        return null;
    }

    public void b(float p0) {
    }

    public void a(com.corrodinggames.rts.game.units.r p0) {
    }

    public static void b(com.corrodinggames.rts.game.units.r p0) {
    }

    public static void a(af p0) {
    }

    public static void b(af p0) {
    }

    public static void c(af p0) {
    }

    public static void J() {
    }

    public static void K() {
    }

    public static void c(float p0) {
    }

    public static void d(float p0) {
    }

    public static void L() {
    }

    public static void e(float p0) {
    }

    public int M() {
        return 0;
    }

    public void N() {
    }

    public void a(i p0) {
    }

    public i O() {
        return null;
    }

    public void b(i p0) {
    }

    public void c(i p0) {
    }

    public d P() {
        return null;
    }

    public double b(a11 p0) {
        return 0d;
    }

    public boolean a(p p0, Team p1) {
        return false;
    }

    public void d(af p0) {
    }

    public void Q() {
    }

    public void c(String p0) {
    }

    @Override
    public int compareTo(Object p0) {
        return 0;
    }
}
