package android.support.v7.widget;

import android.content.Context;
import android.support.v7.internal.view.menu.C0248m;
import android.support.v7.internal.view.menu.C0257v;
import android.support.v7.internal.view.menu.ad;
import android.support.v7.p013b.C0200b;
import android.view.MenuItem;
import android.view.View;

/* renamed from: android.support.v7.widget.c */
class C0289c extends C0257v {
    final /* synthetic */ C0286a f1459c;
    private ad f1460d;

    public C0289c(C0286a c0286a, Context context, ad adVar) {
        boolean z = false;
        this.f1459c = c0286a;
        super(context, adVar, null, false, C0200b.actionOverflowMenuStyle);
        this.f1460d = adVar;
        if (!((C0248m) adVar.getItem()).m1693j()) {
            m1724a(c0286a.f1392i == null ? (View) c0286a.f : c0286a.f1392i);
        }
        m1723a(c0286a.f1390g);
        int size = adVar.size();
        for (int i = 0; i < size; i++) {
            MenuItem item = adVar.getItem(i);
            if (item.isVisible() && item.getIcon() != null) {
                z = true;
                break;
            }
        }
        m1725a(z);
    }

    public void onDismiss() {
        super.onDismiss();
        this.f1459c.f1406w = null;
        this.f1459c.f1391h = 0;
    }
}
