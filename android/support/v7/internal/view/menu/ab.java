package android.support.v7.internal.view.menu;

import android.content.Context;
import android.os.Build.VERSION;
import android.support.v4.p005d.p006a.C0091a;
import android.support.v4.p005d.p006a.C0092b;
import android.support.v4.p005d.p006a.C0093c;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;

public final class ab {
    public static Menu m1542a(Context context, C0091a c0091a) {
        if (VERSION.SDK_INT >= 14) {
            return new ac(context, c0091a);
        }
        throw new UnsupportedOperationException();
    }

    public static MenuItem m1543a(Context context, C0092b c0092b) {
        if (VERSION.SDK_INT >= 16) {
            return new C0255t(context, c0092b);
        }
        if (VERSION.SDK_INT >= 14) {
            return new C0250o(context, c0092b);
        }
        throw new UnsupportedOperationException();
    }

    public static SubMenu m1544a(Context context, C0093c c0093c) {
        if (VERSION.SDK_INT >= 14) {
            return new ae(context, c0093c);
        }
        throw new UnsupportedOperationException();
    }
}
