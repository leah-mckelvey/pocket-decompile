package com.pocket.doorway.vortex;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.pocket.doorway.p019b.C0313a;
import java.util.Random;

/* renamed from: com.pocket.doorway.vortex.d */
public class C0346d extends Drawable {
    private static final Random f1610a;
    private final Paint f1611b;
    private final Path f1612c;
    private final PathMeasure f1613d;
    private final float[] f1614e;
    private final RectF f1615f;
    private boolean f1616g;

    static {
        f1610a = new Random();
    }

    public C0346d() {
        this.f1611b = new Paint(1);
        this.f1612c = new Path();
        this.f1613d = new PathMeasure(this.f1612c, false);
        this.f1614e = new float[2];
        this.f1615f = new RectF();
        this.f1611b.setStyle(Style.STROKE);
        this.f1611b.setStrokeWidth(C0313a.m2331a(2.0f));
    }

    private float m2429a(float f) {
        return (float) (((double) f) + ((((double) f1610a.nextFloat()) - 0.5d) * ((double) C0313a.m2331a(this.f1616g ? 14.0f : 7.0f))));
    }

    private void m2430a() {
        this.f1613d.setPath(this.f1612c, false);
    }

    public void m2431a(float f, float f2, float f3, float f4) {
        this.f1612c.rewind();
        this.f1612c.moveTo(f, f2);
        this.f1612c.lineTo(f3, f4);
        m2430a();
    }

    public void m2432a(int i) {
        this.f1611b.setColor(i);
    }

    public void m2433a(boolean z) {
        this.f1616g = z;
    }

    public void draw(Canvas canvas) {
        float length = this.f1613d.getLength();
        float f = length / 11.0f;
        this.f1613d.getPosTan(0.0f, this.f1614e, null);
        float f2 = this.f1614e[0];
        float f3 = this.f1614e[1];
        int i = 1;
        while (i < 10) {
            this.f1613d.getPosTan(((float) i) * f, this.f1614e, null);
            float a = m2429a(this.f1614e[0]);
            float a2 = m2429a(this.f1614e[1]);
            canvas.drawLine(f2, f3, a, a2, this.f1611b);
            i++;
            f3 = a2;
            f2 = a;
        }
        this.f1613d.getPosTan(length, this.f1614e, null);
        canvas.drawLine(f2, f3, this.f1614e[0], this.f1614e[1], this.f1611b);
        invalidateSelf();
    }

    public int getOpacity() {
        return -3;
    }

    public void setAlpha(int i) {
        this.f1611b.setAlpha(i);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f1611b.setColorFilter(colorFilter);
    }
}
