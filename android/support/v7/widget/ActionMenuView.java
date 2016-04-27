package android.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.support.v7.internal.view.menu.ActionMenuItemView;
import android.support.v7.internal.view.menu.C0007z;
import android.support.v7.internal.view.menu.C0170y;
import android.support.v7.internal.view.menu.C0193j;
import android.support.v7.internal.view.menu.C0236k;
import android.support.v7.internal.view.menu.C0240i;
import android.support.v7.internal.view.menu.C0248m;
import android.support.v7.internal.widget.bq;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.view.accessibility.AccessibilityEvent;

public class ActionMenuView extends C0260z implements C0236k, C0007z {
    private C0240i f1293a;
    private Context f1294b;
    private Context f1295c;
    private int f1296d;
    private boolean f1297e;
    private C0286a f1298f;
    private C0170y f1299g;
    private C0193j f1300h;
    private boolean f1301i;
    private int f1302j;
    private int f1303k;
    private int f1304l;
    private C0287o f1305m;

    public ActionMenuView(Context context) {
        this(context, null);
    }

    public ActionMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1294b = context;
        setBaselineAligned(false);
        float f = context.getResources().getDisplayMetrics().density;
        this.f1303k = (int) (56.0f * f);
        this.f1304l = (int) (f * 4.0f);
        this.f1295c = context;
        this.f1296d = 0;
    }

    static int m2112a(View view, int i, int i2, int i3, int i4) {
        int i5;
        boolean z = false;
        C0298m c0298m = (C0298m) view.getLayoutParams();
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(MeasureSpec.getSize(i3) - i4, MeasureSpec.getMode(i3));
        ActionMenuItemView actionMenuItemView = view instanceof ActionMenuItemView ? (ActionMenuItemView) view : null;
        boolean z2 = actionMenuItemView != null && actionMenuItemView.m1524b();
        if (i2 <= 0 || (z2 && i2 < 2)) {
            i5 = 0;
        } else {
            view.measure(MeasureSpec.makeMeasureSpec(i * i2, Integer.MIN_VALUE), makeMeasureSpec);
            int measuredWidth = view.getMeasuredWidth();
            i5 = measuredWidth / i;
            if (measuredWidth % i != 0) {
                i5++;
            }
            if (z2 && r1 < 2) {
                i5 = 2;
            }
        }
        if (!c0298m.f1471a && z2) {
            z = true;
        }
        c0298m.f1474d = z;
        c0298m.f1472b = i5;
        view.measure(MeasureSpec.makeMeasureSpec(i5 * i, 1073741824), makeMeasureSpec);
        return i5;
    }

    private void m2115c(int i, int i2) {
        int mode = MeasureSpec.getMode(i2);
        int size = MeasureSpec.getSize(i);
        int size2 = MeasureSpec.getSize(i2);
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int childMeasureSpec = getChildMeasureSpec(i2, paddingTop, -2);
        int i3 = size - paddingLeft;
        int i4 = i3 / this.f1303k;
        size = i3 % this.f1303k;
        if (i4 == 0) {
            setMeasuredDimension(i3, 0);
            return;
        }
        Object obj;
        int i5 = this.f1303k + (size / i4);
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        paddingLeft = 0;
        Object obj2 = null;
        long j = 0;
        int childCount = getChildCount();
        int i9 = 0;
        while (i9 < childCount) {
            int i10;
            long j2;
            int i11;
            int i12;
            int i13;
            View childAt = getChildAt(i9);
            if (childAt.getVisibility() == 8) {
                i10 = paddingLeft;
                j2 = j;
                i11 = i6;
                i12 = i4;
                i4 = i7;
            } else {
                boolean z = childAt instanceof ActionMenuItemView;
                i13 = paddingLeft + 1;
                if (z) {
                    childAt.setPadding(this.f1304l, 0, this.f1304l, 0);
                }
                C0298m c0298m = (C0298m) childAt.getLayoutParams();
                c0298m.f1476f = false;
                c0298m.f1473c = 0;
                c0298m.f1472b = 0;
                c0298m.f1474d = false;
                c0298m.leftMargin = 0;
                c0298m.rightMargin = 0;
                boolean z2 = z && ((ActionMenuItemView) childAt).m1524b();
                c0298m.f1475e = z2;
                int a = m2112a(childAt, i5, c0298m.f1471a ? 1 : i4, childMeasureSpec, paddingTop);
                i7 = Math.max(i7, a);
                paddingLeft = c0298m.f1474d ? i8 + 1 : i8;
                obj = c0298m.f1471a ? 1 : obj2;
                int i14 = i4 - a;
                i8 = Math.max(i6, childAt.getMeasuredHeight());
                if (a == 1) {
                    long j3 = ((long) (1 << i9)) | j;
                    i11 = i8;
                    i12 = i14;
                    i8 = paddingLeft;
                    obj2 = obj;
                    j2 = j3;
                    i4 = i7;
                    i10 = i13;
                } else {
                    i10 = i13;
                    i4 = i7;
                    long j4 = j;
                    i11 = i8;
                    i12 = i14;
                    obj2 = obj;
                    i8 = paddingLeft;
                    j2 = j4;
                }
            }
            i9++;
            i7 = i4;
            i6 = i11;
            i4 = i12;
            j = j2;
            paddingLeft = i10;
        }
        Object obj3 = (obj2 == null || paddingLeft != 2) ? null : 1;
        Object obj4 = null;
        long j5 = j;
        paddingTop = i4;
        while (i8 > 0 && paddingTop > 0) {
            i13 = Integer.MAX_VALUE;
            j = 0;
            i4 = 0;
            int i15 = 0;
            while (i15 < childCount) {
                c0298m = (C0298m) getChildAt(i15).getLayoutParams();
                if (c0298m.f1474d) {
                    int i16 = c0298m.f1472b;
                    if (r0 < i13) {
                        i4 = c0298m.f1472b;
                        j = (long) (1 << i15);
                        size = 1;
                    } else if (c0298m.f1472b == i13) {
                        j |= (long) (1 << i15);
                        size = i4 + 1;
                        i4 = i13;
                    } else {
                        size = i4;
                        i4 = i13;
                    }
                } else {
                    size = i4;
                    i4 = i13;
                }
                i15++;
                i13 = i4;
                i4 = size;
            }
            j5 |= j;
            if (i4 > paddingTop) {
                j = j5;
                break;
            }
            i15 = i13 + 1;
            i13 = 0;
            i4 = paddingTop;
            long j6 = j5;
            while (i13 < childCount) {
                View childAt2 = getChildAt(i13);
                c0298m = (C0298m) childAt2.getLayoutParams();
                if ((((long) (1 << i13)) & j) != 0) {
                    if (obj3 != null && c0298m.f1475e && i4 == 1) {
                        childAt2.setPadding(this.f1304l + i5, 0, this.f1304l, 0);
                    }
                    c0298m.f1472b++;
                    c0298m.f1476f = true;
                    size = i4 - 1;
                } else if (c0298m.f1472b == i15) {
                    j6 |= (long) (1 << i13);
                    size = i4;
                } else {
                    size = i4;
                }
                i13++;
                i4 = size;
            }
            j5 = j6;
            i9 = 1;
            paddingTop = i4;
        }
        j = j5;
        obj = (obj2 == null && paddingLeft == 1) ? 1 : null;
        if (paddingTop <= 0 || j == 0 || (paddingTop >= paddingLeft - 1 && obj == null && i7 <= 1)) {
            obj3 = obj4;
        } else {
            float f;
            View childAt3;
            float bitCount = (float) Long.bitCount(j);
            if (obj == null) {
                if (!((1 & j) == 0 || ((C0298m) getChildAt(0).getLayoutParams()).f1475e)) {
                    bitCount -= 0.5f;
                }
                if (!((((long) (1 << (childCount - 1))) & j) == 0 || ((C0298m) getChildAt(childCount - 1).getLayoutParams()).f1475e)) {
                    f = bitCount - 0.5f;
                    paddingLeft = f <= 0.0f ? (int) (((float) (paddingTop * i5)) / f) : 0;
                    i4 = 0;
                    obj3 = obj4;
                    while (i4 < childCount) {
                        if ((((long) (1 << i4)) & j) != 0) {
                            obj = obj3;
                        } else {
                            childAt3 = getChildAt(i4);
                            c0298m = (C0298m) childAt3.getLayoutParams();
                            if (childAt3 instanceof ActionMenuItemView) {
                                c0298m.f1473c = paddingLeft;
                                c0298m.f1476f = true;
                                if (i4 == 0 && !c0298m.f1475e) {
                                    c0298m.leftMargin = (-paddingLeft) / 2;
                                }
                                obj = 1;
                            } else if (c0298m.f1471a) {
                                if (i4 != 0) {
                                    c0298m.leftMargin = paddingLeft / 2;
                                }
                                if (i4 != childCount - 1) {
                                    c0298m.rightMargin = paddingLeft / 2;
                                }
                                obj = obj3;
                            } else {
                                c0298m.f1473c = paddingLeft;
                                c0298m.f1476f = true;
                                c0298m.rightMargin = (-paddingLeft) / 2;
                                obj = 1;
                            }
                        }
                        i4++;
                        obj3 = obj;
                    }
                }
            }
            f = bitCount;
            if (f <= 0.0f) {
            }
            i4 = 0;
            obj3 = obj4;
            while (i4 < childCount) {
                if ((((long) (1 << i4)) & j) != 0) {
                    childAt3 = getChildAt(i4);
                    c0298m = (C0298m) childAt3.getLayoutParams();
                    if (childAt3 instanceof ActionMenuItemView) {
                        c0298m.f1473c = paddingLeft;
                        c0298m.f1476f = true;
                        c0298m.leftMargin = (-paddingLeft) / 2;
                        obj = 1;
                    } else if (c0298m.f1471a) {
                        if (i4 != 0) {
                            c0298m.leftMargin = paddingLeft / 2;
                        }
                        if (i4 != childCount - 1) {
                            c0298m.rightMargin = paddingLeft / 2;
                        }
                        obj = obj3;
                    } else {
                        c0298m.f1473c = paddingLeft;
                        c0298m.f1476f = true;
                        c0298m.rightMargin = (-paddingLeft) / 2;
                        obj = 1;
                    }
                } else {
                    obj = obj3;
                }
                i4++;
                obj3 = obj;
            }
        }
        if (obj3 != null) {
            for (paddingLeft = 0; paddingLeft < childCount; paddingLeft++) {
                childAt = getChildAt(paddingLeft);
                c0298m = (C0298m) childAt.getLayoutParams();
                if (c0298m.f1476f) {
                    childAt.measure(MeasureSpec.makeMeasureSpec(c0298m.f1473c + (c0298m.f1472b * i5), 1073741824), childMeasureSpec);
                }
            }
        }
        if (mode == 1073741824) {
            i6 = size2;
        }
        setMeasuredDimension(i3, i6);
    }

    public C0298m m2116a(AttributeSet attributeSet) {
        return new C0298m(getContext(), attributeSet);
    }

    protected C0298m m2117a(LayoutParams layoutParams) {
        if (layoutParams == null) {
            return m2125b();
        }
        C0298m c0298m = layoutParams instanceof C0298m ? new C0298m((C0298m) layoutParams) : new C0298m(layoutParams);
        if (c0298m.h > 0) {
            return c0298m;
        }
        c0298m.h = 16;
        return c0298m;
    }

    public void m2118a(C0240i c0240i) {
        this.f1293a = c0240i;
    }

    public void m2119a(C0170y c0170y, C0193j c0193j) {
        this.f1299g = c0170y;
        this.f1300h = c0193j;
    }

    public boolean m2120a() {
        return this.f1297e;
    }

    protected boolean m2121a(int i) {
        boolean z = false;
        if (i == 0) {
            return false;
        }
        View childAt = getChildAt(i - 1);
        View childAt2 = getChildAt(i);
        if (i < getChildCount() && (childAt instanceof C0235k)) {
            z = 0 | ((C0235k) childAt).m1517d();
        }
        return (i <= 0 || !(childAt2 instanceof C0235k)) ? z : ((C0235k) childAt2).m1516c() | z;
    }

    public boolean m2122a(C0248m c0248m) {
        return this.f1293a.m1575a((MenuItem) c0248m, 0);
    }

    public /* synthetic */ aa m2123b(AttributeSet attributeSet) {
        return m2116a(attributeSet);
    }

    protected /* synthetic */ aa m2124b(LayoutParams layoutParams) {
        return m2117a(layoutParams);
    }

    protected C0298m m2125b() {
        C0298m c0298m = new C0298m(-2, -2);
        c0298m.h = 16;
        return c0298m;
    }

    public C0298m m2126c() {
        C0298m b = m2125b();
        b.f1471a = true;
        return b;
    }

    protected boolean checkLayoutParams(LayoutParams layoutParams) {
        return layoutParams != null && (layoutParams instanceof C0298m);
    }

    public C0240i m2127d() {
        return this.f1293a;
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return false;
    }

    public boolean m2128e() {
        return this.f1298f != null && this.f1298f.m2230c();
    }

    public boolean m2129f() {
        return this.f1298f != null && this.f1298f.m2232d();
    }

    public boolean m2130g() {
        return this.f1298f != null && this.f1298f.m2235g();
    }

    protected /* synthetic */ LayoutParams generateDefaultLayoutParams() {
        return m2125b();
    }

    public /* synthetic */ LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return m2116a(attributeSet);
    }

    protected /* synthetic */ LayoutParams generateLayoutParams(LayoutParams layoutParams) {
        return m2117a(layoutParams);
    }

    public Menu getMenu() {
        if (this.f1293a == null) {
            Context context = getContext();
            this.f1293a = new C0240i(context);
            this.f1293a.m1567a(new C0299n());
            this.f1298f = new C0286a(context);
            this.f1298f.m2229c(true);
            this.f1298f.m1643a(this.f1299g != null ? this.f1299g : new C0297l());
            this.f1293a.m1570a(this.f1298f, this.f1295c);
            this.f1298f.m2221a(this);
        }
        return this.f1293a;
    }

    public int getPopupTheme() {
        return this.f1296d;
    }

    public int getWindowAnimations() {
        return 0;
    }

    public boolean m2131h() {
        return this.f1298f != null && this.f1298f.m2236h();
    }

    public void m2132i() {
        if (this.f1298f != null) {
            this.f1298f.m2233e();
        }
    }

    protected /* synthetic */ aa m2133j() {
        return m2125b();
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (VERSION.SDK_INT >= 8) {
            super.onConfigurationChanged(configuration);
        }
        if (this.f1298f != null) {
            this.f1298f.m2227b(false);
            if (this.f1298f.m2235g()) {
                this.f1298f.m2232d();
                this.f1298f.m2230c();
            }
        }
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        m2132i();
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.f1301i) {
            int i5;
            int i6;
            C0298m c0298m;
            int paddingLeft;
            int childCount = getChildCount();
            int i7 = (i4 - i2) / 2;
            int dividerWidth = getDividerWidth();
            int i8 = 0;
            int i9 = 0;
            int paddingRight = ((i3 - i) - getPaddingRight()) - getPaddingLeft();
            Object obj = null;
            boolean a = bq.m2069a(this);
            int i10 = 0;
            while (i10 < childCount) {
                Object obj2;
                View childAt = getChildAt(i10);
                if (childAt.getVisibility() == 8) {
                    obj2 = obj;
                    i5 = i9;
                    i6 = paddingRight;
                    paddingRight = i8;
                } else {
                    c0298m = (C0298m) childAt.getLayoutParams();
                    if (c0298m.f1471a) {
                        i6 = childAt.getMeasuredWidth();
                        if (m2121a(i10)) {
                            i6 += dividerWidth;
                        }
                        int measuredHeight = childAt.getMeasuredHeight();
                        if (a) {
                            paddingLeft = c0298m.leftMargin + getPaddingLeft();
                            i5 = paddingLeft + i6;
                        } else {
                            i5 = (getWidth() - getPaddingRight()) - c0298m.rightMargin;
                            paddingLeft = i5 - i6;
                        }
                        int i11 = i7 - (measuredHeight / 2);
                        childAt.layout(paddingLeft, i11, i5, measuredHeight + i11);
                        i6 = paddingRight - i6;
                        obj2 = 1;
                        i5 = i9;
                        paddingRight = i8;
                    } else {
                        i5 = (childAt.getMeasuredWidth() + c0298m.leftMargin) + c0298m.rightMargin;
                        paddingLeft = i8 + i5;
                        i5 = paddingRight - i5;
                        if (m2121a(i10)) {
                            paddingLeft += dividerWidth;
                        }
                        Object obj3 = obj;
                        i6 = i5;
                        i5 = i9 + 1;
                        paddingRight = paddingLeft;
                        obj2 = obj3;
                    }
                }
                i10++;
                i8 = paddingRight;
                paddingRight = i6;
                i9 = i5;
                obj = obj2;
            }
            if (childCount == 1 && obj == null) {
                View childAt2 = getChildAt(0);
                i6 = childAt2.getMeasuredWidth();
                i5 = childAt2.getMeasuredHeight();
                paddingRight = ((i3 - i) / 2) - (i6 / 2);
                i9 = i7 - (i5 / 2);
                childAt2.layout(paddingRight, i9, i6 + paddingRight, i5 + i9);
                return;
            }
            paddingLeft = i9 - (obj != null ? 0 : 1);
            paddingRight = Math.max(0, paddingLeft > 0 ? paddingRight / paddingLeft : 0);
            View childAt3;
            if (a) {
                i6 = getWidth() - getPaddingRight();
                i5 = 0;
                while (i5 < childCount) {
                    childAt3 = getChildAt(i5);
                    c0298m = (C0298m) childAt3.getLayoutParams();
                    if (childAt3.getVisibility() == 8) {
                        paddingLeft = i6;
                    } else if (c0298m.f1471a) {
                        paddingLeft = i6;
                    } else {
                        i6 -= c0298m.rightMargin;
                        i8 = childAt3.getMeasuredWidth();
                        i10 = childAt3.getMeasuredHeight();
                        dividerWidth = i7 - (i10 / 2);
                        childAt3.layout(i6 - i8, dividerWidth, i6, i10 + dividerWidth);
                        paddingLeft = i6 - ((c0298m.leftMargin + i8) + paddingRight);
                    }
                    i5++;
                    i6 = paddingLeft;
                }
                return;
            }
            i6 = getPaddingLeft();
            i5 = 0;
            while (i5 < childCount) {
                childAt3 = getChildAt(i5);
                c0298m = (C0298m) childAt3.getLayoutParams();
                if (childAt3.getVisibility() == 8) {
                    paddingLeft = i6;
                } else if (c0298m.f1471a) {
                    paddingLeft = i6;
                } else {
                    i6 += c0298m.leftMargin;
                    i8 = childAt3.getMeasuredWidth();
                    i10 = childAt3.getMeasuredHeight();
                    dividerWidth = i7 - (i10 / 2);
                    childAt3.layout(i6, dividerWidth, i6 + i8, i10 + dividerWidth);
                    paddingLeft = ((c0298m.rightMargin + i8) + paddingRight) + i6;
                }
                i5++;
                i6 = paddingLeft;
            }
            return;
        }
        super.onLayout(z, i, i2, i3, i4);
    }

    protected void onMeasure(int i, int i2) {
        boolean z = this.f1301i;
        this.f1301i = MeasureSpec.getMode(i) == 1073741824;
        if (z != this.f1301i) {
            this.f1302j = 0;
        }
        int size = MeasureSpec.getSize(i);
        if (!(!this.f1301i || this.f1293a == null || size == this.f1302j)) {
            this.f1302j = size;
            this.f1293a.m1581b(true);
        }
        int childCount = getChildCount();
        if (!this.f1301i || childCount <= 0) {
            for (int i3 = 0; i3 < childCount; i3++) {
                C0298m c0298m = (C0298m) getChildAt(i3).getLayoutParams();
                c0298m.rightMargin = 0;
                c0298m.leftMargin = 0;
            }
            super.onMeasure(i, i2);
            return;
        }
        m2115c(i, i2);
    }

    public void setExpandedActionViewsExclusive(boolean z) {
        this.f1298f.m2231d(z);
    }

    public void setOnMenuItemClickListener(C0287o c0287o) {
        this.f1305m = c0287o;
    }

    public void setOverflowReserved(boolean z) {
        this.f1297e = z;
    }

    public void setPopupTheme(int i) {
        if (this.f1296d != i) {
            this.f1296d = i;
            if (i == 0) {
                this.f1295c = this.f1294b;
            } else {
                this.f1295c = new ContextThemeWrapper(this.f1294b, i);
            }
        }
    }

    public void setPresenter(C0286a c0286a) {
        this.f1298f = c0286a;
        this.f1298f.m2221a(this);
    }
}
