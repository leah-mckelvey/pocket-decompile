package android.support.v7.widget;

import android.content.Context;
import android.support.v7.internal.view.menu.C0240i;
import android.support.v7.internal.view.menu.C0243x;
import android.support.v7.internal.view.menu.C0248m;
import android.support.v7.internal.view.menu.ad;
import android.support.v7.p012d.C0213c;
import android.view.ViewGroup.LayoutParams;

class ax implements C0243x {
    C0240i f1453a;
    C0248m f1454b;
    final /* synthetic */ Toolbar f1455c;

    private ax(Toolbar toolbar) {
        this.f1455c = toolbar;
    }

    public void m2274a(Context context, C0240i c0240i) {
        if (!(this.f1453a == null || this.f1454b == null)) {
            this.f1453a.m1588d(this.f1454b);
        }
        this.f1453a = c0240i;
    }

    public void m2275a(C0240i c0240i, boolean z) {
    }

    public boolean m2276a(ad adVar) {
        return false;
    }

    public boolean m2277a(C0240i c0240i, C0248m c0248m) {
        this.f1455c.m2184n();
        if (this.f1455c.f1372i.getParent() != this.f1455c) {
            this.f1455c.addView(this.f1455c.f1372i);
        }
        this.f1455c.f1364a = c0248m.getActionView();
        this.f1454b = c0248m;
        if (this.f1455c.f1364a.getParent() != this.f1455c) {
            LayoutParams i = this.f1455c.m2201i();
            i.a = 8388611 | (this.f1455c.f1377n & 112);
            i.f1456b = 2;
            this.f1455c.f1364a.setLayoutParams(i);
            this.f1455c.addView(this.f1455c.f1364a);
        }
        this.f1455c.setChildVisibilityForExpandedActionView(true);
        this.f1455c.requestLayout();
        c0248m.m1688e(true);
        if (this.f1455c.f1364a instanceof C0213c) {
            ((C0213c) this.f1455c.f1364a).m1371a();
        }
        return true;
    }

    public void m2278b(boolean z) {
        Object obj = null;
        if (this.f1454b != null) {
            if (this.f1453a != null) {
                int size = this.f1453a.size();
                for (int i = 0; i < size; i++) {
                    if (this.f1453a.getItem(i) == this.f1454b) {
                        obj = 1;
                        break;
                    }
                }
            }
            if (obj == null) {
                m2280b(this.f1453a, this.f1454b);
            }
        }
    }

    public boolean m2279b() {
        return false;
    }

    public boolean m2280b(C0240i c0240i, C0248m c0248m) {
        if (this.f1455c.f1364a instanceof C0213c) {
            ((C0213c) this.f1455c.f1364a).m1372b();
        }
        this.f1455c.removeView(this.f1455c.f1364a);
        this.f1455c.removeView(this.f1455c.f1372i);
        this.f1455c.f1364a = null;
        this.f1455c.setChildVisibilityForExpandedActionView(false);
        this.f1454b = null;
        this.f1455c.requestLayout();
        c0248m.m1688e(false);
        return true;
    }
}
