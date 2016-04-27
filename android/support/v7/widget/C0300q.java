package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v7.internal.p017b.C0222a;
import android.support.v7.internal.widget.be;
import android.support.v7.internal.widget.bh;
import android.support.v7.internal.widget.bi;
import android.support.v7.internal.widget.bk;
import android.support.v7.p013b.C0200b;
import android.support.v7.p013b.C0210l;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;

/* renamed from: android.support.v7.widget.q */
public class C0300q extends Button {
    private static final int[] f1478a;
    private bh f1479b;
    private bh f1480c;
    private bi f1481d;

    static {
        f1478a = new int[]{16842964};
    }

    public C0300q(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0200b.buttonStyle);
    }

    public C0300q(Context context, AttributeSet attributeSet, int i) {
        ColorStateList c;
        super(context, attributeSet, i);
        if (bi.f1214a) {
            bk a = bk.m2000a(getContext(), attributeSet, f1478a, i, 0);
            if (a.m2015e(0)) {
                c = a.m2010c().m1995c(a.m2016f(0, -1));
                if (c != null) {
                    setInternalBackgroundTint(c);
                }
            }
            this.f1481d = a.m2010c();
            a.m2008b();
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0210l.AppCompatTextView, i, 0);
        int resourceId = obtainStyledAttributes.getResourceId(C0210l.AppCompatTextView_android_textAppearance, -1);
        obtainStyledAttributes.recycle();
        if (resourceId != -1) {
            obtainStyledAttributes = context.obtainStyledAttributes(resourceId, C0210l.TextAppearance);
            if (obtainStyledAttributes.hasValue(C0210l.TextAppearance_textAllCaps)) {
                setAllCaps(obtainStyledAttributes.getBoolean(C0210l.TextAppearance_textAllCaps, false));
            }
            obtainStyledAttributes.recycle();
        }
        obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0210l.AppCompatTextView, i, 0);
        if (obtainStyledAttributes.hasValue(C0210l.AppCompatTextView_textAllCaps)) {
            setAllCaps(obtainStyledAttributes.getBoolean(C0210l.AppCompatTextView_textAllCaps, false));
        }
        obtainStyledAttributes.recycle();
        c = getTextColors();
        if (c != null && !c.isStateful()) {
            setTextColor(be.m1973a(c.getDefaultColor(), VERSION.SDK_INT < 21 ? be.m1976c(context, 16842808) : be.m1971a(context, 16842808)));
        }
    }

    private void m2297a() {
        if (getBackground() == null) {
            return;
        }
        if (this.f1480c != null) {
            bi.m1981a((View) this, this.f1480c);
        } else if (this.f1479b != null) {
            bi.m1981a((View) this, this.f1479b);
        }
    }

    private void setInternalBackgroundTint(ColorStateList colorStateList) {
        if (colorStateList != null) {
            if (this.f1479b == null) {
                this.f1479b = new bh();
            }
            this.f1479b.f1210a = colorStateList;
            this.f1479b.f1213d = true;
        } else {
            this.f1479b = null;
        }
        m2297a();
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        m2297a();
    }

    public ColorStateList getSupportBackgroundTintList() {
        return this.f1480c != null ? this.f1480c.f1210a : null;
    }

    public Mode getSupportBackgroundTintMode() {
        return this.f1480c != null ? this.f1480c.f1211b : null;
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(Button.class.getName());
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(Button.class.getName());
    }

    public void setAllCaps(boolean z) {
        setTransformationMethod(z ? new C0222a(getContext()) : null);
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        setInternalBackgroundTint(null);
    }

    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        setInternalBackgroundTint(this.f1481d != null ? this.f1481d.m1995c(i) : null);
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (this.f1480c == null) {
            this.f1480c = new bh();
        }
        this.f1480c.f1210a = colorStateList;
        this.f1480c.f1213d = true;
        m2297a();
    }

    public void setSupportBackgroundTintMode(Mode mode) {
        if (this.f1480c == null) {
            this.f1480c = new bh();
        }
        this.f1480c.f1211b = mode;
        this.f1480c.f1212c = true;
        m2297a();
    }

    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i, C0210l.TextAppearance);
        if (obtainStyledAttributes.hasValue(C0210l.TextAppearance_textAllCaps)) {
            setAllCaps(obtainStyledAttributes.getBoolean(C0210l.TextAppearance_textAllCaps, false));
        }
        obtainStyledAttributes.recycle();
    }
}
