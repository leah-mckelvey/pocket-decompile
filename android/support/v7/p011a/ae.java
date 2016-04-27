package android.support.v7.p011a;

import android.support.v4.p000h.au;
import android.support.v7.p012d.C0171b;
import android.support.v7.p012d.C0212a;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

/* renamed from: android.support.v7.a.ae */
class ae implements C0171b {
    final /* synthetic */ C0194y f505a;
    private C0171b f506b;

    public ae(C0194y c0194y, C0171b c0171b) {
        this.f505a = c0194y;
        this.f506b = c0171b;
    }

    public void m1163a(C0212a c0212a) {
        this.f506b.m1159a(c0212a);
        if (this.f505a.f651l != null) {
            this.f505a.b.getDecorView().removeCallbacks(this.f505a.f652m);
            this.f505a.f651l.dismiss();
        } else if (this.f505a.f650k != null) {
            this.f505a.f650k.setVisibility(8);
            if (this.f505a.f650k.getParent() != null) {
                au.m705i((View) this.f505a.f650k.getParent());
            }
        }
        if (this.f505a.f650k != null) {
            this.f505a.f650k.removeAllViews();
        }
        if (this.f505a.d != null) {
            this.f505a.d.m1176b(this.f505a.f649j);
        }
        this.f505a.f649j = null;
    }

    public boolean m1164a(C0212a c0212a, Menu menu) {
        return this.f506b.m1160a(c0212a, menu);
    }

    public boolean m1165a(C0212a c0212a, MenuItem menuItem) {
        return this.f506b.m1161a(c0212a, menuItem);
    }

    public boolean m1166b(C0212a c0212a, Menu menu) {
        return this.f506b.m1162b(c0212a, menu);
    }
}
