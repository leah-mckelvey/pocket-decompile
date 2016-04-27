package android.support.v7.internal.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.v4.p003c.C0090a;
import android.util.TypedValue;

public class be {
    static final int[] f1198a;
    static final int[] f1199b;
    static final int[] f1200c;
    static final int[] f1201d;
    static final int[] f1202e;
    static final int[] f1203f;
    static final int[] f1204g;
    static final int[] f1205h;
    private static final ThreadLocal f1206i;
    private static final int[] f1207j;

    static {
        f1206i = new ThreadLocal();
        f1198a = new int[]{-16842910};
        f1199b = new int[]{16842908};
        f1200c = new int[]{16843518};
        f1201d = new int[]{16842919};
        f1202e = new int[]{16842912};
        f1203f = new int[]{16842913};
        f1204g = new int[]{-16842919, -16842908};
        f1205h = new int[0];
        f1207j = new int[1];
    }

    public static int m1971a(Context context, int i) {
        f1207j[0] = i;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(null, f1207j);
        try {
            int color = obtainStyledAttributes.getColor(0, 0);
            return color;
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    static int m1972a(Context context, int i, float f) {
        int a = m1971a(context, i);
        return C0090a.m528b(a, Math.round(((float) Color.alpha(a)) * f));
    }

    public static ColorStateList m1973a(int i, int i2) {
        r0 = new int[2][];
        int[] iArr = new int[]{f1198a, i2};
        r0[1] = f1205h;
        iArr[1] = i;
        return new ColorStateList(r0, iArr);
    }

    private static TypedValue m1974a() {
        TypedValue typedValue = (TypedValue) f1206i.get();
        if (typedValue != null) {
            return typedValue;
        }
        typedValue = new TypedValue();
        f1206i.set(typedValue);
        return typedValue;
    }

    public static ColorStateList m1975b(Context context, int i) {
        f1207j[0] = i;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(null, f1207j);
        try {
            ColorStateList colorStateList = obtainStyledAttributes.getColorStateList(0);
            return colorStateList;
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public static int m1976c(Context context, int i) {
        ColorStateList b = m1975b(context, i);
        if (b != null && b.isStateful()) {
            return b.getColorForState(f1198a, b.getDefaultColor());
        }
        TypedValue a = m1974a();
        context.getTheme().resolveAttribute(16842803, a, true);
        return m1972a(context, i, a.getFloat());
    }
}
