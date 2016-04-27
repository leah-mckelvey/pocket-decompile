package com.pocket.doorway;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.animation.DecelerateInterpolator;

/* renamed from: com.pocket.doorway.c */
class C0320c extends AnimatorListenerAdapter {
    final /* synthetic */ BlipView f1533a;

    C0320c(BlipView blipView) {
        this.f1533a = blipView;
    }

    public void onAnimationEnd(Animator animator) {
        this.f1533a.f1506a.animate().scaleX(1.0f).scaleY(1.0f).alpha(0.8f).setInterpolator(new DecelerateInterpolator()).setDuration(1500).setListener(null);
    }
}
