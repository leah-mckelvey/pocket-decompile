package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.support.v7.internal.widget.bf;
import android.support.v7.internal.widget.bh;
import android.support.v7.internal.widget.bi;
import android.support.v7.internal.widget.bk;
import android.support.v7.p013b.C0200b;
import android.util.AttributeSet;
import android.view.View;
import android.widget.MultiAutoCompleteTextView;

/* renamed from: android.support.v7.widget.u */
public class C0304u extends MultiAutoCompleteTextView {
    private static final int[] f1491a;
    private bh f1492b;
    private bh f1493c;
    private bi f1494d;

    static {
        f1491a = new int[]{16842964, 16843126};
    }

    public C0304u(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0200b.autoCompleteTextViewStyle);
    }

    public C0304u(Context context, AttributeSet attributeSet, int i) {
        super(bf.m1977a(context), attributeSet, i);
        if (bi.f1214a) {
            bk a = bk.m2000a(getContext(), attributeSet, f1491a, i, 0);
            this.f1494d = a.m2010c();
            if (a.m2015e(0)) {
                ColorStateList c = a.m2010c().m1995c(a.m2016f(0, -1));
                if (c != null) {
                    setInternalBackgroundTint(c);
                }
            }
            if (a.m2015e(1)) {
                setDropDownBackgroundDrawable(a.m2004a(1));
            }
            a.m2008b();
        }
    }

    private void m2299a() {
        if (getBackground() == null) {
            return;
        }
        if (this.f1493c != null) {
            bi.m1981a((View) this, this.f1493c);
        } else if (this.f1492b != null) {
            bi.m1981a((View) this, this.f1492b);
        }
    }

    private void setInternalBackgroundTint(ColorStateList colorStateList) {
        if (colorStateList != null) {
            if (this.f1492b == null) {
                this.f1492b = new bh();
            }
            this.f1492b.f1210a = colorStateList;
            this.f1492b.f1213d = true;
        } else {
            this.f1492b = null;
        }
        m2299a();
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        m2299a();
    }

    public ColorStateList getSupportBackgroundTintList() {
        return this.f1493c != null ? this.f1493c.f1210a : null;
    }

    public Mode getSupportBackgroundTintMode() {
        return this.f1493c != null ? this.f1493c.f1211b : null;
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        setInternalBackgroundTint(null);
    }

    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        setInternalBackgroundTint(this.f1494d != null ? this.f1494d.m1995c(i) : null);
    }

    public void setDropDownBackgroundResource(int i) {
        if (this.f1494d != null) {
            setDropDownBackgroundDrawable(this.f1494d.m1991a(i));
        } else {
            super.setDropDownBackgroundResource(i);
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (this.f1493c == null) {
            this.f1493c = new bh();
        }
        this.f1493c.f1210a = colorStateList;
        this.f1493c.f1213d = true;
        m2299a();
    }

    public void setSupportBackgroundTintMode(Mode mode) {
        if (this.f1493c == null) {
            this.f1493c = new bh();
        }
        this.f1493c.f1211b = mode;
        this.f1493c.f1212c = true;
        m2299a();
    }
}
