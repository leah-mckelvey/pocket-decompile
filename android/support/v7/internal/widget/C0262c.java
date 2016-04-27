package android.support.v7.internal.widget;

import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.os.Parcelable;
import android.support.v4.p000h.au;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.widget.Adapter;
import android.widget.SpinnerAdapter;

/* renamed from: android.support.v7.internal.widget.c */
abstract class C0262c extends C0261y {
    private DataSetObserver f1130E;
    SpinnerAdapter f1131a;
    int f1132b;
    int f1133c;
    int f1134d;
    int f1135e;
    int f1136f;
    int f1137g;
    final Rect f1138h;
    final C0265d f1139i;

    C0262c(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f1134d = 0;
        this.f1135e = 0;
        this.f1136f = 0;
        this.f1137g = 0;
        this.f1138h = new Rect();
        this.f1139i = new C0265d(this);
        m1910k();
    }

    private void m1910k() {
        setFocusable(true);
        setWillNotDraw(false);
    }

    int m1911a(View view) {
        return view.getMeasuredHeight();
    }

    void m1912a() {
        this.u = false;
        this.o = false;
        removeAllViewsInLayout();
        this.B = -1;
        this.C = Long.MIN_VALUE;
        setSelectedPositionInt(-1);
        setNextSelectedPositionInt(-1);
        invalidate();
    }

    abstract void m1913a(int i, boolean z);

    public void m1914a(SpinnerAdapter spinnerAdapter) {
        int i = -1;
        if (this.f1131a != null) {
            this.f1131a.unregisterDataSetObserver(this.f1130E);
            m1912a();
        }
        this.f1131a = spinnerAdapter;
        this.B = -1;
        this.C = Long.MIN_VALUE;
        if (this.f1131a != null) {
            this.A = this.z;
            this.z = this.f1131a.getCount();
            m1903e();
            this.f1130E = new aa(this);
            this.f1131a.registerDataSetObserver(this.f1130E);
            if (this.z > 0) {
                i = 0;
            }
            setSelectedPositionInt(i);
            setNextSelectedPositionInt(i);
            if (this.z == 0) {
                m1906h();
            }
        } else {
            m1903e();
            m1912a();
            m1906h();
        }
        requestLayout();
    }

    int m1915b(View view) {
        return view.getMeasuredWidth();
    }

    void m1916b() {
        int childCount = getChildCount();
        C0265d c0265d = this.f1139i;
        int i = this.j;
        for (int i2 = 0; i2 < childCount; i2++) {
            c0265d.m2073a(i + i2, getChildAt(i2));
        }
    }

    public SpinnerAdapter m1917c() {
        return this.f1131a;
    }

    protected LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -2);
    }

    public /* synthetic */ Adapter getAdapter() {
        return m1917c();
    }

    public int getCount() {
        return this.z;
    }

    public View getSelectedView() {
        return (this.z <= 0 || this.x < 0) ? null : getChildAt(this.x - this.j);
    }

    protected void onMeasure(int i, int i2) {
        boolean z;
        int mode = MeasureSpec.getMode(i);
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        Rect rect = this.f1138h;
        if (paddingLeft <= this.f1134d) {
            paddingLeft = this.f1134d;
        }
        rect.left = paddingLeft;
        this.f1138h.top = paddingTop > this.f1135e ? paddingTop : this.f1135e;
        this.f1138h.right = paddingRight > this.f1136f ? paddingRight : this.f1136f;
        this.f1138h.bottom = paddingBottom > this.f1137g ? paddingBottom : this.f1137g;
        if (this.u) {
            m1905g();
        }
        paddingTop = getSelectedItemPosition();
        if (paddingTop >= 0 && this.f1131a != null && paddingTop < this.f1131a.getCount()) {
            View a = this.f1139i.m2071a(paddingTop);
            if (a == null) {
                a = this.f1131a.getView(paddingTop, null, this);
            }
            if (a != null) {
                this.f1139i.m2073a(paddingTop, a);
                if (a.getLayoutParams() == null) {
                    this.D = true;
                    a.setLayoutParams(generateDefaultLayoutParams());
                    this.D = false;
                }
                measureChild(a, i, i2);
                paddingTop = (m1911a(a) + this.f1138h.top) + this.f1138h.bottom;
                paddingLeft = (m1915b(a) + this.f1138h.left) + this.f1138h.right;
                z = false;
                if (z) {
                    paddingTop = this.f1138h.top + this.f1138h.bottom;
                    if (mode == 0) {
                        paddingLeft = this.f1138h.left + this.f1138h.right;
                    }
                }
                setMeasuredDimension(au.m682a(Math.max(paddingLeft, getSuggestedMinimumWidth()), i, 0), au.m682a(Math.max(paddingTop, getSuggestedMinimumHeight()), i2, 0));
                this.f1132b = i2;
                this.f1133c = i;
            }
        }
        z = true;
        paddingLeft = 0;
        paddingTop = 0;
        if (z) {
            paddingTop = this.f1138h.top + this.f1138h.bottom;
            if (mode == 0) {
                paddingLeft = this.f1138h.left + this.f1138h.right;
            }
        }
        setMeasuredDimension(au.m682a(Math.max(paddingLeft, getSuggestedMinimumWidth()), i, 0), au.m682a(Math.max(paddingTop, getSuggestedMinimumHeight()), i2, 0));
        this.f1132b = i2;
        this.f1133c = i;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        C0264e c0264e = (C0264e) parcelable;
        super.onRestoreInstanceState(c0264e.getSuperState());
        if (c0264e.f1195a >= 0) {
            this.u = true;
            this.o = true;
            this.m = c0264e.f1195a;
            this.l = c0264e.f1196b;
            this.p = 0;
            requestLayout();
        }
    }

    public Parcelable onSaveInstanceState() {
        Object c0264e = new C0264e(super.onSaveInstanceState());
        c0264e.f1195a = getSelectedItemId();
        if (c0264e.f1195a >= 0) {
            c0264e.f1196b = getSelectedItemPosition();
        } else {
            c0264e.f1196b = -1;
        }
        return c0264e;
    }

    public void requestLayout() {
        if (!this.D) {
            super.requestLayout();
        }
    }

    public /* synthetic */ void setAdapter(Adapter adapter) {
        m1914a((SpinnerAdapter) adapter);
    }

    public void setSelection(int i) {
        setNextSelectedPositionInt(i);
        requestLayout();
        invalidate();
    }
}
