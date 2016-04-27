package android.support.v4.p002a;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.support.v4.p001b.C0066e;

/* renamed from: android.support.v4.a.aq */
public class aq {
    private static final ar f148a;

    static {
        if (VERSION.SDK_INT >= 16) {
            f148a = new at();
        } else {
            f148a = new as();
        }
    }

    public static Intent m230a(Activity activity) {
        return f148a.m236a(activity);
    }

    public static Intent m231a(Context context, ComponentName componentName) {
        String b = aq.m234b(context, componentName);
        if (b == null) {
            return null;
        }
        ComponentName componentName2 = new ComponentName(componentName.getPackageName(), b);
        return aq.m234b(context, componentName2) == null ? C0066e.m451a(componentName2) : new Intent().setComponent(componentName2);
    }

    public static boolean m232a(Activity activity, Intent intent) {
        return f148a.m238a(activity, intent);
    }

    public static String m233b(Activity activity) {
        try {
            return aq.m234b((Context) activity, activity.getComponentName());
        } catch (Throwable e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static String m234b(Context context, ComponentName componentName) {
        return f148a.m237a(context, context.getPackageManager().getActivityInfo(componentName, 128));
    }

    public static void m235b(Activity activity, Intent intent) {
        f148a.m239b(activity, intent);
    }
}
