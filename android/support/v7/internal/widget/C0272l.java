package android.support.v7.internal.widget;

import android.support.v4.p000h.au;

/* renamed from: android.support.v7.internal.widget.l */
class C0272l implements Runnable {
    final /* synthetic */ ActionBarOverlayLayout f1261a;

    C0272l(ActionBarOverlayLayout actionBarOverlayLayout) {
        this.f1261a = actionBarOverlayLayout;
    }

    public void run() {
        this.f1261a.m1779k();
        this.f1261a.f1009y = au.m703g(this.f1261a.f990f).m869c(0.0f).m862a(this.f1261a.f981A);
        if (this.f1261a.f989e != null && this.f1261a.f989e.getVisibility() != 8) {
            this.f1261a.f1010z = au.m703g(this.f1261a.f989e).m869c(0.0f).m862a(this.f1261a.f982B);
        }
    }
}
