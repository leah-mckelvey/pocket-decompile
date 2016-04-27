package android.support.v7.widget;

import android.content.Context;
import android.support.v7.p011a.C0173b;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;

public class ay extends C0173b {
    int f1456b;

    public ay(int i, int i2) {
        super(i, i2);
        this.f1456b = 0;
        this.a = 8388627;
    }

    public ay(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1456b = 0;
    }

    public ay(C0173b c0173b) {
        super(c0173b);
        this.f1456b = 0;
    }

    public ay(ay ayVar) {
        super((C0173b) ayVar);
        this.f1456b = 0;
        this.f1456b = ayVar.f1456b;
    }

    public ay(LayoutParams layoutParams) {
        super(layoutParams);
        this.f1456b = 0;
    }

    public ay(MarginLayoutParams marginLayoutParams) {
        super((LayoutParams) marginLayoutParams);
        this.f1456b = 0;
        m2281a(marginLayoutParams);
    }

    void m2281a(MarginLayoutParams marginLayoutParams) {
        this.leftMargin = marginLayoutParams.leftMargin;
        this.topMargin = marginLayoutParams.topMargin;
        this.rightMargin = marginLayoutParams.rightMargin;
        this.bottomMargin = marginLayoutParams.bottomMargin;
    }
}
