package com.pocket.doorway;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.pocket.doorway.p019b.C0313a;
import com.pocket.doorway.p019b.C0316e;
import com.pocket.doorway.vortex.C0344b;

public class BlipView extends RelativeLayout {
    private ImageView f1506a;
    private ImageView f1507b;
    private boolean f1508c;

    public BlipView(Context context) {
        super(context);
        this.f1508c = true;
        m2306b();
    }

    public BlipView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1508c = true;
        m2306b();
    }

    public BlipView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f1508c = true;
        m2306b();
    }

    @TargetApi(21)
    public BlipView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.f1508c = true;
        m2306b();
    }

    private void m2306b() {
        this.f1506a = new ImageView(getContext());
        this.f1506a.setImageDrawable(new C0344b(C0316e.f1529c, C0313a.m2333b(10.0f)));
        this.f1506a.setAlpha(0.8f);
        addView(this.f1506a, m2307c());
        this.f1507b = new ImageView(getContext());
        this.f1507b.setImageDrawable(new C0344b(C0316e.f1529c, C0313a.m2333b(100.0f)));
        this.f1507b.setScaleX(0.0f);
        this.f1507b.setScaleY(0.0f);
        this.f1507b.setAlpha(0.5f);
        addView(this.f1507b, m2307c());
    }

    private LayoutParams m2307c() {
        LayoutParams layoutParams = new LayoutParams(-2, -2);
        layoutParams.addRule(13);
        return layoutParams;
    }

    public void m2308a() {
        if (this.f1508c) {
            this.f1506a.animate().scaleX(1.66f).scaleY(1.66f).alpha(1.0f).setInterpolator(new DecelerateInterpolator()).setDuration(300).setListener(new C0320c(this));
            this.f1507b.setScaleX(0.0f);
            this.f1507b.setScaleY(0.0f);
            this.f1507b.setAlpha(0.5f);
            this.f1507b.animate().scaleX(2.0f).scaleY(2.0f).alpha(0.0f).setInterpolator(new AccelerateInterpolator()).setDuration(700);
        }
    }

    public void setActive(boolean z) {
        if (this.f1508c != z) {
            this.f1508c = z;
            if (z) {
                animate().alpha(0.0f).setInterpolator(new DecelerateInterpolator()).setDuration(300).setListener(new C0312a(this));
            } else {
                animate().alpha(1.0f).setInterpolator(new DecelerateInterpolator()).setDuration(300).setListener(new C0319b(this));
            }
        }
    }
}
