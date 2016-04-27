package com.pocket.doorway.target;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.pocket.doorway.C0339o;

public class TargetView extends ImageView {
    private C0342c f1572a;
    private int f1573b;

    public TargetView(Context context) {
        super(context);
        this.f1573b = 0;
        m2390a(null);
    }

    public TargetView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1573b = 0;
        m2390a(attributeSet);
    }

    public TargetView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f1573b = 0;
        m2390a(attributeSet);
    }

    @TargetApi(21)
    public TargetView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.f1573b = 0;
        m2390a(attributeSet);
    }

    private void m2390a(AttributeSet attributeSet) {
        this.f1572a = new C0342c();
        this.f1572a.setBounds(0, 0, this.f1572a.getIntrinsicWidth(), this.f1572a.getIntrinsicHeight());
        setImageDrawable(this.f1572a);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, C0339o.TargetView);
            this.f1573b = obtainStyledAttributes.getColor(0, 0);
            obtainStyledAttributes.recycle();
        }
        this.f1572a.m2420a(this.f1573b);
    }

    public void m2391a(C0340a c0340a) {
        if (c0340a.m2413h()) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        setX(c0340a.m2408c() - (((float) this.f1572a.getIntrinsicWidth()) / 2.0f));
        setY(c0340a.m2409d() - (((float) this.f1572a.getIntrinsicHeight()) / 2.0f));
        float g = c0340a.m2412g() / ((float) this.f1572a.m2419a());
        setScaleX(g);
        setScaleY(g);
    }

    public int getColor() {
        return this.f1573b;
    }

    public C0342c getDrawable() {
        return this.f1572a;
    }
}
