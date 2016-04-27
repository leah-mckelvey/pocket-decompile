package android.support.v4.p000h;

import android.view.WindowInsets;

/* renamed from: android.support.v4.h.co */
class co extends cn {
    private final WindowInsets f419a;

    co(WindowInsets windowInsets) {
        this.f419a = windowInsets;
    }

    public int m932a() {
        return this.f419a.getSystemWindowInsetLeft();
    }

    public cn m933a(int i, int i2, int i3, int i4) {
        return new co(this.f419a.replaceSystemWindowInsets(i, i2, i3, i4));
    }

    public int m934b() {
        return this.f419a.getSystemWindowInsetTop();
    }

    public int m935c() {
        return this.f419a.getSystemWindowInsetRight();
    }

    public int m936d() {
        return this.f419a.getSystemWindowInsetBottom();
    }

    public boolean m937e() {
        return this.f419a.isConsumed();
    }

    WindowInsets m938f() {
        return this.f419a;
    }
}
