package android.support.v4.p000h;

import android.view.View;
import android.view.animation.Interpolator;
import java.util.WeakHashMap;

/* renamed from: android.support.v4.h.bv */
class bv implements cd {
    WeakHashMap f407a;

    bv() {
        this.f407a = null;
    }

    private void m883a(View view) {
        if (this.f407a != null) {
            Runnable runnable = (Runnable) this.f407a.get(view);
            if (runnable != null) {
                view.removeCallbacks(runnable);
            }
        }
    }

    private void m884c(bt btVar, View view) {
        Object tag = view.getTag(2113929216);
        ck ckVar = tag instanceof ck ? (ck) tag : null;
        Runnable a = btVar.f404c;
        Runnable b = btVar.f405d;
        if (a != null) {
            a.run();
        }
        if (ckVar != null) {
            ckVar.m109a(view);
            ckVar.m110b(view);
        }
        if (b != null) {
            b.run();
        }
        if (this.f407a != null) {
            this.f407a.remove(view);
        }
    }

    private void m885d(bt btVar, View view) {
        Runnable runnable = this.f407a != null ? (Runnable) this.f407a.get(view) : null;
        if (runnable == null) {
            runnable = new bw(btVar, view, null);
            if (this.f407a == null) {
                this.f407a = new WeakHashMap();
            }
            this.f407a.put(view, runnable);
        }
        view.removeCallbacks(runnable);
        view.post(runnable);
    }

    public void m886a(bt btVar, View view) {
        m885d(btVar, view);
    }

    public void m887a(bt btVar, View view, float f) {
        m885d(btVar, view);
    }

    public void m888a(bt btVar, View view, long j) {
    }

    public void m889a(bt btVar, View view, ck ckVar) {
        view.setTag(2113929216, ckVar);
    }

    public void m890a(bt btVar, View view, cm cmVar) {
    }

    public void m891a(bt btVar, View view, Interpolator interpolator) {
    }

    public void m892b(bt btVar, View view) {
        m883a(view);
        m884c(btVar, view);
    }

    public void m893b(bt btVar, View view, float f) {
        m885d(btVar, view);
    }

    public void m894b(bt btVar, View view, long j) {
    }

    public void m895c(bt btVar, View view, float f) {
        m885d(btVar, view);
    }

    public void m896d(bt btVar, View view, float f) {
        m885d(btVar, view);
    }
}
