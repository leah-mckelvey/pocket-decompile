package android.support.v4.p000h;

import android.os.Build.VERSION;
import android.support.v4.p005d.p006a.C0092b;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

/* renamed from: android.support.v4.h.y */
public class C0141y {
    static final ac f426a;

    static {
        int i = VERSION.SDK_INT;
        if (i >= 14) {
            f426a = new ab();
        } else if (i >= 11) {
            f426a = new aa();
        } else {
            f426a = new C0142z();
        }
    }

    public static MenuItem m968a(MenuItem menuItem, C0118a c0118a) {
        if (menuItem instanceof C0092b) {
            return ((C0092b) menuItem).m530a(c0118a);
        }
        Log.w("MenuItemCompat", "setActionProvider: item does not implement SupportMenuItem; ignoring");
        return menuItem;
    }

    public static MenuItem m969a(MenuItem menuItem, View view) {
        return menuItem instanceof C0092b ? ((C0092b) menuItem).setActionView(view) : f426a.m618a(menuItem, view);
    }

    public static View m970a(MenuItem menuItem) {
        return menuItem instanceof C0092b ? ((C0092b) menuItem).getActionView() : f426a.m619a(menuItem);
    }

    public static void m971a(MenuItem menuItem, int i) {
        if (menuItem instanceof C0092b) {
            ((C0092b) menuItem).setShowAsAction(i);
        } else {
            f426a.m620a(menuItem, i);
        }
    }

    public static MenuItem m972b(MenuItem menuItem, int i) {
        return menuItem instanceof C0092b ? ((C0092b) menuItem).setActionView(i) : f426a.m621b(menuItem, i);
    }

    public static boolean m973b(MenuItem menuItem) {
        return menuItem instanceof C0092b ? ((C0092b) menuItem).expandActionView() : f426a.m622b(menuItem);
    }

    public static boolean m974c(MenuItem menuItem) {
        return menuItem instanceof C0092b ? ((C0092b) menuItem).isActionViewExpanded() : f426a.m623c(menuItem);
    }
}
