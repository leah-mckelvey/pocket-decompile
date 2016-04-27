package android.support.v7.internal.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;

public class bk {
    private final Context f1227a;
    private final TypedArray f1228b;
    private bi f1229c;

    private bk(Context context, TypedArray typedArray) {
        this.f1227a = context;
        this.f1228b = typedArray;
    }

    public static bk m1999a(Context context, AttributeSet attributeSet, int[] iArr) {
        return new bk(context, context.obtainStyledAttributes(attributeSet, iArr));
    }

    public static bk m2000a(Context context, AttributeSet attributeSet, int[] iArr, int i, int i2) {
        return new bk(context, context.obtainStyledAttributes(attributeSet, iArr, i, i2));
    }

    public float m2001a(int i, float f) {
        return this.f1228b.getFloat(i, f);
    }

    public int m2002a() {
        return this.f1228b.length();
    }

    public int m2003a(int i, int i2) {
        return this.f1228b.getInt(i, i2);
    }

    public Drawable m2004a(int i) {
        if (this.f1228b.hasValue(i)) {
            int resourceId = this.f1228b.getResourceId(i, 0);
            if (resourceId != 0) {
                return m2010c().m1991a(resourceId);
            }
        }
        return this.f1228b.getDrawable(i);
    }

    public boolean m2005a(int i, boolean z) {
        return this.f1228b.getBoolean(i, z);
    }

    public int m2006b(int i, int i2) {
        return this.f1228b.getInteger(i, i2);
    }

    public Drawable m2007b(int i) {
        if (this.f1228b.hasValue(i)) {
            int resourceId = this.f1228b.getResourceId(i, 0);
            if (resourceId != 0) {
                return m2010c().m1992a(resourceId, true);
            }
        }
        return null;
    }

    public void m2008b() {
        this.f1228b.recycle();
    }

    public int m2009c(int i, int i2) {
        return this.f1228b.getDimensionPixelOffset(i, i2);
    }

    public bi m2010c() {
        if (this.f1229c == null) {
            this.f1229c = bi.m1979a(this.f1227a);
        }
        return this.f1229c;
    }

    public CharSequence m2011c(int i) {
        return this.f1228b.getText(i);
    }

    public int m2012d(int i, int i2) {
        return this.f1228b.getDimensionPixelSize(i, i2);
    }

    public String m2013d(int i) {
        return this.f1228b.getString(i);
    }

    public int m2014e(int i, int i2) {
        return this.f1228b.getLayoutDimension(i, i2);
    }

    public boolean m2015e(int i) {
        return this.f1228b.hasValue(i);
    }

    public int m2016f(int i, int i2) {
        return this.f1228b.getResourceId(i, i2);
    }
}
