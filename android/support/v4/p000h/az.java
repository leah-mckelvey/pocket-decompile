package android.support.v4.p000h;

import android.view.View;
import java.util.WeakHashMap;

/* renamed from: android.support.v4.h.az */
class az extends ay {
    static boolean f397b;

    static {
        f397b = false;
    }

    az() {
    }

    public bt m790g(View view) {
        if (this.a == null) {
            this.a = new WeakHashMap();
        }
        bt btVar = (bt) this.a.get(view);
        if (btVar != null) {
            return btVar;
        }
        btVar = new bt(view);
        this.a.put(view, btVar);
        return btVar;
    }
}
