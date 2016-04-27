package android.support.v4.p000h;

import android.view.MenuItem;
import android.view.View;

/* renamed from: android.support.v4.h.ae */
class ae {
    public static MenuItem m634a(MenuItem menuItem, View view) {
        return menuItem.setActionView(view);
    }

    public static View m635a(MenuItem menuItem) {
        return menuItem.getActionView();
    }

    public static void m636a(MenuItem menuItem, int i) {
        menuItem.setShowAsAction(i);
    }

    public static MenuItem m637b(MenuItem menuItem, int i) {
        return menuItem.setActionView(i);
    }
}
