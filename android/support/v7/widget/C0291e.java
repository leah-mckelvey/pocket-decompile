package android.support.v7.widget;

import android.view.View;

/* renamed from: android.support.v7.widget.e */
class C0291e implements Runnable {
    final /* synthetic */ C0286a f1462a;
    private C0294h f1463b;

    public C0291e(C0286a c0286a, C0294h c0294h) {
        this.f1462a = c0286a;
        this.f1463b = c0294h;
    }

    public void run() {
        this.f1462a.c.m1590f();
        View view = (View) this.f1462a.f;
        if (!(view == null || view.getWindowToken() == null || !this.f1463b.m1732d())) {
            this.f1462a.f1405v = this.f1463b;
        }
        this.f1462a.f1407x = null;
    }
}
