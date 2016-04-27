package android.support.v7.internal.view.menu;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;

/* renamed from: android.support.v7.internal.view.menu.w */
class C0258w extends BaseAdapter {
    final /* synthetic */ C0257v f942a;
    private C0240i f943b;
    private int f944c;

    public C0258w(C0257v c0257v, C0240i c0240i) {
        this.f942a = c0257v;
        this.f944c = -1;
        this.f943b = c0240i;
        m1737a();
    }

    public C0248m m1736a(int i) {
        ArrayList l = this.f942a.f930g ? this.f943b.m1596l() : this.f943b.m1593i();
        if (this.f944c >= 0 && i >= this.f944c) {
            i++;
        }
        return (C0248m) l.get(i);
    }

    void m1737a() {
        C0248m r = this.f942a.f928e.m1602r();
        if (r != null) {
            ArrayList l = this.f942a.f928e.m1596l();
            int size = l.size();
            for (int i = 0; i < size; i++) {
                if (((C0248m) l.get(i)) == r) {
                    this.f944c = i;
                    return;
                }
            }
        }
        this.f944c = -1;
    }

    public int getCount() {
        ArrayList l = this.f942a.f930g ? this.f943b.m1596l() : this.f943b.m1593i();
        return this.f944c < 0 ? l.size() : l.size() - 1;
    }

    public /* synthetic */ Object getItem(int i) {
        return m1736a(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        View inflate = view == null ? this.f942a.f927d.inflate(C0257v.f924a, viewGroup, false) : view;
        aa aaVar = (aa) inflate;
        if (this.f942a.f925b) {
            ((ListMenuItemView) inflate).setForceShowIcon(true);
        }
        aaVar.m0a(m1736a(i), 0);
        return inflate;
    }

    public void notifyDataSetChanged() {
        m1737a();
        super.notifyDataSetChanged();
    }
}
