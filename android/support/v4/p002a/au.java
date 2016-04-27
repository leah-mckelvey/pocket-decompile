package android.support.v4.p002a;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;

/* renamed from: android.support.v4.a.au */
class au {
    public static Intent m249a(Activity activity) {
        return activity.getParentActivityIntent();
    }

    public static String m250a(ActivityInfo activityInfo) {
        return activityInfo.parentActivityName;
    }

    public static boolean m251a(Activity activity, Intent intent) {
        return activity.shouldUpRecreateTask(intent);
    }

    public static void m252b(Activity activity, Intent intent) {
        activity.navigateUpTo(intent);
    }
}
