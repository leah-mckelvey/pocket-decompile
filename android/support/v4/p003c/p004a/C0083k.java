package android.support.v4.p003c.p004a;

import android.graphics.drawable.Drawable;

/* renamed from: android.support.v4.c.a.k */
class C0083k {
    public static void m512a(Drawable drawable, boolean z) {
        drawable.setAutoMirrored(z);
    }

    public static boolean m513a(Drawable drawable) {
        return drawable.isAutoMirrored();
    }

    public static Drawable m514b(Drawable drawable) {
        return !(drawable instanceof C0088p) ? new C0088p(drawable) : drawable;
    }
}
