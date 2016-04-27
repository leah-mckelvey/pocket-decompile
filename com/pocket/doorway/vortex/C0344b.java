package com.pocket.doorway.vortex;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

/* renamed from: com.pocket.doorway.vortex.b */
public class C0344b extends Drawable {
    private final Paint f1603a;
    private final int f1604b;

    public C0344b(int i, int i2) {
        this.f1603a = new Paint(1);
        this.f1603a.setStyle(Style.FILL);
        this.f1603a.setColor(i);
        this.f1604b = i2;
    }

    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        canvas.drawCircle(bounds.exactCenterX(), bounds.exactCenterY(), Math.min(((float) bounds.width()) / 2.0f, ((float) bounds.height()) / 2.0f), this.f1603a);
    }

    public int getIntrinsicHeight() {
        return this.f1604b;
    }

    public int getIntrinsicWidth() {
        return this.f1604b;
    }

    public int getOpacity() {
        return -3;
    }

    public void setAlpha(int i) {
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }
}
