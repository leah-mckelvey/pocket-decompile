package android.support.v4.p003c.p004a;

import android.graphics.drawable.Drawable;

/* renamed from: android.support.v4.c.a.j */
class C0082j {
    public static void m510a(Drawable drawable) {
        drawable.jumpToCurrentState();
    }

    public static Drawable m511b(Drawable drawable) {
        return !(drawable instanceof C0087o) ? new C0087o(drawable) : drawable;
    }
}
