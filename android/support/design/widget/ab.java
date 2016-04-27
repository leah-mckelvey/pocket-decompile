package android.support.design.widget;

import android.support.v4.p000h.au;
import android.view.View;

class ab implements Runnable {
    final /* synthetic */ C0027y f17a;
    private final View f18b;
    private final boolean f19c;

    ab(C0027y c0027y, View view, boolean z) {
        this.f17a = c0027y;
        this.f18b = view;
        this.f19c = z;
    }

    public void run() {
        if (this.f17a.f69a != null && this.f17a.f69a.m1048a(true)) {
            au.m689a(this.f18b, (Runnable) this);
        } else if (this.f19c && this.f17a.f70b != null) {
            this.f17a.f70b.m23a(this.f18b);
        }
    }
}
