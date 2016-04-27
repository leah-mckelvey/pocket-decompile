package android.support.v7.widget;

import android.support.v7.internal.view.menu.C0193j;
import android.support.v7.internal.view.menu.C0240i;
import android.view.MenuItem;

/* renamed from: android.support.v7.widget.n */
class C0299n implements C0193j {
    final /* synthetic */ ActionMenuView f1477a;

    private C0299n(ActionMenuView actionMenuView) {
        this.f1477a = actionMenuView;
    }

    public void m2295a(C0240i c0240i) {
        if (this.f1477a.f1300h != null) {
            this.f1477a.f1300h.m1287a(c0240i);
        }
    }

    public boolean m2296a(C0240i c0240i, MenuItem menuItem) {
        return this.f1477a.f1305m != null && this.f1477a.f1305m.m2272a(menuItem);
    }
}
