package android.support.v4.p000h;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.LayoutInflater.Factory;
import android.view.LayoutInflater.Factory2;
import java.lang.reflect.Field;

/* renamed from: android.support.v4.h.p */
class C0133p {
    private static Field f423a;
    private static boolean f424b;

    static void m955a(LayoutInflater layoutInflater, C0058s c0058s) {
        Factory2 c0134q = c0058s != null ? new C0134q(c0058s) : null;
        layoutInflater.setFactory2(c0134q);
        Factory factory = layoutInflater.getFactory();
        if (factory instanceof Factory2) {
            C0133p.m956a(layoutInflater, (Factory2) factory);
        } else {
            C0133p.m956a(layoutInflater, c0134q);
        }
    }

    static void m956a(LayoutInflater layoutInflater, Factory2 factory2) {
        if (!f424b) {
            try {
                f423a = LayoutInflater.class.getDeclaredField("mFactory2");
                f423a.setAccessible(true);
            } catch (Throwable e) {
                Log.e("LayoutInflaterCompatHC", "forceSetFactory2 Could not find field 'mFactory2' on class " + LayoutInflater.class.getName() + "; inflation may have unexpected results.", e);
            }
            f424b = true;
        }
        if (f423a != null) {
            try {
                f423a.set(layoutInflater, factory2);
            } catch (Throwable e2) {
                Log.e("LayoutInflaterCompatHC", "forceSetFactory2 could not set the Factory2 on LayoutInflater " + layoutInflater + "; inflation may have unexpected results.", e2);
            }
        }
    }
}
