package android.support.v4.p000h.p010a;

import android.view.animation.Interpolator;

/* renamed from: android.support.v4.h.a.b */
abstract class C0116b implements Interpolator {
    private final float[] f385a;
    private final float f386b;

    public C0116b(float[] fArr) {
        this.f385a = fArr;
        this.f386b = 1.0f / ((float) (this.f385a.length - 1));
    }

    public float getInterpolation(float f) {
        if (f >= 1.0f) {
            return 1.0f;
        }
        if (f <= 0.0f) {
            return 0.0f;
        }
        int min = Math.min((int) (((float) (this.f385a.length - 1)) * f), this.f385a.length - 2);
        float f2 = (f - (((float) min) * this.f386b)) / this.f386b;
        return ((this.f385a[min + 1] - this.f385a[min]) * f2) + this.f385a[min];
    }
}
