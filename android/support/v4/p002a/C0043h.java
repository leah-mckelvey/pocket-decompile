package android.support.v4.p002a;

import android.view.View;
import android.view.ViewTreeObserver.OnPreDrawListener;

/* renamed from: android.support.v4.a.h */
class C0043h implements OnPreDrawListener {
    final /* synthetic */ View f185a;
    final /* synthetic */ C0045j f186b;
    final /* synthetic */ int f187c;
    final /* synthetic */ Object f188d;
    final /* synthetic */ C0040e f189e;

    C0043h(C0040e c0040e, View view, C0045j c0045j, int i, Object obj) {
        this.f189e = c0040e;
        this.f185a = view;
        this.f186b = c0045j;
        this.f187c = i;
        this.f188d = obj;
    }

    public boolean onPreDraw() {
        this.f185a.getViewTreeObserver().removeOnPreDrawListener(this);
        this.f189e.m278a(this.f186b, this.f187c, this.f188d);
        return true;
    }
}
