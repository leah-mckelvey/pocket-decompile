package com.pocket.doorway.p019b;

import android.graphics.RectF;
import android.os.Bundle;
import android.os.Handler;
import com.pocket.doorway.C0308m;

/* renamed from: com.pocket.doorway.b.b */
public abstract class C0309b implements C0308m {
    private final Handler f1515a;
    private final int f1516b;
    private final Runnable f1517c;
    private boolean f1518d;

    public C0309b(int i) {
        this.f1515a = new Handler();
        this.f1516b = i;
        this.f1517c = new C0314c(this);
    }

    public Bundle m2321a() {
        this.f1518d = false;
        this.f1515a.removeCallbacks(this.f1517c);
        return null;
    }

    public void m2322a(double d, RectF rectF) {
    }

    public void m2323a(Bundle bundle) {
    }

    public void m2324b() {
        if (!this.f1518d) {
            this.f1518d = true;
            this.f1517c.run();
        }
    }

    public abstract void m2325c();
}
