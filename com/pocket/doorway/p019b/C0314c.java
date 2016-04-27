package com.pocket.doorway.p019b;

/* renamed from: com.pocket.doorway.b.c */
class C0314c implements Runnable {
    final /* synthetic */ C0309b f1526a;

    C0314c(C0309b c0309b) {
        this.f1526a = c0309b;
    }

    public void run() {
        if (this.f1526a.f1518d) {
            this.f1526a.m2325c();
            this.f1526a.f1515a.removeCallbacks(this.f1526a.f1517c);
            this.f1526a.f1515a.postDelayed(this.f1526a.f1517c, (long) this.f1526a.f1516b);
        }
    }
}
