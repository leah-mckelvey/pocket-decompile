package android.support.v4.p000h;

import android.graphics.Paint;
import android.view.View;
import java.util.WeakHashMap;

/* renamed from: android.support.v4.h.av */
class av implements be {
    WeakHashMap f396a;

    av() {
        this.f396a = null;
    }

    public int m743a(int i, int i2) {
        return i | i2;
    }

    public int m744a(int i, int i2, int i3) {
        return View.resolveSize(i, i2);
    }

    public int m745a(View view) {
        return 0;
    }

    long m746a() {
        return 10;
    }

    public cn m747a(View view, cn cnVar) {
        return cnVar;
    }

    public void m748a(View view, float f) {
    }

    public void m749a(View view, int i, int i2, int i3, int i4) {
        view.setPadding(i, i2, i3, i4);
    }

    public void m750a(View view, int i, Paint paint) {
    }

    public void m751a(View view, ao aoVar) {
    }

    public void m752a(View view, Runnable runnable) {
        view.postDelayed(runnable, m746a());
    }

    public void m753a(View view, Runnable runnable, long j) {
        view.postDelayed(runnable, m746a() + j);
    }

    public void m754a(View view, boolean z) {
    }

    public int m755b(View view) {
        return 0;
    }

    public cn m756b(View view, cn cnVar) {
        return cnVar;
    }

    public void m757b(View view, float f) {
    }

    public void m758b(View view, boolean z) {
    }

    public int m759c(View view) {
        return view.getPaddingLeft();
    }

    public void m760c(View view, float f) {
    }

    public int m761d(View view) {
        return view.getPaddingRight();
    }

    public void m762d(View view, float f) {
    }

    public float m763e(View view) {
        return 0.0f;
    }

    public void m764e(View view, float f) {
    }

    public int m765f(View view) {
        return bf.m814b(view);
    }

    public bt m766g(View view) {
        return new bt(view);
    }

    public int m767h(View view) {
        return 0;
    }

    public void m768i(View view) {
    }

    public float m769j(View view) {
        return 0.0f;
    }

    public float m770k(View view) {
        return 0.0f;
    }

    public boolean m771l(View view) {
        return false;
    }

    public void m772m(View view) {
    }

    public boolean m773n(View view) {
        return false;
    }

    public boolean m774o(View view) {
        return bf.m813a(view);
    }

    public float m775p(View view) {
        return m770k(view) + m769j(view);
    }

    public boolean m776q(View view) {
        return bf.m815c(view);
    }
}
