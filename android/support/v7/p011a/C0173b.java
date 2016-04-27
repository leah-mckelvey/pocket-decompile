package android.support.v7.p011a;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.p013b.C0210l;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;

/* renamed from: android.support.v7.a.b */
public class C0173b extends MarginLayoutParams {
    public int f529a;

    public C0173b(int i, int i2) {
        super(i, i2);
        this.f529a = 0;
        this.f529a = 8388627;
    }

    public C0173b(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f529a = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0210l.ActionBarLayout);
        this.f529a = obtainStyledAttributes.getInt(C0210l.ActionBarLayout_android_layout_gravity, 0);
        obtainStyledAttributes.recycle();
    }

    public C0173b(C0173b c0173b) {
        super(c0173b);
        this.f529a = 0;
        this.f529a = c0173b.f529a;
    }

    public C0173b(LayoutParams layoutParams) {
        super(layoutParams);
        this.f529a = 0;
    }
}
