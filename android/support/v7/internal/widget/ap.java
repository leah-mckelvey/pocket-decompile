package android.support.v7.internal.widget;

import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.support.v7.internal.view.C0224a;
import android.support.v7.p011a.C0175d;
import android.support.v7.p013b.C0200b;
import android.support.v7.widget.C0260z;
import android.support.v7.widget.aa;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.AbsListView.LayoutParams;
import android.widget.HorizontalScrollView;

public class ap extends HorizontalScrollView implements ab {
    private static final Interpolator f1084j;
    Runnable f1085a;
    int f1086b;
    int f1087c;
    private as f1088d;
    private C0260z f1089e;
    private au f1090f;
    private boolean f1091g;
    private int f1092h;
    private int f1093i;

    static {
        f1084j = new DecelerateInterpolator();
    }

    private at m1882a(C0175d c0175d, boolean z) {
        at atVar = new at(this, getContext(), c0175d, z);
        if (z) {
            atVar.setBackgroundDrawable(null);
            atVar.setLayoutParams(new LayoutParams(-1, this.f1092h));
        } else {
            atVar.setFocusable(true);
            if (this.f1088d == null) {
                this.f1088d = new as();
            }
            atVar.setOnClickListener(this.f1088d);
        }
        return atVar;
    }

    private boolean m1885a() {
        return this.f1090f != null && this.f1090f.getParent() == this;
    }

    private void m1886b() {
        if (!m1885a()) {
            if (this.f1090f == null) {
                this.f1090f = m1888d();
            }
            removeView(this.f1089e);
            addView(this.f1090f, new ViewGroup.LayoutParams(-2, -1));
            if (this.f1090f.m1917c() == null) {
                this.f1090f.m1924a(new ar());
            }
            if (this.f1085a != null) {
                removeCallbacks(this.f1085a);
                this.f1085a = null;
            }
            this.f1090f.setSelection(this.f1093i);
        }
    }

    private boolean m1887c() {
        if (m1885a()) {
            removeView(this.f1090f);
            addView(this.f1089e, new ViewGroup.LayoutParams(-2, -1));
            setTabSelected(this.f1090f.getSelectedItemPosition());
        }
        return false;
    }

    private au m1888d() {
        au auVar = new au(getContext(), null, C0200b.actionDropDownStyle);
        auVar.setLayoutParams(new aa(-2, -1));
        auVar.m1923a((ab) this);
        return auVar;
    }

    public void m1889a(int i) {
        View childAt = this.f1089e.getChildAt(i);
        if (this.f1085a != null) {
            removeCallbacks(this.f1085a);
        }
        this.f1085a = new aq(this, childAt);
        post(this.f1085a);
    }

    public void m1890a(C0261y c0261y, View view, int i, long j) {
        ((at) view).m1893b().m1187d();
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f1085a != null) {
            post(this.f1085a);
        }
    }

    protected void onConfigurationChanged(Configuration configuration) {
        if (VERSION.SDK_INT >= 8) {
            super.onConfigurationChanged(configuration);
        }
        C0224a a = C0224a.m1450a(getContext());
        setContentHeight(a.m1455e());
        this.f1087c = a.m1457g();
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f1085a != null) {
            removeCallbacks(this.f1085a);
        }
    }

    public void onMeasure(int i, int i2) {
        int i3 = 1;
        int mode = MeasureSpec.getMode(i);
        boolean z = mode == 1073741824;
        setFillViewport(z);
        int childCount = this.f1089e.getChildCount();
        if (childCount <= 1 || !(mode == 1073741824 || mode == Integer.MIN_VALUE)) {
            this.f1086b = -1;
        } else {
            if (childCount > 2) {
                this.f1086b = (int) (((float) MeasureSpec.getSize(i)) * 0.4f);
            } else {
                this.f1086b = MeasureSpec.getSize(i) / 2;
            }
            this.f1086b = Math.min(this.f1086b, this.f1087c);
        }
        mode = MeasureSpec.makeMeasureSpec(this.f1092h, 1073741824);
        if (z || !this.f1091g) {
            i3 = 0;
        }
        if (i3 != 0) {
            this.f1089e.measure(0, mode);
            if (this.f1089e.getMeasuredWidth() > MeasureSpec.getSize(i)) {
                m1886b();
            } else {
                m1887c();
            }
        } else {
            m1887c();
        }
        i3 = getMeasuredWidth();
        super.onMeasure(i, mode);
        int measuredWidth = getMeasuredWidth();
        if (z && i3 != measuredWidth) {
            setTabSelected(this.f1093i);
        }
    }

    public void setAllowCollapse(boolean z) {
        this.f1091g = z;
    }

    public void setContentHeight(int i) {
        this.f1092h = i;
        requestLayout();
    }

    public void setTabSelected(int i) {
        this.f1093i = i;
        int childCount = this.f1089e.getChildCount();
        int i2 = 0;
        while (i2 < childCount) {
            View childAt = this.f1089e.getChildAt(i2);
            boolean z = i2 == i;
            childAt.setSelected(z);
            if (z) {
                m1889a(i);
            }
            i2++;
        }
        if (this.f1090f != null && i >= 0) {
            this.f1090f.setSelection(i);
        }
    }
}
