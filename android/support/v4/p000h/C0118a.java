package android.support.v4.p000h;

import android.content.Context;
import android.util.Log;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

/* renamed from: android.support.v4.h.a */
public abstract class C0118a {
    private final Context f388a;
    private C0119b f389b;
    private C0120c f390c;

    public C0118a(Context context) {
        this.f388a = context;
    }

    public abstract View m608a();

    public View m609a(MenuItem menuItem) {
        return m608a();
    }

    public void m610a(C0119b c0119b) {
        this.f389b = c0119b;
    }

    public void m611a(C0120c c0120c) {
        if (!(this.f390c == null || c0120c == null)) {
            Log.w("ActionProvider(support)", "setVisibilityListener: Setting a new ActionProvider.VisibilityListener when one is already set. Are you reusing this " + getClass().getSimpleName() + " instance while it is still in use somewhere else?");
        }
        this.f390c = c0120c;
    }

    public void m612a(SubMenu subMenu) {
    }

    public void m613a(boolean z) {
        if (this.f389b != null) {
            this.f389b.m791a(z);
        }
    }

    public boolean m614b() {
        return false;
    }

    public boolean m615c() {
        return true;
    }

    public boolean m616d() {
        return false;
    }

    public boolean m617e() {
        return false;
    }
}
