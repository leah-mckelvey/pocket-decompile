package android.support.v4.p002a;

import android.os.Build.VERSION;
import android.support.v4.p009g.C0103a;
import android.support.v4.p009g.C0108e;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import com.pocket.doorway.C0339o;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Map;

/* renamed from: android.support.v4.a.e */
final class C0040e extends ae implements Runnable {
    static final boolean f153a;
    final C0059w f154b;
    C0044i f155c;
    C0044i f156d;
    int f157e;
    int f158f;
    int f159g;
    int f160h;
    int f161i;
    int f162j;
    int f163k;
    boolean f164l;
    boolean f165m;
    String f166n;
    boolean f167o;
    int f168p;
    int f169q;
    CharSequence f170r;
    int f171s;
    CharSequence f172t;
    ArrayList f173u;
    ArrayList f174v;

    static {
        f153a = VERSION.SDK_INT >= 21;
    }

    public C0040e(C0059w c0059w) {
        this.f165m = true;
        this.f168p = -1;
        this.f154b = c0059w;
    }

    private C0045j m267a(SparseArray sparseArray, SparseArray sparseArray2, boolean z) {
        int i = 0;
        C0045j c0045j = new C0045j(this);
        c0045j.f202d = new View(this.f154b.f306o);
        int i2 = 0;
        int i3 = 0;
        while (i2 < sparseArray.size()) {
            int i4 = m287a(sparseArray.keyAt(i2), c0045j, z, sparseArray, sparseArray2) ? 1 : i3;
            i2++;
            i3 = i4;
        }
        while (i < sparseArray2.size()) {
            i4 = sparseArray2.keyAt(i);
            if (sparseArray.get(i4) == null && m287a(i4, c0045j, z, sparseArray, sparseArray2)) {
                i3 = 1;
            }
            i++;
        }
        return i3 == 0 ? null : c0045j;
    }

    private C0103a m269a(C0045j c0045j, C0048m c0048m, boolean z) {
        C0103a c0103a = new C0103a();
        if (this.f173u != null) {
            af.m200a((Map) c0103a, c0048m.m347g());
            if (z) {
                c0103a.m559a(this.f174v);
            } else {
                c0103a = C0040e.m271a(this.f173u, this.f174v, c0103a);
            }
        }
        if (z) {
            if (c0048m.f240Y != null) {
                c0048m.f240Y.m255a(this.f174v, c0103a);
            }
            m280a(c0045j, c0103a, false);
        } else {
            if (c0048m.f241Z != null) {
                c0048m.f241Z.m255a(this.f174v, c0103a);
            }
            m290b(c0045j, c0103a, false);
        }
        return c0103a;
    }

    private C0103a m270a(C0045j c0045j, boolean z, C0048m c0048m) {
        C0103a b = m288b(c0045j, c0048m, z);
        if (z) {
            if (c0048m.f241Z != null) {
                c0048m.f241Z.m255a(this.f174v, b);
            }
            m280a(c0045j, b, true);
        } else {
            if (c0048m.f240Y != null) {
                c0048m.f240Y.m255a(this.f174v, b);
            }
            m290b(c0045j, b, true);
        }
        return b;
    }

    private static C0103a m271a(ArrayList arrayList, ArrayList arrayList2, C0103a c0103a) {
        if (c0103a.isEmpty()) {
            return c0103a;
        }
        C0103a c0103a2 = new C0103a();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            View view = (View) c0103a.get(arrayList.get(i));
            if (view != null) {
                c0103a2.put(arrayList2.get(i), view);
            }
        }
        return c0103a2;
    }

    private static Object m272a(C0048m c0048m, C0048m c0048m2, boolean z) {
        if (c0048m == null || c0048m2 == null) {
            return null;
        }
        return af.m188a(z ? c0048m2.m365v() : c0048m.m364u());
    }

    private static Object m273a(C0048m c0048m, boolean z) {
        if (c0048m == null) {
            return null;
        }
        return af.m188a(z ? c0048m.m363t() : c0048m.m360q());
    }

    private static Object m274a(Object obj, C0048m c0048m, ArrayList arrayList, C0103a c0103a, View view) {
        return obj != null ? af.m189a(obj, c0048m.m347g(), arrayList, c0103a, view) : obj;
    }

    private void m278a(C0045j c0045j, int i, Object obj) {
        if (this.f154b.f298g != null) {
            for (int i2 = 0; i2 < this.f154b.f298g.size(); i2++) {
                C0048m c0048m = (C0048m) this.f154b.f298g.get(i2);
                if (!(c0048m.f225J == null || c0048m.f224I == null || c0048m.f265y != i)) {
                    if (!c0048m.f216A) {
                        af.m196a(obj, c0048m.f225J, false);
                        c0045j.f200b.remove(c0048m.f225J);
                    } else if (!c0045j.f200b.contains(c0048m.f225J)) {
                        af.m196a(obj, c0048m.f225J, true);
                        c0045j.f200b.add(c0048m.f225J);
                    }
                }
            }
        }
    }

    private void m279a(C0045j c0045j, C0048m c0048m, C0048m c0048m2, boolean z, C0103a c0103a) {
        aw awVar = z ? c0048m2.f240Y : c0048m.f240Y;
        if (awVar != null) {
            awVar.m256b(new ArrayList(c0103a.keySet()), new ArrayList(c0103a.values()), null);
        }
    }

    private void m280a(C0045j c0045j, C0103a c0103a, boolean z) {
        int size = this.f174v == null ? 0 : this.f174v.size();
        for (int i = 0; i < size; i++) {
            String str = (String) this.f173u.get(i);
            View view = (View) c0103a.get((String) this.f174v.get(i));
            if (view != null) {
                String a = af.m191a(view);
                if (z) {
                    C0040e.m284a(c0045j.f199a, str, a);
                } else {
                    C0040e.m284a(c0045j.f199a, a, str);
                }
            }
        }
    }

    private void m281a(C0045j c0045j, View view, Object obj, C0048m c0048m, C0048m c0048m2, boolean z, ArrayList arrayList) {
        view.getViewTreeObserver().addOnPreDrawListener(new C0042g(this, view, obj, arrayList, c0045j, z, c0048m, c0048m2));
    }

    private static void m282a(C0045j c0045j, ArrayList arrayList, ArrayList arrayList2) {
        if (arrayList != null) {
            for (int i = 0; i < arrayList.size(); i++) {
                C0040e.m284a(c0045j.f199a, (String) arrayList.get(i), (String) arrayList2.get(i));
            }
        }
    }

    private void m283a(C0103a c0103a, C0045j c0045j) {
        if (this.f174v != null && !c0103a.isEmpty()) {
            View view = (View) c0103a.get(this.f174v.get(0));
            if (view != null) {
                c0045j.f201c.f125a = view;
            }
        }
    }

    private static void m284a(C0103a c0103a, String str, String str2) {
        if (str != null && str2 != null && !str.equals(str2)) {
            for (int i = 0; i < c0103a.size(); i++) {
                if (str.equals(c0103a.m556c(i))) {
                    c0103a.m552a(i, (Object) str2);
                    return;
                }
            }
            c0103a.put(str, str2);
        }
    }

    private static void m285a(SparseArray sparseArray, C0048m c0048m) {
        if (c0048m != null) {
            int i = c0048m.f265y;
            if (i != 0 && !c0048m.m346f() && c0048m.m344e() && c0048m.m347g() != null && sparseArray.get(i) == null) {
                sparseArray.put(i, c0048m);
            }
        }
    }

    private void m286a(View view, C0045j c0045j, int i, Object obj) {
        view.getViewTreeObserver().addOnPreDrawListener(new C0043h(this, view, c0045j, i, obj));
    }

    private boolean m287a(int i, C0045j c0045j, boolean z, SparseArray sparseArray, SparseArray sparseArray2) {
        View view = (ViewGroup) this.f154b.f307p.m370a(i);
        if (view == null) {
            return false;
        }
        C0048m c0048m = (C0048m) sparseArray2.get(i);
        C0048m c0048m2 = (C0048m) sparseArray.get(i);
        Object a = C0040e.m273a(c0048m, z);
        Object a2 = C0040e.m272a(c0048m, c0048m2, z);
        Object b = C0040e.m289b(c0048m2, z);
        if (a == null && a2 == null && b == null) {
            return false;
        }
        C0103a c0103a = null;
        ArrayList arrayList = new ArrayList();
        if (a2 != null) {
            c0103a = m269a(c0045j, c0048m2, z);
            arrayList.add(c0045j.f202d);
            arrayList.addAll(c0103a.values());
            aw awVar = z ? c0048m2.f240Y : c0048m.f240Y;
            if (awVar != null) {
                awVar.m254a(new ArrayList(c0103a.keySet()), new ArrayList(c0103a.values()), null);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        Object a3 = C0040e.m274a(b, c0048m2, arrayList2, c0103a, c0045j.f202d);
        if (!(this.f174v == null || c0103a == null)) {
            View view2 = (View) c0103a.get(this.f174v.get(0));
            if (view2 != null) {
                if (a3 != null) {
                    af.m195a(a3, view2);
                }
                if (a2 != null) {
                    af.m195a(a2, view2);
                }
            }
        }
        al c0041f = new C0041f(this, c0048m);
        if (a2 != null) {
            m281a(c0045j, view, a2, c0048m, c0048m2, z, arrayList);
        }
        ArrayList arrayList3 = new ArrayList();
        Map c0103a2 = new C0103a();
        Object a4 = af.m190a(a, a3, a2, z ? c0048m.m367x() : c0048m.m366w());
        if (a4 != null) {
            af.m197a(a, a2, view, c0041f, c0045j.f202d, c0045j.f201c, c0045j.f199a, arrayList3, c0103a2, arrayList);
            m286a(view, c0045j, i, a4);
            af.m196a(a4, c0045j.f202d, true);
            m278a(c0045j, i, a4);
            af.m194a((ViewGroup) view, a4);
            af.m193a(view, c0045j.f202d, a, arrayList3, a3, arrayList2, a2, arrayList, a4, c0045j.f200b, c0103a2);
        }
        return a4 != null;
    }

    private C0103a m288b(C0045j c0045j, C0048m c0048m, boolean z) {
        C0103a c0103a = new C0103a();
        View g = c0048m.m347g();
        if (g == null || this.f173u == null) {
            return c0103a;
        }
        af.m200a((Map) c0103a, g);
        if (z) {
            return C0040e.m271a(this.f173u, this.f174v, c0103a);
        }
        c0103a.m559a(this.f174v);
        return c0103a;
    }

    private static Object m289b(C0048m c0048m, boolean z) {
        if (c0048m == null) {
            return null;
        }
        return af.m188a(z ? c0048m.m361r() : c0048m.m362s());
    }

    private void m290b(C0045j c0045j, C0103a c0103a, boolean z) {
        int size = c0103a.size();
        for (int i = 0; i < size; i++) {
            String str = (String) c0103a.m555b(i);
            String a = af.m191a((View) c0103a.m556c(i));
            if (z) {
                C0040e.m284a(c0045j.f199a, str, a);
            } else {
                C0040e.m284a(c0045j.f199a, a, str);
            }
        }
    }

    private void m291b(SparseArray sparseArray, C0048m c0048m) {
        if (c0048m != null) {
            int i = c0048m.f265y;
            if (i != 0) {
                sparseArray.put(i, c0048m);
            }
        }
    }

    private void m292b(SparseArray sparseArray, SparseArray sparseArray2) {
        if (this.f154b.f307p.m371a()) {
            for (C0044i c0044i = this.f155c; c0044i != null; c0044i = c0044i.f190a) {
                switch (c0044i.f192c) {
                    case C0339o.View_android_focusable /*1*/:
                        m291b(sparseArray2, c0044i.f193d);
                        break;
                    case C0339o.View_paddingStart /*2*/:
                        C0048m c0048m;
                        C0048m c0048m2 = c0044i.f193d;
                        if (this.f154b.f298g != null) {
                            c0048m = c0048m2;
                            for (int i = 0; i < this.f154b.f298g.size(); i++) {
                                C0048m c0048m3 = (C0048m) this.f154b.f298g.get(i);
                                if (c0048m == null || c0048m3.f265y == c0048m.f265y) {
                                    if (c0048m3 == c0048m) {
                                        c0048m = null;
                                    } else {
                                        C0040e.m285a(sparseArray, c0048m3);
                                    }
                                }
                            }
                        } else {
                            c0048m = c0048m2;
                        }
                        m291b(sparseArray2, c0048m);
                        break;
                    case C0339o.View_paddingEnd /*3*/:
                        C0040e.m285a(sparseArray, c0044i.f193d);
                        break;
                    case C0339o.View_theme /*4*/:
                        C0040e.m285a(sparseArray, c0044i.f193d);
                        break;
                    case C0339o.View_backgroundTint /*5*/:
                        m291b(sparseArray2, c0044i.f193d);
                        break;
                    case C0339o.View_backgroundTintMode /*6*/:
                        C0040e.m285a(sparseArray, c0044i.f193d);
                        break;
                    case C0339o.Toolbar_contentInsetRight /*7*/:
                        m291b(sparseArray2, c0044i.f193d);
                        break;
                    default:
                        break;
                }
            }
        }
    }

    public C0045j m293a(boolean z, C0045j c0045j, SparseArray sparseArray, SparseArray sparseArray2) {
        if (C0059w.f291a) {
            Log.v("FragmentManager", "popFromBackStack: " + this);
            m298a("  ", null, new PrintWriter(new C0108e("FragmentManager")), null);
        }
        if (f153a) {
            if (c0045j == null) {
                if (!(sparseArray.size() == 0 && sparseArray2.size() == 0)) {
                    c0045j = m267a(sparseArray, sparseArray2, true);
                }
            } else if (!z) {
                C0040e.m282a(c0045j, this.f174v, this.f173u);
            }
        }
        m295a(-1);
        int i = c0045j != null ? 0 : this.f163k;
        int i2 = c0045j != null ? 0 : this.f162j;
        C0044i c0044i = this.f156d;
        while (c0044i != null) {
            int i3 = c0045j != null ? 0 : c0044i.f196g;
            int i4 = c0045j != null ? 0 : c0044i.f197h;
            C0048m c0048m;
            C0048m c0048m2;
            switch (c0044i.f192c) {
                case C0339o.View_android_focusable /*1*/:
                    c0048m = c0044i.f193d;
                    c0048m.f223H = i4;
                    this.f154b.m408a(c0048m, C0059w.m393c(i2), i);
                    break;
                case C0339o.View_paddingStart /*2*/:
                    c0048m = c0044i.f193d;
                    if (c0048m != null) {
                        c0048m.f223H = i4;
                        this.f154b.m408a(c0048m, C0059w.m393c(i2), i);
                    }
                    if (c0044i.f198i == null) {
                        break;
                    }
                    for (int i5 = 0; i5 < c0044i.f198i.size(); i5++) {
                        c0048m2 = (C0048m) c0044i.f198i.get(i5);
                        c0048m2.f223H = i3;
                        this.f154b.m410a(c0048m2, false);
                    }
                    break;
                case C0339o.View_paddingEnd /*3*/:
                    c0048m2 = c0044i.f193d;
                    c0048m2.f223H = i3;
                    this.f154b.m410a(c0048m2, false);
                    break;
                case C0339o.View_theme /*4*/:
                    c0048m2 = c0044i.f193d;
                    c0048m2.f223H = i3;
                    this.f154b.m426c(c0048m2, C0059w.m393c(i2), i);
                    break;
                case C0339o.View_backgroundTint /*5*/:
                    c0048m = c0044i.f193d;
                    c0048m.f223H = i4;
                    this.f154b.m420b(c0048m, C0059w.m393c(i2), i);
                    break;
                case C0339o.View_backgroundTintMode /*6*/:
                    c0048m2 = c0044i.f193d;
                    c0048m2.f223H = i3;
                    this.f154b.m432e(c0048m2, C0059w.m393c(i2), i);
                    break;
                case C0339o.Toolbar_contentInsetRight /*7*/:
                    c0048m2 = c0044i.f193d;
                    c0048m2.f223H = i3;
                    this.f154b.m428d(c0048m2, C0059w.m393c(i2), i);
                    break;
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + c0044i.f192c);
            }
            c0044i = c0044i.f191b;
        }
        if (z) {
            this.f154b.m400a(this.f154b.f305n, C0059w.m393c(i2), i, true);
            c0045j = null;
        }
        if (this.f168p >= 0) {
            this.f154b.m418b(this.f168p);
            this.f168p = -1;
        }
        return c0045j;
    }

    public String m294a() {
        return this.f166n;
    }

    void m295a(int i) {
        if (this.f164l) {
            if (C0059w.f291a) {
                Log.v("FragmentManager", "Bump nesting in " + this + " by " + i);
            }
            for (C0044i c0044i = this.f155c; c0044i != null; c0044i = c0044i.f190a) {
                C0048m c0048m;
                if (c0044i.f193d != null) {
                    c0048m = c0044i.f193d;
                    c0048m.f259s += i;
                    if (C0059w.f291a) {
                        Log.v("FragmentManager", "Bump nesting of " + c0044i.f193d + " to " + c0044i.f193d.f259s);
                    }
                }
                if (c0044i.f198i != null) {
                    for (int size = c0044i.f198i.size() - 1; size >= 0; size--) {
                        c0048m = (C0048m) c0044i.f198i.get(size);
                        c0048m.f259s += i;
                        if (C0059w.f291a) {
                            Log.v("FragmentManager", "Bump nesting of " + c0048m + " to " + c0048m.f259s);
                        }
                    }
                }
            }
        }
    }

    void m296a(C0044i c0044i) {
        if (this.f155c == null) {
            this.f156d = c0044i;
            this.f155c = c0044i;
        } else {
            c0044i.f191b = this.f156d;
            this.f156d.f190a = c0044i;
            this.f156d = c0044i;
        }
        c0044i.f194e = this.f158f;
        c0044i.f195f = this.f159g;
        c0044i.f196g = this.f160h;
        c0044i.f197h = this.f161i;
        this.f157e++;
    }

    public void m297a(SparseArray sparseArray, SparseArray sparseArray2) {
        if (this.f154b.f307p.m371a()) {
            for (C0044i c0044i = this.f155c; c0044i != null; c0044i = c0044i.f190a) {
                switch (c0044i.f192c) {
                    case C0339o.View_android_focusable /*1*/:
                        C0040e.m285a(sparseArray, c0044i.f193d);
                        break;
                    case C0339o.View_paddingStart /*2*/:
                        if (c0044i.f198i != null) {
                            for (int size = c0044i.f198i.size() - 1; size >= 0; size--) {
                                m291b(sparseArray2, (C0048m) c0044i.f198i.get(size));
                            }
                        }
                        C0040e.m285a(sparseArray, c0044i.f193d);
                        break;
                    case C0339o.View_paddingEnd /*3*/:
                        m291b(sparseArray2, c0044i.f193d);
                        break;
                    case C0339o.View_theme /*4*/:
                        m291b(sparseArray2, c0044i.f193d);
                        break;
                    case C0339o.View_backgroundTint /*5*/:
                        C0040e.m285a(sparseArray, c0044i.f193d);
                        break;
                    case C0339o.View_backgroundTintMode /*6*/:
                        m291b(sparseArray2, c0044i.f193d);
                        break;
                    case C0339o.Toolbar_contentInsetRight /*7*/:
                        C0040e.m285a(sparseArray, c0044i.f193d);
                        break;
                    default:
                        break;
                }
            }
        }
    }

    public void m298a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        m299a(str, printWriter, true);
    }

    public void m299a(String str, PrintWriter printWriter, boolean z) {
        if (z) {
            printWriter.print(str);
            printWriter.print("mName=");
            printWriter.print(this.f166n);
            printWriter.print(" mIndex=");
            printWriter.print(this.f168p);
            printWriter.print(" mCommitted=");
            printWriter.println(this.f167o);
            if (this.f162j != 0) {
                printWriter.print(str);
                printWriter.print("mTransition=#");
                printWriter.print(Integer.toHexString(this.f162j));
                printWriter.print(" mTransitionStyle=#");
                printWriter.println(Integer.toHexString(this.f163k));
            }
            if (!(this.f158f == 0 && this.f159g == 0)) {
                printWriter.print(str);
                printWriter.print("mEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f158f));
                printWriter.print(" mExitAnim=#");
                printWriter.println(Integer.toHexString(this.f159g));
            }
            if (!(this.f160h == 0 && this.f161i == 0)) {
                printWriter.print(str);
                printWriter.print("mPopEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f160h));
                printWriter.print(" mPopExitAnim=#");
                printWriter.println(Integer.toHexString(this.f161i));
            }
            if (!(this.f169q == 0 && this.f170r == null)) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbTitleRes=#");
                printWriter.print(Integer.toHexString(this.f169q));
                printWriter.print(" mBreadCrumbTitleText=");
                printWriter.println(this.f170r);
            }
            if (!(this.f171s == 0 && this.f172t == null)) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbShortTitleRes=#");
                printWriter.print(Integer.toHexString(this.f171s));
                printWriter.print(" mBreadCrumbShortTitleText=");
                printWriter.println(this.f172t);
            }
        }
        if (this.f155c != null) {
            printWriter.print(str);
            printWriter.println("Operations:");
            String str2 = str + "    ";
            int i = 0;
            C0044i c0044i = this.f155c;
            while (c0044i != null) {
                String str3;
                switch (c0044i.f192c) {
                    case C0339o.View_android_theme /*0*/:
                        str3 = "NULL";
                        break;
                    case C0339o.View_android_focusable /*1*/:
                        str3 = "ADD";
                        break;
                    case C0339o.View_paddingStart /*2*/:
                        str3 = "REPLACE";
                        break;
                    case C0339o.View_paddingEnd /*3*/:
                        str3 = "REMOVE";
                        break;
                    case C0339o.View_theme /*4*/:
                        str3 = "HIDE";
                        break;
                    case C0339o.View_backgroundTint /*5*/:
                        str3 = "SHOW";
                        break;
                    case C0339o.View_backgroundTintMode /*6*/:
                        str3 = "DETACH";
                        break;
                    case C0339o.Toolbar_contentInsetRight /*7*/:
                        str3 = "ATTACH";
                        break;
                    default:
                        str3 = "cmd=" + c0044i.f192c;
                        break;
                }
                printWriter.print(str);
                printWriter.print("  Op #");
                printWriter.print(i);
                printWriter.print(": ");
                printWriter.print(str3);
                printWriter.print(" ");
                printWriter.println(c0044i.f193d);
                if (z) {
                    if (!(c0044i.f194e == 0 && c0044i.f195f == 0)) {
                        printWriter.print(str);
                        printWriter.print("enterAnim=#");
                        printWriter.print(Integer.toHexString(c0044i.f194e));
                        printWriter.print(" exitAnim=#");
                        printWriter.println(Integer.toHexString(c0044i.f195f));
                    }
                    if (!(c0044i.f196g == 0 && c0044i.f197h == 0)) {
                        printWriter.print(str);
                        printWriter.print("popEnterAnim=#");
                        printWriter.print(Integer.toHexString(c0044i.f196g));
                        printWriter.print(" popExitAnim=#");
                        printWriter.println(Integer.toHexString(c0044i.f197h));
                    }
                }
                if (c0044i.f198i != null && c0044i.f198i.size() > 0) {
                    for (int i2 = 0; i2 < c0044i.f198i.size(); i2++) {
                        printWriter.print(str2);
                        if (c0044i.f198i.size() == 1) {
                            printWriter.print("Removed: ");
                        } else {
                            if (i2 == 0) {
                                printWriter.println("Removed:");
                            }
                            printWriter.print(str2);
                            printWriter.print("  #");
                            printWriter.print(i2);
                            printWriter.print(": ");
                        }
                        printWriter.println(c0044i.f198i.get(i2));
                    }
                }
                c0044i = c0044i.f190a;
                i++;
            }
        }
    }

    public void run() {
        if (C0059w.f291a) {
            Log.v("FragmentManager", "Run: " + this);
        }
        if (!this.f164l || this.f168p >= 0) {
            C0045j a;
            m295a(1);
            if (f153a) {
                SparseArray sparseArray = new SparseArray();
                SparseArray sparseArray2 = new SparseArray();
                m292b(sparseArray, sparseArray2);
                a = m267a(sparseArray, sparseArray2, false);
            } else {
                Object obj = null;
            }
            int i = a != null ? 0 : this.f163k;
            int i2 = a != null ? 0 : this.f162j;
            C0044i c0044i = this.f155c;
            while (c0044i != null) {
                int i3 = a != null ? 0 : c0044i.f194e;
                int i4 = a != null ? 0 : c0044i.f195f;
                C0048m c0048m;
                switch (c0044i.f192c) {
                    case C0339o.View_android_focusable /*1*/:
                        c0048m = c0044i.f193d;
                        c0048m.f223H = i3;
                        this.f154b.m410a(c0048m, false);
                        break;
                    case C0339o.View_paddingStart /*2*/:
                        C0048m c0048m2;
                        c0048m = c0044i.f193d;
                        if (this.f154b.f298g != null) {
                            c0048m2 = c0048m;
                            for (int i5 = 0; i5 < this.f154b.f298g.size(); i5++) {
                                c0048m = (C0048m) this.f154b.f298g.get(i5);
                                if (C0059w.f291a) {
                                    Log.v("FragmentManager", "OP_REPLACE: adding=" + c0048m2 + " old=" + c0048m);
                                }
                                if (c0048m2 == null || c0048m.f265y == c0048m2.f265y) {
                                    if (c0048m == c0048m2) {
                                        c0044i.f193d = null;
                                        c0048m2 = null;
                                    } else {
                                        if (c0044i.f198i == null) {
                                            c0044i.f198i = new ArrayList();
                                        }
                                        c0044i.f198i.add(c0048m);
                                        c0048m.f223H = i4;
                                        if (this.f164l) {
                                            c0048m.f259s++;
                                            if (C0059w.f291a) {
                                                Log.v("FragmentManager", "Bump nesting of " + c0048m + " to " + c0048m.f259s);
                                            }
                                        }
                                        this.f154b.m408a(c0048m, i2, i);
                                    }
                                }
                            }
                        } else {
                            c0048m2 = c0048m;
                        }
                        if (c0048m2 == null) {
                            break;
                        }
                        c0048m2.f223H = i3;
                        this.f154b.m410a(c0048m2, false);
                        break;
                    case C0339o.View_paddingEnd /*3*/:
                        c0048m = c0044i.f193d;
                        c0048m.f223H = i4;
                        this.f154b.m408a(c0048m, i2, i);
                        break;
                    case C0339o.View_theme /*4*/:
                        c0048m = c0044i.f193d;
                        c0048m.f223H = i4;
                        this.f154b.m420b(c0048m, i2, i);
                        break;
                    case C0339o.View_backgroundTint /*5*/:
                        c0048m = c0044i.f193d;
                        c0048m.f223H = i3;
                        this.f154b.m426c(c0048m, i2, i);
                        break;
                    case C0339o.View_backgroundTintMode /*6*/:
                        c0048m = c0044i.f193d;
                        c0048m.f223H = i4;
                        this.f154b.m428d(c0048m, i2, i);
                        break;
                    case C0339o.Toolbar_contentInsetRight /*7*/:
                        c0048m = c0044i.f193d;
                        c0048m.f223H = i3;
                        this.f154b.m432e(c0048m, i2, i);
                        break;
                    default:
                        throw new IllegalArgumentException("Unknown cmd: " + c0044i.f192c);
                }
                c0044i = c0044i.f190a;
            }
            this.f154b.m400a(this.f154b.f305n, i2, i, true);
            if (this.f164l) {
                this.f154b.m406a(this);
                return;
            }
            return;
        }
        throw new IllegalStateException("addToBackStack() called after commit()");
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(128);
        stringBuilder.append("BackStackEntry{");
        stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
        if (this.f168p >= 0) {
            stringBuilder.append(" #");
            stringBuilder.append(this.f168p);
        }
        if (this.f166n != null) {
            stringBuilder.append(" ");
            stringBuilder.append(this.f166n);
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
