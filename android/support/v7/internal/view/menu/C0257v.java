package android.support.v7.internal.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.p013b.C0200b;
import android.support.v7.p013b.C0203e;
import android.support.v7.p013b.C0207i;
import android.support.v7.widget.ab;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnKeyListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.PopupWindow.OnDismissListener;

/* renamed from: android.support.v7.internal.view.menu.v */
public class C0257v implements C0243x, OnKeyListener, OnGlobalLayoutListener, OnItemClickListener, OnDismissListener {
    static final int f924a;
    boolean f925b;
    private final Context f926c;
    private final LayoutInflater f927d;
    private final C0240i f928e;
    private final C0258w f929f;
    private final boolean f930g;
    private final int f931h;
    private final int f932i;
    private final int f933j;
    private View f934k;
    private ab f935l;
    private ViewTreeObserver f936m;
    private C0170y f937n;
    private ViewGroup f938o;
    private boolean f939p;
    private int f940q;
    private int f941r;

    static {
        f924a = C0207i.abc_popup_menu_item_layout;
    }

    public C0257v(Context context, C0240i c0240i, View view) {
        this(context, c0240i, view, false, C0200b.popupMenuStyle);
    }

    public C0257v(Context context, C0240i c0240i, View view, boolean z, int i) {
        this(context, c0240i, view, z, i, 0);
    }

    public C0257v(Context context, C0240i c0240i, View view, boolean z, int i, int i2) {
        this.f941r = 0;
        this.f926c = context;
        this.f927d = LayoutInflater.from(context);
        this.f928e = c0240i;
        this.f929f = new C0258w(this, this.f928e);
        this.f930g = z;
        this.f932i = i;
        this.f933j = i2;
        Resources resources = context.getResources();
        this.f931h = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(C0203e.abc_config_prefDialogWidth));
        this.f934k = view;
        c0240i.m1570a((C0243x) this, context);
    }

    private int m1718g() {
        ListAdapter listAdapter = this.f929f;
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(0, 0);
        int makeMeasureSpec2 = MeasureSpec.makeMeasureSpec(0, 0);
        int count = listAdapter.getCount();
        int i = 0;
        int i2 = 0;
        View view = null;
        int i3 = 0;
        while (i < count) {
            View view2;
            int itemViewType = listAdapter.getItemViewType(i);
            if (itemViewType != i2) {
                i2 = itemViewType;
                view2 = null;
            } else {
                view2 = view;
            }
            if (this.f938o == null) {
                this.f938o = new FrameLayout(this.f926c);
            }
            view = listAdapter.getView(i, view2, this.f938o);
            view.measure(makeMeasureSpec, makeMeasureSpec2);
            itemViewType = view.getMeasuredWidth();
            if (itemViewType >= this.f931h) {
                return this.f931h;
            }
            if (itemViewType <= i3) {
                itemViewType = i3;
            }
            i++;
            i3 = itemViewType;
        }
        return i3;
    }

    public void m1719a() {
        if (!m1732d()) {
            throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
        }
    }

    public void m1720a(int i) {
        this.f941r = i;
    }

    public void m1721a(Context context, C0240i c0240i) {
    }

    public void m1722a(C0240i c0240i, boolean z) {
        if (c0240i == this.f928e) {
            m1733e();
            if (this.f937n != null) {
                this.f937n.m1155a(c0240i, z);
            }
        }
    }

    public void m1723a(C0170y c0170y) {
        this.f937n = c0170y;
    }

    public void m1724a(View view) {
        this.f934k = view;
    }

    public void m1725a(boolean z) {
        this.f925b = z;
    }

    public boolean m1726a(ad adVar) {
        if (adVar.hasVisibleItems()) {
            boolean z;
            C0257v c0257v = new C0257v(this.f926c, adVar, this.f934k);
            c0257v.m1723a(this.f937n);
            int size = adVar.size();
            for (int i = 0; i < size; i++) {
                MenuItem item = adVar.getItem(i);
                if (item.isVisible() && item.getIcon() != null) {
                    z = true;
                    break;
                }
            }
            z = false;
            c0257v.m1725a(z);
            if (c0257v.m1732d()) {
                if (this.f937n == null) {
                    return true;
                }
                this.f937n.m1156a(adVar);
                return true;
            }
        }
        return false;
    }

    public boolean m1727a(C0240i c0240i, C0248m c0248m) {
        return false;
    }

    public void m1728b(boolean z) {
        this.f939p = false;
        if (this.f929f != null) {
            this.f929f.notifyDataSetChanged();
        }
    }

    public boolean m1729b() {
        return false;
    }

    public boolean m1730b(C0240i c0240i, C0248m c0248m) {
        return false;
    }

    public ab m1731c() {
        return this.f935l;
    }

    public boolean m1732d() {
        boolean z = false;
        this.f935l = new ab(this.f926c, null, this.f932i, this.f933j);
        this.f935l.m1950a((OnDismissListener) this);
        this.f935l.m1948a((OnItemClickListener) this);
        this.f935l.m1949a(this.f929f);
        this.f935l.m1951a(true);
        View view = this.f934k;
        if (view == null) {
            return false;
        }
        if (this.f936m == null) {
            z = true;
        }
        this.f936m = view.getViewTreeObserver();
        if (z) {
            this.f936m.addOnGlobalLayoutListener(this);
        }
        this.f935l.m1947a(view);
        this.f935l.m1952b(this.f941r);
        if (!this.f939p) {
            this.f940q = m1718g();
            this.f939p = true;
        }
        this.f935l.m1957d(this.f940q);
        this.f935l.m1959e(2);
        this.f935l.m1954c();
        this.f935l.m1961g().setOnKeyListener(this);
        return true;
    }

    public void m1733e() {
        if (m1734f()) {
            this.f935l.m1944a();
        }
    }

    public boolean m1734f() {
        return this.f935l != null && this.f935l.m1953b();
    }

    public void onDismiss() {
        this.f935l = null;
        this.f928e.close();
        if (this.f936m != null) {
            if (!this.f936m.isAlive()) {
                this.f936m = this.f934k.getViewTreeObserver();
            }
            this.f936m.removeGlobalOnLayoutListener(this);
            this.f936m = null;
        }
    }

    public void onGlobalLayout() {
        if (m1734f()) {
            View view = this.f934k;
            if (view == null || !view.isShown()) {
                m1733e();
            } else if (m1734f()) {
                this.f935l.m1954c();
            }
        }
    }

    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        C0258w c0258w = this.f929f;
        c0258w.f943b.m1575a(c0258w.m1736a(i), 0);
    }

    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || i != 82) {
            return false;
        }
        m1733e();
        return true;
    }
}
