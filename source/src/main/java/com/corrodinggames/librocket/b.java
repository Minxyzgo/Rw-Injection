package com.corrodinggames.librocket;

import android.graphics.Rect;
import android.graphics.RectF;
import com.Element;
import com.ElementDocument;
import com.LibRocket;
import com.corrodinggames.librocket.scripts.ScriptEngine;
import com.corrodinggames.rts.gameFramework.bl;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class b extends LibRocket {
    public static bl a;

    public static String b;

    public ScriptEngine c;

    protected int d;

    protected Rect e;

    protected RectF f;

    protected boolean g;

    private d i;

    private d j;

    Pattern h;

    public b() {
        super();
    }

    public void a() {
    }

    public static String a(String p0) {
        return null;
    }

    public Matcher a(String p0, String p1) {
        return null;
    }

    @Override
    public void ReleaseTexture(int p0) {
    }

    @Override
    public boolean LoadTexture(int p0, String p1) {
        return false;
    }

    public abstract void EnableScissorRegion(boolean p0);

    @Override
    public void SetScissorRegion(int p0, int p1, int p2, int p3) {
    }

    public boolean b() {
        return false;
    }

    @Override
    public void HandleEvent(String p0) {
    }

    public Object b(String p0) {
        return null;
    }

    @Override
    public void newDocumentLoaded(ElementDocument p0) {
    }

    @Override
    public void newDocumentShown(ElementDocument p0) {
    }

    public ElementDocument c() {
        return null;
    }

    public ElementDocument d() {
        return null;
    }

    public ElementDocument e() {
        return null;
    }

    public ElementDocument f() {
        return null;
    }

    public ElementDocument g() {
        return null;
    }

    public void c(String p0) {
    }

    public void b(String p0, String p1) {
    }

    public void a(String p0, String p1, String p2, String p3, String p4) {
    }

    public void a(String p0, String p1, String p2, e p3, e p4) {
    }

    public ElementDocument a(String p0, String p1, String p2, Object p3, Object p4, boolean p5,
            boolean p6) {
        return null;
    }

    public ElementDocument a(d p0) {
        return null;
    }

    public boolean b(d p0) {
        return false;
    }

    public boolean a(ElementDocument p0) {
        return false;
    }

    public boolean c(d p0) {
        return false;
    }

    public ElementDocument a(String p0, Object p1, String p2, boolean p3) {
        return null;
    }

    public void a(Element p0) {
    }

    public void a(ElementDocument p0, String p1, Object p2, HashMap p3) {
    }

    public boolean h() {
        return false;
    }

    public boolean i() {
        return false;
    }

    public boolean j() {
        return false;
    }

    public String k() {
        return null;
    }

    public String d(String p0) {
        return null;
    }

    @Override
    public String TranslateString(String p0) {
        return null;
    }

    @Override
    public long getFileLastModified(String p0) {
        return 0;
    }

    @Override
    public void postUpdate() {
    }
}
