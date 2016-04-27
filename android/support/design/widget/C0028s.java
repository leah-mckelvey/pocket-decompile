package android.support.design.widget;

import android.support.design.widget.Snackbar.SnackbarLayout;
import android.view.MotionEvent;
import android.view.View;
import com.pocket.doorway.C0339o;

/* renamed from: android.support.design.widget.s */
final class C0028s extends C0027y {
    final /* synthetic */ Snackbar f79a;

    C0028s(Snackbar snackbar) {
        this.f79a = snackbar;
    }

    public boolean m138a(C0009b c0009b, SnackbarLayout snackbarLayout, MotionEvent motionEvent) {
        if (c0009b.m54a((View) snackbarLayout, (int) motionEvent.getX(), (int) motionEvent.getY())) {
            switch (motionEvent.getActionMasked()) {
                case C0339o.View_android_theme /*0*/:
                    C0029u.m140a().m151d(this.f79a.f13d);
                    break;
                case C0339o.View_android_focusable /*1*/:
                case C0339o.View_paddingEnd /*3*/:
                    C0029u.m140a().m152e(this.f79a.f13d);
                    break;
            }
        }
        return super.m135a(c0009b, (View) snackbarLayout, motionEvent);
    }
}
