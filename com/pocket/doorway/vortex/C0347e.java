package com.pocket.doorway.vortex;

import android.graphics.PointF;
import android.graphics.RectF;
import android.os.Bundle;
import com.pocket.doorway.C0308m;
import com.pocket.doorway.p019b.C0315d;

/* renamed from: com.pocket.doorway.vortex.e */
public class C0347e implements C0308m {
    private final VortexView f1617a;
    private final PointF f1618b;
    private final PointF f1619c;
    private C0348f f1620d;
    private float f1621e;
    private C0348f f1622f;
    private float f1623g;

    public C0347e(VortexView vortexView, float f, float f2) {
        this.f1618b = new PointF();
        this.f1619c = new PointF();
        this.f1620d = C0348f.NO_TARGET;
        this.f1618b.set(f, f2);
        this.f1617a = vortexView;
    }

    private void m2434a(C0348f c0348f) {
        this.f1620d = c0348f;
        m2435p();
    }

    private void m2435p() {
        this.f1617a.m2422a(this);
    }

    public Bundle m2436a() {
        return null;
    }

    public void m2437a(double d, RectF rectF) {
        if (this.f1620d == C0348f.ATTRACTING_TARGET) {
            this.f1621e = 1.0f - (C0315d.m2334a(this.f1618b.x * rectF.width(), this.f1618b.y * rectF.height(), this.f1619c.x, this.f1619c.y) / Math.max(rectF.width(), rectF.height()));
        } else {
            this.f1621e = 0.15f;
        }
        if (this.f1622f != this.f1620d || this.f1623g != this.f1621e) {
            this.f1622f = this.f1620d;
            this.f1623g = this.f1621e;
            m2435p();
        }
    }

    public void m2438a(float f, float f2, boolean z) {
        if (this.f1620d != C0348f.OVERLOAD && this.f1620d != C0348f.COMPLETED) {
            this.f1619c.set(f, f2);
            m2434a(z ? C0348f.ATTRACTING_TARGET : C0348f.ATTRACTING_NOTHING);
        }
    }

    public void m2439a(Bundle bundle) {
    }

    public void m2440b() {
    }

    public void m2441c() {
        if (this.f1620d != C0348f.OVERLOAD && this.f1620d != C0348f.COMPLETED) {
            m2434a(C0348f.NO_TARGET);
        }
    }

    public void m2442d() {
        if (this.f1620d != C0348f.OVERLOAD) {
            m2434a(C0348f.COMPLETED);
        }
    }

    public void m2443e() {
        m2434a(C0348f.OVERLOAD);
    }

    public int m2444f() {
        return this.f1617a.getColor();
    }

    public float m2445g() {
        return this.f1618b.x;
    }

    public float m2446h() {
        return this.f1618b.y;
    }

    public float m2447i() {
        return this.f1619c.x;
    }

    public float m2448j() {
        return this.f1619c.y;
    }

    public float m2449k() {
        return this.f1621e;
    }

    public boolean m2450l() {
        return this.f1621e >= 0.9f;
    }

    public boolean m2451m() {
        return this.f1620d == C0348f.ATTRACTING_TARGET || this.f1620d == C0348f.ATTRACTING_NOTHING;
    }

    public boolean m2452n() {
        return this.f1620d == C0348f.NO_TARGET || this.f1620d == C0348f.ATTRACTING_NOTHING || this.f1620d == C0348f.ATTRACTING_TARGET;
    }

    public float m2453o() {
        return this.f1620d.f1630f;
    }
}
