package android.support.v7.internal.widget;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.v7.p014c.p015a.C0211a;

class am extends C0211a {
    private boolean f1074a;

    public am(Drawable drawable) {
        super(drawable);
        this.f1074a = true;
    }

    void m1874a(boolean z) {
        this.f1074a = z;
    }

    public void draw(Canvas canvas) {
        if (this.f1074a) {
            super.draw(canvas);
        }
    }

    public void setHotspot(float f, float f2) {
        if (this.f1074a) {
            super.setHotspot(f, f2);
        }
    }

    public void setHotspotBounds(int i, int i2, int i3, int i4) {
        if (this.f1074a) {
            super.setHotspotBounds(i, i2, i3, i4);
        }
    }

    public boolean setState(int[] iArr) {
        return this.f1074a ? super.setState(iArr) : false;
    }

    public boolean setVisible(boolean z, boolean z2) {
        return this.f1074a ? super.setVisible(z, z2) : false;
    }
}
