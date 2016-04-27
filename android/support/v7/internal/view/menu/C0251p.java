package android.support.v7.internal.view.menu;

import android.content.Context;
import android.support.v4.p000h.C0118a;
import android.view.ActionProvider;
import android.view.SubMenu;
import android.view.View;

/* renamed from: android.support.v7.internal.view.menu.p */
class C0251p extends C0118a {
    final ActionProvider f917a;
    final /* synthetic */ C0250o f918b;

    public C0251p(C0250o c0250o, Context context, ActionProvider actionProvider) {
        this.f918b = c0250o;
        super(context);
        this.f917a = actionProvider;
    }

    public View m1701a() {
        return this.f917a.onCreateActionView();
    }

    public void m1702a(SubMenu subMenu) {
        this.f917a.onPrepareSubMenu(this.f918b.m1546a(subMenu));
    }

    public boolean m1703d() {
        return this.f917a.onPerformDefaultAction();
    }

    public boolean m1704e() {
        return this.f917a.hasSubMenu();
    }
}
