package android.support.v7.p011a;

import android.support.v7.internal.view.menu.C0170y;
import android.support.v7.internal.view.menu.C0240i;
import android.view.Menu;
import android.view.Window.Callback;

/* renamed from: android.support.v7.a.ah */
final class ah implements C0170y {
    final /* synthetic */ C0194y f527a;

    private ah(C0194y c0194y) {
        this.f527a = c0194y;
    }

    public void m1172a(C0240i c0240i, boolean z) {
        Menu menu;
        Menu p = c0240i.m1600p();
        boolean z2 = p != c0240i;
        C0194y c0194y = this.f527a;
        if (z2) {
            menu = p;
        }
        ag a = c0194y.m1292a(menu);
        if (a == null) {
            return;
        }
        if (z2) {
            this.f527a.m1293a(a.f508a, a, p);
            this.f527a.m1295a(a, true);
            return;
        }
        this.f527a.m1295a(a, z);
    }

    public boolean m1173a(C0240i c0240i) {
        if (c0240i == null && this.f527a.e) {
            Callback l = this.f527a.m1285l();
            if (!(l == null || this.f527a.m1284k())) {
                l.onMenuOpened(8, c0240i);
            }
        }
        return true;
    }
}
