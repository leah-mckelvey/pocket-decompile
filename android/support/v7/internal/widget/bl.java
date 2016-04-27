package android.support.v7.internal.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.p000h.au;
import android.support.v7.internal.view.menu.C0170y;
import android.support.v7.internal.view.menu.C0240i;
import android.support.v7.p013b.C0200b;
import android.support.v7.p013b.C0204f;
import android.support.v7.p013b.C0205g;
import android.support.v7.p013b.C0208j;
import android.support.v7.p013b.C0210l;
import android.support.v7.widget.C0286a;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.ay;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window.Callback;

public class bl implements ai {
    private Toolbar f1230a;
    private int f1231b;
    private View f1232c;
    private View f1233d;
    private Drawable f1234e;
    private Drawable f1235f;
    private Drawable f1236g;
    private boolean f1237h;
    private CharSequence f1238i;
    private CharSequence f1239j;
    private CharSequence f1240k;
    private Callback f1241l;
    private boolean f1242m;
    private C0286a f1243n;
    private int f1244o;
    private final bi f1245p;
    private int f1246q;
    private Drawable f1247r;

    public bl(Toolbar toolbar, boolean z) {
        this(toolbar, z, C0208j.abc_action_bar_up_description, C0204f.abc_ic_ab_back_mtrl_am_alpha);
    }

    public bl(Toolbar toolbar, boolean z, int i, int i2) {
        this.f1244o = 0;
        this.f1246q = 0;
        this.f1230a = toolbar;
        this.f1238i = toolbar.getTitle();
        this.f1239j = toolbar.getSubtitle();
        this.f1237h = this.f1238i != null;
        this.f1236g = toolbar.getNavigationIcon();
        if (z) {
            bk a = bk.m2000a(toolbar.getContext(), null, C0210l.ActionBar, C0200b.actionBarStyle, 0);
            CharSequence c = a.m2011c(C0210l.ActionBar_title);
            if (!TextUtils.isEmpty(c)) {
                m2038b(c);
            }
            c = a.m2011c(C0210l.ActionBar_subtitle);
            if (!TextUtils.isEmpty(c)) {
                m2042c(c);
            }
            Drawable a2 = a.m2004a(C0210l.ActionBar_logo);
            if (a2 != null) {
                m2041c(a2);
            }
            a2 = a.m2004a(C0210l.ActionBar_icon);
            if (this.f1236g == null && a2 != null) {
                m2028a(a2);
            }
            a2 = a.m2004a(C0210l.ActionBar_homeAsUpIndicator);
            if (a2 != null) {
                m2045d(a2);
            }
            m2040c(a.m2003a(C0210l.ActionBar_displayOptions, 0));
            int f = a.m2016f(C0210l.ActionBar_customNavigationLayout, 0);
            if (f != 0) {
                m2031a(LayoutInflater.from(this.f1230a.getContext()).inflate(f, this.f1230a, false));
                m2040c(this.f1231b | 16);
            }
            f = a.m2014e(C0210l.ActionBar_height, 0);
            if (f > 0) {
                LayoutParams layoutParams = this.f1230a.getLayoutParams();
                layoutParams.height = f;
                this.f1230a.setLayoutParams(layoutParams);
            }
            f = a.m2009c(C0210l.ActionBar_contentInsetStart, -1);
            int c2 = a.m2009c(C0210l.ActionBar_contentInsetEnd, -1);
            if (f >= 0 || c2 >= 0) {
                this.f1230a.m2189a(Math.max(f, 0), Math.max(c2, 0));
            }
            f = a.m2016f(C0210l.ActionBar_titleTextStyle, 0);
            if (f != 0) {
                this.f1230a.m2190a(this.f1230a.getContext(), f);
            }
            f = a.m2016f(C0210l.ActionBar_subtitleTextStyle, 0);
            if (f != 0) {
                this.f1230a.m2193b(this.f1230a.getContext(), f);
            }
            int f2 = a.m2016f(C0210l.ActionBar_popupTheme, 0);
            if (f2 != 0) {
                this.f1230a.setPopupTheme(f2);
            }
            a.m2008b();
            this.f1245p = a.m2010c();
        } else {
            this.f1231b = m2022r();
            this.f1245p = bi.m1979a(toolbar.getContext());
        }
        m2049e(i);
        this.f1240k = this.f1230a.getNavigationContentDescription();
        m2037b(this.f1245p.m1991a(i2));
        this.f1230a.setNavigationOnClickListener(new bm(this));
    }

    private void m2021e(CharSequence charSequence) {
        this.f1238i = charSequence;
        if ((this.f1231b & 8) != 0) {
            this.f1230a.setTitle(charSequence);
        }
    }

    private int m2022r() {
        return this.f1230a.getNavigationIcon() != null ? 15 : 11;
    }

    private void m2023s() {
        Drawable drawable = null;
        if ((this.f1231b & 2) != 0) {
            drawable = (this.f1231b & 1) != 0 ? this.f1235f != null ? this.f1235f : this.f1234e : this.f1234e;
        }
        this.f1230a.setLogo(drawable);
    }

    private void m2024t() {
        if ((this.f1231b & 4) == 0) {
            return;
        }
        if (TextUtils.isEmpty(this.f1240k)) {
            this.f1230a.setNavigationContentDescription(this.f1246q);
        } else {
            this.f1230a.setNavigationContentDescription(this.f1240k);
        }
    }

    private void m2025u() {
        if ((this.f1231b & 4) != 0) {
            this.f1230a.setNavigationIcon(this.f1236g != null ? this.f1236g : this.f1247r);
        }
    }

    public ViewGroup m2026a() {
        return this.f1230a;
    }

    public void m2027a(int i) {
        m2028a(i != 0 ? this.f1245p.m1991a(i) : null);
    }

    public void m2028a(Drawable drawable) {
        this.f1234e = drawable;
        m2023s();
    }

    public void m2029a(ap apVar) {
        if (this.f1232c != null && this.f1232c.getParent() == this.f1230a) {
            this.f1230a.removeView(this.f1232c);
        }
        this.f1232c = apVar;
        if (apVar != null && this.f1244o == 2) {
            this.f1230a.addView(this.f1232c, 0);
            ay ayVar = (ay) this.f1232c.getLayoutParams();
            ayVar.width = -2;
            ayVar.height = -2;
            ayVar.a = 8388691;
            apVar.setAllowCollapse(true);
        }
    }

    public void m2030a(Menu menu, C0170y c0170y) {
        if (this.f1243n == null) {
            this.f1243n = new C0286a(this.f1230a.getContext());
            this.f1243n.m1639a(C0205g.action_menu_presenter);
        }
        this.f1243n.m1643a(c0170y);
        this.f1230a.m2191a((C0240i) menu, this.f1243n);
    }

    public void m2031a(View view) {
        if (!(this.f1233d == null || (this.f1231b & 16) == 0)) {
            this.f1230a.removeView(this.f1233d);
        }
        this.f1233d = view;
        if (view != null && (this.f1231b & 16) != 0) {
            this.f1230a.addView(this.f1233d);
        }
    }

    public void m2032a(Callback callback) {
        this.f1241l = callback;
    }

    public void m2033a(CharSequence charSequence) {
        if (!this.f1237h) {
            m2021e(charSequence);
        }
    }

    public void m2034a(boolean z) {
        this.f1230a.setCollapsible(z);
    }

    public Context m2035b() {
        return this.f1230a.getContext();
    }

    public void m2036b(int i) {
        m2041c(i != 0 ? this.f1245p.m1991a(i) : null);
    }

    public void m2037b(Drawable drawable) {
        if (this.f1247r != drawable) {
            this.f1247r = drawable;
            m2025u();
        }
    }

    public void m2038b(CharSequence charSequence) {
        this.f1237h = true;
        m2021e(charSequence);
    }

    public void m2039b(boolean z) {
    }

    public void m2040c(int i) {
        int i2 = this.f1231b ^ i;
        this.f1231b = i;
        if (i2 != 0) {
            if ((i2 & 4) != 0) {
                if ((i & 4) != 0) {
                    m2025u();
                    m2024t();
                } else {
                    this.f1230a.setNavigationIcon(null);
                }
            }
            if ((i2 & 3) != 0) {
                m2023s();
            }
            if ((i2 & 8) != 0) {
                if ((i & 8) != 0) {
                    this.f1230a.setTitle(this.f1238i);
                    this.f1230a.setSubtitle(this.f1239j);
                } else {
                    this.f1230a.setTitle(null);
                    this.f1230a.setSubtitle(null);
                }
            }
            if ((i2 & 16) != 0 && this.f1233d != null) {
                if ((i & 16) != 0) {
                    this.f1230a.addView(this.f1233d);
                } else {
                    this.f1230a.removeView(this.f1233d);
                }
            }
        }
    }

    public void m2041c(Drawable drawable) {
        this.f1235f = drawable;
        m2023s();
    }

    public void m2042c(CharSequence charSequence) {
        this.f1239j = charSequence;
        if ((this.f1231b & 8) != 0) {
            this.f1230a.setSubtitle(charSequence);
        }
    }

    public boolean m2043c() {
        return false;
    }

    public void m2044d(int i) {
        if (i == 8) {
            au.m703g(this.f1230a).m860a(0.0f).m862a(new bn(this));
        } else if (i == 0) {
            au.m703g(this.f1230a).m860a(1.0f).m862a(new bo(this));
        }
    }

    public void m2045d(Drawable drawable) {
        this.f1236g = drawable;
        m2025u();
    }

    public void m2046d(CharSequence charSequence) {
        this.f1240k = charSequence;
        m2024t();
    }

    public boolean m2047d() {
        return this.f1230a.m2199g();
    }

    public void m2048e() {
        this.f1230a.m2200h();
    }

    public void m2049e(int i) {
        if (i != this.f1246q) {
            this.f1246q = i;
            if (TextUtils.isEmpty(this.f1230a.getNavigationContentDescription())) {
                m2051f(this.f1246q);
            }
        }
    }

    public CharSequence m2050f() {
        return this.f1230a.getTitle();
    }

    public void m2051f(int i) {
        m2046d(i == 0 ? null : m2035b().getString(i));
    }

    public void m2052g() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    public void m2053h() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    public boolean m2054i() {
        return this.f1230a.m2192a();
    }

    public boolean m2055j() {
        return this.f1230a.m2194b();
    }

    public boolean m2056k() {
        return this.f1230a.m2195c();
    }

    public boolean m2057l() {
        return this.f1230a.m2196d();
    }

    public boolean m2058m() {
        return this.f1230a.m2197e();
    }

    public void m2059n() {
        this.f1242m = true;
    }

    public void m2060o() {
        this.f1230a.m2198f();
    }

    public int m2061p() {
        return this.f1231b;
    }

    public int m2062q() {
        return this.f1244o;
    }
}
