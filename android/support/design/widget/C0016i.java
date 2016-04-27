package android.support.design.widget;

import android.support.v4.p000h.au;
import android.view.View;
import java.util.Comparator;

/* renamed from: android.support.design.widget.i */
class C0016i implements Comparator {
    C0016i() {
    }

    public int m104a(View view, View view2) {
        float n = au.m710n(view);
        float n2 = au.m710n(view2);
        return n > n2 ? -1 : n < n2 ? 1 : 0;
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return m104a((View) obj, (View) obj2);
    }
}
