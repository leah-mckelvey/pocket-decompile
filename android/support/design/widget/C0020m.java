package android.support.design.widget;

import android.view.View;
import com.pocket.doorway.C0339o;

/* renamed from: android.support.design.widget.m */
class C0020m implements aa {
    final /* synthetic */ Snackbar f63a;

    C0020m(Snackbar snackbar) {
        this.f63a = snackbar;
    }

    public void m105a(int i) {
        switch (i) {
            case C0339o.View_android_theme /*0*/:
                C0029u.m140a().m152e(this.f63a.f13d);
            case C0339o.View_android_focusable /*1*/:
            case C0339o.View_paddingStart /*2*/:
                C0029u.m140a().m151d(this.f63a.f13d);
            default:
        }
    }

    public void m106a(View view) {
        this.f63a.m19a();
    }
}
