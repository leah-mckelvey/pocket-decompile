package android.support.v4.p005d.p006a;

import android.support.v4.p000h.C0118a;
import android.support.v4.p000h.ad;
import android.view.MenuItem;
import android.view.View;

/* renamed from: android.support.v4.d.a.b */
public interface C0092b extends MenuItem {
    C0092b m530a(C0118a c0118a);

    C0092b m531a(ad adVar);

    C0118a m532a();

    boolean collapseActionView();

    boolean expandActionView();

    View getActionView();

    boolean isActionViewExpanded();

    MenuItem setActionView(int i);

    MenuItem setActionView(View view);

    void setShowAsAction(int i);

    MenuItem setShowAsActionFlags(int i);
}
