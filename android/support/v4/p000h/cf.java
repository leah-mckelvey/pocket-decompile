package android.support.v4.p000h;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

/* renamed from: android.support.v4.h.cf */
final class cf extends AnimatorListenerAdapter {
    final /* synthetic */ ck f413a;
    final /* synthetic */ View f414b;

    cf(ck ckVar, View view) {
        this.f413a = ckVar;
        this.f414b = view;
    }

    public void onAnimationCancel(Animator animator) {
        this.f413a.m111c(this.f414b);
    }

    public void onAnimationEnd(Animator animator) {
        this.f413a.m110b(this.f414b);
    }

    public void onAnimationStart(Animator animator) {
        this.f413a.m109a(this.f414b);
    }
}
