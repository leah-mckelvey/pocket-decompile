package android.support.v4.p003c.p004a;

import android.content.res.Resources.Theme;
import android.graphics.Outline;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

/* renamed from: android.support.v4.c.a.q */
class C0089q extends C0088p {
    C0089q(Drawable drawable) {
        super(drawable);
    }

    public void applyTheme(Theme theme) {
        this.b.applyTheme(theme);
    }

    public boolean canApplyTheme() {
        return this.b.canApplyTheme();
    }

    public Rect getDirtyBounds() {
        return this.b.getDirtyBounds();
    }

    public void getOutline(Outline outline) {
        this.b.getOutline(outline);
    }

    public void setHotspot(float f, float f2) {
        this.b.setHotspot(f, f2);
    }

    public void setHotspotBounds(int i, int i2, int i3, int i4) {
        this.b.setHotspotBounds(i, i2, i3, i4);
    }
}
