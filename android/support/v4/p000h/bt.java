package android.support.v4.p000h;

import android.os.Build.VERSION;
import android.view.View;
import android.view.animation.Interpolator;
import java.lang.ref.WeakReference;

/* renamed from: android.support.v4.h.bt */
public class bt {
    static final cd f402a;
    private WeakReference f403b;
    private Runnable f404c;
    private Runnable f405d;
    private int f406e;

    static {
        int i = VERSION.SDK_INT;
        if (i >= 21) {
            f402a = new cc();
        } else if (i >= 19) {
            f402a = new cb();
        } else if (i >= 18) {
            f402a = new bz();
        } else if (i >= 16) {
            f402a = new ca();
        } else if (i >= 14) {
            f402a = new bx();
        } else {
            f402a = new bv();
        }
    }

    bt(View view) {
        this.f404c = null;
        this.f405d = null;
        this.f406e = -1;
        this.f403b = new WeakReference(view);
    }

    public bt m860a(float f) {
        View view = (View) this.f403b.get();
        if (view != null) {
            f402a.m872a(this, view, f);
        }
        return this;
    }

    public bt m861a(long j) {
        View view = (View) this.f403b.get();
        if (view != null) {
            f402a.m873a(this, view, j);
        }
        return this;
    }

    public bt m862a(ck ckVar) {
        View view = (View) this.f403b.get();
        if (view != null) {
            f402a.m874a(this, view, ckVar);
        }
        return this;
    }

    public bt m863a(cm cmVar) {
        View view = (View) this.f403b.get();
        if (view != null) {
            f402a.m875a(this, view, cmVar);
        }
        return this;
    }

    public bt m864a(Interpolator interpolator) {
        View view = (View) this.f403b.get();
        if (view != null) {
            f402a.m876a(this, view, interpolator);
        }
        return this;
    }

    public void m865a() {
        View view = (View) this.f403b.get();
        if (view != null) {
            f402a.m871a(this, view);
        }
    }

    public bt m866b(float f) {
        View view = (View) this.f403b.get();
        if (view != null) {
            f402a.m878b(this, view, f);
        }
        return this;
    }

    public bt m867b(long j) {
        View view = (View) this.f403b.get();
        if (view != null) {
            f402a.m879b(this, view, j);
        }
        return this;
    }

    public void m868b() {
        View view = (View) this.f403b.get();
        if (view != null) {
            f402a.m877b(this, view);
        }
    }

    public bt m869c(float f) {
        View view = (View) this.f403b.get();
        if (view != null) {
            f402a.m880c(this, view, f);
        }
        return this;
    }

    public bt m870d(float f) {
        View view = (View) this.f403b.get();
        if (view != null) {
            f402a.m881d(this, view, f);
        }
        return this;
    }
}
