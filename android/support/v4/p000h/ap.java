package android.support.v4.p000h;

import android.os.Build.VERSION;
import android.view.VelocityTracker;

/* renamed from: android.support.v4.h.ap */
public class ap {
    static final as f394a;

    static {
        if (VERSION.SDK_INT >= 11) {
            f394a = new ar();
        } else {
            f394a = new aq();
        }
    }

    public static float m671a(VelocityTracker velocityTracker, int i) {
        return f394a.m673a(velocityTracker, i);
    }

    public static float m672b(VelocityTracker velocityTracker, int i) {
        return f394a.m674b(velocityTracker, i);
    }
}
