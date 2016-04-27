package android.support.v4.p000h;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

/* renamed from: android.support.v4.h.ch */
final class ch extends AnimatorListenerAdapter {
    final /* synthetic */ ck f415a;
    final /* synthetic */ View f416b;

    ch(ck ckVar, View view) {
        this.f415a = ckVar;
        this.f416b = view;
    }

    public void onAnimationCancel(Animator animator) {
        this.f415a.m111c(this.f416b);
    }

    public void onAnimationEnd(Animator animator) {
        this.f415a.m110b(this.f416b);
    }

    public void onAnimationStart(Animator animator) {
        this.f415a.m109a(this.f416b);
    }
}
