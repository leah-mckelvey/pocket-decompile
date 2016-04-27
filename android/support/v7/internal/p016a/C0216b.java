package android.support.v7.internal.p016a;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.support.v4.p000h.au;
import android.support.v4.p000h.bt;
import android.support.v4.p000h.ck;
import android.support.v4.p000h.cm;
import android.support.v7.internal.view.C0224a;
import android.support.v7.internal.view.C0232i;
import android.support.v7.internal.widget.ActionBarContainer;
import android.support.v7.internal.widget.ActionBarContextView;
import android.support.v7.internal.widget.ActionBarOverlayLayout;
import android.support.v7.internal.widget.C0215n;
import android.support.v7.internal.widget.ai;
import android.support.v7.internal.widget.ap;
import android.support.v7.p011a.C0169a;
import android.support.v7.p011a.C0174c;
import android.support.v7.p012d.C0171b;
import android.support.v7.p012d.C0212a;
import android.support.v7.p013b.C0200b;
import android.support.v7.p013b.C0205g;
import android.support.v7.p013b.C0210l;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.animation.AnimationUtils;
import java.util.ArrayList;

/* renamed from: android.support.v7.internal.a.b */
public class C0216b extends C0169a implements C0215n {
    static final /* synthetic */ boolean f675h;
    private static final boolean f676i;
    private boolean f677A;
    private int f678B;
    private boolean f679C;
    private boolean f680D;
    private boolean f681E;
    private boolean f682F;
    private boolean f683G;
    private C0232i f684H;
    private boolean f685I;
    C0220f f686a;
    C0212a f687b;
    C0171b f688c;
    boolean f689d;
    final ck f690e;
    final ck f691f;
    final cm f692g;
    private Context f693j;
    private Context f694k;
    private Activity f695l;
    private Dialog f696m;
    private ActionBarOverlayLayout f697n;
    private ActionBarContainer f698o;
    private ai f699p;
    private ActionBarContextView f700q;
    private ActionBarContainer f701r;
    private View f702s;
    private ap f703t;
    private ArrayList f704u;
    private int f705v;
    private boolean f706w;
    private boolean f707x;
    private ArrayList f708y;
    private int f709z;

    static {
        boolean z = true;
        f675h = !C0216b.class.desiredAssertionStatus();
        if (VERSION.SDK_INT < 14) {
            z = false;
        }
        f676i = z;
    }

    public C0216b(Activity activity, boolean z) {
        this.f704u = new ArrayList();
        this.f705v = -1;
        this.f708y = new ArrayList();
        this.f678B = 0;
        this.f679C = true;
        this.f683G = true;
        this.f690e = new C0217c(this);
        this.f691f = new C0218d(this);
        this.f692g = new C0219e(this);
        this.f695l = activity;
        View decorView = activity.getWindow().getDecorView();
        m1384a(decorView);
        if (!z) {
            this.f702s = decorView.findViewById(16908290);
        }
    }

    public C0216b(Dialog dialog) {
        this.f704u = new ArrayList();
        this.f705v = -1;
        this.f708y = new ArrayList();
        this.f678B = 0;
        this.f679C = true;
        this.f683G = true;
        this.f690e = new C0217c(this);
        this.f691f = new C0218d(this);
        this.f692g = new C0219e(this);
        this.f696m = dialog;
        m1384a(dialog.getWindow().getDecorView());
    }

    private void m1384a(View view) {
        this.f697n = (ActionBarOverlayLayout) view.findViewById(C0205g.decor_content_parent);
        if (this.f697n != null) {
            this.f697n.setActionBarVisibilityCallback(this);
        }
        this.f699p = m1387b(view.findViewById(C0205g.action_bar));
        this.f700q = (ActionBarContextView) view.findViewById(C0205g.action_context_bar);
        this.f698o = (ActionBarContainer) view.findViewById(C0205g.action_bar_container);
        this.f701r = (ActionBarContainer) view.findViewById(C0205g.split_action_bar);
        if (this.f699p == null || this.f700q == null || this.f698o == null) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used " + "with a compatible window decor layout");
        }
        this.f693j = this.f699p.m1846b();
        this.f709z = this.f699p.m1850c() ? 1 : 0;
        boolean z = (this.f699p.m1864p() & 4) != 0;
        if (z) {
            this.f706w = true;
        }
        C0224a a = C0224a.m1450a(this.f693j);
        z = a.m1456f() || z;
        m1410a(z);
        m1400k(a.m1454d());
        TypedArray obtainStyledAttributes = this.f693j.obtainStyledAttributes(null, C0210l.ActionBar, C0200b.actionBarStyle, 0);
        if (obtainStyledAttributes.getBoolean(C0210l.ActionBar_hideOnContentScroll, false)) {
            m1412b(true);
        }
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(C0210l.ActionBar_elevation, 0);
        if (dimensionPixelSize != 0) {
            m1405a((float) dimensionPixelSize);
        }
        obtainStyledAttributes.recycle();
    }

    private ai m1387b(View view) {
        if (view instanceof ai) {
            return (ai) view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getWrapper();
        }
        throw new IllegalStateException(new StringBuilder().append("Can't make a decor toolbar out of ").append(view).toString() != null ? view.getClass().getSimpleName() : "null");
    }

    private static boolean m1389b(boolean z, boolean z2, boolean z3) {
        return z3 ? true : (z || z2) ? false : true;
    }

    private void m1399k() {
        if (!this.f682F) {
            this.f682F = true;
            if (this.f697n != null) {
                this.f697n.setShowingForActionMode(true);
            }
            m1402l(false);
        }
    }

    private void m1400k(boolean z) {
        boolean z2 = true;
        this.f677A = z;
        if (this.f677A) {
            this.f698o.setTabContainer(null);
            this.f699p.m1841a(this.f703t);
        } else {
            this.f699p.m1841a(null);
            this.f698o.setTabContainer(this.f703t);
        }
        boolean z3 = m1418f() == 2;
        if (this.f703t != null) {
            if (z3) {
                this.f703t.setVisibility(0);
                if (this.f697n != null) {
                    au.m705i(this.f697n);
                }
            } else {
                this.f703t.setVisibility(8);
            }
        }
        ai aiVar = this.f699p;
        boolean z4 = !this.f677A && z3;
        aiVar.m1845a(z4);
        ActionBarOverlayLayout actionBarOverlayLayout = this.f697n;
        if (this.f677A || !z3) {
            z2 = false;
        }
        actionBarOverlayLayout.setHasNonEmbeddedTabs(z2);
    }

    private void m1401l() {
        if (this.f682F) {
            this.f682F = false;
            if (this.f697n != null) {
                this.f697n.setShowingForActionMode(false);
            }
            m1402l(false);
        }
    }

    private void m1402l(boolean z) {
        if (C0216b.m1389b(this.f680D, this.f681E, this.f682F)) {
            if (!this.f683G) {
                this.f683G = true;
                m1423h(z);
            }
        } else if (this.f683G) {
            this.f683G = false;
            m1425i(z);
        }
    }

    public int m1403a() {
        return this.f699p.m1864p();
    }

    public C0212a m1404a(C0171b c0171b) {
        if (this.f686a != null) {
            this.f686a.m1441c();
        }
        this.f697n.setHideOnContentScrollEnabled(false);
        this.f700q.m1755c();
        C0212a c0220f = new C0220f(this, this.f700q.getContext(), c0171b);
        if (!c0220f.m1443e()) {
            return null;
        }
        c0220f.m1442d();
        this.f700q.m1750a(c0220f);
        m1427j(true);
        if (!(this.f701r == null || this.f709z != 1 || this.f701r.getVisibility() == 0)) {
            this.f701r.setVisibility(0);
            if (this.f697n != null) {
                au.m705i(this.f697n);
            }
        }
        this.f700q.sendAccessibilityEvent(32);
        this.f686a = c0220f;
        return c0220f;
    }

    public void m1405a(float f) {
        au.m701e(this.f698o, f);
        if (this.f701r != null) {
            au.m701e(this.f701r, f);
        }
    }

    public void m1406a(int i) {
        this.f678B = i;
    }

    public void m1407a(int i, int i2) {
        int p = this.f699p.m1864p();
        if ((i2 & 4) != 0) {
            this.f706w = true;
        }
        this.f699p.m1849c((p & (i2 ^ -1)) | (i & i2));
    }

    public void m1408a(Configuration configuration) {
        m1400k(C0224a.m1450a(this.f693j).m1454d());
    }

    public void m1409a(CharSequence charSequence) {
        this.f699p.m1844a(charSequence);
    }

    public void m1410a(boolean z) {
        this.f699p.m1848b(z);
    }

    public Context m1411b() {
        if (this.f694k == null) {
            TypedValue typedValue = new TypedValue();
            this.f693j.getTheme().resolveAttribute(C0200b.actionBarWidgetTheme, typedValue, true);
            int i = typedValue.resourceId;
            if (i != 0) {
                this.f694k = new ContextThemeWrapper(this.f693j, i);
            } else {
                this.f694k = this.f693j;
            }
        }
        return this.f694k;
    }

    public void m1412b(boolean z) {
        if (!z || this.f697n.m1787a()) {
            this.f689d = z;
            this.f697n.setHideOnContentScrollEnabled(z);
            return;
        }
        throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to enable hide on content scroll");
    }

    public void m1413c(boolean z) {
        if (!this.f706w) {
            m1419f(z);
        }
    }

    public void m1414d(boolean z) {
        this.f685I = z;
        if (!z && this.f684H != null) {
            this.f684H.m1512b();
        }
    }

    public boolean m1415d() {
        if (this.f699p == null || !this.f699p.m1852d()) {
            return false;
        }
        this.f699p.m1853e();
        return true;
    }

    void m1416e() {
        if (this.f688c != null) {
            this.f688c.m1159a(this.f687b);
            this.f687b = null;
            this.f688c = null;
        }
    }

    public void m1417e(boolean z) {
        if (z != this.f707x) {
            this.f707x = z;
            int size = this.f708y.size();
            for (int i = 0; i < size; i++) {
                ((C0174c) this.f708y.get(i)).m1183a(z);
            }
        }
    }

    public int m1418f() {
        return this.f699p.m1865q();
    }

    public void m1419f(boolean z) {
        m1407a(z ? 4 : 0, 4);
    }

    public void m1420g() {
        if (this.f681E) {
            this.f681E = false;
            m1402l(true);
        }
    }

    public void m1421g(boolean z) {
        this.f679C = z;
    }

    public void m1422h() {
        if (!this.f681E) {
            this.f681E = true;
            m1402l(true);
        }
    }

    public void m1423h(boolean z) {
        if (this.f684H != null) {
            this.f684H.m1512b();
        }
        this.f698o.setVisibility(0);
        if (this.f678B == 0 && f676i && (this.f685I || z)) {
            au.m694b(this.f698o, 0.0f);
            float f = (float) (-this.f698o.getHeight());
            if (z) {
                int[] iArr = new int[]{0, 0};
                this.f698o.getLocationInWindow(iArr);
                f -= (float) iArr[1];
            }
            au.m694b(this.f698o, f);
            C0232i c0232i = new C0232i();
            bt c = au.m703g(this.f698o).m869c(0.0f);
            c.m863a(this.f692g);
            c0232i.m1508a(c);
            if (this.f679C && this.f702s != null) {
                au.m694b(this.f702s, f);
                c0232i.m1508a(au.m703g(this.f702s).m869c(0.0f));
            }
            if (this.f701r != null && this.f709z == 1) {
                au.m694b(this.f701r, (float) this.f701r.getHeight());
                this.f701r.setVisibility(0);
                c0232i.m1508a(au.m703g(this.f701r).m869c(0.0f));
            }
            c0232i.m1510a(AnimationUtils.loadInterpolator(this.f693j, 17432582));
            c0232i.m1507a(250);
            c0232i.m1509a(this.f691f);
            this.f684H = c0232i;
            c0232i.m1511a();
        } else {
            au.m697c(this.f698o, 1.0f);
            au.m694b(this.f698o, 0.0f);
            if (this.f679C && this.f702s != null) {
                au.m694b(this.f702s, 0.0f);
            }
            if (this.f701r != null && this.f709z == 1) {
                au.m697c(this.f701r, 1.0f);
                au.m694b(this.f701r, 0.0f);
                this.f701r.setVisibility(0);
            }
            this.f691f.m110b(null);
        }
        if (this.f697n != null) {
            au.m705i(this.f697n);
        }
    }

    public void m1424i() {
        if (this.f684H != null) {
            this.f684H.m1512b();
            this.f684H = null;
        }
    }

    public void m1425i(boolean z) {
        if (this.f684H != null) {
            this.f684H.m1512b();
        }
        if (this.f678B == 0 && f676i && (this.f685I || z)) {
            au.m697c(this.f698o, 1.0f);
            this.f698o.setTransitioning(true);
            C0232i c0232i = new C0232i();
            float f = (float) (-this.f698o.getHeight());
            if (z) {
                int[] iArr = new int[]{0, 0};
                this.f698o.getLocationInWindow(iArr);
                f -= (float) iArr[1];
            }
            bt c = au.m703g(this.f698o).m869c(f);
            c.m863a(this.f692g);
            c0232i.m1508a(c);
            if (this.f679C && this.f702s != null) {
                c0232i.m1508a(au.m703g(this.f702s).m869c(f));
            }
            if (this.f701r != null && this.f701r.getVisibility() == 0) {
                au.m697c(this.f701r, 1.0f);
                c0232i.m1508a(au.m703g(this.f701r).m869c((float) this.f701r.getHeight()));
            }
            c0232i.m1510a(AnimationUtils.loadInterpolator(this.f693j, 17432581));
            c0232i.m1507a(250);
            c0232i.m1509a(this.f690e);
            this.f684H = c0232i;
            c0232i.m1511a();
            return;
        }
        this.f690e.m110b(null);
    }

    public void m1426j() {
    }

    public void m1427j(boolean z) {
        int i = 0;
        if (z) {
            m1399k();
        } else {
            m1401l();
        }
        this.f699p.m1851d(z ? 8 : 0);
        ActionBarContextView actionBarContextView = this.f700q;
        if (!z) {
            i = 8;
        }
        actionBarContextView.m1749a(i);
    }
}
