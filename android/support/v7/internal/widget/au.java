package android.support.v7.internal.widget;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.support.v4.p000h.C0121d;
import android.support.v7.p013b.C0210l;
import android.support.v7.widget.ag;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.widget.Adapter;
import android.widget.SpinnerAdapter;
import com.pocket.doorway.C0339o;

class au extends C0262c implements OnClickListener {
    int f1140E;
    private ag f1141F;
    private bd f1142G;
    private ay f1143H;
    private int f1144I;
    private boolean f1145J;
    private Rect f1146K;
    private final bi f1147L;

    au(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, -1);
    }

    au(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i);
        this.f1146K = new Rect();
        bk a = bk.m2000a(context, attributeSet, C0210l.Spinner, i, 0);
        if (a.m2015e(C0210l.Spinner_android_background)) {
            setBackgroundDrawable(a.m2004a(C0210l.Spinner_android_background));
        }
        if (i2 == -1) {
            i2 = a.m2003a(C0210l.Spinner_spinnerMode, 0);
        }
        switch (i2) {
            case C0339o.View_android_theme /*0*/:
                this.f1142G = new ax();
                break;
            case C0339o.View_android_focusable /*1*/:
                Object azVar = new az(this, context, attributeSet, i);
                this.f1140E = a.m2014e(C0210l.Spinner_android_dropDownWidth, -2);
                azVar.m1946a(a.m2004a(C0210l.Spinner_android_popupBackground));
                this.f1142G = azVar;
                this.f1141F = new av(this, this, azVar);
                break;
        }
        this.f1144I = a.m2003a(C0210l.Spinner_android_gravity, 17);
        this.f1142G.m1929a(a.m2013d(C0210l.Spinner_prompt));
        this.f1145J = a.m2005a(C0210l.Spinner_disableChildrenWhenDisabled, false);
        a.m2008b();
        if (this.f1143H != null) {
            this.f1142G.m1928a(this.f1143H);
            this.f1143H = null;
        }
        this.f1147L = a.m2010c();
    }

    private void m1919a(View view, boolean z) {
        LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = generateDefaultLayoutParams();
        }
        if (z) {
            addViewInLayout(view, 0, layoutParams);
        }
        view.setSelected(hasFocus());
        if (this.f1145J) {
            view.setEnabled(isEnabled());
        }
        view.measure(ViewGroup.getChildMeasureSpec(this.c, this.h.left + this.h.right, layoutParams.width), ViewGroup.getChildMeasureSpec(this.b, this.h.top + this.h.bottom, layoutParams.height));
        int measuredHeight = this.h.top + ((((getMeasuredHeight() - this.h.bottom) - this.h.top) - view.getMeasuredHeight()) / 2);
        view.layout(0, measuredHeight, view.getMeasuredWidth() + 0, view.getMeasuredHeight() + measuredHeight);
    }

    private View m1920c(int i, boolean z) {
        View a;
        if (!this.u) {
            a = this.i.m2071a(i);
            if (a != null) {
                m1919a(a, z);
                return a;
            }
        }
        a = this.a.getView(i, null, this);
        m1919a(a, z);
        return a;
    }

    int m1921a(SpinnerAdapter spinnerAdapter, Drawable drawable) {
        if (spinnerAdapter == null) {
            return 0;
        }
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(0, 0);
        int makeMeasureSpec2 = MeasureSpec.makeMeasureSpec(0, 0);
        int max = Math.max(0, getSelectedItemPosition());
        int min = Math.min(spinnerAdapter.getCount(), max + 15);
        int max2 = Math.max(0, max - (15 - (min - max)));
        View view = null;
        int i = 0;
        max = 0;
        while (max2 < min) {
            View view2;
            int itemViewType = spinnerAdapter.getItemViewType(max2);
            if (itemViewType != max) {
                view2 = null;
            } else {
                itemViewType = max;
                view2 = view;
            }
            view = spinnerAdapter.getView(max2, view2, this);
            if (view.getLayoutParams() == null) {
                view.setLayoutParams(new LayoutParams(-2, -2));
            }
            view.measure(makeMeasureSpec, makeMeasureSpec2);
            i = Math.max(i, view.getMeasuredWidth());
            max2++;
            max = itemViewType;
        }
        if (drawable == null) {
            return i;
        }
        drawable.getPadding(this.f1146K);
        return (this.f1146K.left + this.f1146K.right) + i;
    }

    void m1922a(int i, boolean z) {
        int i2 = this.h.left;
        int right = ((getRight() - getLeft()) - this.h.left) - this.h.right;
        if (this.u) {
            m1905g();
        }
        if (this.z == 0) {
            m1912a();
            return;
        }
        if (this.v >= 0) {
            setSelectedPositionInt(this.v);
        }
        m1916b();
        removeAllViewsInLayout();
        this.j = this.x;
        if (this.a != null) {
            View c = m1920c(this.x, true);
            int measuredWidth = c.getMeasuredWidth();
            switch (C0121d.m939a(this.f1144I, android.support.v4.p000h.au.m683a(this)) & 7) {
                case C0339o.View_android_focusable /*1*/:
                    i2 = (i2 + (right / 2)) - (measuredWidth / 2);
                    break;
                case C0339o.View_backgroundTint /*5*/:
                    i2 = (i2 + right) - measuredWidth;
                    break;
            }
            c.offsetLeftAndRight(i2);
        }
        this.i.m2072a();
        invalidate();
        m1906h();
        this.u = false;
        this.o = false;
        setNextSelectedPositionInt(this.x);
    }

    void m1923a(ab abVar) {
        super.setOnItemClickListener(abVar);
    }

    public void m1924a(SpinnerAdapter spinnerAdapter) {
        super.m1914a(spinnerAdapter);
        this.i.m2072a();
        if (getContext().getApplicationInfo().targetSdkVersion >= 21 && spinnerAdapter != null && spinnerAdapter.getViewTypeCount() != 1) {
            throw new IllegalArgumentException("Spinner adapter view type count must be 1");
        } else if (this.f1142G != null) {
            this.f1142G.m1928a(new ay(spinnerAdapter));
        } else {
            this.f1143H = new ay(spinnerAdapter);
        }
    }

    public int getBaseline() {
        View view = null;
        if (getChildCount() > 0) {
            view = getChildAt(0);
        } else if (this.a != null && this.a.getCount() > 0) {
            view = m1920c(0, false);
            this.i.m2073a(0, view);
        }
        if (view == null) {
            return -1;
        }
        int baseline = view.getBaseline();
        return baseline >= 0 ? view.getTop() + baseline : -1;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        setSelection(i);
        dialogInterface.dismiss();
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f1142G != null && this.f1142G.m1930b()) {
            this.f1142G.m1927a();
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.q = true;
        m1922a(0, false);
        this.q = false;
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.f1142G != null && MeasureSpec.getMode(i) == Integer.MIN_VALUE) {
            setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), m1921a(m1917c(), getBackground())), MeasureSpec.getSize(i)), getMeasuredHeight());
        }
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        bb bbVar = (bb) parcelable;
        super.onRestoreInstanceState(bbVar.getSuperState());
        if (bbVar.f1197c) {
            ViewTreeObserver viewTreeObserver = getViewTreeObserver();
            if (viewTreeObserver != null) {
                viewTreeObserver.addOnGlobalLayoutListener(new aw(this));
            }
        }
    }

    public Parcelable onSaveInstanceState() {
        Parcelable bbVar = new bb(super.onSaveInstanceState());
        boolean z = this.f1142G != null && this.f1142G.m1930b();
        bbVar.f1197c = z;
        return bbVar;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return (this.f1141F == null || !this.f1141F.onTouch(this, motionEvent)) ? super.onTouchEvent(motionEvent) : true;
    }

    public boolean performClick() {
        boolean performClick = super.performClick();
        if (!performClick) {
            performClick = true;
            if (!this.f1142G.m1930b()) {
                this.f1142G.m1931c();
            }
        }
        return performClick;
    }

    public /* synthetic */ void setAdapter(Adapter adapter) {
        m1924a((SpinnerAdapter) adapter);
    }

    public void setEnabled(boolean z) {
        super.setEnabled(z);
        if (this.f1145J) {
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                getChildAt(i).setEnabled(z);
            }
        }
    }

    public void setOnItemClickListener(ab abVar) {
        throw new RuntimeException("setOnItemClickListener cannot be used with a spinner.");
    }
}
