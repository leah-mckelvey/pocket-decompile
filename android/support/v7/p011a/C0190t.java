package android.support.v7.p011a;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v7.internal.p016a.C0216b;
import android.support.v7.internal.view.C0229f;
import android.support.v7.p012d.C0171b;
import android.support.v7.p012d.C0212a;
import android.support.v7.p013b.C0210l;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.Window;
import android.view.Window.Callback;

/* renamed from: android.support.v7.a.t */
abstract class C0190t extends C0189s {
    final Context f627a;
    final Window f628b;
    final Callback f629c;
    final C0172r f630d;
    boolean f631e;
    boolean f632f;
    boolean f633g;
    boolean f634h;
    boolean f635i;
    private C0169a f636j;
    private MenuInflater f637k;
    private CharSequence f638l;
    private boolean f639m;

    C0190t(Context context, Window window, C0172r c0172r) {
        this.f627a = context;
        this.f628b = window;
        this.f630d = c0172r;
        this.f629c = this.f628b.getCallback();
        if (this.f629c instanceof C0192u) {
            throw new IllegalStateException("AppCompat has already installed itself into the Window");
        }
        this.f628b.setCallback(m1271a(this.f629c));
    }

    public C0169a m1269a() {
        if (this.f631e) {
            if (this.f636j == null) {
                this.f636j = m1281h();
            }
        } else if (this.f636j instanceof C0216b) {
            this.f636j = null;
        }
        return this.f636j;
    }

    abstract C0212a m1270a(C0171b c0171b);

    Callback m1271a(Callback callback) {
        return new C0192u(this, callback);
    }

    public void m1272a(Bundle bundle) {
        TypedArray obtainStyledAttributes = this.f627a.obtainStyledAttributes(C0210l.Theme);
        if (obtainStyledAttributes.hasValue(C0210l.Theme_windowActionBar)) {
            if (obtainStyledAttributes.getBoolean(C0210l.Theme_windowActionBar, false)) {
                this.f631e = true;
            }
            if (obtainStyledAttributes.getBoolean(C0210l.Theme_windowActionBarOverlay, false)) {
                this.f632f = true;
            }
            if (obtainStyledAttributes.getBoolean(C0210l.Theme_windowActionModeOverlay, false)) {
                this.f633g = true;
            }
            this.f634h = obtainStyledAttributes.getBoolean(C0210l.Theme_android_windowIsFloating, false);
            this.f635i = obtainStyledAttributes.getBoolean(C0210l.Theme_windowNoTitle, false);
            obtainStyledAttributes.recycle();
            return;
        }
        obtainStyledAttributes.recycle();
        throw new IllegalStateException("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
    }

    public final void m1273a(CharSequence charSequence) {
        this.f638l = charSequence;
        m1278b(charSequence);
    }

    abstract boolean m1274a(int i, KeyEvent keyEvent);

    abstract boolean m1275a(int i, Menu menu);

    abstract boolean m1276a(KeyEvent keyEvent);

    public MenuInflater m1277b() {
        if (this.f637k == null) {
            this.f637k = new C0229f(m1283j());
        }
        return this.f637k;
    }

    abstract void m1278b(CharSequence charSequence);

    abstract boolean m1279b(int i, Menu menu);

    public final void m1280f() {
        this.f639m = true;
    }

    abstract C0169a m1281h();

    final C0169a m1282i() {
        return this.f636j;
    }

    final Context m1283j() {
        Context context = null;
        C0169a a = m1269a();
        if (a != null) {
            context = a.m1145b();
        }
        return context == null ? this.f627a : context;
    }

    final boolean m1284k() {
        return this.f639m;
    }

    final Callback m1285l() {
        return this.f628b.getCallback();
    }

    final CharSequence m1286m() {
        return this.f629c instanceof Activity ? ((Activity) this.f629c).getTitle() : this.f638l;
    }
}
