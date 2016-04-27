package android.support.v7.internal.view.menu;

import android.content.Context;
import android.support.v4.p005d.p006a.C0092b;
import android.support.v4.p005d.p006a.C0093c;
import android.support.v4.p009g.C0103a;
import android.view.MenuItem;
import android.view.SubMenu;
import java.util.Iterator;
import java.util.Map;

/* renamed from: android.support.v7.internal.view.menu.e */
abstract class C0239e extends C0238f {
    final Context f823a;
    private Map f824c;
    private Map f825d;

    C0239e(Context context, Object obj) {
        super(obj);
        this.f823a = context;
    }

    final MenuItem m1545a(MenuItem menuItem) {
        if (!(menuItem instanceof C0092b)) {
            return menuItem;
        }
        C0092b c0092b = (C0092b) menuItem;
        if (this.f824c == null) {
            this.f824c = new C0103a();
        }
        MenuItem menuItem2 = (MenuItem) this.f824c.get(menuItem);
        if (menuItem2 != null) {
            return menuItem2;
        }
        menuItem2 = ab.m1543a(this.f823a, c0092b);
        this.f824c.put(c0092b, menuItem2);
        return menuItem2;
    }

    final SubMenu m1546a(SubMenu subMenu) {
        if (!(subMenu instanceof C0093c)) {
            return subMenu;
        }
        C0093c c0093c = (C0093c) subMenu;
        if (this.f825d == null) {
            this.f825d = new C0103a();
        }
        SubMenu subMenu2 = (SubMenu) this.f825d.get(c0093c);
        if (subMenu2 != null) {
            return subMenu2;
        }
        subMenu2 = ab.m1544a(this.f823a, c0093c);
        this.f825d.put(c0093c, subMenu2);
        return subMenu2;
    }

    final void m1547a() {
        if (this.f824c != null) {
            this.f824c.clear();
        }
        if (this.f825d != null) {
            this.f825d.clear();
        }
    }

    final void m1548a(int i) {
        if (this.f824c != null) {
            Iterator it = this.f824c.keySet().iterator();
            while (it.hasNext()) {
                if (i == ((MenuItem) it.next()).getGroupId()) {
                    it.remove();
                }
            }
        }
    }

    final void m1549b(int i) {
        if (this.f824c != null) {
            Iterator it = this.f824c.keySet().iterator();
            while (it.hasNext()) {
                if (i == ((MenuItem) it.next()).getItemId()) {
                    it.remove();
                    return;
                }
            }
        }
    }
}
