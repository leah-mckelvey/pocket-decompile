package android.support.v4.p002a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;

/* renamed from: android.support.v4.a.at */
class at extends as {
    at() {
    }

    public Intent m244a(Activity activity) {
        Intent a = au.m249a(activity);
        return a == null ? m247b(activity) : a;
    }

    public String m245a(Context context, ActivityInfo activityInfo) {
        String a = au.m250a(activityInfo);
        return a == null ? super.m241a(context, activityInfo) : a;
    }

    public boolean m246a(Activity activity, Intent intent) {
        return au.m251a(activity, intent);
    }

    Intent m247b(Activity activity) {
        return super.m240a(activity);
    }

    public void m248b(Activity activity, Intent intent) {
        au.m252b(activity, intent);
    }
}
