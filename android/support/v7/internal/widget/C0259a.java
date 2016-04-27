package android.support.v7.internal.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.support.v4.p000h.au;
import android.support.v4.p000h.bt;
import android.support.v7.internal.view.C0232i;
import android.support.v7.p013b.C0200b;
import android.support.v7.p013b.C0210l;
import android.support.v7.widget.ActionMenuView;
import android.support.v7.widget.C0286a;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;

/* renamed from: android.support.v7.internal.widget.a */
abstract class C0259a extends ViewGroup {
    private static final Interpolator f955j;
    protected final C0263b f956a;
    protected final Context f957b;
    protected ActionMenuView f958c;
    protected C0286a f959d;
    protected ViewGroup f960e;
    protected boolean f961f;
    protected boolean f962g;
    protected int f963h;
    protected bt f964i;

    static {
        f955j = new DecelerateInterpolator();
    }

    C0259a(Context context) {
        this(context, null);
    }

    C0259a(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    C0259a(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f956a = new C0263b(this);
        TypedValue typedValue = new TypedValue();
        if (!context.getTheme().resolveAttribute(C0200b.actionBarPopupTheme, typedValue, true) || typedValue.resourceId == 0) {
            this.f957b = context;
        } else {
            this.f957b = new ContextThemeWrapper(context, typedValue.resourceId);
        }
    }

    protected static int m1740a(int i, int i2, boolean z) {
        return z ? i - i2 : i + i2;
    }

    protected int m1741a(View view, int i, int i2, int i3) {
        view.measure(MeasureSpec.makeMeasureSpec(i, Integer.MIN_VALUE), i2);
        return Math.max(0, (i - view.getMeasuredWidth()) - i3);
    }

    protected int m1742a(View view, int i, int i2, int i3, boolean z) {
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        int i4 = ((i3 - measuredHeight) / 2) + i2;
        if (z) {
            view.layout(i - measuredWidth, i4, i, measuredHeight + i4);
        } else {
            view.layout(i, i4, i + measuredWidth, measuredHeight + i4);
        }
        return z ? -measuredWidth : measuredWidth;
    }

    public void m1743a(int i) {
        if (this.f964i != null) {
            this.f964i.m865a();
        }
        bt a;
        if (i == 0) {
            if (getVisibility() != 0) {
                au.m697c(this, 0.0f);
                if (!(this.f960e == null || this.f958c == null)) {
                    au.m697c(this.f958c, 0.0f);
                }
            }
            a = au.m703g(this).m860a(1.0f);
            a.m861a(200);
            a.m864a(f955j);
            if (this.f960e == null || this.f958c == null) {
                a.m862a(this.f956a.m1965a(a, i));
                a.m868b();
                return;
            }
            C0232i c0232i = new C0232i();
            bt a2 = au.m703g(this.f958c).m860a(1.0f);
            a2.m861a(200);
            c0232i.m1509a(this.f956a.m1965a(a, i));
            c0232i.m1508a(a).m1508a(a2);
            c0232i.m1511a();
            return;
        }
        a = au.m703g(this).m860a(0.0f);
        a.m861a(200);
        a.m864a(f955j);
        if (this.f960e == null || this.f958c == null) {
            a.m862a(this.f956a.m1965a(a, i));
            a.m868b();
            return;
        }
        c0232i = new C0232i();
        a2 = au.m703g(this.f958c).m860a(0.0f);
        a2.m861a(200);
        c0232i.m1509a(this.f956a.m1965a(a, i));
        c0232i.m1508a(a).m1508a(a2);
        c0232i.m1511a();
    }

    public boolean m1744a() {
        return this.f959d != null ? this.f959d.m2230c() : false;
    }

    public int getAnimatedVisibility() {
        return this.f964i != null ? this.f956a.f1190a : getVisibility();
    }

    public int getContentHeight() {
        return this.f963h;
    }

    protected void onConfigurationChanged(Configuration configuration) {
        if (VERSION.SDK_INT >= 8) {
            super.onConfigurationChanged(configuration);
        }
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(null, C0210l.ActionBar, C0200b.actionBarStyle, 0);
        setContentHeight(obtainStyledAttributes.getLayoutDimension(C0210l.ActionBar_height, 0));
        obtainStyledAttributes.recycle();
        if (this.f959d != null) {
            this.f959d.m2218a(configuration);
        }
    }

    public void setContentHeight(int i) {
        this.f963h = i;
        requestLayout();
    }

    public void setSplitToolbar(boolean z) {
        this.f961f = z;
    }

    public void setSplitView(ViewGroup viewGroup) {
        this.f960e = viewGroup;
    }

    public void setSplitWhenNarrow(boolean z) {
        this.f962g = z;
    }
}
