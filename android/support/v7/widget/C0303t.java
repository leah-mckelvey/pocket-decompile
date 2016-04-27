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
import android.widget.EditText;

/* renamed from: android.support.v7.widget.t */
public class C0303t extends EditText {
    private static final int[] f1487a;
    private bh f1488b;
    private bh f1489c;
    private bi f1490d;

    static {
        f1487a = new int[]{16842964};
    }

    public C0303t(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0200b.editTextStyle);
    }

    public C0303t(Context context, AttributeSet attributeSet, int i) {
        super(bf.m1977a(context), attributeSet, i);
        if (bi.f1214a) {
            bk a = bk.m2000a(getContext(), attributeSet, f1487a, i, 0);
            if (a.m2015e(0)) {
                ColorStateList c = a.m2010c().m1995c(a.m2016f(0, -1));
                if (c != null) {
                    setInternalBackgroundTint(c);
                }
            }
            this.f1490d = a.m2010c();
            a.m2008b();
        }
    }

    private void m2298a() {
        if (getBackground() == null) {
            return;
        }
        if (this.f1489c != null) {
            bi.m1981a((View) this, this.f1489c);
        } else if (this.f1488b != null) {
            bi.m1981a((View) this, this.f1488b);
        }
    }

    private void setInternalBackgroundTint(ColorStateList colorStateList) {
        if (colorStateList != null) {
            if (this.f1488b == null) {
                this.f1488b = new bh();
            }
            this.f1488b.f1210a = colorStateList;
            this.f1488b.f1213d = true;
        } else {
            this.f1488b = null;
        }
        m2298a();
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        m2298a();
    }

    public ColorStateList getSupportBackgroundTintList() {
        return this.f1489c != null ? this.f1489c.f1210a : null;
    }

    public Mode getSupportBackgroundTintMode() {
        return this.f1489c != null ? this.f1489c.f1211b : null;
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        setInternalBackgroundTint(null);
    }

    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        setInternalBackgroundTint(this.f1490d != null ? this.f1490d.m1995c(i) : null);
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (this.f1489c == null) {
            this.f1489c = new bh();
        }
        this.f1489c.f1210a = colorStateList;
        this.f1489c.f1213d = true;
        m2298a();
    }

    public void setSupportBackgroundTintMode(Mode mode) {
        if (this.f1489c == null) {
            this.f1489c = new bh();
        }
        this.f1489c.f1211b = mode;
        this.f1489c.f1212c = true;
        m2298a();
    }
}
