package com.pocket.doorway.target;

import android.graphics.Bitmap;
import android.graphics.BlurMaskFilter;
import android.graphics.BlurMaskFilter.Blur;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.pocket.doorway.p019b.C0313a;
import com.pocket.doorway.p019b.C0317f;

/* renamed from: com.pocket.doorway.target.c */
public class C0342c extends Drawable {
    private final float f1583a;
    private final int f1584b;
    private final Paint f1585c;
    private final Paint f1586d;
    private final Paint f1587e;
    private final Paint f1588f;
    private Bitmap f1589g;

    public C0342c() {
        this.f1583a = C0317f.m2336a(1.0f, 20.0f, C0313a.m2331a(5.0f));
        this.f1584b = C0313a.m2333b(28.0f);
        this.f1585c = new Paint(1);
        this.f1586d = new Paint(1);
        this.f1587e = new Paint(1);
        this.f1588f = new Paint(1);
        this.f1586d.setColor(Color.argb(20, 0, 0, 0));
        this.f1586d.setStyle(Style.STROKE);
        this.f1588f.setColor(Color.argb(20, 0, 0, 0));
        this.f1588f.setStyle(Style.FILL);
        this.f1588f.setMaskFilter(new BlurMaskFilter(this.f1583a, Blur.NORMAL));
    }

    public int m2419a() {
        return this.f1584b;
    }

    public void m2420a(int i) {
        this.f1585c.setColor(i);
    }

    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        float exactCenterX = bounds.exactCenterX();
        float exactCenterY = bounds.exactCenterY();
        canvas.drawCircle(exactCenterX, exactCenterY, (float) this.f1584b, this.f1585c);
        canvas.drawCircle(exactCenterX, exactCenterY, (float) this.f1584b, this.f1586d);
        if (this.f1589g != null) {
            canvas.drawBitmap(this.f1589g, exactCenterX - (((float) this.f1589g.getWidth()) / 2.0f), exactCenterY - (((float) this.f1589g.getHeight()) / 2.0f), this.f1587e);
        }
    }

    public int getIntrinsicHeight() {
        return (int) (((float) getIntrinsicWidth()) + (this.f1583a * 2.0f));
    }

    public int getIntrinsicWidth() {
        return (int) (((float) (this.f1584b * 2)) + (this.f1583a * 2.0f));
    }

    public int getOpacity() {
        return -3;
    }

    public void setAlpha(int i) {
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }
}
