package android.support.v4.p002a;

import android.app.Activity;
import android.os.Build.VERSION;
import android.support.v4.p001b.C0034a;

/* renamed from: android.support.v4.a.a */
public class C0035a extends C0034a {
    public static void m181a(Activity activity) {
        if (VERSION.SDK_INT >= 16) {
            C0039d.m266a(activity);
        } else {
            activity.finish();
        }
    }

    public static void m182b(Activity activity) {
        if (VERSION.SDK_INT >= 21) {
            C0037b.m264a(activity);
        } else {
            activity.finish();
        }
    }
}
