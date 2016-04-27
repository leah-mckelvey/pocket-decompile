package android.support.v7.internal.widget;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;

/* renamed from: android.support.v7.internal.widget.g */
class C0267g extends Drawable {
    final ActionBarContainer f1256a;

    public C0267g(ActionBarContainer actionBarContainer) {
        this.f1256a = actionBarContainer;
    }

    public void draw(Canvas canvas) {
        if (!this.f1256a.f948d) {
            if (this.f1256a.f945a != null) {
                this.f1256a.f945a.draw(canvas);
            }
            if (this.f1256a.f946b != null && this.f1256a.f949e) {
                this.f1256a.f946b.draw(canvas);
            }
        } else if (this.f1256a.f947c != null) {
            this.f1256a.f947c.draw(canvas);
        }
    }

    public int getOpacity() {
        return 0;
    }

    public void setAlpha(int i) {
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }
}
