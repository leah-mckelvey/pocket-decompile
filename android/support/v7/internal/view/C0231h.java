package android.support.v7.internal.view;

import android.content.res.TypedArray;
import android.support.v4.p000h.C0118a;
import android.support.v4.p000h.C0141y;
import android.support.v7.internal.view.menu.C0248m;
import android.support.v7.internal.view.menu.C0250o;
import android.support.v7.p013b.C0210l;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

/* renamed from: android.support.v7.internal.view.h */
class C0231h {
    final /* synthetic */ C0229f f745a;
    private Menu f746b;
    private int f747c;
    private int f748d;
    private int f749e;
    private int f750f;
    private boolean f751g;
    private boolean f752h;
    private boolean f753i;
    private int f754j;
    private int f755k;
    private CharSequence f756l;
    private CharSequence f757m;
    private int f758n;
    private char f759o;
    private char f760p;
    private int f761q;
    private boolean f762r;
    private boolean f763s;
    private boolean f764t;
    private int f765u;
    private int f766v;
    private String f767w;
    private String f768x;
    private String f769y;
    private C0118a f770z;

    public C0231h(C0229f c0229f, Menu menu) {
        this.f745a = c0229f;
        this.f746b = menu;
        m1497a();
    }

    private char m1493a(String str) {
        return str == null ? '\u0000' : str.charAt(0);
    }

    private Object m1495a(String str, Class[] clsArr, Object[] objArr) {
        try {
            return this.f745a.f740e.getClassLoader().loadClass(str).getConstructor(clsArr).newInstance(objArr);
        } catch (Throwable e) {
            Log.w("SupportMenuInflater", "Cannot instantiate class: " + str, e);
            return null;
        }
    }

    private void m1496a(MenuItem menuItem) {
        boolean z = true;
        menuItem.setChecked(this.f762r).setVisible(this.f763s).setEnabled(this.f764t).setCheckable(this.f761q >= 1).setTitleCondensed(this.f757m).setIcon(this.f758n).setAlphabeticShortcut(this.f759o).setNumericShortcut(this.f760p);
        if (this.f765u >= 0) {
            C0141y.m971a(menuItem, this.f765u);
        }
        if (this.f769y != null) {
            if (this.f745a.f740e.isRestricted()) {
                throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
            }
            menuItem.setOnMenuItemClickListener(new C0230g(this.f745a.m1490c(), this.f769y));
        }
        if (menuItem instanceof C0248m) {
            C0248m c0248m = (C0248m) menuItem;
        }
        if (this.f761q >= 2) {
            if (menuItem instanceof C0248m) {
                ((C0248m) menuItem).m1679a(true);
            } else if (menuItem instanceof C0250o) {
                ((C0250o) menuItem).m1700a(true);
            }
        }
        if (this.f767w != null) {
            C0141y.m969a(menuItem, (View) m1495a(this.f767w, C0229f.f736a, this.f745a.f738c));
        } else {
            z = false;
        }
        if (this.f766v > 0) {
            if (z) {
                Log.w("SupportMenuInflater", "Ignoring attribute 'itemActionViewLayout'. Action view already specified.");
            } else {
                C0141y.m972b(menuItem, this.f766v);
            }
        }
        if (this.f770z != null) {
            C0141y.m968a(menuItem, this.f770z);
        }
    }

    public void m1497a() {
        this.f747c = 0;
        this.f748d = 0;
        this.f749e = 0;
        this.f750f = 0;
        this.f751g = true;
        this.f752h = true;
    }

    public void m1498a(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.f745a.f740e.obtainStyledAttributes(attributeSet, C0210l.MenuGroup);
        this.f747c = obtainStyledAttributes.getResourceId(C0210l.MenuGroup_android_id, 0);
        this.f748d = obtainStyledAttributes.getInt(C0210l.MenuGroup_android_menuCategory, 0);
        this.f749e = obtainStyledAttributes.getInt(C0210l.MenuGroup_android_orderInCategory, 0);
        this.f750f = obtainStyledAttributes.getInt(C0210l.MenuGroup_android_checkableBehavior, 0);
        this.f751g = obtainStyledAttributes.getBoolean(C0210l.MenuGroup_android_visible, true);
        this.f752h = obtainStyledAttributes.getBoolean(C0210l.MenuGroup_android_enabled, true);
        obtainStyledAttributes.recycle();
    }

    public void m1499b() {
        this.f753i = true;
        m1496a(this.f746b.add(this.f747c, this.f754j, this.f755k, this.f756l));
    }

    public void m1500b(AttributeSet attributeSet) {
        boolean z = true;
        TypedArray obtainStyledAttributes = this.f745a.f740e.obtainStyledAttributes(attributeSet, C0210l.MenuItem);
        this.f754j = obtainStyledAttributes.getResourceId(C0210l.MenuItem_android_id, 0);
        this.f755k = (obtainStyledAttributes.getInt(C0210l.MenuItem_android_menuCategory, this.f748d) & -65536) | (obtainStyledAttributes.getInt(C0210l.MenuItem_android_orderInCategory, this.f749e) & 65535);
        this.f756l = obtainStyledAttributes.getText(C0210l.MenuItem_android_title);
        this.f757m = obtainStyledAttributes.getText(C0210l.MenuItem_android_titleCondensed);
        this.f758n = obtainStyledAttributes.getResourceId(C0210l.MenuItem_android_icon, 0);
        this.f759o = m1493a(obtainStyledAttributes.getString(C0210l.MenuItem_android_alphabeticShortcut));
        this.f760p = m1493a(obtainStyledAttributes.getString(C0210l.MenuItem_android_numericShortcut));
        if (obtainStyledAttributes.hasValue(C0210l.MenuItem_android_checkable)) {
            this.f761q = obtainStyledAttributes.getBoolean(C0210l.MenuItem_android_checkable, false) ? 1 : 0;
        } else {
            this.f761q = this.f750f;
        }
        this.f762r = obtainStyledAttributes.getBoolean(C0210l.MenuItem_android_checked, false);
        this.f763s = obtainStyledAttributes.getBoolean(C0210l.MenuItem_android_visible, this.f751g);
        this.f764t = obtainStyledAttributes.getBoolean(C0210l.MenuItem_android_enabled, this.f752h);
        this.f765u = obtainStyledAttributes.getInt(C0210l.MenuItem_showAsAction, -1);
        this.f769y = obtainStyledAttributes.getString(C0210l.MenuItem_android_onClick);
        this.f766v = obtainStyledAttributes.getResourceId(C0210l.MenuItem_actionLayout, 0);
        this.f767w = obtainStyledAttributes.getString(C0210l.MenuItem_actionViewClass);
        this.f768x = obtainStyledAttributes.getString(C0210l.MenuItem_actionProviderClass);
        if (this.f768x == null) {
            z = false;
        }
        if (z && this.f766v == 0 && this.f767w == null) {
            this.f770z = (C0118a) m1495a(this.f768x, C0229f.f737b, this.f745a.f739d);
        } else {
            if (z) {
                Log.w("SupportMenuInflater", "Ignoring attribute 'actionProviderClass'. Action view already specified.");
            }
            this.f770z = null;
        }
        obtainStyledAttributes.recycle();
        this.f753i = false;
    }

    public SubMenu m1501c() {
        this.f753i = true;
        SubMenu addSubMenu = this.f746b.addSubMenu(this.f747c, this.f754j, this.f755k, this.f756l);
        m1496a(addSubMenu.getItem());
        return addSubMenu;
    }

    public boolean m1502d() {
        return this.f753i;
    }
}
