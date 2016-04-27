package android.support.v7.internal.view.menu;

import android.support.v7.p012d.C0213c;
import android.view.CollapsibleActionView;
import android.view.View;
import android.widget.FrameLayout;

/* renamed from: android.support.v7.internal.view.menu.q */
class C0252q extends FrameLayout implements C0213c {
    final CollapsibleActionView f919a;

    C0252q(View view) {
        super(view.getContext());
        this.f919a = (CollapsibleActionView) view;
        addView(view);
    }

    public void m1705a() {
        this.f919a.onActionViewExpanded();
    }

    public void m1706b() {
        this.f919a.onActionViewCollapsed();
    }

    View m1707c() {
        return (View) this.f919a;
    }
}
