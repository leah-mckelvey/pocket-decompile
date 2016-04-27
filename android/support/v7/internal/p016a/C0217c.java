package android.support.v7.internal.p016a;

import android.support.v4.p000h.au;
import android.support.v4.p000h.cl;
import android.view.View;

/* renamed from: android.support.v7.internal.a.c */
class C0217c extends cl {
    final /* synthetic */ C0216b f710a;

    C0217c(C0216b c0216b) {
        this.f710a = c0216b;
    }

    public void m1428b(View view) {
        if (this.f710a.f679C && this.f710a.f702s != null) {
            au.m694b(this.f710a.f702s, 0.0f);
            au.m694b(this.f710a.f698o, 0.0f);
        }
        if (this.f710a.f701r != null && this.f710a.f709z == 1) {
            this.f710a.f701r.setVisibility(8);
        }
        this.f710a.f698o.setVisibility(8);
        this.f710a.f698o.setTransitioning(false);
        this.f710a.f684H = null;
        this.f710a.m1416e();
        if (this.f710a.f697n != null) {
            au.m705i(this.f710a.f697n);
        }
    }
}
