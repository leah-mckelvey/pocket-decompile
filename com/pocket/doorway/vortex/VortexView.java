package com.pocket.doorway.vortex;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.pocket.doorway.C0339o;
import com.pocket.doorway.p019b.C0313a;

public class VortexView extends RelativeLayout {
    private final int f1590a;
    private int f1591b;
    private ImageView f1592c;
    private ImageView f1593d;
    private View f1594e;
    private C0343a f1595f;
    private int f1596g;
    private C0347e f1597h;

    public VortexView(Context context) {
        super(context);
        this.f1590a = C0313a.m2333b(100.0f);
        m2421a(null);
    }

    public VortexView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1590a = C0313a.m2333b(100.0f);
        m2421a(attributeSet);
    }

    public VortexView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f1590a = C0313a.m2333b(100.0f);
        m2421a(attributeSet);
    }

    @TargetApi(21)
    public VortexView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.f1590a = C0313a.m2333b(100.0f);
        m2421a(attributeSet);
    }

    private void m2421a(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, C0339o.TargetView);
            this.f1591b = obtainStyledAttributes.getColor(0, 0);
            obtainStyledAttributes.recycle();
        }
        this.f1592c = new ImageView(getContext());
        this.f1592c.setImageDrawable(new C0344b(this.f1591b, this.f1590a));
        this.f1592c.setAlpha(0.25f);
        addView(this.f1592c);
        this.f1593d = new ImageView(getContext());
        this.f1593d.setImageDrawable(new C0344b(this.f1591b, this.f1590a));
        addView(this.f1593d);
        this.f1595f = new C0343a(this.f1591b);
        this.f1594e = new View(getContext());
        this.f1594e.setBackgroundDrawable(this.f1595f);
        this.f1595f.setCallback(this.f1594e);
        addView(this.f1594e, new LayoutParams(-1, -1));
    }

    public void m2422a(C0347e c0347e) {
        this.f1597h = c0347e;
        if (this.f1597h != null && this.f1596g != 0) {
            float f = ((float) this.f1590a) / 2.0f;
            this.f1592c.setX((c0347e.m2445g() * ((float) getWidth())) - f);
            this.f1592c.setY((c0347e.m2446h() * ((float) getHeight())) - f);
            this.f1593d.setX((c0347e.m2445g() * ((float) getWidth())) - f);
            this.f1593d.setY((c0347e.m2446h() * ((float) getHeight())) - f);
            f = (c0347e.m2449k() * ((float) this.f1596g)) / ((float) this.f1590a);
            this.f1592c.setScaleX(f);
            this.f1592c.setScaleY(f);
            f = (c0347e.m2453o() * ((float) this.f1596g)) / ((float) this.f1590a);
            this.f1593d.setScaleX(f);
            this.f1593d.setScaleY(f);
            if (c0347e.m2451m()) {
                this.f1595f.m2424a(c0347e.m2445g() * ((float) getWidth()), c0347e.m2446h() * ((float) getHeight()), c0347e.m2447i(), c0347e.m2448j());
            } else {
                this.f1595f.m2423a();
            }
        }
    }

    public int getColor() {
        return this.f1591b;
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.f1596g = Math.max(i, i2);
        m2422a(this.f1597h);
    }
}
