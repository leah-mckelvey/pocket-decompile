package android.support.v4.p000h;

import android.view.View;

/* renamed from: android.support.v4.h.cg */
class cg {
    public static void m923a(View view, ck ckVar) {
        if (ckVar != null) {
            view.animate().setListener(new ch(ckVar, view));
        } else {
            view.animate().setListener(null);
        }
    }
}
