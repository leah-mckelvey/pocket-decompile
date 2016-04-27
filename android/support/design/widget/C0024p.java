package android.support.design.widget;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

/* renamed from: android.support.design.widget.p */
class C0024p implements AnimationListener {
    final /* synthetic */ Snackbar f66a;

    C0024p(Snackbar snackbar) {
        this.f66a = snackbar;
    }

    public void onAnimationEnd(Animation animation) {
        C0029u.m140a().m150c(this.f66a.f13d);
    }

    public void onAnimationRepeat(Animation animation) {
    }

    public void onAnimationStart(Animation animation) {
    }
}
