package com.corrodinggames.rts.gameFramework.j;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;

public strictfp interface h {
    void a(boolean p0);

    boolean c();

    void a(Rect p0);

    void a(RectF p0);

    void a(Bitmap p0, float p1, float p2, Paint p3);

    void a(Bitmap p0, Matrix p1, Paint p2);

    void a(Bitmap p0, Rect p1, Rect p2, Paint p3);

    void a(Bitmap p0, Rect p1, RectF p2, Paint p3);

    void a(float p0, float p1, float p2, Paint p3);

    void a(int p0, PorterDuff.Mode p1);

    void a(int p0);

    void a(float p0, float p1, float p2, float p3, Paint p4);

    void a(float[] p0, int p1, int p2, Paint p3);

    void a(Rect p0, Paint p1);

    void a(RectF p0, Paint p1);

    void a(String p0, float p1, float p2, Paint p3);

    void a();

    void a(float p0, float p1, float p2);

    void b();

    void a(float p0, float p1);

    void a(float p0, float p1, float p2, float p3);

    void a(Bitmap p0);

    void b(float p0, float p1);

    void a(i p0);
}
