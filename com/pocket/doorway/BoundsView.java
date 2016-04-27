package com.pocket.doorway;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

public class BoundsView extends RelativeLayout {
    private C0321d f1509a;

    public BoundsView(Context context) {
        super(context);
    }

    public BoundsView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public BoundsView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @TargetApi(21)
    public BoundsView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.f1509a != null) {
            this.f1509a.m2338a(this);
        }
    }

    public void setBoundsListener(C0321d c0321d) {
        this.f1509a = c0321d;
    }
}
