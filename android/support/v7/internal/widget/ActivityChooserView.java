package android.support.v7.internal.widget;

import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.drawable.Drawable;
import android.support.v4.p000h.C0118a;
import android.support.v7.p013b.C0208j;
import android.support.v7.widget.C0260z;
import android.support.v7.widget.ab;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.PopupWindow.OnDismissListener;

public class ActivityChooserView extends ViewGroup {
    C0118a f1027a;
    private final C0282w f1028b;
    private final C0283x f1029c;
    private final C0260z f1030d;
    private final FrameLayout f1031e;
    private final ImageView f1032f;
    private final FrameLayout f1033g;
    private final int f1034h;
    private final DataSetObserver f1035i;
    private final OnGlobalLayoutListener f1036j;
    private ab f1037k;
    private OnDismissListener f1038l;
    private boolean f1039m;
    private int f1040n;
    private boolean f1041o;
    private int f1042p;

    public class InnerLayout extends C0260z {
        private static final int[] f1026a;

        static {
            f1026a = new int[]{16842964};
        }

        public InnerLayout(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            bk a = bk.m1999a(context, attributeSet, f1026a);
            setBackgroundDrawable(a.m2004a(0));
            a.m2008b();
        }
    }

    private void m1819a(int i) {
        if (this.f1028b.m2109d() == null) {
            throw new IllegalStateException("No data model. Did you call #setDataModel?");
        }
        getViewTreeObserver().addOnGlobalLayoutListener(this.f1036j);
        boolean z = this.f1033g.getVisibility() == 0;
        int c = this.f1028b.m2108c();
        int i2 = z ? 1 : 0;
        if (i == Integer.MAX_VALUE || c <= i2 + i) {
            this.f1028b.m2105a(false);
            this.f1028b.m2103a(i);
        } else {
            this.f1028b.m2105a(true);
            this.f1028b.m2103a(i - 1);
        }
        ab listPopupWindow = getListPopupWindow();
        if (!listPopupWindow.m1953b()) {
            if (this.f1039m || !z) {
                this.f1028b.m2106a(true, z);
            } else {
                this.f1028b.m2106a(false, false);
            }
            listPopupWindow.m1957d(Math.min(this.f1028b.m2102a(), this.f1034h));
            listPopupWindow.m1954c();
            if (this.f1027a != null) {
                this.f1027a.m613a(true);
            }
            listPopupWindow.m1961g().setContentDescription(getContext().getString(C0208j.abc_activitychooserview_choose_application));
        }
    }

    private ab getListPopupWindow() {
        if (this.f1037k == null) {
            this.f1037k = new ab(getContext());
            this.f1037k.m1949a(this.f1028b);
            this.f1037k.m1947a((View) this);
            this.f1037k.m1951a(true);
            this.f1037k.m1948a(this.f1029c);
            this.f1037k.m1950a(this.f1029c);
        }
        return this.f1037k;
    }

    public boolean m1828a() {
        if (m1830c() || !this.f1041o) {
            return false;
        }
        this.f1039m = false;
        m1819a(this.f1040n);
        return true;
    }

    public boolean m1829b() {
        if (m1830c()) {
            getListPopupWindow().m1944a();
            ViewTreeObserver viewTreeObserver = getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.removeGlobalOnLayoutListener(this.f1036j);
            }
        }
        return true;
    }

    public boolean m1830c() {
        return getListPopupWindow().m1953b();
    }

    public C0275p getDataModel() {
        return this.f1028b.m2109d();
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        C0275p d = this.f1028b.m2109d();
        if (d != null) {
            d.registerObserver(this.f1035i);
        }
        this.f1041o = true;
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        C0275p d = this.f1028b.m2109d();
        if (d != null) {
            d.unregisterObserver(this.f1035i);
        }
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            viewTreeObserver.removeGlobalOnLayoutListener(this.f1036j);
        }
        if (m1830c()) {
            m1829b();
        }
        this.f1041o = false;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.f1030d.layout(0, 0, i3 - i, i4 - i2);
        if (!m1830c()) {
            m1829b();
        }
    }

    protected void onMeasure(int i, int i2) {
        View view = this.f1030d;
        if (this.f1033g.getVisibility() != 0) {
            i2 = MeasureSpec.makeMeasureSpec(MeasureSpec.getSize(i2), 1073741824);
        }
        measureChild(view, i, i2);
        setMeasuredDimension(view.getMeasuredWidth(), view.getMeasuredHeight());
    }

    public void setActivityChooserModel(C0275p c0275p) {
        this.f1028b.m2104a(c0275p);
        if (m1830c()) {
            m1829b();
            m1828a();
        }
    }

    public void setDefaultActionButtonContentDescription(int i) {
        this.f1042p = i;
    }

    public void setExpandActivityOverflowButtonContentDescription(int i) {
        this.f1032f.setContentDescription(getContext().getString(i));
    }

    public void setExpandActivityOverflowButtonDrawable(Drawable drawable) {
        this.f1032f.setImageDrawable(drawable);
    }

    public void setInitialActivityCount(int i) {
        this.f1040n = i;
    }

    public void setOnDismissListener(OnDismissListener onDismissListener) {
        this.f1038l = onDismissListener;
    }

    public void setProvider(C0118a c0118a) {
        this.f1027a = c0118a;
    }
}
