package android.support.v7.internal.widget;

import android.graphics.Outline;

/* renamed from: android.support.v7.internal.widget.h */
class C0268h extends C0267g {
    public C0268h(ActionBarContainer actionBarContainer) {
        super(actionBarContainer);
    }

    public void getOutline(Outline outline) {
        if (this.a.f948d) {
            if (this.a.f947c != null) {
                this.a.f947c.getOutline(outline);
            }
        } else if (this.a.f945a != null) {
            this.a.f945a.getOutline(outline);
        }
    }
}
