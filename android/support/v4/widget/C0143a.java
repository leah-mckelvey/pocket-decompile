package android.support.v4.widget;

import android.content.res.Resources;
import android.os.SystemClock;
import android.support.v4.p000h.ag;
import android.support.v4.p000h.au;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Interpolator;
import com.pocket.doorway.C0339o;

/* renamed from: android.support.v4.widget.a */
public abstract class C0143a implements OnTouchListener {
    private static final int f427r;
    private final C0147c f428a;
    private final Interpolator f429b;
    private final View f430c;
    private Runnable f431d;
    private float[] f432e;
    private float[] f433f;
    private int f434g;
    private int f435h;
    private float[] f436i;
    private float[] f437j;
    private float[] f438k;
    private boolean f439l;
    private boolean f440m;
    private boolean f441n;
    private boolean f442o;
    private boolean f443p;
    private boolean f444q;

    static {
        f427r = ViewConfiguration.getTapTimeout();
    }

    public C0143a(View view) {
        this.f428a = new C0147c();
        this.f429b = new AccelerateInterpolator();
        this.f432e = new float[]{0.0f, 0.0f};
        this.f433f = new float[]{Float.MAX_VALUE, Float.MAX_VALUE};
        this.f436i = new float[]{0.0f, 0.0f};
        this.f437j = new float[]{0.0f, 0.0f};
        this.f438k = new float[]{Float.MAX_VALUE, Float.MAX_VALUE};
        this.f430c = view;
        DisplayMetrics displayMetrics = Resources.getSystem().getDisplayMetrics();
        int i = (int) ((1575.0f * displayMetrics.density) + 0.5f);
        int i2 = (int) ((displayMetrics.density * 315.0f) + 0.5f);
        m1003a((float) i, (float) i);
        m1007b((float) i2, (float) i2);
        m1004a(1);
        m1013e(Float.MAX_VALUE, Float.MAX_VALUE);
        m1011d(0.2f, 0.2f);
        m1009c(1.0f, 1.0f);
        m1008b(f427r);
        m1010c(500);
        m1012d(500);
    }

    private float m983a(float f, float f2, float f3, float f4) {
        float f5;
        float b = C0143a.m989b(f * f2, 0.0f, f3);
        b = m1000f(f2 - f4, b) - m1000f(f4, b);
        if (b < 0.0f) {
            f5 = -this.f429b.getInterpolation(-b);
        } else if (b <= 0.0f) {
            return 0.0f;
        } else {
            f5 = this.f429b.getInterpolation(b);
        }
        return C0143a.m989b(f5, -1.0f, 1.0f);
    }

    private float m984a(int i, float f, float f2, float f3) {
        float a = m983a(this.f432e[i], f2, this.f433f[i], f);
        if (a == 0.0f) {
            return 0.0f;
        }
        float f4 = this.f436i[i];
        float f5 = this.f437j[i];
        float f6 = this.f438k[i];
        f4 *= f3;
        return a > 0.0f ? C0143a.m989b(a * f4, f5, f6) : -C0143a.m989b((-a) * f4, f5, f6);
    }

    private boolean m986a() {
        C0147c c0147c = this.f428a;
        int f = c0147c.m1064f();
        int e = c0147c.m1063e();
        return (f != 0 && m1015f(f)) || (e != 0 && m1014e(e));
    }

    private static float m989b(float f, float f2, float f3) {
        return f > f3 ? f3 : f < f2 ? f2 : f;
    }

    private static int m990b(int i, int i2, int i3) {
        return i > i3 ? i3 : i < i2 ? i2 : i;
    }

    private void m991b() {
        if (this.f431d == null) {
            this.f431d = new C0148d();
        }
        this.f442o = true;
        this.f440m = true;
        if (this.f439l || this.f435h <= 0) {
            this.f431d.run();
        } else {
            au.m690a(this.f430c, this.f431d, (long) this.f435h);
        }
        this.f439l = true;
    }

    private void m995c() {
        if (this.f440m) {
            this.f442o = false;
        } else {
            this.f428a.m1059b();
        }
    }

    private void m997d() {
        long uptimeMillis = SystemClock.uptimeMillis();
        MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
        this.f430c.onTouchEvent(obtain);
        obtain.recycle();
    }

    private float m1000f(float f, float f2) {
        if (f2 == 0.0f) {
            return 0.0f;
        }
        switch (this.f434g) {
            case C0339o.View_android_theme /*0*/:
            case C0339o.View_android_focusable /*1*/:
                return f < f2 ? f >= 0.0f ? 1.0f - (f / f2) : (this.f442o && this.f434g == 1) ? 1.0f : 0.0f : 0.0f;
            case C0339o.View_paddingStart /*2*/:
                return f < 0.0f ? f / (-f2) : 0.0f;
            default:
                return 0.0f;
        }
    }

    public C0143a m1003a(float f, float f2) {
        this.f438k[0] = f / 1000.0f;
        this.f438k[1] = f2 / 1000.0f;
        return this;
    }

    public C0143a m1004a(int i) {
        this.f434g = i;
        return this;
    }

    public C0143a m1005a(boolean z) {
        if (this.f443p && !z) {
            m995c();
        }
        this.f443p = z;
        return this;
    }

    public abstract void m1006a(int i, int i2);

    public C0143a m1007b(float f, float f2) {
        this.f437j[0] = f / 1000.0f;
        this.f437j[1] = f2 / 1000.0f;
        return this;
    }

    public C0143a m1008b(int i) {
        this.f435h = i;
        return this;
    }

    public C0143a m1009c(float f, float f2) {
        this.f436i[0] = f / 1000.0f;
        this.f436i[1] = f2 / 1000.0f;
        return this;
    }

    public C0143a m1010c(int i) {
        this.f428a.m1058a(i);
        return this;
    }

    public C0143a m1011d(float f, float f2) {
        this.f432e[0] = f;
        this.f432e[1] = f2;
        return this;
    }

    public C0143a m1012d(int i) {
        this.f428a.m1060b(i);
        return this;
    }

    public C0143a m1013e(float f, float f2) {
        this.f433f[0] = f;
        this.f433f[1] = f2;
        return this;
    }

    public abstract boolean m1014e(int i);

    public abstract boolean m1015f(int i);

    public boolean onTouch(View view, MotionEvent motionEvent) {
        boolean z = true;
        if (!this.f443p) {
            return false;
        }
        switch (ag.m640a(motionEvent)) {
            case C0339o.View_android_theme /*0*/:
                this.f441n = true;
                this.f439l = false;
                break;
            case C0339o.View_android_focusable /*1*/:
            case C0339o.View_paddingEnd /*3*/:
                m995c();
                break;
            case C0339o.View_paddingStart /*2*/:
                break;
        }
        this.f428a.m1057a(m984a(0, motionEvent.getX(), (float) view.getWidth(), (float) this.f430c.getWidth()), m984a(1, motionEvent.getY(), (float) view.getHeight(), (float) this.f430c.getHeight()));
        if (!this.f442o && m986a()) {
            m991b();
        }
        if (!(this.f444q && this.f442o)) {
            z = false;
        }
        return z;
    }
}
