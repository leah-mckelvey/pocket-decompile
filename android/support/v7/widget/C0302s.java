package android.support.v7.widget;

import android.content.Context;
import android.support.v7.internal.widget.bi;
import android.support.v7.internal.widget.bk;
import android.util.AttributeSet;
import android.widget.CheckedTextView;

/* renamed from: android.support.v7.widget.s */
public class C0302s extends CheckedTextView {
    private static final int[] f1485a;
    private bi f1486b;

    static {
        f1485a = new int[]{16843016};
    }

    public C0302s(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16843720);
    }

    public C0302s(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        if (bi.f1214a) {
            bk a = bk.m2000a(getContext(), attributeSet, f1485a, i, 0);
            setCheckMarkDrawable(a.m2004a(0));
            a.m2008b();
            this.f1486b = a.m2010c();
        }
    }

    public void setCheckMarkDrawable(int i) {
        if (this.f1486b != null) {
            setCheckMarkDrawable(this.f1486b.m1991a(i));
        } else {
            super.setCheckMarkDrawable(i);
        }
    }
}
