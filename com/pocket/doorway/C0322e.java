package com.pocket.doorway;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.RectF;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.Toast;
import com.pocket.doorway.input.C0331d;
import com.pocket.doorway.p019b.C0318g;
import com.pocket.doorway.p020a.C0311b;
import com.pocket.doorway.target.C0340a;
import com.pocket.doorway.target.TargetView;
import com.pocket.doorway.vortex.C0347e;
import com.pocket.doorway.vortex.VortexView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* renamed from: com.pocket.doorway.e */
public class C0322e {
    private final List f1534a;
    private final RectF f1535b;
    private final C0325h f1536c;
    private final C0327i f1537d;
    private final SparseArray f1538e;
    private final List f1539f;
    private final Context f1540g;
    private final C0335j f1541h;
    private final BoundsView f1542i;
    private C0347e f1543j;
    private C0340a f1544k;
    private ValueAnimator f1545l;
    private long f1546m;
    private int f1547n;
    private boolean f1548o;

    public C0322e(ViewGroup viewGroup, C0335j c0335j, Bundle bundle) {
        this.f1534a = new ArrayList();
        this.f1535b = new RectF();
        this.f1536c = new C0325h();
        this.f1537d = new C0327i();
        this.f1538e = new SparseArray();
        this.f1539f = new ArrayList();
        this.f1540g = viewGroup.getContext();
        this.f1541h = c0335j;
        this.f1542i = (BoundsView) LayoutInflater.from(this.f1540g).inflate(R.layout.view_game, viewGroup, false);
        this.f1542i.setBoundsListener(this.f1536c);
        m2342a((VortexView) this.f1542i.findViewById(R.id.vortex_red), 0.0f, 1.0f);
        m2342a((VortexView) this.f1542i.findViewById(R.id.vortex_green), 1.0f, 0.0f);
        m2342a((VortexView) this.f1542i.findViewById(R.id.vortex_gold), 1.0f, 1.0f);
        m2342a((VortexView) this.f1542i.findViewById(R.id.vortex_blue), 0.0f, 0.0f);
        this.f1539f.add(new C0340a((TargetView) this.f1542i.findViewById(R.id.target_red)));
        this.f1539f.add(new C0340a((TargetView) this.f1542i.findViewById(R.id.target_green)));
        this.f1539f.add(new C0340a((TargetView) this.f1542i.findViewById(R.id.target_gold)));
        this.f1539f.add(new C0340a((TargetView) this.f1542i.findViewById(R.id.target_blue)));
        C0322e.m2345b(this.f1539f);
        C0322e.m2343a(this.f1539f);
        this.f1534a.addAll(this.f1539f);
        this.f1534a.add(new C0331d(this.f1537d));
        if (null != null) {
            for (C0308m a : this.f1534a) {
                a.m2315a(null);
            }
        }
    }

    private C0340a m2339a(float f, float f2) {
        for (C0340a c0340a : this.f1539f) {
            if (c0340a.m2407b(f, f2)) {
                return c0340a;
            }
        }
        return null;
    }

    private void m2342a(VortexView vortexView, float f, float f2) {
        C0347e c0347e = new C0347e(vortexView, f, f2);
        this.f1538e.put(c0347e.m2444f(), c0347e);
        this.f1534a.add(c0347e);
    }

    private static void m2343a(List list) {
        for (C0340a k : list) {
            k.m2416k();
        }
    }

    private void m2344a(boolean z, String str) {
        this.f1548o = true;
        if (z) {
            this.f1541h.m2385a();
        } else {
            this.f1541h.m2386a(str);
        }
    }

    private static void m2345b(List list) {
        Collections.sort(list, new C0324g());
    }

    private void m2348e() {
        if (this.f1545l != null && !this.f1535b.isEmpty()) {
            m2349f();
            m2350g();
            m2351h();
        }
    }

    private void m2349f() {
        long nanoTime = System.nanoTime();
        long j = nanoTime - this.f1546m;
        this.f1546m = nanoTime;
        double d = ((double) j) / 1.0E9d;
        for (C0308m a : this.f1534a) {
            a.m2314a(d, this.f1535b);
        }
    }

    private void m2350g() {
        if (this.f1537d.f1554d) {
            C0347e c0347e = (C0347e) this.f1538e.get(this.f1537d.f1552b);
            if (!c0347e.m2452n()) {
                c0347e = null;
            }
            if (c0347e == null || c0347e != this.f1543j) {
                m2353j();
            }
            this.f1543j = c0347e;
            if (this.f1543j != null) {
                float f = this.f1537d.f1551a.x;
                float f2 = this.f1537d.f1551a.y;
                if (!(this.f1544k == null || this.f1544k.m2407b(f, f2))) {
                    m2352i();
                }
                if (this.f1544k == null) {
                    this.f1544k = m2339a(f, f2);
                }
                if (this.f1544k != null) {
                    this.f1544k.m2402a(f, f2);
                    this.f1544k.m2404a(true);
                }
                this.f1543j.m2438a(f, f2, this.f1544k != null);
            } else {
                m2352i();
            }
        } else {
            m2352i();
            m2353j();
        }
        m2349f();
    }

    private void m2351h() {
        if (this.f1543j != null && this.f1544k != null && this.f1543j.m2450l()) {
            this.f1544k.m2406b(true);
            if (this.f1544k.m2415j() == this.f1543j.m2444f()) {
                this.f1543j.m2442d();
                C0318g.m2337a(200);
                this.f1547n++;
                if (this.f1547n >= this.f1539f.size()) {
                    m2344a(true, null);
                    return;
                } else {
                    Toast.makeText(this.f1540g, "FAB Captured!", 0).show();
                    return;
                }
            }
            C0311b.m2329a("Frequency mismatch!! DANGER! Catastrophic vortex failure!");
            this.f1543j.m2443e();
            C0318g.m2337a(1000);
            m2344a(false, "Catastrophic vortex failure! FABs must be captured by a vortex of the same color.");
        }
    }

    private void m2352i() {
        if (this.f1544k != null) {
            this.f1544k.m2404a(false);
            this.f1544k.m2416k();
            this.f1544k = null;
        }
    }

    private void m2353j() {
        if (this.f1543j != null) {
            this.f1543j.m2441c();
            this.f1543j = null;
        }
    }

    public View m2354a() {
        return this.f1542i;
    }

    public void m2355b() {
        if (this.f1545l == null) {
            this.f1545l = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
            this.f1545l.setDuration(10000);
            this.f1545l.setInterpolator(new LinearInterpolator());
            this.f1545l.setRepeatCount(-1);
            this.f1545l.setRepeatMode(1);
            this.f1545l.addUpdateListener(new C0323f(this));
            this.f1546m = System.nanoTime();
            for (C0308m b : this.f1534a) {
                b.m2316b();
            }
            this.f1545l.start();
        }
    }

    public void m2356c() {
        if (this.f1545l != null) {
            this.f1545l.cancel();
            this.f1545l = null;
            for (C0308m a : this.f1534a) {
                a.m2313a();
            }
        }
    }

    public void m2357d() {
        m2356c();
    }
}
