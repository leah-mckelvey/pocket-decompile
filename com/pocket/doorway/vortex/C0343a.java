package com.pocket.doorway.vortex;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import com.pocket.doorway.p019b.C0313a;

/* renamed from: com.pocket.doorway.vortex.a */
public class C0343a extends Drawable {
    private final C0346d f1598a;
    private final C0345c f1599b;
    private final C0345c f1600c;
    private boolean f1601d;
    private boolean f1602e;

    public C0343a(int i) {
        this.f1598a = new C0346d();
        this.f1599b = new C0345c();
        this.f1600c = new C0345c();
        this.f1598a.m2433a(true);
        this.f1598a.m2432a(i);
        this.f1599b.m2426a(C0313a.m2331a(74.666664f));
        this.f1599b.m2428a(i);
        this.f1600c.m2426a(C0313a.m2331a(33.333332f));
        this.f1600c.m2428a(i);
    }

    public void m2423a() {
        this.f1602e = false;
        invalidateSelf();
    }

    public void m2424a(float f, float f2, float f3, float f4) {
        this.f1599b.m2427a(f, f2);
        this.f1600c.m2427a(f3, f4);
        this.f1598a.m2431a(f, f2, f3, f4);
        this.f1601d = true;
        this.f1602e = true;
        invalidateSelf();
    }

    public void draw(Canvas canvas) {
        if (this.f1601d && this.f1602e) {
            this.f1598a.draw(canvas);
            this.f1599b.draw(canvas);
            this.f1600c.draw(canvas);
            invalidateSelf();
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
