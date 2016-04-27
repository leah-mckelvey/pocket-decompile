package android.support.v7.internal.widget;

import android.support.v7.p011a.C0175d;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

class ar extends BaseAdapter {
    final /* synthetic */ ap f1096a;

    private ar(ap apVar) {
        this.f1096a = apVar;
    }

    public int getCount() {
        return this.f1096a.f1089e.getChildCount();
    }

    public Object getItem(int i) {
        return ((at) this.f1096a.f1089e.getChildAt(i)).m1893b();
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            return this.f1096a.m1882a((C0175d) getItem(i), true);
        }
        ((at) view).m1892a((C0175d) getItem(i));
        return view;
    }
}
