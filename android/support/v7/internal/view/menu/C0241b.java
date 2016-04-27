package android.support.v7.internal.view.menu;

import android.support.v7.widget.ab;
import android.support.v7.widget.ag;

/* renamed from: android.support.v7.internal.view.menu.b */
class C0241b extends ag {
    final /* synthetic */ ActionMenuItemView f863a;

    public C0241b(ActionMenuItemView actionMenuItemView) {
        this.f863a = actionMenuItemView;
        super(actionMenuItemView);
    }

    public ab m1625a() {
        return this.f863a.f785f != null ? this.f863a.f785f.m1628a() : null;
    }

    protected boolean m1626b() {
        if (this.f863a.f783d == null || !this.f863a.f783d.m1527a(this.f863a.f780a)) {
            return false;
        }
        ab a = m1625a();
        return a != null && a.m1953b();
    }

    protected boolean m1627c() {
        ab a = m1625a();
        if (a == null) {
            return false;
        }
        a.m1944a();
        return true;
    }
}
