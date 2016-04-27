package android.support.v4.p000h;

import android.view.View;

/* renamed from: android.support.v4.h.by */
class by implements ck {
    bt f412a;

    by(bt btVar) {
        this.f412a = btVar;
    }

    public void m907a(View view) {
        if (this.f412a.f406e >= 0) {
            au.m687a(view, 2, null);
        }
        if (this.f412a.f404c != null) {
            this.f412a.f404c.run();
        }
        Object tag = view.getTag(2113929216);
        ck ckVar = tag instanceof ck ? (ck) tag : null;
        if (ckVar != null) {
            ckVar.m109a(view);
        }
    }

    public void m908b(View view) {
        if (this.f412a.f406e >= 0) {
            au.m687a(view, this.f412a.f406e, null);
            this.f412a.f406e = -1;
        }
        if (this.f412a.f405d != null) {
            this.f412a.f405d.run();
        }
        Object tag = view.getTag(2113929216);
        ck ckVar = tag instanceof ck ? (ck) tag : null;
        if (ckVar != null) {
            ckVar.m110b(view);
        }
    }

    public void m909c(View view) {
        Object tag = view.getTag(2113929216);
        ck ckVar = tag instanceof ck ? (ck) tag : null;
        if (ckVar != null) {
            ckVar.m111c(view);
        }
    }
}
