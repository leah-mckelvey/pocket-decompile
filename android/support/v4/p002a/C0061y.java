package android.support.v4.p002a;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

/* renamed from: android.support.v4.a.y */
class C0061y implements AnimationListener {
    final /* synthetic */ C0048m f318a;
    final /* synthetic */ C0059w f319b;

    C0061y(C0059w c0059w, C0048m c0048m) {
        this.f319b = c0059w;
        this.f318a = c0048m;
    }

    public void onAnimationEnd(Animation animation) {
        if (this.f318a.f243c != null) {
            this.f318a.f243c = null;
            this.f319b.m409a(this.f318a, this.f318a.f244d, 0, 0, false);
        }
    }

    public void onAnimationRepeat(Animation animation) {
    }

    public void onAnimationStart(Animation animation) {
    }
}
