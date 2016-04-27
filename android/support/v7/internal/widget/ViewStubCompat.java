package android.support.v7.internal.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.support.v7.p013b.C0210l;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import java.lang.ref.WeakReference;

public final class ViewStubCompat extends View {
    private int f1054a;
    private int f1055b;
    private WeakReference f1056c;
    private LayoutInflater f1057d;
    private bp f1058e;

    public ViewStubCompat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ViewStubCompat(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f1054a = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0210l.ViewStubCompat, i, 0);
        this.f1055b = obtainStyledAttributes.getResourceId(C0210l.ViewStubCompat_android_inflatedId, -1);
        this.f1054a = obtainStyledAttributes.getResourceId(C0210l.ViewStubCompat_android_layout, 0);
        setId(obtainStyledAttributes.getResourceId(C0210l.ViewStubCompat_android_id, -1));
        obtainStyledAttributes.recycle();
        setVisibility(8);
        setWillNotDraw(true);
    }

    public View m1833a() {
        ViewParent parent = getParent();
        if (parent == null || !(parent instanceof ViewGroup)) {
            throw new IllegalStateException("ViewStub must have a non-null ViewGroup viewParent");
        } else if (this.f1054a != 0) {
            ViewGroup viewGroup = (ViewGroup) parent;
            View inflate = (this.f1057d != null ? this.f1057d : LayoutInflater.from(getContext())).inflate(this.f1054a, viewGroup, false);
            if (this.f1055b != -1) {
                inflate.setId(this.f1055b);
            }
            int indexOfChild = viewGroup.indexOfChild(this);
            viewGroup.removeViewInLayout(this);
            LayoutParams layoutParams = getLayoutParams();
            if (layoutParams != null) {
                viewGroup.addView(inflate, indexOfChild, layoutParams);
            } else {
                viewGroup.addView(inflate, indexOfChild);
            }
            this.f1056c = new WeakReference(inflate);
            if (this.f1058e != null) {
                this.f1058e.m2066a(this, inflate);
            }
            return inflate;
        } else {
            throw new IllegalArgumentException("ViewStub must have a valid layoutResource");
        }
    }

    protected void dispatchDraw(Canvas canvas) {
    }

    public void draw(Canvas canvas) {
    }

    public int getInflatedId() {
        return this.f1055b;
    }

    public LayoutInflater getLayoutInflater() {
        return this.f1057d;
    }

    public int getLayoutResource() {
        return this.f1054a;
    }

    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(0, 0);
    }

    public void setInflatedId(int i) {
        this.f1055b = i;
    }

    public void setLayoutInflater(LayoutInflater layoutInflater) {
        this.f1057d = layoutInflater;
    }

    public void setLayoutResource(int i) {
        this.f1054a = i;
    }

    public void setOnInflateListener(bp bpVar) {
        this.f1058e = bpVar;
    }

    public void setVisibility(int i) {
        if (this.f1056c != null) {
            View view = (View) this.f1056c.get();
            if (view != null) {
                view.setVisibility(i);
                return;
            }
            throw new IllegalStateException("setVisibility called on un-referenced view");
        }
        super.setVisibility(i);
        if (i == 0 || i == 4) {
            m1833a();
        }
    }
}
