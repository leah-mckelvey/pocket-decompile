package android.support.v4.p000h;

import android.view.View;
import android.view.View.OnApplyWindowInsetsListener;
import android.view.WindowInsets;

/* renamed from: android.support.v4.h.bl */
final class bl implements OnApplyWindowInsetsListener {
    final /* synthetic */ ao f400a;

    bl(ao aoVar) {
        this.f400a = aoVar;
    }

    public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
        return ((co) this.f400a.m670a(view, new co(windowInsets))).m938f();
    }
}
