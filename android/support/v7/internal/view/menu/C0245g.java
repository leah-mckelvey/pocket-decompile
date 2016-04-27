package android.support.v7.internal.view.menu;

import android.content.Context;
import android.support.v7.p013b.C0207i;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListAdapter;

/* renamed from: android.support.v7.internal.view.menu.g */
public class C0245g implements C0243x, OnItemClickListener {
    Context f874a;
    LayoutInflater f875b;
    C0240i f876c;
    ExpandedMenuView f877d;
    int f878e;
    int f879f;
    C0246h f880g;
    private int f881h;
    private C0170y f882i;

    public C0245g(int i, int i2) {
        this.f879f = i;
        this.f878e = i2;
    }

    public C0245g(Context context, int i) {
        this(i, 0);
        this.f874a = context;
        this.f875b = LayoutInflater.from(this.f874a);
    }

    public C0007z m1654a(ViewGroup viewGroup) {
        if (this.f877d == null) {
            this.f877d = (ExpandedMenuView) this.f875b.inflate(C0207i.abc_expanded_menu_layout, viewGroup, false);
            if (this.f880g == null) {
                this.f880g = new C0246h(this);
            }
            this.f877d.setAdapter(this.f880g);
            this.f877d.setOnItemClickListener(this);
        }
        return this.f877d;
    }

    public ListAdapter m1655a() {
        if (this.f880g == null) {
            this.f880g = new C0246h(this);
        }
        return this.f880g;
    }

    public void m1656a(Context context, C0240i c0240i) {
        if (this.f878e != 0) {
            this.f874a = new ContextThemeWrapper(context, this.f878e);
            this.f875b = LayoutInflater.from(this.f874a);
        } else if (this.f874a != null) {
            this.f874a = context;
            if (this.f875b == null) {
                this.f875b = LayoutInflater.from(this.f874a);
            }
        }
        this.f876c = c0240i;
        if (this.f880g != null) {
            this.f880g.notifyDataSetChanged();
        }
    }

    public void m1657a(C0240i c0240i, boolean z) {
        if (this.f882i != null) {
            this.f882i.m1155a(c0240i, z);
        }
    }

    public void m1658a(C0170y c0170y) {
        this.f882i = c0170y;
    }

    public boolean m1659a(ad adVar) {
        if (!adVar.hasVisibleItems()) {
            return false;
        }
        new C0247l(adVar).m1667a(null);
        if (this.f882i != null) {
            this.f882i.m1156a(adVar);
        }
        return true;
    }

    public boolean m1660a(C0240i c0240i, C0248m c0248m) {
        return false;
    }

    public void m1661b(boolean z) {
        if (this.f880g != null) {
            this.f880g.notifyDataSetChanged();
        }
    }

    public boolean m1662b() {
        return false;
    }

    public boolean m1663b(C0240i c0240i, C0248m c0248m) {
        return false;
    }

    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        this.f876c.m1576a(this.f880g.m1664a(i), (C0243x) this, 0);
    }
}
