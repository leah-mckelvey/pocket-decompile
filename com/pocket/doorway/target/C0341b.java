package com.pocket.doorway.target;

import android.os.Bundle;

/* renamed from: com.pocket.doorway.target.b */
class C0341b {
    public static Bundle m2417a(C0340a c0340a) {
        Bundle bundle = new Bundle();
        bundle.putFloat("x", c0340a.m2408c());
        bundle.putFloat("y", c0340a.m2409d());
        bundle.putFloat("vx", c0340a.m2410e());
        bundle.putFloat("vx", c0340a.m2411f());
        bundle.putFloat("r", c0340a.m2412g());
        return bundle;
    }

    public static void m2418a(C0340a c0340a, Bundle bundle) {
        if (bundle == null) {
            c0340a.f1576c.set(bundle.getFloat("x"), bundle.getFloat("y"));
            c0340a.f1578e = bundle.getFloat("vx");
            c0340a.f1579f = bundle.getFloat("vy");
            c0340a.f1580g = bundle.getFloat("r");
        }
    }
}
