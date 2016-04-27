package android.support.v7.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v7.internal.widget.bi;
import android.support.v7.internal.widget.bk;
import android.support.v7.p013b.C0200b;
import android.util.AttributeSet;
import android.widget.RadioButton;

/* renamed from: android.support.v7.widget.v */
public class C0305v extends RadioButton {
    private static final int[] f1495a;
    private bi f1496b;
    private Drawable f1497c;

    static {
        f1495a = new int[]{16843015};
    }

    public C0305v(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0200b.radioButtonStyle);
    }

    public C0305v(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        if (bi.f1214a) {
            bk a = bk.m2000a(getContext(), attributeSet, f1495a, i, 0);
            setButtonDrawable(a.m2004a(0));
            a.m2008b();
            this.f1496b = a.m2010c();
        }
    }

    public int getCompoundPaddingLeft() {
        int compoundPaddingLeft = super.getCompoundPaddingLeft();
        return (VERSION.SDK_INT >= 17 || this.f1497c == null) ? compoundPaddingLeft : compoundPaddingLeft + this.f1497c.getIntrinsicWidth();
    }

    public void setButtonDrawable(int i) {
        if (this.f1496b != null) {
            setButtonDrawable(this.f1496b.m1991a(i));
        } else {
            super.setButtonDrawable(i);
        }
    }

    public void setButtonDrawable(Drawable drawable) {
        super.setButtonDrawable(drawable);
        this.f1497c = drawable;
    }
}
