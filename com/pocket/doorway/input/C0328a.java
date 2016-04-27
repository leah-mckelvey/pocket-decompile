package com.pocket.doorway.input;

import android.os.SystemClock;

/* renamed from: com.pocket.doorway.input.a */
public class C0328a {
    private final long[] f1559a;
    private int f1560b;

    public C0328a(int i) {
        this.f1559a = new long[i];
        this.f1560b = 0;
    }

    public boolean m2369a() {
        long uptimeMillis = SystemClock.uptimeMillis();
        this.f1559a[this.f1560b] = uptimeMillis;
        this.f1560b++;
        if (this.f1560b >= this.f1559a.length) {
            this.f1560b = 0;
        }
        long j = this.f1559a[this.f1560b];
        return j != 0 && uptimeMillis - j <= 1000;
    }
}
