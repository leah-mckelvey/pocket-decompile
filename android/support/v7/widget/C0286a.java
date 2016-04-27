package android.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.support.v4.p000h.C0118a;
import android.support.v4.p000h.C0119b;
import android.support.v7.internal.p018c.C0223a;
import android.support.v7.internal.view.C0224a;
import android.support.v7.internal.view.menu.ActionMenuItemView;
import android.support.v7.internal.view.menu.C0007z;
import android.support.v7.internal.view.menu.C0240i;
import android.support.v7.internal.view.menu.C0244d;
import android.support.v7.internal.view.menu.C0248m;
import android.support.v7.internal.view.menu.C0257v;
import android.support.v7.internal.view.menu.aa;
import android.support.v7.internal.view.menu.ad;
import android.support.v7.p013b.C0206h;
import android.support.v7.p013b.C0207i;
import android.util.SparseBooleanArray;
import android.view.MenuItem;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import java.util.ArrayList;

/* renamed from: android.support.v7.widget.a */
public class C0286a extends C0244d implements C0119b {
    final C0295i f1390g;
    int f1391h;
    private View f1392i;
    private boolean f1393j;
    private boolean f1394k;
    private int f1395l;
    private int f1396m;
    private int f1397n;
    private boolean f1398o;
    private boolean f1399p;
    private boolean f1400q;
    private boolean f1401r;
    private int f1402s;
    private final SparseBooleanArray f1403t;
    private View f1404u;
    private C0294h f1405v;
    private C0289c f1406w;
    private C0291e f1407x;
    private C0290d f1408y;

    public C0286a(Context context) {
        super(context, C0207i.abc_action_menu_layout, C0207i.abc_action_menu_item_layout);
        this.f1403t = new SparseBooleanArray();
        this.f1390g = new C0295i();
    }

    private View m2206a(MenuItem menuItem) {
        ViewGroup viewGroup = (ViewGroup) this.f;
        if (viewGroup == null) {
            return null;
        }
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if ((childAt instanceof aa) && ((aa) childAt).getItemData() == menuItem) {
                return childAt;
            }
        }
        return null;
    }

    public C0007z m2214a(ViewGroup viewGroup) {
        C0007z a = super.m1637a(viewGroup);
        ((ActionMenuView) a).setPresenter(this);
        return a;
    }

    public View m2215a(C0248m c0248m, View view, ViewGroup viewGroup) {
        View actionView = c0248m.getActionView();
        if (actionView == null || c0248m.m1697n()) {
            actionView = super.m1638a(c0248m, view, viewGroup);
        }
        actionView.setVisibility(c0248m.isActionViewExpanded() ? 8 : 0);
        ActionMenuView actionMenuView = (ActionMenuView) viewGroup;
        LayoutParams layoutParams = actionView.getLayoutParams();
        if (!actionMenuView.checkLayoutParams(layoutParams)) {
            actionView.setLayoutParams(actionMenuView.m2117a(layoutParams));
        }
        return actionView;
    }

    public void m2216a(int i, boolean z) {
        this.f1395l = i;
        this.f1399p = z;
        this.f1400q = true;
    }

    public void m2217a(Context context, C0240i c0240i) {
        super.m1640a(context, c0240i);
        Resources resources = context.getResources();
        C0224a a = C0224a.m1450a(context);
        if (!this.f1394k) {
            this.f1393j = a.m1452b();
        }
        if (!this.f1400q) {
            this.f1395l = a.m1453c();
        }
        if (!this.f1398o) {
            this.f1397n = a.m1451a();
        }
        int i = this.f1395l;
        if (this.f1393j) {
            if (this.f1392i == null) {
                this.f1392i = new C0292f(this, this.a);
                int makeMeasureSpec = MeasureSpec.makeMeasureSpec(0, 0);
                this.f1392i.measure(makeMeasureSpec, makeMeasureSpec);
            }
            i -= this.f1392i.getMeasuredWidth();
        } else {
            this.f1392i = null;
        }
        this.f1396m = i;
        this.f1402s = (int) (56.0f * resources.getDisplayMetrics().density);
        this.f1404u = null;
    }

    public void m2218a(Configuration configuration) {
        if (!this.f1398o) {
            this.f1397n = this.b.getResources().getInteger(C0206h.abc_max_action_buttons);
        }
        if (this.c != null) {
            this.c.m1581b(true);
        }
    }

    public void m2219a(C0240i c0240i, boolean z) {
        m2233e();
        super.m1641a(c0240i, z);
    }

    public void m2220a(C0248m c0248m, aa aaVar) {
        aaVar.m0a(c0248m, 0);
        ActionMenuItemView actionMenuItemView = (ActionMenuItemView) aaVar;
        actionMenuItemView.setItemInvoker((ActionMenuView) this.f);
        if (this.f1408y == null) {
            this.f1408y = new C0290d();
        }
        actionMenuItemView.setPopupCallback(this.f1408y);
    }

    public void m2221a(ActionMenuView actionMenuView) {
        this.f = actionMenuView;
        actionMenuView.m2118a(this.c);
    }

    public void m2222a(boolean z) {
        if (z) {
            super.m1646a(null);
        } else {
            this.c.m1573a(false);
        }
    }

    public boolean m2223a(int i, C0248m c0248m) {
        return c0248m.m1693j();
    }

    public boolean m2224a(ad adVar) {
        if (!adVar.hasVisibleItems()) {
            return false;
        }
        ad adVar2 = adVar;
        while (adVar2.m1611s() != this.c) {
            adVar2 = (ad) adVar2.m1611s();
        }
        View a = m2206a(adVar2.getItem());
        if (a == null) {
            if (this.f1392i == null) {
                return false;
            }
            a = this.f1392i;
        }
        this.f1391h = adVar.getItem().getItemId();
        this.f1406w = new C0289c(this, this.b, adVar);
        this.f1406w.m1724a(a);
        this.f1406w.m1719a();
        super.m1646a(adVar);
        return true;
    }

    public boolean m2225a(ViewGroup viewGroup, int i) {
        return viewGroup.getChildAt(i) == this.f1392i ? false : super.m1648a(viewGroup, i);
    }

    public void m2226b(int i) {
        this.f1397n = i;
        this.f1398o = true;
    }

    public void m2227b(boolean z) {
        int i;
        int i2 = 1;
        int i3 = 0;
        ViewGroup viewGroup = (ViewGroup) ((View) this.f).getParent();
        if (viewGroup != null) {
            C0223a.m1449a(viewGroup);
        }
        super.m1650b(z);
        ((View) this.f).requestLayout();
        if (this.c != null) {
            ArrayList k = this.c.m1595k();
            int size = k.size();
            for (i = 0; i < size; i++) {
                C0118a a = ((C0248m) k.get(i)).m1675a();
                if (a != null) {
                    a.m610a((C0119b) this);
                }
            }
        }
        ArrayList l = this.c != null ? this.c.m1596l() : null;
        if (this.f1393j && l != null) {
            i = l.size();
            if (i == 1) {
                i3 = !((C0248m) l.get(0)).isActionViewExpanded() ? 1 : 0;
            } else {
                if (i <= 0) {
                    i2 = 0;
                }
                i3 = i2;
            }
        }
        if (i3 != 0) {
            if (this.f1392i == null) {
                this.f1392i = new C0292f(this, this.a);
            }
            viewGroup = (ViewGroup) this.f1392i.getParent();
            if (viewGroup != this.f) {
                if (viewGroup != null) {
                    viewGroup.removeView(this.f1392i);
                }
                ActionMenuView actionMenuView = (ActionMenuView) this.f;
                actionMenuView.addView(this.f1392i, actionMenuView.m2126c());
            }
        } else if (this.f1392i != null && this.f1392i.getParent() == this.f) {
            ((ViewGroup) this.f).removeView(this.f1392i);
        }
        ((ActionMenuView) this.f).setOverflowReserved(this.f1393j);
    }

    public boolean m2228b() {
        int i;
        ArrayList i2 = this.c.m1593i();
        int size = i2.size();
        int i3 = this.f1397n;
        int i4 = this.f1396m;
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(0, 0);
        ViewGroup viewGroup = (ViewGroup) this.f;
        int i5 = 0;
        int i6 = 0;
        Object obj = null;
        int i7 = 0;
        while (i7 < size) {
            C0248m c0248m = (C0248m) i2.get(i7);
            if (c0248m.m1695l()) {
                i5++;
            } else if (c0248m.m1694k()) {
                i6++;
            } else {
                obj = 1;
            }
            i = (this.f1401r && c0248m.isActionViewExpanded()) ? 0 : i3;
            i7++;
            i3 = i;
        }
        if (this.f1393j && (r4 != null || i5 + i6 > i3)) {
            i3--;
        }
        i7 = i3 - i5;
        SparseBooleanArray sparseBooleanArray = this.f1403t;
        sparseBooleanArray.clear();
        i = 0;
        if (this.f1399p) {
            i = i4 / this.f1402s;
            i6 = ((i4 % this.f1402s) / i) + this.f1402s;
        } else {
            i6 = 0;
        }
        int i8 = 0;
        i3 = 0;
        int i9 = i;
        while (i8 < size) {
            c0248m = (C0248m) i2.get(i8);
            int i10;
            if (c0248m.m1695l()) {
                View a = m2215a(c0248m, this.f1404u, viewGroup);
                if (this.f1404u == null) {
                    this.f1404u = a;
                }
                if (this.f1399p) {
                    i9 -= ActionMenuView.m2112a(a, i6, i9, makeMeasureSpec, 0);
                } else {
                    a.measure(makeMeasureSpec, makeMeasureSpec);
                }
                i5 = a.getMeasuredWidth();
                i10 = i4 - i5;
                if (i3 != 0) {
                    i5 = i3;
                }
                i3 = c0248m.getGroupId();
                if (i3 != 0) {
                    sparseBooleanArray.put(i3, true);
                }
                c0248m.m1686d(true);
                i = i10;
                i3 = i7;
            } else if (c0248m.m1694k()) {
                boolean z;
                int groupId = c0248m.getGroupId();
                boolean z2 = sparseBooleanArray.get(groupId);
                boolean z3 = (i7 > 0 || z2) && i4 > 0 && (!this.f1399p || i9 > 0);
                if (z3) {
                    View a2 = m2215a(c0248m, this.f1404u, viewGroup);
                    if (this.f1404u == null) {
                        this.f1404u = a2;
                    }
                    boolean z4;
                    if (this.f1399p) {
                        int a3 = ActionMenuView.m2112a(a2, i6, i9, makeMeasureSpec, 0);
                        i10 = i9 - a3;
                        if (a3 == 0) {
                            i9 = 0;
                        } else {
                            z4 = z3;
                        }
                        i5 = i10;
                    } else {
                        a2.measure(makeMeasureSpec, makeMeasureSpec);
                        boolean z5 = z3;
                        i5 = i9;
                        z4 = z5;
                    }
                    i10 = a2.getMeasuredWidth();
                    i4 -= i10;
                    if (i3 == 0) {
                        i3 = i10;
                    }
                    if (this.f1399p) {
                        z = i9 & (i4 >= 0 ? 1 : 0);
                        i10 = i3;
                        i3 = i5;
                    } else {
                        z = i9 & (i4 + i3 > 0 ? 1 : 0);
                        i10 = i3;
                        i3 = i5;
                    }
                } else {
                    z = z3;
                    i10 = i3;
                    i3 = i9;
                }
                if (z && groupId != 0) {
                    sparseBooleanArray.put(groupId, true);
                    i9 = i7;
                } else if (z2) {
                    sparseBooleanArray.put(groupId, false);
                    i5 = i7;
                    for (i7 = 0; i7 < i8; i7++) {
                        C0248m c0248m2 = (C0248m) i2.get(i7);
                        if (c0248m2.getGroupId() == groupId) {
                            if (c0248m2.m1693j()) {
                                i5++;
                            }
                            c0248m2.m1686d(false);
                        }
                    }
                    i9 = i5;
                } else {
                    i9 = i7;
                }
                if (z) {
                    i9--;
                }
                c0248m.m1686d(z);
                i5 = i10;
                i = i4;
                int i11 = i3;
                i3 = i9;
                i9 = i11;
            } else {
                c0248m.m1686d(false);
                i5 = i3;
                i = i4;
                i3 = i7;
            }
            i8++;
            i4 = i;
            i7 = i3;
            i3 = i5;
        }
        return true;
    }

    public void m2229c(boolean z) {
        this.f1393j = z;
        this.f1394k = true;
    }

    public boolean m2230c() {
        if (!this.f1393j || m2235g() || this.c == null || this.f == null || this.f1407x != null || this.c.m1596l().isEmpty()) {
            return false;
        }
        this.f1407x = new C0291e(this, new C0294h(this, this.b, this.c, this.f1392i, true));
        ((View) this.f).post(this.f1407x);
        super.m1646a(null);
        return true;
    }

    public void m2231d(boolean z) {
        this.f1401r = z;
    }

    public boolean m2232d() {
        if (this.f1407x == null || this.f == null) {
            C0257v c0257v = this.f1405v;
            if (c0257v == null) {
                return false;
            }
            c0257v.m1733e();
            return true;
        }
        ((View) this.f).removeCallbacks(this.f1407x);
        this.f1407x = null;
        return true;
    }

    public boolean m2233e() {
        return m2232d() | m2234f();
    }

    public boolean m2234f() {
        if (this.f1406w == null) {
            return false;
        }
        this.f1406w.m1733e();
        return true;
    }

    public boolean m2235g() {
        return this.f1405v != null && this.f1405v.m1734f();
    }

    public boolean m2236h() {
        return this.f1407x != null || m2235g();
    }
}
