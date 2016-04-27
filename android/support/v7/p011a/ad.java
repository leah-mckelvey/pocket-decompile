package android.support.v7.p011a;

import android.support.v7.internal.view.menu.C0170y;
import android.support.v7.internal.view.menu.C0240i;
import android.view.Window.Callback;

/* renamed from: android.support.v7.a.ad */
final class ad implements C0170y {
    final /* synthetic */ C0194y f504a;

    private ad(C0194y c0194y) {
        this.f504a = c0194y;
    }

    public void m1157a(C0240i c0240i, boolean z) {
        this.f504a.m1306b(c0240i);
    }

    public boolean m1158a(C0240i c0240i) {
        Callback l = this.f504a.m1285l();
        if (l != null) {
            l.onMenuOpened(8, c0240i);
        }
        return true;
    }
}
