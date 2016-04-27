package android.support.v4.p002a;

import android.support.v4.p009g.C0103a;
import android.view.View;
import android.view.ViewTreeObserver.OnPreDrawListener;
import java.util.ArrayList;

/* renamed from: android.support.v4.a.g */
class C0042g implements OnPreDrawListener {
    final /* synthetic */ View f177a;
    final /* synthetic */ Object f178b;
    final /* synthetic */ ArrayList f179c;
    final /* synthetic */ C0045j f180d;
    final /* synthetic */ boolean f181e;
    final /* synthetic */ C0048m f182f;
    final /* synthetic */ C0048m f183g;
    final /* synthetic */ C0040e f184h;

    C0042g(C0040e c0040e, View view, Object obj, ArrayList arrayList, C0045j c0045j, boolean z, C0048m c0048m, C0048m c0048m2) {
        this.f184h = c0040e;
        this.f177a = view;
        this.f178b = obj;
        this.f179c = arrayList;
        this.f180d = c0045j;
        this.f181e = z;
        this.f182f = c0048m;
        this.f183g = c0048m2;
    }

    public boolean onPreDraw() {
        this.f177a.getViewTreeObserver().removeOnPreDrawListener(this);
        if (this.f178b != null) {
            af.m198a(this.f178b, this.f179c);
            this.f179c.clear();
            C0103a a = this.f184h.m270a(this.f180d, this.f181e, this.f182f);
            this.f179c.add(this.f180d.f202d);
            this.f179c.addAll(a.values());
            af.m204b(this.f178b, this.f179c);
            this.f184h.m283a(a, this.f180d);
            this.f184h.m279a(this.f180d, this.f182f, this.f183g, this.f181e, a);
        }
        return true;
    }
}
