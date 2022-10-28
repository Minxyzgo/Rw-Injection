package com.corrodinggames.rts.java;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import com.corrodinggames.rts.gameFramework.j.a;
import com.corrodinggames.rts.gameFramework.j.h;
import com.corrodinggames.rts.gameFramework.j.i;
import com.corrodinggames.rts.gameFramework.j.l;
import java.io.File;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.Stack;
import org.newdawn.slick.Color;
import org.newdawn.slick.Font;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.opengl.ImageData;
import org.newdawn.slick.opengl.renderer.LineStripRenderer;
import org.newdawn.slick.opengl.renderer.SGL;
import rwij.annotations.RenameFrom;

@RenameFrom(oldName = "e")
public final class GraphicsProcessor implements l {
    public static final Color b = null;

    public static final Color c = null;

    public static final Color d = null;

    public static Graphics g;

    private static SGL L;

    public static a34 k;

    public static a34 l;

    public static a34 m;

    public static final Color t = null;

    static float u;

    static ArrayList x;

    static RectF A;

    static RectF B;

    private static LineStripRenderer M;

    public boolean a;

    public Graphics e;

    public com.corrodinggames.rts.gameFramework.j.e f;

    final Rect h = null;

    final Rect i = null;

    final RectF j = null;

    ArrayList n;

    int o;

    Paint p;

    r q;

    boolean r;

    final Paint s = null;

    f v;

    byte[] w;

    int y;

    RectF z;

    public float C;

    Rect D;

    Stack E;

    FloatBuffer F;

    float[] G;

    int H;

    float I;

    float J;

    float K;

    public GraphicsProcessor() {
        super();
    }

    public static void p() {
    }

    public Color q() {
        return null;
    }

    @Override
    public l a(com.corrodinggames.rts.gameFramework.j.e p0) {
        return null;
    }

    @Override
    public boolean a() {
        return false;
    }

    @Override
    public void a(Context p0) {
    }

    @Override
    public void b() {
    }

    @Override
    public h c() {
        return null;
    }

    @Override
    public void a(h p0) {
    }

    @Override
    public void a(a p0) {
    }

    public static boolean a(String p0) {
        return false;
    }

    Font a(f p0, String p1, boolean p2) {
        return null;
    }

    f a(f p0, boolean p1) {
        return null;
    }

    public void a(Paint p0, String p1) {
    }

    public void b(Paint p0) {
    }

    public void a(Paint p0, r p1) {
    }

    public void a(Paint p0, boolean p1, String p2, r p3) {
    }

    private void e(int p0) {
    }

    private void a(Color p0) {
    }

    public void a(float p0) {
    }

    public Font a(Paint p0, String p1, boolean p2) {
        return null;
    }

    public static void a(ImageData p0, ByteBuffer p1, int p2, int p3, int p4, int p5, int p6,
            int p7, int p8) {
    }

    public static int a(ImageData p0, ByteBuffer p1, int p2, int p3, int p4) {
        return 0;
    }

    public static final int a(int p0, int p1, int p2, int p3) {
        return 0;
    }

    public static Color a(int p0, Color p1) {
        return null;
    }

    @Override
    public com.corrodinggames.rts.gameFramework.j.e a(int p0) {
        return null;
    }

    @Override
    public void d() {
    }

    public static void r() {
    }

    public static void a(r p0) {
    }

    public static r b(int p0, boolean p1) {
        return null;
    }

    @Override
    public com.corrodinggames.rts.gameFramework.j.e a(int p0, boolean p1) {
        return null;
    }

    public static ImageData a(InputStream p0) {
        return null;
    }

    @Override
    public com.corrodinggames.rts.gameFramework.j.e a(InputStream p0, boolean p1) {
        return null;
    }

    public static r a(ImageData p0, String p1) {
        return null;
    }

    @Override
    public com.corrodinggames.rts.gameFramework.j.e a(int p0, int p1, boolean p2) {
        return null;
    }

    @Override
    public com.corrodinggames.rts.gameFramework.j.e b(int p0, int p1, boolean p2) {
        return null;
    }

    @Override
    public void a(com.corrodinggames.rts.gameFramework.j.e p0, float p1, float p2, float p3,
            Paint p4) {
    }

    @Override
    public void a(com.corrodinggames.rts.gameFramework.j.e p0, Rect p1, float p2, float p3,
            float p4, Paint p5) {
    }

    @Override
    public void a(com.corrodinggames.rts.gameFramework.j.e p0, Rect p1, Rect p2, Paint p3) {
    }

    @Override
    public void b(com.corrodinggames.rts.gameFramework.j.e p0, Rect p1, Rect p2, Paint p3) {
    }

    @Override
    public void a(Rect p0, Paint p1) {
    }

    @Override
    public void a(boolean p0) {
    }

    @Override
    public void e() {
    }

    private final r b(com.corrodinggames.rts.gameFramework.j.e p0) {
        return null;
    }

    @Override
    public void a(com.corrodinggames.rts.gameFramework.j.e p0, Rect p1, RectF p2, Paint p3) {
    }

    @Override
    public void a(com.corrodinggames.rts.gameFramework.j.e p0, float p1, float p2, Paint p3) {
    }

    @Override
    public void a(com.corrodinggames.rts.gameFramework.j.e p0, float p1, float p2, Paint p3,
            float p4, float p5) {
    }

    @Override
    public void b(com.corrodinggames.rts.gameFramework.j.e p0, float p1, float p2, Paint p3) {
    }

    @Override
    public void a(com.corrodinggames.rts.gameFramework.j.e p0, Rect p1, Paint p2) {
    }

    @Override
    public void a(com.corrodinggames.rts.gameFramework.j.e p0, Rect p1, Paint p2, int p3, int p4,
            int p5, int p6) {
    }

    @Override
    public void a(com.corrodinggames.rts.gameFramework.j.e p0, RectF p1, Paint p2, float p3,
            float p4, int p5, int p6) {
    }

    @Override
    public void b(int p0) {
    }

    @Override
    public void l() {
    }

    @Override
    public void a(int p0, PorterDuff.Mode p1) {
    }

    @Override
    public void a(String p0, float p1, float p2, Paint p3, Paint p4, float p5) {
    }

    boolean s() {
        return false;
    }

    @Override
    public void a(String p0, float p1, float p2, Paint p3) {
    }

    @Override
    public void b(Rect p0, Paint p1) {
    }

    @Override
    public void a(RectF p0, Paint p1) {
    }

    @Override
    public void f() {
    }

    @Override
    public void g() {
    }

    @Override
    public void c(Rect p0, Paint p1) {
    }

    @Override
    public void a(Rect p0) {
    }

    @Override
    public void a(RectF p0) {
    }

    public void t() {
    }

    @Override
    public void a(float p0, float p1, float p2, Paint p3) {
    }

    public FloatBuffer c(int p0) {
        return null;
    }

    public FloatBuffer a(float[] p0, int p1) {
        return null;
    }

    public float[] d(int p0) {
        return null;
    }

    @Override
    public void a(float[] p0, int p1, int p2, Paint p3) {
    }

    public void b(float[] p0, int p1, int p2, Paint p3) {
    }

    public void a(float p0, float p1, float p2, int p3) {
    }

    @Override
    public void h() {
    }

    @Override
    public void i() {
    }

    @Override
    public void j() {
    }

    @Override
    public void k() {
    }

    @Override
    public void a(float p0, float p1, float p2) {
    }

    @Override
    public void a(float p0, float p1) {
    }

    @Override
    public void a(float p0, float p1, float p2, float p3) {
    }

    @Override
    public void b(float p0, float p1) {
    }

    @Override
    public void a(i p0) {
    }

    @Override
    public void a(float p0, float p1, float p2, float p3, Paint p4) {
    }

    @Override
    public void a(Paint p0) {
    }

    @Override
    public void m() {
    }

    @Override
    public void n() {
    }

    @Override
    public int a(String p0, Paint p1) {
        return 0;
    }

    @Override
    public int b(String p0, Paint p1) {
        return 0;
    }

    @Override
    public com.corrodinggames.rts.gameFramework.j.e o() {
        return null;
    }

    @Override
    public void a(com.corrodinggames.rts.gameFramework.j.e p0, File p1) {
    }
}
