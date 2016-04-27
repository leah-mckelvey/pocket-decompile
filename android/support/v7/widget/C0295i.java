package android.support.v7.widget;

import android.support.v7.internal.view.menu.C0170y;
import android.support.v7.internal.view.menu.C0240i;
import android.support.v7.internal.view.menu.ad;

/* renamed from: android.support.v7.widget.i */
class C0295i implements C0170y {
    final /* synthetic */ C0286a f1469a;

    private C0295i(C0286a c0286a) {
        this.f1469a = c0286a;
    }

    public void m2291a(C0240i c0240i, boolean z) {
        if (c0240i instanceof ad) {
            ((ad) c0240i).m1610p().m1573a(false);
        }
        C0170y a = this.f1469a.m1636a();
        if (a != null) {
            a.m1155a(c0240i, z);
        }
    }

    public boolean m2292a(C0240i c0240i) {
        if (c0240i == null) {
            return false;
        }
        this.f1469a.f1391h = ((ad) c0240i).getItem().getItemId();
        C0170y a = this.f1469a.m1636a();
        return a != null ? a.m1156a(c0240i) : false;
    }
}
