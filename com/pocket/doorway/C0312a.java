package com.pocket.doorway;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* renamed from: com.pocket.doorway.a */
class C0312a extends AnimatorListenerAdapter {
    final /* synthetic */ BlipView f1524a;

    C0312a(BlipView blipView) {
        this.f1524a = blipView;
    }

    public void onAnimationEnd(Animator animator) {
        this.f1524a.setVisibility(8);
    }
}
