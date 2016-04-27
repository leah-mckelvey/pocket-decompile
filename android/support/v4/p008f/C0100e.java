package android.support.v4.p008f;

import android.util.Log;
import java.lang.reflect.Method;

/* renamed from: android.support.v4.f.e */
class C0100e {
    private static Method f338a;
    private static Method f339b;

    static {
        try {
            Class cls = Class.forName("libcore.icu.ICU");
            if (cls != null) {
                f338a = cls.getMethod("getScript", new Class[]{String.class});
                f339b = cls.getMethod("addLikelySubtags", new Class[]{String.class});
            }
        } catch (Throwable e) {
            Log.w("ICUCompatIcs", e);
        }
    }

    public static String m543a(String str) {
        try {
            if (f338a != null) {
                return (String) f338a.invoke(null, new Object[]{str});
            }
        } catch (Throwable e) {
            Log.w("ICUCompatIcs", e);
        } catch (Throwable e2) {
            Log.w("ICUCompatIcs", e2);
        }
        return null;
    }

    public static String m544b(String str) {
        try {
            if (f339b != null) {
                return (String) f339b.invoke(null, new Object[]{str});
            }
        } catch (Throwable e) {
            Log.w("ICUCompatIcs", e);
        } catch (Throwable e2) {
            Log.w("ICUCompatIcs", e2);
        }
        return str;
    }
}
