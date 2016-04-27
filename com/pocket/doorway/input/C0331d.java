package com.pocket.doorway.input;

import android.graphics.PointF;
import android.graphics.RectF;
import android.os.Bundle;
import com.pocket.doorway.C0308m;

/* renamed from: com.pocket.doorway.input.d */
public class C0331d implements C0308m {
    private final C0333f f1562a;
    private final C0334h f1563b;
    private final PointF f1564c;
    private final C0326g f1565d;
    private int f1566e;

    public C0331d(C0326g c0326g) {
        this.f1562a = new C0333f();
        this.f1563b = new C0334h();
        this.f1564c = new PointF(-1.0f, -1.0f);
        this.f1566e = -1;
        this.f1565d = c0326g;
    }

    private void m2376c() {
        this.f1564c.set(-1.0f, -1.0f);
        this.f1566e = -1;
        this.f1565d.m2360a();
    }

    public Bundle m2378a() {
        TractorBeamTargetingService.m2368a(null);
        return null;
    }

    public void m2379a(double d, RectF rectF) {
    }

    public void m2380a(Bundle bundle) {
    }

    public void m2381b() {
        TractorBeamTargetingService.m2368a(this.f1562a);
    }
}
