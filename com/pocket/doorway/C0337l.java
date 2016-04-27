package com.pocket.doorway;

import android.view.animation.DecelerateInterpolator;
import android.widget.TextView;

/* renamed from: com.pocket.doorway.l */
class C0337l implements C0335j {
    final /* synthetic */ GameActivity f1570a;

    private C0337l(GameActivity gameActivity) {
        this.f1570a = gameActivity;
    }

    private boolean m2387b() {
        return this.f1570a.f1514r == this;
    }

    public void m2388a() {
        if (m2387b()) {
            this.f1570a.f1512p.setAlpha(0.0f);
            this.f1570a.f1512p.setVisibility(0);
            this.f1570a.f1512p.animate().alpha(1.0f).setDuration(2500).setInterpolator(new DecelerateInterpolator());
        }
    }

    public void m2389a(String str) {
        if (m2387b()) {
            ((TextView) this.f1570a.f1511o.findViewById(R.id.game_over_reason)).setText(str);
            this.f1570a.f1511o.setAlpha(0.0f);
            this.f1570a.f1511o.setVisibility(0);
            this.f1570a.f1511o.animate().alpha(1.0f).setDuration(2500).setInterpolator(new DecelerateInterpolator());
        }
    }
}
