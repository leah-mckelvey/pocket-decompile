package android.support.v4.p002a;

import android.transition.Transition;
import android.view.View;
import android.view.ViewTreeObserver.OnPreDrawListener;
import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;

/* renamed from: android.support.v4.a.aj */
final class aj implements OnPreDrawListener {
    final /* synthetic */ View f114a;
    final /* synthetic */ Transition f115b;
    final /* synthetic */ View f116c;
    final /* synthetic */ ArrayList f117d;
    final /* synthetic */ Transition f118e;
    final /* synthetic */ ArrayList f119f;
    final /* synthetic */ Transition f120g;
    final /* synthetic */ ArrayList f121h;
    final /* synthetic */ Map f122i;
    final /* synthetic */ ArrayList f123j;
    final /* synthetic */ Transition f124k;

    aj(View view, Transition transition, View view2, ArrayList arrayList, Transition transition2, ArrayList arrayList2, Transition transition3, ArrayList arrayList3, Map map, ArrayList arrayList4, Transition transition4) {
        this.f114a = view;
        this.f115b = transition;
        this.f116c = view2;
        this.f117d = arrayList;
        this.f118e = transition2;
        this.f119f = arrayList2;
        this.f120g = transition3;
        this.f121h = arrayList3;
        this.f122i = map;
        this.f123j = arrayList4;
        this.f124k = transition4;
    }

    public boolean onPreDraw() {
        this.f114a.getViewTreeObserver().removeOnPreDrawListener(this);
        if (this.f115b != null) {
            this.f115b.removeTarget(this.f116c);
            af.m198a(this.f115b, this.f117d);
        }
        if (this.f118e != null) {
            af.m198a(this.f118e, this.f119f);
        }
        if (this.f120g != null) {
            af.m198a(this.f120g, this.f121h);
        }
        for (Entry entry : this.f122i.entrySet()) {
            ((View) entry.getValue()).setTransitionName((String) entry.getKey());
        }
        int size = this.f123j.size();
        for (int i = 0; i < size; i++) {
            this.f124k.excludeTarget((View) this.f123j.get(i), false);
        }
        this.f124k.excludeTarget(this.f116c, false);
        return true;
    }
}
