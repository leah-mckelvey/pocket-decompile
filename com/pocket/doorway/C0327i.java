package com.pocket.doorway;

import android.graphics.PointF;
import com.pocket.doorway.input.C0326g;
import com.pocket.doorway.p019b.C0318g;

/* renamed from: com.pocket.doorway.i */
class C0327i implements C0326g {
    public final PointF f1551a;
    public int f1552b;
    public float f1553c;
    public boolean f1554d;
    final /* synthetic */ C0322e f1555e;

    private C0327i(C0322e c0322e) {
        this.f1555e = c0322e;
        this.f1551a = new PointF();
    }

    public void m2363a() {
        this.f1554d = false;
        this.f1555e.m2348e();
    }

    public void m2364a(float f, float f2, int i, float f3) {
        if (!this.f1555e.f1548o) {
            this.f1551a.set(f, f2);
            this.f1553c = f3;
            this.f1552b = i;
            this.f1554d = true;
            this.f1555e.m2348e();
        }
    }

    public void m2365b() {
        if (!this.f1555e.f1548o) {
            C0318g.m2337a(1000);
            this.f1555e.m2344a(false, "Vortex overloaded! Vortexes can only receive 60 commands per second.");
        }
    }
}
