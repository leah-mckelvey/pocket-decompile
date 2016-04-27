package android.support.v4.widget;

import android.view.animation.AnimationUtils;

/* renamed from: android.support.v4.widget.c */
class C0147c {
    private int f469a;
    private int f470b;
    private float f471c;
    private float f472d;
    private long f473e;
    private long f474f;
    private int f475g;
    private int f476h;
    private long f477i;
    private float f478j;
    private int f479k;

    public C0147c() {
        this.f473e = Long.MIN_VALUE;
        this.f477i = -1;
        this.f474f = 0;
        this.f475g = 0;
        this.f476h = 0;
    }

    private float m1054a(float f) {
        return ((-4.0f * f) * f) + (4.0f * f);
    }

    private float m1055a(long j) {
        if (j < this.f473e) {
            return 0.0f;
        }
        if (this.f477i < 0 || j < this.f477i) {
            return C0143a.m989b(((float) (j - this.f473e)) / ((float) this.f469a), 0.0f, 1.0f) * 0.5f;
        }
        long j2 = j - this.f477i;
        return (C0143a.m989b(((float) j2) / ((float) this.f479k), 0.0f, 1.0f) * this.f478j) + (1.0f - this.f478j);
    }

    public void m1056a() {
        this.f473e = AnimationUtils.currentAnimationTimeMillis();
        this.f477i = -1;
        this.f474f = this.f473e;
        this.f478j = 0.5f;
        this.f475g = 0;
        this.f476h = 0;
    }

    public void m1057a(float f, float f2) {
        this.f471c = f;
        this.f472d = f2;
    }

    public void m1058a(int i) {
        this.f469a = i;
    }

    public void m1059b() {
        long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        this.f479k = C0143a.m990b((int) (currentAnimationTimeMillis - this.f473e), 0, this.f470b);
        this.f478j = m1055a(currentAnimationTimeMillis);
        this.f477i = currentAnimationTimeMillis;
    }

    public void m1060b(int i) {
        this.f470b = i;
    }

    public boolean m1061c() {
        return this.f477i > 0 && AnimationUtils.currentAnimationTimeMillis() > this.f477i + ((long) this.f479k);
    }

    public void m1062d() {
        if (this.f474f == 0) {
            throw new RuntimeException("Cannot compute scroll delta before calling start()");
        }
        long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        float a = m1054a(m1055a(currentAnimationTimeMillis));
        long j = currentAnimationTimeMillis - this.f474f;
        this.f474f = currentAnimationTimeMillis;
        this.f475g = (int) ((((float) j) * a) * this.f471c);
        this.f476h = (int) ((((float) j) * a) * this.f472d);
    }

    public int m1063e() {
        return (int) (this.f471c / Math.abs(this.f471c));
    }

    public int m1064f() {
        return (int) (this.f472d / Math.abs(this.f472d));
    }

    public int m1065g() {
        return this.f475g;
    }

    public int m1066h() {
        return this.f476h;
    }
}
