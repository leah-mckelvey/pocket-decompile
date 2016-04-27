package android.support.v4.widget;

import android.support.v4.p000h.au;

/* renamed from: android.support.v4.widget.d */
class C0148d implements Runnable {
    final /* synthetic */ C0143a f480a;

    private C0148d(C0143a c0143a) {
        this.f480a = c0143a;
    }

    public void run() {
        if (this.f480a.f442o) {
            if (this.f480a.f440m) {
                this.f480a.f440m = false;
                this.f480a.f428a.m1056a();
            }
            C0147c c = this.f480a.f428a;
            if (c.m1061c() || !this.f480a.m986a()) {
                this.f480a.f442o = false;
                return;
            }
            if (this.f480a.f441n) {
                this.f480a.f441n = false;
                this.f480a.m997d();
            }
            c.m1062d();
            this.f480a.m1006a(c.m1065g(), c.m1066h());
            au.m689a(this.f480a.f430c, (Runnable) this);
        }
    }
}
