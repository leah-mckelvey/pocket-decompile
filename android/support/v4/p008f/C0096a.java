package android.support.v4.p008f;

import android.os.Build.VERSION;

/* renamed from: android.support.v4.f.a */
public class C0096a {
    private static final C0097b f337a;

    static {
        if (VERSION.SDK_INT >= 14) {
            f337a = new C0099d();
        } else {
            f337a = new C0098c();
        }
    }

    public static String m535a(String str) {
        return f337a.m537a(str);
    }

    public static String m536b(String str) {
        return f337a.m538b(str);
    }
}
