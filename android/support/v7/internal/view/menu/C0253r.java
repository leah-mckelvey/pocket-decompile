package android.support.v7.internal.view.menu;

import android.support.v4.p000h.ad;
import android.view.MenuItem;
import android.view.MenuItem.OnActionExpandListener;

/* renamed from: android.support.v7.internal.view.menu.r */
class C0253r extends C0238f implements ad {
    final /* synthetic */ C0250o f920a;

    C0253r(C0250o c0250o, OnActionExpandListener onActionExpandListener) {
        this.f920a = c0250o;
        super(onActionExpandListener);
    }

    public boolean m1708a(MenuItem menuItem) {
        return ((OnActionExpandListener) this.b).onMenuItemActionExpand(this.f920a.m1545a(menuItem));
    }

    public boolean m1709b(MenuItem menuItem) {
        return ((OnActionExpandListener) this.b).onMenuItemActionCollapse(this.f920a.m1545a(menuItem));
    }
}
