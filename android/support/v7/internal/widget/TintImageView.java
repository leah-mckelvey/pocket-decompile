package android.support.v7.internal.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

public class TintImageView extends ImageView {
    private static final int[] f1052a;
    private final bi f1053b;

    static {
        f1052a = new int[]{16842964, 16843033};
    }

    public TintImageView(Context context) {
        this(context, null);
    }

    public TintImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TintImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        bk a = bk.m2000a(getContext(), attributeSet, f1052a, i, 0);
        if (a.m2002a() > 0) {
            if (a.m2015e(0)) {
                setBackgroundDrawable(a.m2004a(0));
            }
            if (a.m2015e(1)) {
                setImageDrawable(a.m2004a(1));
            }
        }
        a.m2008b();
        this.f1053b = a.m2010c();
    }

    public void setImageResource(int i) {
        setImageDrawable(this.f1053b.m1991a(i));
    }
}
