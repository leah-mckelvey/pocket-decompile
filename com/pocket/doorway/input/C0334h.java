package com.pocket.doorway.input;

import android.os.Handler;

/* renamed from: com.pocket.doorway.input.h */
class C0334h implements Runnable {
    final /* synthetic */ C0331d f1568a;
    private final Handler f1569b;

    private C0334h(C0331d c0331d) {
        this.f1568a = c0331d;
        this.f1569b = new Handler();
    }

    public void m2384a() {
        this.f1569b.removeCallbacks(this);
        this.f1569b.postDelayed(this, 50);
    }

    public void run() {
        this.f1569b.removeCallbacks(this);
        this.f1568a.m2376c();
    }
}
