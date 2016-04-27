package android.support.v7.internal.view.menu;

import android.content.Context;
import android.support.v4.p000h.C0120c;
import android.view.ActionProvider;
import android.view.ActionProvider.VisibilityListener;
import android.view.MenuItem;
import android.view.View;

/* renamed from: android.support.v7.internal.view.menu.u */
class C0256u extends C0251p implements VisibilityListener {
    C0120c f922c;
    final /* synthetic */ C0255t f923d;

    public C0256u(C0255t c0255t, Context context, ActionProvider actionProvider) {
        this.f923d = c0255t;
        super(c0255t, context, actionProvider);
    }

    public View m1711a(MenuItem menuItem) {
        return this.a.onCreateActionView(menuItem);
    }

    public void m1712a(C0120c c0120c) {
        VisibilityListener visibilityListener;
        this.f922c = c0120c;
        ActionProvider actionProvider = this.a;
        if (c0120c == null) {
            visibilityListener = null;
        }
        actionProvider.setVisibilityListener(visibilityListener);
    }

    public boolean m1713b() {
        return this.a.overridesItemVisibility();
    }

    public boolean m1714c() {
        return this.a.isVisible();
    }

    public void onActionProviderVisibilityChanged(boolean z) {
        if (this.f922c != null) {
            this.f922c.m911a(z);
        }
    }
}
