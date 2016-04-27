package android.support.v4.p001b;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;

/* renamed from: android.support.v4.b.a */
public class C0034a {
    public static final Drawable m179a(Context context, int i) {
        return VERSION.SDK_INT >= 21 ? C0063b.m448a(context, i) : context.getResources().getDrawable(i);
    }

    public static boolean m180a(Context context, Intent[] intentArr, Bundle bundle) {
        int i = VERSION.SDK_INT;
        if (i >= 16) {
            C0065d.m450a(context, intentArr, bundle);
            return true;
        } else if (i < 11) {
            return false;
        } else {
            C0064c.m449a(context, intentArr);
            return true;
        }
    }
}
