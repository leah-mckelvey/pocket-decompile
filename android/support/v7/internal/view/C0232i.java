package android.support.v7.internal.view;

import android.support.v4.p000h.bt;
import android.support.v4.p000h.ck;
import android.support.v4.p000h.cl;
import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: android.support.v7.internal.view.i */
public class C0232i {
    private final ArrayList f771a;
    private long f772b;
    private Interpolator f773c;
    private ck f774d;
    private boolean f775e;
    private final cl f776f;

    public C0232i() {
        this.f772b = -1;
        this.f776f = new C0233j(this);
        this.f771a = new ArrayList();
    }

    private void m1506c() {
        this.f775e = false;
    }

    public C0232i m1507a(long j) {
        if (!this.f775e) {
            this.f772b = j;
        }
        return this;
    }

    public C0232i m1508a(bt btVar) {
        if (!this.f775e) {
            this.f771a.add(btVar);
        }
        return this;
    }

    public C0232i m1509a(ck ckVar) {
        if (!this.f775e) {
            this.f774d = ckVar;
        }
        return this;
    }

    public C0232i m1510a(Interpolator interpolator) {
        if (!this.f775e) {
            this.f773c = interpolator;
        }
        return this;
    }

    public void m1511a() {
        if (!this.f775e) {
            Iterator it = this.f771a.iterator();
            while (it.hasNext()) {
                bt btVar = (bt) it.next();
                if (this.f772b >= 0) {
                    btVar.m861a(this.f772b);
                }
                if (this.f773c != null) {
                    btVar.m864a(this.f773c);
                }
                if (this.f774d != null) {
                    btVar.m862a(this.f776f);
                }
                btVar.m868b();
            }
            this.f775e = true;
        }
    }

    public void m1512b() {
        if (this.f775e) {
            Iterator it = this.f771a.iterator();
            while (it.hasNext()) {
                ((bt) it.next()).m865a();
            }
            this.f775e = false;
        }
    }
}
