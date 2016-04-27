package android.support.v7.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v7.internal.widget.bh;
import android.support.v7.internal.widget.bi;
import android.support.v7.internal.widget.bk;
import android.support.v7.p013b.C0200b;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ListPopupWindow;
import android.widget.Spinner;
import java.lang.reflect.Field;

/* renamed from: android.support.v7.widget.x */
public class C0307x extends Spinner {
    private static final int[] f1500a;
    private bh f1501b;
    private bh f1502c;
    private bi f1503d;

    static {
        f1500a = new int[]{16842964, 16843126};
    }

    public C0307x(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0200b.spinnerStyle);
    }

    public C0307x(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        if (bi.f1214a) {
            bk a = bk.m2000a(getContext(), attributeSet, f1500a, i, 0);
            if (a.m2015e(0)) {
                ColorStateList c = a.m2010c().m1995c(a.m2016f(0, -1));
                if (c != null) {
                    setInternalBackgroundTint(c);
                }
            }
            if (a.m2015e(1)) {
                Drawable a2 = a.m2004a(1);
                if (VERSION.SDK_INT >= 16) {
                    setPopupBackgroundDrawable(a2);
                } else if (VERSION.SDK_INT >= 11) {
                    C0307x.m2303a(this, a2);
                }
            }
            this.f1503d = a.m2010c();
            a.m2008b();
        }
    }

    private void m2302a() {
        if (getBackground() == null) {
            return;
        }
        if (this.f1502c != null) {
            bi.m1981a((View) this, this.f1502c);
        } else if (this.f1501b != null) {
            bi.m1981a((View) this, this.f1501b);
        }
    }

    @TargetApi(11)
    private static void m2303a(Spinner spinner, Drawable drawable) {
        try {
            Field declaredField = Spinner.class.getDeclaredField("mPopup");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(spinner);
            if (obj instanceof ListPopupWindow) {
                ((ListPopupWindow) obj).setBackgroundDrawable(drawable);
            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
        }
    }

    private void setInternalBackgroundTint(ColorStateList colorStateList) {
        if (colorStateList != null) {
            if (this.f1501b == null) {
                this.f1501b = new bh();
            }
            this.f1501b.f1210a = colorStateList;
            this.f1501b.f1213d = true;
        } else {
            this.f1501b = null;
        }
        m2302a();
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        m2302a();
    }

    public ColorStateList getSupportBackgroundTintList() {
        return this.f1502c != null ? this.f1502c.f1210a : null;
    }

    public Mode getSupportBackgroundTintMode() {
        return this.f1502c != null ? this.f1502c.f1211b : null;
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        setInternalBackgroundTint(null);
    }

    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        setInternalBackgroundTint(this.f1503d != null ? this.f1503d.m1995c(i) : null);
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (this.f1502c == null) {
            this.f1502c = new bh();
        }
        this.f1502c.f1210a = colorStateList;
        this.f1502c.f1213d = true;
        m2302a();
    }

    public void setSupportBackgroundTintMode(Mode mode) {
        if (this.f1502c == null) {
            this.f1502c = new bh();
        }
        this.f1502c.f1211b = mode;
        this.f1502c.f1212c = true;
        m2302a();
    }
}
