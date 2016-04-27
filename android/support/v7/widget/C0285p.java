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
import android.widget.AutoCompleteTextView;

/* renamed from: android.support.v7.widget.p */
public class C0285p extends AutoCompleteTextView {
    private static final int[] f1306a;
    private bh f1307b;
    private bh f1308c;
    private bi f1309d;

    static {
        f1306a = new int[]{16842964, 16843126};
    }

    public C0285p(Context context) {
        this(context, null);
    }

    public C0285p(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0200b.autoCompleteTextViewStyle);
    }

    public C0285p(Context context, AttributeSet attributeSet, int i) {
        super(bf.m1977a(context), attributeSet, i);
        if (bi.f1214a) {
            bk a = bk.m2000a(getContext(), attributeSet, f1306a, i, 0);
            this.f1309d = a.m2010c();
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

    private void m2134a() {
        if (getBackground() == null) {
            return;
        }
        if (this.f1308c != null) {
            bi.m1981a((View) this, this.f1308c);
        } else if (this.f1307b != null) {
            bi.m1981a((View) this, this.f1307b);
        }
    }

    private void setInternalBackgroundTint(ColorStateList colorStateList) {
        if (colorStateList != null) {
            if (this.f1307b == null) {
                this.f1307b = new bh();
            }
            this.f1307b.f1210a = colorStateList;
            this.f1307b.f1213d = true;
        } else {
            this.f1307b = null;
        }
        m2134a();
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        m2134a();
    }

    public ColorStateList getSupportBackgroundTintList() {
        return this.f1308c != null ? this.f1308c.f1210a : null;
    }

    public Mode getSupportBackgroundTintMode() {
        return this.f1308c != null ? this.f1308c.f1211b : null;
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        setInternalBackgroundTint(null);
    }

    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        setInternalBackgroundTint(this.f1309d != null ? this.f1309d.m1995c(i) : null);
    }

    public void setDropDownBackgroundResource(int i) {
        setDropDownBackgroundDrawable(this.f1309d.m1991a(i));
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (this.f1308c == null) {
            this.f1308c = new bh();
        }
        this.f1308c.f1210a = colorStateList;
        this.f1308c.f1213d = true;
        m2134a();
    }

    public void setSupportBackgroundTintMode(Mode mode) {
        if (this.f1308c == null) {
            this.f1308c = new bh();
        }
        this.f1308c.f1211b = mode;
        this.f1308c.f1212c = true;
        m2134a();
    }
}
