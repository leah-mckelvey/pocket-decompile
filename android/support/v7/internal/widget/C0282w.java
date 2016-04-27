package android.support.v7.internal.widget;

import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.support.v4.p000h.au;
import android.support.v7.p013b.C0205g;
import android.support.v7.p013b.C0207i;
import android.support.v7.p013b.C0208j;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.pocket.doorway.C0339o;

/* renamed from: android.support.v7.internal.widget.w */
class C0282w extends BaseAdapter {
    final /* synthetic */ ActivityChooserView f1286a;
    private C0275p f1287b;
    private int f1288c;
    private boolean f1289d;
    private boolean f1290e;
    private boolean f1291f;

    public int m2102a() {
        int i = 0;
        int i2 = this.f1288c;
        this.f1288c = Integer.MAX_VALUE;
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(0, 0);
        int makeMeasureSpec2 = MeasureSpec.makeMeasureSpec(0, 0);
        int count = getCount();
        View view = null;
        int i3 = 0;
        while (i < count) {
            view = getView(i, view, null);
            view.measure(makeMeasureSpec, makeMeasureSpec2);
            i3 = Math.max(i3, view.getMeasuredWidth());
            i++;
        }
        this.f1288c = i2;
        return i3;
    }

    public void m2103a(int i) {
        if (this.f1288c != i) {
            this.f1288c = i;
            notifyDataSetChanged();
        }
    }

    public void m2104a(C0275p c0275p) {
        C0275p d = this.f1286a.f1028b.m2109d();
        if (d != null && this.f1286a.isShown()) {
            d.unregisterObserver(this.f1286a.f1035i);
        }
        this.f1287b = c0275p;
        if (c0275p != null && this.f1286a.isShown()) {
            c0275p.registerObserver(this.f1286a.f1035i);
        }
        notifyDataSetChanged();
    }

    public void m2105a(boolean z) {
        if (this.f1291f != z) {
            this.f1291f = z;
            notifyDataSetChanged();
        }
    }

    public void m2106a(boolean z, boolean z2) {
        if (this.f1289d != z || this.f1290e != z2) {
            this.f1289d = z;
            this.f1290e = z2;
            notifyDataSetChanged();
        }
    }

    public ResolveInfo m2107b() {
        return this.f1287b.m2096b();
    }

    public int m2108c() {
        return this.f1287b.m2092a();
    }

    public C0275p m2109d() {
        return this.f1287b;
    }

    public boolean m2110e() {
        return this.f1289d;
    }

    public int getCount() {
        int a = this.f1287b.m2092a();
        if (!(this.f1289d || this.f1287b.m2096b() == null)) {
            a--;
        }
        a = Math.min(a, this.f1288c);
        return this.f1291f ? a + 1 : a;
    }

    public Object getItem(int i) {
        switch (getItemViewType(i)) {
            case C0339o.View_android_theme /*0*/:
                if (!(this.f1289d || this.f1287b.m2096b() == null)) {
                    i++;
                }
                return this.f1287b.m2094a(i);
            case C0339o.View_android_focusable /*1*/:
                return null;
            default:
                throw new IllegalArgumentException();
        }
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public int getItemViewType(int i) {
        return (this.f1291f && i == getCount() - 1) ? 1 : 0;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        switch (getItemViewType(i)) {
            case C0339o.View_android_theme /*0*/:
                if (view == null || view.getId() != C0205g.list_item) {
                    view = LayoutInflater.from(this.f1286a.getContext()).inflate(C0207i.abc_activity_chooser_view_list_item, viewGroup, false);
                }
                PackageManager packageManager = this.f1286a.getContext().getPackageManager();
                ResolveInfo resolveInfo = (ResolveInfo) getItem(i);
                ((ImageView) view.findViewById(C0205g.icon)).setImageDrawable(resolveInfo.loadIcon(packageManager));
                ((TextView) view.findViewById(C0205g.title)).setText(resolveInfo.loadLabel(packageManager));
                if (this.f1289d && i == 0 && this.f1290e) {
                    au.m695b(view, true);
                    return view;
                }
                au.m695b(view, false);
                return view;
            case C0339o.View_android_focusable /*1*/:
                if (view != null && view.getId() == 1) {
                    return view;
                }
                view = LayoutInflater.from(this.f1286a.getContext()).inflate(C0207i.abc_activity_chooser_view_list_item, viewGroup, false);
                view.setId(1);
                ((TextView) view.findViewById(C0205g.title)).setText(this.f1286a.getContext().getString(C0208j.abc_activity_chooser_view_see_all));
                return view;
            default:
                throw new IllegalArgumentException();
        }
    }

    public int getViewTypeCount() {
        return 3;
    }
}
