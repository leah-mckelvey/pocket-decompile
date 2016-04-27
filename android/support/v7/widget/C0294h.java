package android.support.v7.widget;

import android.content.Context;
import android.support.v7.internal.view.menu.C0240i;
import android.support.v7.internal.view.menu.C0257v;
import android.support.v7.p013b.C0200b;
import android.view.View;

/* renamed from: android.support.v7.widget.h */
class C0294h extends C0257v {
    final /* synthetic */ C0286a f1468c;

    public C0294h(C0286a c0286a, Context context, C0240i c0240i, View view, boolean z) {
        this.f1468c = c0286a;
        super(context, c0240i, view, z, C0200b.actionOverflowMenuStyle);
        m1720a(8388613);
        m1723a(c0286a.f1390g);
    }

    public void onDismiss() {
        super.onDismiss();
        this.f1468c.c.close();
        this.f1468c.f1405v = null;
    }
}
