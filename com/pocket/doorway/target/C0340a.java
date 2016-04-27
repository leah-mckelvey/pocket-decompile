package com.pocket.doorway.target;

import android.graphics.PointF;
import android.graphics.RectF;
import android.os.Bundle;
import android.view.ViewGroup;
import com.pocket.doorway.C0308m;
import com.pocket.doorway.p019b.C0313a;
import com.pocket.doorway.p019b.C0315d;
import java.util.Random;

/* renamed from: com.pocket.doorway.target.a */
public class C0340a implements C0308m {
    public static final float f1574a;
    private static final Random f1575b;
    private final PointF f1576c;
    private final TargetView f1577d;
    private float f1578e;
    private float f1579f;
    private float f1580g;
    private boolean f1581h;
    private boolean f1582i;

    static {
        f1575b = new Random();
        f1574a = C0313a.m2331a(280.0f);
    }

    public C0340a(TargetView targetView) {
        this.f1576c = new PointF();
        this.f1580g = (float) C0313a.m2333b(28.0f);
        this.f1577d = targetView;
    }

    private void m2394a(double d) {
        m2402a((float) (((double) this.f1576c.x) + (((double) this.f1578e) * d)), (float) (((double) this.f1576c.y) + (((double) this.f1579f) * d)));
    }

    private void m2395a(RectF rectF) {
        float g = m2412g();
        float c = m2408c();
        float d = m2409d();
        float e = m2410e();
        float f = m2411f();
        Object obj;
        do {
            float f2;
            Object obj2;
            float f3 = rectF.left - (c - g);
            if (f3 > 0.0f) {
                f2 = c + (f3 * 2.0f);
                c = e * -1.0f;
                obj2 = 1;
            } else {
                f2 = c;
                c = e;
                obj2 = null;
            }
            f3 = rectF.top - (d - g);
            if (f3 > 0.0f) {
                d += f3 * 2.0f;
                f *= -1.0f;
                obj2 = 1;
            }
            f3 = (f2 + g) - rectF.right;
            if (f3 > 0.0f) {
                e = c * -1.0f;
                c = f2 - (f3 * 2.0f);
                obj = 1;
            } else {
                Object obj3 = obj2;
                e = c;
                c = f2;
                obj = obj3;
            }
            f3 = (d + g) - rectF.bottom;
            if (f3 > 0.0f) {
                d -= f3 * 2.0f;
                f *= -1.0f;
                obj = 1;
                continue;
            }
        } while (obj != null);
        m2402a(c, d);
        m2398c(e, f);
    }

    private void m2398c(float f, float f2) {
        this.f1578e = f;
        this.f1579f = f2;
    }

    private void m2399l() {
        this.f1577d.m2391a(this);
    }

    public Bundle m2400a() {
        return C0341b.m2417a(this);
    }

    public void m2401a(double d, RectF rectF) {
        if (!this.f1582i && !this.f1581h) {
            m2394a(d);
            m2395a(rectF);
        }
    }

    public void m2402a(float f, float f2) {
        this.f1576c.set(f, f2);
        m2399l();
    }

    public void m2403a(Bundle bundle) {
        C0341b.m2418a(this, bundle);
    }

    public void m2404a(boolean z) {
        this.f1581h = z;
    }

    public void m2405b() {
    }

    public void m2406b(boolean z) {
        this.f1582i = z;
        m2399l();
    }

    public boolean m2407b(float f, float f2) {
        return Math.abs(C0315d.m2334a(f, f2, m2408c(), m2409d())) <= m2412g();
    }

    public float m2408c() {
        return this.f1576c.x;
    }

    public float m2409d() {
        return this.f1576c.y;
    }

    public float m2410e() {
        return this.f1578e;
    }

    public float m2411f() {
        return this.f1579f;
    }

    public float m2412g() {
        return this.f1580g;
    }

    public boolean m2413h() {
        return this.f1582i;
    }

    public int m2414i() {
        ViewGroup viewGroup = (ViewGroup) this.f1577d.getParent();
        return viewGroup == null ? -1 : viewGroup.indexOfChild(this.f1577d);
    }

    public int m2415j() {
        return this.f1577d.getColor();
    }

    public void m2416k() {
        float nextFloat = f1575b.nextFloat() * 360.0f;
        m2398c((float) (((double) f1574a) * Math.cos((double) nextFloat)), (float) (((double) f1574a) * Math.sin((double) nextFloat)));
    }
}
