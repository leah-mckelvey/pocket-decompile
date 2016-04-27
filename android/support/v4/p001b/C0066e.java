package android.support.v4.p001b;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Build.VERSION;

/* renamed from: android.support.v4.b.e */
public class C0066e {
    private static final C0067f f321a;

    static {
        int i = VERSION.SDK_INT;
        if (i >= 15) {
            f321a = new C0070i();
        } else if (i >= 11) {
            f321a = new C0069h();
        } else {
            f321a = new C0068g();
        }
    }

    public static Intent m451a(ComponentName componentName) {
        return f321a.m452a(componentName);
    }
}
