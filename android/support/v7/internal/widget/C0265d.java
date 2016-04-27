package android.support.v7.internal.widget;

import android.util.SparseArray;
import android.view.View;

/* renamed from: android.support.v7.internal.widget.d */
class C0265d {
    final /* synthetic */ C0262c f1254a;
    private final SparseArray f1255b;

    C0265d(C0262c c0262c) {
        this.f1254a = c0262c;
        this.f1255b = new SparseArray();
    }

    View m2071a(int i) {
        View view = (View) this.f1255b.get(i);
        if (view != null) {
            this.f1255b.delete(i);
        }
        return view;
    }

    void m2072a() {
        SparseArray sparseArray = this.f1255b;
        int size = sparseArray.size();
        for (int i = 0; i < size; i++) {
            View view = (View) sparseArray.valueAt(i);
            if (view != null) {
                this.f1254a.removeDetachedView(view, true);
            }
        }
        sparseArray.clear();
    }

    public void m2073a(int i, View view) {
        this.f1255b.put(i, view);
    }
}
