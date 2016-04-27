package android.support.design.widget;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

/* renamed from: android.support.design.widget.r */
class C0026r implements AnimationListener {
    final /* synthetic */ Snackbar f68a;

    C0026r(Snackbar snackbar) {
        this.f68a = snackbar;
    }

    public void onAnimationEnd(Animation animation) {
        this.f68a.m17f();
    }

    public void onAnimationRepeat(Animation animation) {
    }

    public void onAnimationStart(Animation animation) {
    }
}
