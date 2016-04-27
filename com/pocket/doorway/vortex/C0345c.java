package com.pocket.doorway.vortex;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import java.util.Random;

/* renamed from: com.pocket.doorway.vortex.c */
public class C0345c extends Drawable {
    private static final Random f1605a;
    private final Paint f1606b;
    private final PointF f1607c;
    private int f1608d;
    private float f1609e;

    static {
        f1605a = new Random();
    }

    public C0345c() {
        this.f1606b = new Paint(1);
        this.f1607c = new PointF();
        this.f1606b.setStyle(Style.FILL);
    }

    private float m2425b(float f, float f2) {
        float nextFloat = f - ((f * f2) * f1605a.nextFloat());
        return nextFloat <= 0.0f ? f : nextFloat;
    }

    public void m2426a(float f) {
        this.f1609e = f;
    }

    public void m2427a(float f, float f2) {
        this.f1607c.set(f, f2);
    }

    public void m2428a(int i) {
        this.f1608d = i;
    }

    public void draw(Canvas canvas) {
        if (this.f1609e > 0.0f) {
            float b = m2425b(this.f1609e, 0.1f);
            this.f1606b.setColor(Color.argb(Math.min(255, Math.max(0, (int) (m2425b(0.2f, 0.1f) * 255.0f))), Color.red(this.f1608d), Color.green(this.f1608d), Color.blue(this.f1608d)));
            canvas.drawCircle(this.f1607c.x, this.f1607c.y, b, this.f1606b);
        }
    }

    public int getOpacity() {
        return -3;
    }

    public void setAlpha(int i) {
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }
}
