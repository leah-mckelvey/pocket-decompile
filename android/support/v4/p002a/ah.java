package android.support.v4.p002a;

import android.transition.Transition;
import android.view.View;
import android.view.ViewTreeObserver.OnPreDrawListener;
import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;

/* renamed from: android.support.v4.a.ah */
final class ah implements OnPreDrawListener {
    final /* synthetic */ View f105a;
    final /* synthetic */ al f106b;
    final /* synthetic */ Map f107c;
    final /* synthetic */ Map f108d;
    final /* synthetic */ Transition f109e;
    final /* synthetic */ ArrayList f110f;
    final /* synthetic */ View f111g;

    ah(View view, al alVar, Map map, Map map2, Transition transition, ArrayList arrayList, View view2) {
        this.f105a = view;
        this.f106b = alVar;
        this.f107c = map;
        this.f108d = map2;
        this.f109e = transition;
        this.f110f = arrayList;
        this.f111g = view2;
    }

    public boolean onPreDraw() {
        this.f105a.getViewTreeObserver().removeOnPreDrawListener(this);
        View a = this.f106b.m207a();
        if (a != null) {
            if (!this.f107c.isEmpty()) {
                af.m200a(this.f108d, a);
                this.f108d.keySet().retainAll(this.f107c.values());
                for (Entry entry : this.f107c.entrySet()) {
                    View view = (View) this.f108d.get((String) entry.getValue());
                    if (view != null) {
                        view.setTransitionName((String) entry.getKey());
                    }
                }
            }
            if (this.f109e != null) {
                af.m205b(this.f110f, a);
                this.f110f.removeAll(this.f108d.values());
                this.f110f.add(this.f111g);
                this.f109e.removeTarget(this.f111g);
                af.m204b(this.f109e, this.f110f);
            }
        }
        return true;
    }
}
