package android.support.v4.p000h;

import android.view.View;
import java.lang.reflect.Field;

/* renamed from: android.support.v4.h.bf */
class bf {
    private static Field f398a;
    private static boolean f399b;

    static boolean m813a(View view) {
        return view.getWidth() > 0 && view.getHeight() > 0;
    }

    static int m814b(View view) {
        if (!f399b) {
            try {
                f398a = View.class.getDeclaredField("mMinHeight");
                f398a.setAccessible(true);
            } catch (NoSuchFieldException e) {
            }
            f399b = true;
        }
        if (f398a != null) {
            try {
                return ((Integer) f398a.get(view)).intValue();
            } catch (Exception e2) {
            }
        }
        return 0;
    }

    static boolean m815c(View view) {
        return view.getWindowToken() != null;
    }
}
