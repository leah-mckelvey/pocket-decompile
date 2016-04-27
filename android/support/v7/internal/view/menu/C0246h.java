package android.support.v7.internal.view.menu;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;

/* renamed from: android.support.v7.internal.view.menu.h */
class C0246h extends BaseAdapter {
    final /* synthetic */ C0245g f883a;
    private int f884b;

    public C0246h(C0245g c0245g) {
        this.f883a = c0245g;
        this.f884b = -1;
        m1665a();
    }

    public C0248m m1664a(int i) {
        ArrayList l = this.f883a.f876c.m1596l();
        int a = this.f883a.f881h + i;
        if (this.f884b >= 0 && a >= this.f884b) {
            a++;
        }
        return (C0248m) l.get(a);
    }

    void m1665a() {
        C0248m r = this.f883a.f876c.m1602r();
        if (r != null) {
            ArrayList l = this.f883a.f876c.m1596l();
            int size = l.size();
            for (int i = 0; i < size; i++) {
                if (((C0248m) l.get(i)) == r) {
                    this.f884b = i;
                    return;
                }
            }
        }
        this.f884b = -1;
    }

    public int getCount() {
        int size = this.f883a.f876c.m1596l().size() - this.f883a.f881h;
        return this.f884b < 0 ? size : size - 1;
    }

    public /* synthetic */ Object getItem(int i) {
        return m1664a(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        View inflate = view == null ? this.f883a.f875b.inflate(this.f883a.f879f, viewGroup, false) : view;
        ((aa) inflate).m0a(m1664a(i), 0);
        return inflate;
    }

    public void notifyDataSetChanged() {
        m1665a();
        super.notifyDataSetChanged();
    }
}
