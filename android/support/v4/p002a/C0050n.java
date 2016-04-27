package android.support.v4.p002a;

import android.view.View;

/* renamed from: android.support.v4.a.n */
class C0050n implements C0049t {
    final /* synthetic */ C0048m f267a;

    C0050n(C0048m c0048m) {
        this.f267a = c0048m;
    }

    public View m372a(int i) {
        if (this.f267a.f225J != null) {
            return this.f267a.f225J.findViewById(i);
        }
        throw new IllegalStateException("Fragment does not have a view");
    }

    public boolean m373a() {
        return this.f267a.f225J != null;
    }
}
