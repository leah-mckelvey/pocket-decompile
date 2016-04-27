package android.support.v7.internal.widget;

import android.support.v4.p000h.au;

/* renamed from: android.support.v7.internal.widget.m */
class C0273m implements Runnable {
    final /* synthetic */ ActionBarOverlayLayout f1262a;

    C0273m(ActionBarOverlayLayout actionBarOverlayLayout) {
        this.f1262a = actionBarOverlayLayout;
    }

    public void run() {
        this.f1262a.m1779k();
        this.f1262a.f1009y = au.m703g(this.f1262a.f990f).m869c((float) (-this.f1262a.f990f.getHeight())).m862a(this.f1262a.f981A);
        if (this.f1262a.f989e != null && this.f1262a.f989e.getVisibility() != 8) {
            this.f1262a.f1010z = au.m703g(this.f1262a.f989e).m869c((float) this.f1262a.f989e.getHeight()).m862a(this.f1262a.f982B);
        }
    }
}
