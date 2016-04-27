package com.pocket.doorway.p019b;

import android.util.DisplayMetrics;
import android.util.TypedValue;
import com.pocket.doorway.App;

/* renamed from: com.pocket.doorway.b.a */
public abstract class C0313a {
    private static DisplayMetrics f1525a;

    public static float m2331a(float f) {
        return TypedValue.applyDimension(1, f, C0313a.m2332a());
    }

    public static DisplayMetrics m2332a() {
        if (f1525a == null) {
            f1525a = App.m2304a().getResources().getDisplayMetrics();
        }
        return f1525a;
    }

    public static int m2333b(float f) {
        return (int) C0313a.m2331a(f);
    }
}
