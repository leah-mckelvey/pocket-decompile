package com.pocket.doorway;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* renamed from: com.pocket.doorway.b */
class C0319b extends AnimatorListenerAdapter {
    final /* synthetic */ BlipView f1532a;

    C0319b(BlipView blipView) {
        this.f1532a = blipView;
    }

    public void onAnimationEnd(Animator animator) {
        this.f1532a.setVisibility(0);
    }
}
