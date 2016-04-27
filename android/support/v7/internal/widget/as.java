package android.support.v7.internal.widget;

import android.view.View;
import android.view.View.OnClickListener;

class as implements OnClickListener {
    final /* synthetic */ ap f1097a;

    private as(ap apVar) {
        this.f1097a = apVar;
    }

    public void onClick(View view) {
        ((at) view).m1893b().m1187d();
        int childCount = this.f1097a.f1089e.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.f1097a.f1089e.getChildAt(i);
            childAt.setSelected(childAt == view);
        }
    }
}
