package android.support.v4.p000h;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;

/* renamed from: android.support.v4.h.cj */
final class cj implements AnimatorUpdateListener {
    final /* synthetic */ cm f417a;
    final /* synthetic */ View f418b;

    cj(cm cmVar, View view) {
        this.f417a = cmVar;
        this.f418b = view;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f417a.m925a(this.f418b);
    }
}
