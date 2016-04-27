package android.support.v4.p000h;

import android.view.View;
import java.lang.ref.WeakReference;

/* renamed from: android.support.v4.h.bw */
class bw implements Runnable {
    WeakReference f408a;
    bt f409b;
    final /* synthetic */ bv f410c;

    private bw(bv bvVar, bt btVar, View view) {
        this.f410c = bvVar;
        this.f408a = new WeakReference(view);
        this.f409b = btVar;
    }

    public void run() {
        View view = (View) this.f408a.get();
        if (view != null) {
            this.f410c.m884c(this.f409b, view);
        }
    }
}
