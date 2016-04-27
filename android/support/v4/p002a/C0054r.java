package android.support.v4.p002a;

import android.view.View;
import android.view.Window;

/* renamed from: android.support.v4.a.r */
class C0054r implements C0049t {
    final /* synthetic */ C0052p f282a;

    C0054r(C0052p c0052p) {
        this.f282a = c0052p;
    }

    public View m385a(int i) {
        return this.f282a.findViewById(i);
    }

    public boolean m386a() {
        Window window = this.f282a.getWindow();
        return (window == null || window.peekDecorView() == null) ? false : true;
    }
}
