package android.support.v7.internal.view;

import android.content.Context;
import android.support.v4.p005d.p006a.C0091a;
import android.support.v4.p005d.p006a.C0092b;
import android.support.v4.p009g.C0102m;
import android.support.v7.internal.view.menu.ab;
import android.support.v7.p012d.C0171b;
import android.support.v7.p012d.C0212a;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.Menu;
import android.view.MenuItem;
import java.util.ArrayList;

/* renamed from: android.support.v7.internal.view.e */
public class C0228e implements C0171b {
    final Callback f732a;
    final Context f733b;
    final ArrayList f734c;
    final C0102m f735d;

    public C0228e(Context context, Callback callback) {
        this.f733b = context;
        this.f732a = callback;
        this.f734c = new ArrayList();
        this.f735d = new C0102m();
    }

    private Menu m1477a(Menu menu) {
        Menu menu2 = (Menu) this.f735d.get(menu);
        if (menu2 != null) {
            return menu2;
        }
        menu2 = ab.m1542a(this.f733b, (C0091a) menu);
        this.f735d.put(menu, menu2);
        return menu2;
    }

    private ActionMode m1478b(C0212a c0212a) {
        int size = this.f734c.size();
        for (int i = 0; i < size; i++) {
            C0227d c0227d = (C0227d) this.f734c.get(i);
            if (c0227d != null && c0227d.f731b == c0212a) {
                return c0227d;
            }
        }
        ActionMode c0227d2 = new C0227d(this.f733b, c0212a);
        this.f734c.add(c0227d2);
        return c0227d2;
    }

    public void m1479a(C0212a c0212a) {
        this.f732a.onDestroyActionMode(m1478b(c0212a));
    }

    public void m1480a(C0227d c0227d) {
        this.f734c.add(c0227d);
    }

    public boolean m1481a(C0212a c0212a, Menu menu) {
        return this.f732a.onCreateActionMode(m1478b(c0212a), m1477a(menu));
    }

    public boolean m1482a(C0212a c0212a, MenuItem menuItem) {
        return this.f732a.onActionItemClicked(m1478b(c0212a), ab.m1543a(this.f733b, (C0092b) menuItem));
    }

    public boolean m1483b(C0212a c0212a, Menu menu) {
        return this.f732a.onPrepareActionMode(m1478b(c0212a), m1477a(menu));
    }
}
