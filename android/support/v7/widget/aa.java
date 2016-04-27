package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.p013b.C0210l;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;

public class aa extends MarginLayoutParams {
    public float f1409g;
    public int f1410h;

    public aa(int i, int i2) {
        super(i, i2);
        this.f1410h = -1;
        this.f1409g = 0.0f;
    }

    public aa(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1410h = -1;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0210l.LinearLayoutCompat_Layout);
        this.f1409g = obtainStyledAttributes.getFloat(C0210l.LinearLayoutCompat_Layout_android_layout_weight, 0.0f);
        this.f1410h = obtainStyledAttributes.getInt(C0210l.LinearLayoutCompat_Layout_android_layout_gravity, -1);
        obtainStyledAttributes.recycle();
    }

    public aa(LayoutParams layoutParams) {
        super(layoutParams);
        this.f1410h = -1;
    }
}
