package android.support.v4.p000h;

import android.view.View;
import android.view.WindowInsets;

/* renamed from: android.support.v4.h.bk */
class bk {
    public static cn m842a(View view, cn cnVar) {
        if (!(cnVar instanceof co)) {
            return cnVar;
        }
        WindowInsets f = ((co) cnVar).m938f();
        WindowInsets onApplyWindowInsets = view.onApplyWindowInsets(f);
        return onApplyWindowInsets != f ? new co(onApplyWindowInsets) : cnVar;
    }

    public static void m843a(View view) {
        view.requestApplyInsets();
    }

    public static void m844a(View view, float f) {
        view.setElevation(f);
    }

    public static void m845a(View view, ao aoVar) {
        view.setOnApplyWindowInsetsListener(new bl(aoVar));
    }

    public static float m846b(View view) {
        return view.getElevation();
    }

    public static cn m847b(View view, cn cnVar) {
        if (!(cnVar instanceof co)) {
            return cnVar;
        }
        WindowInsets f = ((co) cnVar).m938f();
        WindowInsets dispatchApplyWindowInsets = view.dispatchApplyWindowInsets(f);
        return dispatchApplyWindowInsets != f ? new co(dispatchApplyWindowInsets) : cnVar;
    }

    public static float m848c(View view) {
        return view.getTranslationZ();
    }

    public static float m849d(View view) {
        return view.getZ();
    }
}
