package android.support.v4.p002a;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.p000h.C0058s;
import android.support.v4.p009g.C0107d;
import android.support.v4.p009g.C0108e;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.ScaleAnimation;
import com.pocket.doorway.C0339o;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;

/* renamed from: android.support.v4.a.w */
final class C0059w extends C0056u implements C0058s {
    static final Interpolator f288A;
    static final Interpolator f289B;
    static final Interpolator f290C;
    static boolean f291a;
    static final boolean f292b;
    static final Interpolator f293z;
    ArrayList f294c;
    Runnable[] f295d;
    boolean f296e;
    ArrayList f297f;
    ArrayList f298g;
    ArrayList f299h;
    ArrayList f300i;
    ArrayList f301j;
    ArrayList f302k;
    ArrayList f303l;
    ArrayList f304m;
    int f305n;
    C0052p f306o;
    C0049t f307p;
    C0048m f308q;
    boolean f309r;
    boolean f310s;
    boolean f311t;
    String f312u;
    boolean f313v;
    Bundle f314w;
    SparseArray f315x;
    Runnable f316y;

    static {
        boolean z = false;
        f291a = false;
        if (VERSION.SDK_INT >= 11) {
            z = true;
        }
        f292b = z;
        f293z = new DecelerateInterpolator(2.5f);
        f288A = new DecelerateInterpolator(1.5f);
        f289B = new AccelerateInterpolator(2.5f);
        f290C = new AccelerateInterpolator(1.5f);
    }

    C0059w() {
        this.f305n = 0;
        this.f314w = null;
        this.f315x = null;
        this.f316y = new C0060x(this);
    }

    static Animation m389a(Context context, float f, float f2) {
        Animation alphaAnimation = new AlphaAnimation(f, f2);
        alphaAnimation.setInterpolator(f288A);
        alphaAnimation.setDuration(220);
        return alphaAnimation;
    }

    static Animation m390a(Context context, float f, float f2, float f3, float f4) {
        Animation animationSet = new AnimationSet(false);
        Animation scaleAnimation = new ScaleAnimation(f, f2, f, f2, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setInterpolator(f293z);
        scaleAnimation.setDuration(220);
        animationSet.addAnimation(scaleAnimation);
        scaleAnimation = new AlphaAnimation(f3, f4);
        scaleAnimation.setInterpolator(f288A);
        scaleAnimation.setDuration(220);
        animationSet.addAnimation(scaleAnimation);
        return animationSet;
    }

    private void m391a(RuntimeException runtimeException) {
        Log.e("FragmentManager", runtimeException.getMessage());
        Log.e("FragmentManager", "Activity state:");
        PrintWriter printWriter = new PrintWriter(new C0108e("FragmentManager"));
        if (this.f306o != null) {
            try {
                this.f306o.dump("  ", null, printWriter, new String[0]);
            } catch (Throwable e) {
                Log.e("FragmentManager", "Failed dumping state", e);
            }
        } else {
            try {
                m412a("  ", null, printWriter, new String[0]);
            } catch (Throwable e2) {
                Log.e("FragmentManager", "Failed dumping state", e2);
            }
        }
        throw runtimeException;
    }

    public static int m392b(int i, boolean z) {
        switch (i) {
            case 4097:
                return z ? 1 : 2;
            case 4099:
                return z ? 5 : 6;
            case 8194:
                return z ? 3 : 4;
            default:
                return -1;
        }
    }

    public static int m393c(int i) {
        switch (i) {
            case 4097:
                return 8194;
            case 4099:
                return 4099;
            case 8194:
                return 4097;
            default:
                return 0;
        }
    }

    private void m394t() {
        if (this.f310s) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        } else if (this.f312u != null) {
            throw new IllegalStateException("Can not perform this action inside of " + this.f312u);
        }
    }

    public C0048m m395a(int i) {
        int size;
        C0048m c0048m;
        if (this.f298g != null) {
            for (size = this.f298g.size() - 1; size >= 0; size--) {
                c0048m = (C0048m) this.f298g.get(size);
                if (c0048m != null && c0048m.f264x == i) {
                    return c0048m;
                }
            }
        }
        if (this.f297f != null) {
            for (size = this.f297f.size() - 1; size >= 0; size--) {
                c0048m = (C0048m) this.f297f.get(size);
                if (c0048m != null && c0048m.f264x == i) {
                    return c0048m;
                }
            }
        }
        return null;
    }

    public C0048m m396a(Bundle bundle, String str) {
        int i = bundle.getInt(str, -1);
        if (i == -1) {
            return null;
        }
        if (i >= this.f297f.size()) {
            m391a(new IllegalStateException("Fragment no longer exists for key " + str + ": index " + i));
        }
        C0048m c0048m = (C0048m) this.f297f.get(i);
        if (c0048m != null) {
            return c0048m;
        }
        m391a(new IllegalStateException("Fragment no longer exists for key " + str + ": index " + i));
        return c0048m;
    }

    public C0048m m397a(String str) {
        int size;
        C0048m c0048m;
        if (!(this.f298g == null || str == null)) {
            for (size = this.f298g.size() - 1; size >= 0; size--) {
                c0048m = (C0048m) this.f298g.get(size);
                if (c0048m != null && str.equals(c0048m.f266z)) {
                    return c0048m;
                }
            }
        }
        if (!(this.f297f == null || str == null)) {
            for (size = this.f297f.size() - 1; size >= 0; size--) {
                c0048m = (C0048m) this.f297f.get(size);
                if (c0048m != null && str.equals(c0048m.f266z)) {
                    return c0048m;
                }
            }
        }
        return null;
    }

    public View m398a(View view, String str, Context context, AttributeSet attributeSet) {
        if (!"fragment".equals(str)) {
            return null;
        }
        String attributeValue = attributeSet.getAttributeValue(null, "class");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0062z.f320a);
        String string = attributeValue == null ? obtainStyledAttributes.getString(0) : attributeValue;
        int resourceId = obtainStyledAttributes.getResourceId(1, -1);
        String string2 = obtainStyledAttributes.getString(2);
        obtainStyledAttributes.recycle();
        if (!C0048m.m306b(this.f306o, string)) {
            return null;
        }
        int id = view != null ? view.getId() : 0;
        if (id == -1 && resourceId == -1 && string2 == null) {
            throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Must specify unique android:id, android:tag, or have a parent with an id for " + string);
        }
        C0048m c0048m;
        C0048m a = resourceId != -1 ? m395a(resourceId) : null;
        if (a == null && string2 != null) {
            a = m397a(string2);
        }
        if (a == null && id != -1) {
            a = m395a(id);
        }
        if (f291a) {
            Log.v("FragmentManager", "onCreateView: id=0x" + Integer.toHexString(resourceId) + " fname=" + string + " existing=" + a);
        }
        if (a == null) {
            C0048m a2 = C0048m.m304a(context, string);
            a2.f256p = true;
            a2.f264x = resourceId != 0 ? resourceId : id;
            a2.f265y = id;
            a2.f266z = string2;
            a2.f257q = true;
            a2.f260t = this;
            a2.m319a(this.f306o, attributeSet, a2.f245e);
            m410a(a2, true);
            c0048m = a2;
        } else if (a.f257q) {
            throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Duplicate id 0x" + Integer.toHexString(resourceId) + ", tag " + string2 + ", or parent id 0x" + Integer.toHexString(id) + " with another fragment for " + string);
        } else {
            a.f257q = true;
            if (!a.f219D) {
                a.m319a(this.f306o, attributeSet, a.f245e);
            }
            c0048m = a;
        }
        if (this.f305n >= 1 || !c0048m.f256p) {
            m419b(c0048m);
        } else {
            m409a(c0048m, 1, 0, 0, false);
        }
        if (c0048m.f225J == null) {
            throw new IllegalStateException("Fragment " + string + " did not create a view.");
        }
        if (resourceId != 0) {
            c0048m.f225J.setId(resourceId);
        }
        if (c0048m.f225J.getTag() == null) {
            c0048m.f225J.setTag(string2);
        }
        return c0048m.f225J;
    }

    Animation m399a(C0048m c0048m, int i, boolean z, int i2) {
        Animation a = c0048m.m315a(i, z, c0048m.f223H);
        if (a != null) {
            return a;
        }
        if (c0048m.f223H != 0) {
            a = AnimationUtils.loadAnimation(this.f306o, c0048m.f223H);
            if (a != null) {
                return a;
            }
        }
        if (i == 0) {
            return null;
        }
        int b = C0059w.m392b(i, z);
        if (b < 0) {
            return null;
        }
        switch (b) {
            case C0339o.View_android_focusable /*1*/:
                return C0059w.m390a(this.f306o, 1.125f, 1.0f, 0.0f, 1.0f);
            case C0339o.View_paddingStart /*2*/:
                return C0059w.m390a(this.f306o, 1.0f, 0.975f, 1.0f, 0.0f);
            case C0339o.View_paddingEnd /*3*/:
                return C0059w.m390a(this.f306o, 0.975f, 1.0f, 0.0f, 1.0f);
            case C0339o.View_theme /*4*/:
                return C0059w.m390a(this.f306o, 1.0f, 1.075f, 1.0f, 0.0f);
            case C0339o.View_backgroundTint /*5*/:
                return C0059w.m389a(this.f306o, 0.0f, 1.0f);
            case C0339o.View_backgroundTintMode /*6*/:
                return C0059w.m389a(this.f306o, 1.0f, 0.0f);
            default:
                if (i2 == 0 && this.f306o.getWindow() != null) {
                    i2 = this.f306o.getWindow().getAttributes().windowAnimations;
                }
                return i2 == 0 ? null : null;
        }
    }

    void m400a(int i, int i2, int i3, boolean z) {
        if (this.f306o == null && i != 0) {
            throw new IllegalStateException("No activity");
        } else if (z || this.f305n != i) {
            this.f305n = i;
            if (this.f297f != null) {
                int i4 = 0;
                int i5 = 0;
                while (i4 < this.f297f.size()) {
                    int a;
                    C0048m c0048m = (C0048m) this.f297f.get(i4);
                    if (c0048m != null) {
                        m409a(c0048m, i, i2, i3, false);
                        if (c0048m.f229N != null) {
                            a = i5 | c0048m.f229N.m214a();
                            i4++;
                            i5 = a;
                        }
                    }
                    a = i5;
                    i4++;
                    i5 = a;
                }
                if (i5 == 0) {
                    m424c();
                }
                if (this.f309r && this.f306o != null && this.f305n == 5) {
                    this.f306o.m383d();
                    this.f309r = false;
                }
            }
        }
    }

    public void m401a(int i, C0040e c0040e) {
        synchronized (this) {
            if (this.f302k == null) {
                this.f302k = new ArrayList();
            }
            int size = this.f302k.size();
            if (i < size) {
                if (f291a) {
                    Log.v("FragmentManager", "Setting back stack index " + i + " to " + c0040e);
                }
                this.f302k.set(i, c0040e);
            } else {
                while (size < i) {
                    this.f302k.add(null);
                    if (this.f303l == null) {
                        this.f303l = new ArrayList();
                    }
                    if (f291a) {
                        Log.v("FragmentManager", "Adding available back stack index " + size);
                    }
                    this.f303l.add(Integer.valueOf(size));
                    size++;
                }
                if (f291a) {
                    Log.v("FragmentManager", "Adding back stack index " + i + " with " + c0040e);
                }
                this.f302k.add(c0040e);
            }
        }
    }

    void m402a(int i, boolean z) {
        m400a(i, 0, 0, z);
    }

    public void m403a(Configuration configuration) {
        if (this.f298g != null) {
            for (int i = 0; i < this.f298g.size(); i++) {
                C0048m c0048m = (C0048m) this.f298g.get(i);
                if (c0048m != null) {
                    c0048m.m320a(configuration);
                }
            }
        }
    }

    public void m404a(Bundle bundle, String str, C0048m c0048m) {
        if (c0048m.f247g < 0) {
            m391a(new IllegalStateException("Fragment " + c0048m + " is not currently in the FragmentManager"));
        }
        bundle.putInt(str, c0048m.f247g);
    }

    void m405a(Parcelable parcelable, ArrayList arrayList) {
        if (parcelable != null) {
            aa aaVar = (aa) parcelable;
            if (aaVar.f90a != null) {
                int i;
                C0048m c0048m;
                int i2;
                if (arrayList != null) {
                    for (i = 0; i < arrayList.size(); i++) {
                        c0048m = (C0048m) arrayList.get(i);
                        if (f291a) {
                            Log.v("FragmentManager", "restoreAllState: re-attaching retained " + c0048m);
                        }
                        ac acVar = aaVar.f90a[c0048m.f247g];
                        acVar.f103k = c0048m;
                        c0048m.f246f = null;
                        c0048m.f259s = 0;
                        c0048m.f257q = false;
                        c0048m.f253m = false;
                        c0048m.f250j = null;
                        if (acVar.f102j != null) {
                            acVar.f102j.setClassLoader(this.f306o.getClassLoader());
                            c0048m.f246f = acVar.f102j.getSparseParcelableArray("android:view_state");
                            c0048m.f245e = acVar.f102j;
                        }
                    }
                }
                this.f297f = new ArrayList(aaVar.f90a.length);
                if (this.f299h != null) {
                    this.f299h.clear();
                }
                for (i2 = 0; i2 < aaVar.f90a.length; i2++) {
                    ac acVar2 = aaVar.f90a[i2];
                    if (acVar2 != null) {
                        C0048m a = acVar2.m185a(this.f306o, this.f308q);
                        if (f291a) {
                            Log.v("FragmentManager", "restoreAllState: active #" + i2 + ": " + a);
                        }
                        this.f297f.add(a);
                        acVar2.f103k = null;
                    } else {
                        this.f297f.add(null);
                        if (this.f299h == null) {
                            this.f299h = new ArrayList();
                        }
                        if (f291a) {
                            Log.v("FragmentManager", "restoreAllState: avail #" + i2);
                        }
                        this.f299h.add(Integer.valueOf(i2));
                    }
                }
                if (arrayList != null) {
                    for (int i3 = 0; i3 < arrayList.size(); i3++) {
                        c0048m = (C0048m) arrayList.get(i3);
                        if (c0048m.f251k >= 0) {
                            if (c0048m.f251k < this.f297f.size()) {
                                c0048m.f250j = (C0048m) this.f297f.get(c0048m.f251k);
                            } else {
                                Log.w("FragmentManager", "Re-attaching retained fragment " + c0048m + " target no longer exists: " + c0048m.f251k);
                                c0048m.f250j = null;
                            }
                        }
                    }
                }
                if (aaVar.f91b != null) {
                    this.f298g = new ArrayList(aaVar.f91b.length);
                    for (i = 0; i < aaVar.f91b.length; i++) {
                        c0048m = (C0048m) this.f297f.get(aaVar.f91b[i]);
                        if (c0048m == null) {
                            m391a(new IllegalStateException("No instantiated fragment for index #" + aaVar.f91b[i]));
                        }
                        c0048m.f253m = true;
                        if (f291a) {
                            Log.v("FragmentManager", "restoreAllState: added #" + i + ": " + c0048m);
                        }
                        if (this.f298g.contains(c0048m)) {
                            throw new IllegalStateException("Already added!");
                        }
                        this.f298g.add(c0048m);
                    }
                } else {
                    this.f298g = null;
                }
                if (aaVar.f92c != null) {
                    this.f300i = new ArrayList(aaVar.f92c.length);
                    for (i2 = 0; i2 < aaVar.f92c.length; i2++) {
                        C0040e a2 = aaVar.f92c[i2].m301a(this);
                        if (f291a) {
                            Log.v("FragmentManager", "restoreAllState: back stack #" + i2 + " (index " + a2.f168p + "): " + a2);
                            a2.m299a("  ", new PrintWriter(new C0108e("FragmentManager")), false);
                        }
                        this.f300i.add(a2);
                        if (a2.f168p >= 0) {
                            m401a(a2.f168p, a2);
                        }
                    }
                    return;
                }
                this.f300i = null;
            }
        }
    }

    void m406a(C0040e c0040e) {
        if (this.f300i == null) {
            this.f300i = new ArrayList();
        }
        this.f300i.add(c0040e);
        m430e();
    }

    public void m407a(C0048m c0048m) {
        if (!c0048m.f227L) {
            return;
        }
        if (this.f296e) {
            this.f313v = true;
            return;
        }
        c0048m.f227L = false;
        m409a(c0048m, this.f305n, 0, 0, false);
    }

    public void m408a(C0048m c0048m, int i, int i2) {
        if (f291a) {
            Log.v("FragmentManager", "remove: " + c0048m + " nesting=" + c0048m.f259s);
        }
        boolean z = !c0048m.m327a();
        if (!c0048m.f217B || z) {
            if (this.f298g != null) {
                this.f298g.remove(c0048m);
            }
            if (c0048m.f220E && c0048m.f221F) {
                this.f309r = true;
            }
            c0048m.f253m = false;
            c0048m.f254n = true;
            m409a(c0048m, z ? 0 : 1, i, i2, false);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    void m409a(android.support.v4.p002a.C0048m r11, int r12, int r13, int r14, boolean r15) {
        /*
        r10 = this;
        r9 = 4;
        r6 = 3;
        r5 = 1;
        r3 = 0;
        r7 = 0;
        r0 = r11.f253m;
        if (r0 == 0) goto L_0x000d;
    L_0x0009:
        r0 = r11.f217B;
        if (r0 == 0) goto L_0x0010;
    L_0x000d:
        if (r12 <= r5) goto L_0x0010;
    L_0x000f:
        r12 = r5;
    L_0x0010:
        r0 = r11.f254n;
        if (r0 == 0) goto L_0x001a;
    L_0x0014:
        r0 = r11.f242b;
        if (r12 <= r0) goto L_0x001a;
    L_0x0018:
        r12 = r11.f242b;
    L_0x001a:
        r0 = r11.f227L;
        if (r0 == 0) goto L_0x0025;
    L_0x001e:
        r0 = r11.f242b;
        if (r0 >= r9) goto L_0x0025;
    L_0x0022:
        if (r12 <= r6) goto L_0x0025;
    L_0x0024:
        r12 = r6;
    L_0x0025:
        r0 = r11.f242b;
        if (r0 >= r12) goto L_0x0265;
    L_0x0029:
        r0 = r11.f256p;
        if (r0 == 0) goto L_0x0032;
    L_0x002d:
        r0 = r11.f257q;
        if (r0 != 0) goto L_0x0032;
    L_0x0031:
        return;
    L_0x0032:
        r0 = r11.f243c;
        if (r0 == 0) goto L_0x0040;
    L_0x0036:
        r11.f243c = r7;
        r2 = r11.f244d;
        r0 = r10;
        r1 = r11;
        r4 = r3;
        r0.m409a(r1, r2, r3, r4, r5);
    L_0x0040:
        r0 = r11.f242b;
        switch(r0) {
            case 0: goto L_0x0048;
            case 1: goto L_0x0134;
            case 2: goto L_0x0200;
            case 3: goto L_0x0200;
            case 4: goto L_0x0221;
            default: goto L_0x0045;
        };
    L_0x0045:
        r11.f242b = r12;
        goto L_0x0031;
    L_0x0048:
        r0 = f291a;
        if (r0 == 0) goto L_0x0064;
    L_0x004c:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "moveto CREATED: ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x0064:
        r0 = r11.f245e;
        if (r0 == 0) goto L_0x00a8;
    L_0x0068:
        r0 = r11.f245e;
        r1 = r10.f306o;
        r1 = r1.getClassLoader();
        r0.setClassLoader(r1);
        r0 = r11.f245e;
        r1 = "android:view_state";
        r0 = r0.getSparseParcelableArray(r1);
        r11.f246f = r0;
        r0 = r11.f245e;
        r1 = "android:target_state";
        r0 = r10.m396a(r0, r1);
        r11.f250j = r0;
        r0 = r11.f250j;
        if (r0 == 0) goto L_0x0095;
    L_0x008b:
        r0 = r11.f245e;
        r1 = "android:target_req_state";
        r0 = r0.getInt(r1, r3);
        r11.f252l = r0;
    L_0x0095:
        r0 = r11.f245e;
        r1 = "android:user_visible_hint";
        r0 = r0.getBoolean(r1, r5);
        r11.f228M = r0;
        r0 = r11.f228M;
        if (r0 != 0) goto L_0x00a8;
    L_0x00a3:
        r11.f227L = r5;
        if (r12 <= r6) goto L_0x00a8;
    L_0x00a7:
        r12 = r6;
    L_0x00a8:
        r0 = r10.f306o;
        r11.f261u = r0;
        r0 = r10.f308q;
        r11.f263w = r0;
        r0 = r10.f308q;
        if (r0 == 0) goto L_0x00e4;
    L_0x00b4:
        r0 = r10.f308q;
        r0 = r0.f262v;
    L_0x00b8:
        r11.f260t = r0;
        r11.f222G = r3;
        r0 = r10.f306o;
        r11.m318a(r0);
        r0 = r11.f222G;
        if (r0 != 0) goto L_0x00e9;
    L_0x00c5:
        r0 = new android.support.v4.a.ax;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "Fragment ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r2 = " did not call through to super.onAttach()";
        r1 = r1.append(r2);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
    L_0x00e4:
        r0 = r10.f306o;
        r0 = r0.f269b;
        goto L_0x00b8;
    L_0x00e9:
        r0 = r11.f263w;
        if (r0 != 0) goto L_0x00f2;
    L_0x00ed:
        r0 = r10.f306o;
        r0.m377a(r11);
    L_0x00f2:
        r0 = r11.f219D;
        if (r0 != 0) goto L_0x00fb;
    L_0x00f6:
        r0 = r11.f245e;
        r11.m348g(r0);
    L_0x00fb:
        r11.f219D = r3;
        r0 = r11.f256p;
        if (r0 == 0) goto L_0x0134;
    L_0x0101:
        r0 = r11.f245e;
        r0 = r11.m330b(r0);
        r1 = r11.f245e;
        r0 = r11.m331b(r0, r7, r1);
        r11.f225J = r0;
        r0 = r11.f225J;
        if (r0 == 0) goto L_0x0254;
    L_0x0113:
        r0 = r11.f225J;
        r11.f226K = r0;
        r0 = android.os.Build.VERSION.SDK_INT;
        r1 = 11;
        if (r0 < r1) goto L_0x024a;
    L_0x011d:
        r0 = r11.f225J;
        android.support.v4.p000h.au.m691a(r0, r3);
    L_0x0122:
        r0 = r11.f216A;
        if (r0 == 0) goto L_0x012d;
    L_0x0126:
        r0 = r11.f225J;
        r1 = 8;
        r0.setVisibility(r1);
    L_0x012d:
        r0 = r11.f225J;
        r1 = r11.f245e;
        r11.m324a(r0, r1);
    L_0x0134:
        if (r12 <= r5) goto L_0x0200;
    L_0x0136:
        r0 = f291a;
        if (r0 == 0) goto L_0x0152;
    L_0x013a:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "moveto ACTIVITY_CREATED: ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x0152:
        r0 = r11.f256p;
        if (r0 != 0) goto L_0x01f0;
    L_0x0156:
        r0 = r11.f265y;
        if (r0 == 0) goto L_0x03c0;
    L_0x015a:
        r0 = r10.f307p;
        r1 = r11.f265y;
        r0 = r0.m370a(r1);
        r0 = (android.view.ViewGroup) r0;
        if (r0 != 0) goto L_0x01a9;
    L_0x0166:
        r1 = r11.f258r;
        if (r1 != 0) goto L_0x01a9;
    L_0x016a:
        r1 = new java.lang.IllegalArgumentException;
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r4 = "No view found for id 0x";
        r2 = r2.append(r4);
        r4 = r11.f265y;
        r4 = java.lang.Integer.toHexString(r4);
        r2 = r2.append(r4);
        r4 = " (";
        r2 = r2.append(r4);
        r4 = r11.m335c();
        r8 = r11.f265y;
        r4 = r4.getResourceName(r8);
        r2 = r2.append(r4);
        r4 = ") for fragment ";
        r2 = r2.append(r4);
        r2 = r2.append(r11);
        r2 = r2.toString();
        r1.<init>(r2);
        r10.m391a(r1);
    L_0x01a9:
        r11.f224I = r0;
        r1 = r11.f245e;
        r1 = r11.m330b(r1);
        r2 = r11.f245e;
        r1 = r11.m331b(r1, r0, r2);
        r11.f225J = r1;
        r1 = r11.f225J;
        if (r1 == 0) goto L_0x0262;
    L_0x01bd:
        r1 = r11.f225J;
        r11.f226K = r1;
        r1 = android.os.Build.VERSION.SDK_INT;
        r2 = 11;
        if (r1 < r2) goto L_0x0258;
    L_0x01c7:
        r1 = r11.f225J;
        android.support.v4.p000h.au.m691a(r1, r3);
    L_0x01cc:
        if (r0 == 0) goto L_0x01de;
    L_0x01ce:
        r1 = r10.m399a(r11, r13, r5, r14);
        if (r1 == 0) goto L_0x01d9;
    L_0x01d4:
        r2 = r11.f225J;
        r2.startAnimation(r1);
    L_0x01d9:
        r1 = r11.f225J;
        r0.addView(r1);
    L_0x01de:
        r0 = r11.f216A;
        if (r0 == 0) goto L_0x01e9;
    L_0x01e2:
        r0 = r11.f225J;
        r1 = 8;
        r0.setVisibility(r1);
    L_0x01e9:
        r0 = r11.f225J;
        r1 = r11.f245e;
        r11.m324a(r0, r1);
    L_0x01f0:
        r0 = r11.f245e;
        r11.m350h(r0);
        r0 = r11.f225J;
        if (r0 == 0) goto L_0x01fe;
    L_0x01f9:
        r0 = r11.f245e;
        r11.m321a(r0);
    L_0x01fe:
        r11.f245e = r7;
    L_0x0200:
        if (r12 <= r6) goto L_0x0221;
    L_0x0202:
        r0 = f291a;
        if (r0 == 0) goto L_0x021e;
    L_0x0206:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "moveto STARTED: ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x021e:
        r11.m369z();
    L_0x0221:
        if (r12 <= r9) goto L_0x0045;
    L_0x0223:
        r0 = f291a;
        if (r0 == 0) goto L_0x023f;
    L_0x0227:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "moveto RESUMED: ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x023f:
        r11.f255o = r5;
        r11.m307A();
        r11.f245e = r7;
        r11.f246f = r7;
        goto L_0x0045;
    L_0x024a:
        r0 = r11.f225J;
        r0 = android.support.v4.p002a.av.m253a(r0);
        r11.f225J = r0;
        goto L_0x0122;
    L_0x0254:
        r11.f226K = r7;
        goto L_0x0134;
    L_0x0258:
        r1 = r11.f225J;
        r1 = android.support.v4.p002a.av.m253a(r1);
        r11.f225J = r1;
        goto L_0x01cc;
    L_0x0262:
        r11.f226K = r7;
        goto L_0x01f0;
    L_0x0265:
        r0 = r11.f242b;
        if (r0 <= r12) goto L_0x0045;
    L_0x0269:
        r0 = r11.f242b;
        switch(r0) {
            case 1: goto L_0x0270;
            case 2: goto L_0x02f0;
            case 3: goto L_0x02cf;
            case 4: goto L_0x02ae;
            case 5: goto L_0x028a;
            default: goto L_0x026e;
        };
    L_0x026e:
        goto L_0x0045;
    L_0x0270:
        if (r12 >= r5) goto L_0x0045;
    L_0x0272:
        r0 = r10.f311t;
        if (r0 == 0) goto L_0x0281;
    L_0x0276:
        r0 = r11.f243c;
        if (r0 == 0) goto L_0x0281;
    L_0x027a:
        r0 = r11.f243c;
        r11.f243c = r7;
        r0.clearAnimation();
    L_0x0281:
        r0 = r11.f243c;
        if (r0 == 0) goto L_0x035d;
    L_0x0285:
        r11.f244d = r12;
        r12 = r5;
        goto L_0x0045;
    L_0x028a:
        r0 = 5;
        if (r12 >= r0) goto L_0x02ae;
    L_0x028d:
        r0 = f291a;
        if (r0 == 0) goto L_0x02a9;
    L_0x0291:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "movefrom RESUMED: ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x02a9:
        r11.m309C();
        r11.f255o = r3;
    L_0x02ae:
        if (r12 >= r9) goto L_0x02cf;
    L_0x02b0:
        r0 = f291a;
        if (r0 == 0) goto L_0x02cc;
    L_0x02b4:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "movefrom STARTED: ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x02cc:
        r11.m310D();
    L_0x02cf:
        if (r12 >= r6) goto L_0x02f0;
    L_0x02d1:
        r0 = f291a;
        if (r0 == 0) goto L_0x02ed;
    L_0x02d5:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "movefrom STOPPED: ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x02ed:
        r11.m311E();
    L_0x02f0:
        r0 = 2;
        if (r12 >= r0) goto L_0x0270;
    L_0x02f3:
        r0 = f291a;
        if (r0 == 0) goto L_0x030f;
    L_0x02f7:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "movefrom ACTIVITY_CREATED: ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x030f:
        r0 = r11.f225J;
        if (r0 == 0) goto L_0x0322;
    L_0x0313:
        r0 = r10.f306o;
        r0 = r0.isFinishing();
        if (r0 != 0) goto L_0x0322;
    L_0x031b:
        r0 = r11.f246f;
        if (r0 != 0) goto L_0x0322;
    L_0x031f:
        r10.m431e(r11);
    L_0x0322:
        r11.m312F();
        r0 = r11.f225J;
        if (r0 == 0) goto L_0x0355;
    L_0x0329:
        r0 = r11.f224I;
        if (r0 == 0) goto L_0x0355;
    L_0x032d:
        r0 = r10.f305n;
        if (r0 <= 0) goto L_0x03bd;
    L_0x0331:
        r0 = r10.f311t;
        if (r0 != 0) goto L_0x03bd;
    L_0x0335:
        r0 = r10.m399a(r11, r13, r3, r14);
    L_0x0339:
        if (r0 == 0) goto L_0x034e;
    L_0x033b:
        r1 = r11.f225J;
        r11.f243c = r1;
        r11.f244d = r12;
        r1 = new android.support.v4.a.y;
        r1.<init>(r10, r11);
        r0.setAnimationListener(r1);
        r1 = r11.f225J;
        r1.startAnimation(r0);
    L_0x034e:
        r0 = r11.f224I;
        r1 = r11.f225J;
        r0.removeView(r1);
    L_0x0355:
        r11.f224I = r7;
        r11.f225J = r7;
        r11.f226K = r7;
        goto L_0x0270;
    L_0x035d:
        r0 = f291a;
        if (r0 == 0) goto L_0x0379;
    L_0x0361:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "movefrom CREATED: ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x0379:
        r0 = r11.f219D;
        if (r0 != 0) goto L_0x0380;
    L_0x037d:
        r11.m313G();
    L_0x0380:
        r11.f222G = r3;
        r11.m358o();
        r0 = r11.f222G;
        if (r0 != 0) goto L_0x03a8;
    L_0x0389:
        r0 = new android.support.v4.a.ax;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "Fragment ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r2 = " did not call through to super.onDetach()";
        r1 = r1.append(r2);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
    L_0x03a8:
        if (r15 != 0) goto L_0x0045;
    L_0x03aa:
        r0 = r11.f219D;
        if (r0 != 0) goto L_0x03b3;
    L_0x03ae:
        r10.m427d(r11);
        goto L_0x0045;
    L_0x03b3:
        r11.f261u = r7;
        r11.f263w = r7;
        r11.f260t = r7;
        r11.f262v = r7;
        goto L_0x0045;
    L_0x03bd:
        r0 = r7;
        goto L_0x0339;
    L_0x03c0:
        r0 = r7;
        goto L_0x01a9;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.a.w.a(android.support.v4.a.m, int, int, int, boolean):void");
    }

    public void m410a(C0048m c0048m, boolean z) {
        if (this.f298g == null) {
            this.f298g = new ArrayList();
        }
        if (f291a) {
            Log.v("FragmentManager", "add: " + c0048m);
        }
        m425c(c0048m);
        if (!c0048m.f217B) {
            if (this.f298g.contains(c0048m)) {
                throw new IllegalStateException("Fragment already added: " + c0048m);
            }
            this.f298g.add(c0048m);
            c0048m.f253m = true;
            c0048m.f254n = false;
            if (c0048m.f220E && c0048m.f221F) {
                this.f309r = true;
            }
            if (z) {
                m419b(c0048m);
            }
        }
    }

    public void m411a(C0052p c0052p, C0049t c0049t, C0048m c0048m) {
        if (this.f306o != null) {
            throw new IllegalStateException("Already attached");
        }
        this.f306o = c0052p;
        this.f307p = c0049t;
        this.f308q = c0048m;
    }

    public void m412a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int size;
        int i;
        C0048m c0048m;
        int i2 = 0;
        String str2 = str + "    ";
        if (this.f297f != null) {
            size = this.f297f.size();
            if (size > 0) {
                printWriter.print(str);
                printWriter.print("Active Fragments in ");
                printWriter.print(Integer.toHexString(System.identityHashCode(this)));
                printWriter.println(":");
                for (i = 0; i < size; i++) {
                    c0048m = (C0048m) this.f297f.get(i);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i);
                    printWriter.print(": ");
                    printWriter.println(c0048m);
                    if (c0048m != null) {
                        c0048m.m325a(str2, fileDescriptor, printWriter, strArr);
                    }
                }
            }
        }
        if (this.f298g != null) {
            size = this.f298g.size();
            if (size > 0) {
                printWriter.print(str);
                printWriter.println("Added Fragments:");
                for (i = 0; i < size; i++) {
                    c0048m = (C0048m) this.f298g.get(i);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i);
                    printWriter.print(": ");
                    printWriter.println(c0048m.toString());
                }
            }
        }
        if (this.f301j != null) {
            size = this.f301j.size();
            if (size > 0) {
                printWriter.print(str);
                printWriter.println("Fragments Created Menus:");
                for (i = 0; i < size; i++) {
                    c0048m = (C0048m) this.f301j.get(i);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i);
                    printWriter.print(": ");
                    printWriter.println(c0048m.toString());
                }
            }
        }
        if (this.f300i != null) {
            size = this.f300i.size();
            if (size > 0) {
                printWriter.print(str);
                printWriter.println("Back Stack:");
                for (i = 0; i < size; i++) {
                    C0040e c0040e = (C0040e) this.f300i.get(i);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i);
                    printWriter.print(": ");
                    printWriter.println(c0040e.toString());
                    c0040e.m298a(str2, fileDescriptor, printWriter, strArr);
                }
            }
        }
        synchronized (this) {
            if (this.f302k != null) {
                int size2 = this.f302k.size();
                if (size2 > 0) {
                    printWriter.print(str);
                    printWriter.println("Back Stack Indices:");
                    for (i = 0; i < size2; i++) {
                        c0040e = (C0040e) this.f302k.get(i);
                        printWriter.print(str);
                        printWriter.print("  #");
                        printWriter.print(i);
                        printWriter.print(": ");
                        printWriter.println(c0040e);
                    }
                }
            }
            if (this.f303l != null && this.f303l.size() > 0) {
                printWriter.print(str);
                printWriter.print("mAvailBackStackIndices: ");
                printWriter.println(Arrays.toString(this.f303l.toArray()));
            }
        }
        if (this.f294c != null) {
            i = this.f294c.size();
            if (i > 0) {
                printWriter.print(str);
                printWriter.println("Pending Actions:");
                while (i2 < i) {
                    Runnable runnable = (Runnable) this.f294c.get(i2);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i2);
                    printWriter.print(": ");
                    printWriter.println(runnable);
                    i2++;
                }
            }
        }
        printWriter.print(str);
        printWriter.println("FragmentManager misc state:");
        printWriter.print(str);
        printWriter.print("  mActivity=");
        printWriter.println(this.f306o);
        printWriter.print(str);
        printWriter.print("  mContainer=");
        printWriter.println(this.f307p);
        if (this.f308q != null) {
            printWriter.print(str);
            printWriter.print("  mParent=");
            printWriter.println(this.f308q);
        }
        printWriter.print(str);
        printWriter.print("  mCurState=");
        printWriter.print(this.f305n);
        printWriter.print(" mStateSaved=");
        printWriter.print(this.f310s);
        printWriter.print(" mDestroyed=");
        printWriter.println(this.f311t);
        if (this.f309r) {
            printWriter.print(str);
            printWriter.print("  mNeedMenuInvalidate=");
            printWriter.println(this.f309r);
        }
        if (this.f312u != null) {
            printWriter.print(str);
            printWriter.print("  mNoTransactionsBecause=");
            printWriter.println(this.f312u);
        }
        if (this.f299h != null && this.f299h.size() > 0) {
            printWriter.print(str);
            printWriter.print("  mAvailIndices: ");
            printWriter.println(Arrays.toString(this.f299h.toArray()));
        }
    }

    public boolean m413a() {
        return m429d();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    boolean m414a(android.os.Handler r12, java.lang.String r13, int r14, int r15) {
        /*
        r11 = this;
        r4 = 0;
        r2 = 1;
        r3 = 0;
        r0 = r11.f300i;
        if (r0 != 0) goto L_0x0008;
    L_0x0007:
        return r3;
    L_0x0008:
        if (r13 != 0) goto L_0x0037;
    L_0x000a:
        if (r14 >= 0) goto L_0x0037;
    L_0x000c:
        r0 = r15 & 1;
        if (r0 != 0) goto L_0x0037;
    L_0x0010:
        r0 = r11.f300i;
        r0 = r0.size();
        r0 = r0 + -1;
        if (r0 < 0) goto L_0x0007;
    L_0x001a:
        r1 = r11.f300i;
        r0 = r1.remove(r0);
        r0 = (android.support.v4.p002a.C0040e) r0;
        r1 = new android.util.SparseArray;
        r1.<init>();
        r3 = new android.util.SparseArray;
        r3.<init>();
        r0.m297a(r1, r3);
        r0.m293a(r2, r4, r1, r3);
        r11.m430e();
    L_0x0035:
        r3 = r2;
        goto L_0x0007;
    L_0x0037:
        r0 = -1;
        if (r13 != 0) goto L_0x003c;
    L_0x003a:
        if (r14 < 0) goto L_0x008b;
    L_0x003c:
        r0 = r11.f300i;
        r0 = r0.size();
        r1 = r0 + -1;
    L_0x0044:
        if (r1 < 0) goto L_0x005a;
    L_0x0046:
        r0 = r11.f300i;
        r0 = r0.get(r1);
        r0 = (android.support.v4.p002a.C0040e) r0;
        if (r13 == 0) goto L_0x0081;
    L_0x0050:
        r5 = r0.m294a();
        r5 = r13.equals(r5);
        if (r5 == 0) goto L_0x0081;
    L_0x005a:
        if (r1 < 0) goto L_0x0007;
    L_0x005c:
        r0 = r15 & 1;
        if (r0 == 0) goto L_0x008a;
    L_0x0060:
        r1 = r1 + -1;
    L_0x0062:
        if (r1 < 0) goto L_0x008a;
    L_0x0064:
        r0 = r11.f300i;
        r0 = r0.get(r1);
        r0 = (android.support.v4.p002a.C0040e) r0;
        if (r13 == 0) goto L_0x0078;
    L_0x006e:
        r5 = r0.m294a();
        r5 = r13.equals(r5);
        if (r5 != 0) goto L_0x007e;
    L_0x0078:
        if (r14 < 0) goto L_0x008a;
    L_0x007a:
        r0 = r0.f168p;
        if (r14 != r0) goto L_0x008a;
    L_0x007e:
        r1 = r1 + -1;
        goto L_0x0062;
    L_0x0081:
        if (r14 < 0) goto L_0x0087;
    L_0x0083:
        r0 = r0.f168p;
        if (r14 == r0) goto L_0x005a;
    L_0x0087:
        r1 = r1 + -1;
        goto L_0x0044;
    L_0x008a:
        r0 = r1;
    L_0x008b:
        r1 = r11.f300i;
        r1 = r1.size();
        r1 = r1 + -1;
        if (r0 == r1) goto L_0x0007;
    L_0x0095:
        r6 = new java.util.ArrayList;
        r6.<init>();
        r1 = r11.f300i;
        r1 = r1.size();
        r1 = r1 + -1;
    L_0x00a2:
        if (r1 <= r0) goto L_0x00b0;
    L_0x00a4:
        r5 = r11.f300i;
        r5 = r5.remove(r1);
        r6.add(r5);
        r1 = r1 + -1;
        goto L_0x00a2;
    L_0x00b0:
        r0 = r6.size();
        r7 = r0 + -1;
        r8 = new android.util.SparseArray;
        r8.<init>();
        r9 = new android.util.SparseArray;
        r9.<init>();
        r1 = r3;
    L_0x00c1:
        if (r1 > r7) goto L_0x00d0;
    L_0x00c3:
        r0 = r6.get(r1);
        r0 = (android.support.v4.p002a.C0040e) r0;
        r0.m297a(r8, r9);
        r0 = r1 + 1;
        r1 = r0;
        goto L_0x00c1;
    L_0x00d0:
        r5 = r4;
        r4 = r3;
    L_0x00d2:
        if (r4 > r7) goto L_0x0108;
    L_0x00d4:
        r0 = f291a;
        if (r0 == 0) goto L_0x00f4;
    L_0x00d8:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r10 = "Popping back stack state: ";
        r1 = r1.append(r10);
        r10 = r6.get(r4);
        r1 = r1.append(r10);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x00f4:
        r0 = r6.get(r4);
        r0 = (android.support.v4.p002a.C0040e) r0;
        if (r4 != r7) goto L_0x0106;
    L_0x00fc:
        r1 = r2;
    L_0x00fd:
        r1 = r0.m293a(r1, r5, r8, r9);
        r0 = r4 + 1;
        r4 = r0;
        r5 = r1;
        goto L_0x00d2;
    L_0x0106:
        r1 = r3;
        goto L_0x00fd;
    L_0x0108:
        r11.m430e();
        goto L_0x0035;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.a.w.a(android.os.Handler, java.lang.String, int, int):boolean");
    }

    public boolean m415a(Menu menu) {
        if (this.f298g == null) {
            return false;
        }
        boolean z = false;
        for (int i = 0; i < this.f298g.size(); i++) {
            C0048m c0048m = (C0048m) this.f298g.get(i);
            if (c0048m != null && c0048m.m337c(menu)) {
                z = true;
            }
        }
        return z;
    }

    public boolean m416a(Menu menu, MenuInflater menuInflater) {
        boolean z;
        C0048m c0048m;
        int i = 0;
        ArrayList arrayList = null;
        if (this.f298g != null) {
            int i2 = 0;
            z = false;
            while (i2 < this.f298g.size()) {
                c0048m = (C0048m) this.f298g.get(i2);
                if (c0048m != null && c0048m.m333b(menu, menuInflater)) {
                    z = true;
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(c0048m);
                }
                i2++;
                z = z;
            }
        } else {
            z = false;
        }
        if (this.f301j != null) {
            while (i < this.f301j.size()) {
                c0048m = (C0048m) this.f301j.get(i);
                if (arrayList == null || !arrayList.contains(c0048m)) {
                    c0048m.m359p();
                }
                i++;
            }
        }
        this.f301j = arrayList;
        return z;
    }

    public boolean m417a(MenuItem menuItem) {
        if (this.f298g == null) {
            return false;
        }
        for (int i = 0; i < this.f298g.size(); i++) {
            C0048m c0048m = (C0048m) this.f298g.get(i);
            if (c0048m != null && c0048m.m338c(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public void m418b(int i) {
        synchronized (this) {
            this.f302k.set(i, null);
            if (this.f303l == null) {
                this.f303l = new ArrayList();
            }
            if (f291a) {
                Log.v("FragmentManager", "Freeing back stack index " + i);
            }
            this.f303l.add(Integer.valueOf(i));
        }
    }

    void m419b(C0048m c0048m) {
        m409a(c0048m, this.f305n, 0, 0, false);
    }

    public void m420b(C0048m c0048m, int i, int i2) {
        if (f291a) {
            Log.v("FragmentManager", "hide: " + c0048m);
        }
        if (!c0048m.f216A) {
            c0048m.f216A = true;
            if (c0048m.f225J != null) {
                Animation a = m399a(c0048m, i, false, i2);
                if (a != null) {
                    c0048m.f225J.startAnimation(a);
                }
                c0048m.f225J.setVisibility(8);
            }
            if (c0048m.f253m && c0048m.f220E && c0048m.f221F) {
                this.f309r = true;
            }
            c0048m.m326a(true);
        }
    }

    public void m421b(Menu menu) {
        if (this.f298g != null) {
            for (int i = 0; i < this.f298g.size(); i++) {
                C0048m c0048m = (C0048m) this.f298g.get(i);
                if (c0048m != null) {
                    c0048m.m341d(menu);
                }
            }
        }
    }

    public boolean m422b() {
        m394t();
        m413a();
        return m414a(this.f306o.f268a, null, -1, 0);
    }

    public boolean m423b(MenuItem menuItem) {
        if (this.f298g == null) {
            return false;
        }
        for (int i = 0; i < this.f298g.size(); i++) {
            C0048m c0048m = (C0048m) this.f298g.get(i);
            if (c0048m != null && c0048m.m342d(menuItem)) {
                return true;
            }
        }
        return false;
    }

    void m424c() {
        if (this.f297f != null) {
            for (int i = 0; i < this.f297f.size(); i++) {
                C0048m c0048m = (C0048m) this.f297f.get(i);
                if (c0048m != null) {
                    m407a(c0048m);
                }
            }
        }
    }

    void m425c(C0048m c0048m) {
        if (c0048m.f247g < 0) {
            if (this.f299h == null || this.f299h.size() <= 0) {
                if (this.f297f == null) {
                    this.f297f = new ArrayList();
                }
                c0048m.m317a(this.f297f.size(), this.f308q);
                this.f297f.add(c0048m);
            } else {
                c0048m.m317a(((Integer) this.f299h.remove(this.f299h.size() - 1)).intValue(), this.f308q);
                this.f297f.set(c0048m.f247g, c0048m);
            }
            if (f291a) {
                Log.v("FragmentManager", "Allocated fragment index " + c0048m);
            }
        }
    }

    public void m426c(C0048m c0048m, int i, int i2) {
        if (f291a) {
            Log.v("FragmentManager", "show: " + c0048m);
        }
        if (c0048m.f216A) {
            c0048m.f216A = false;
            if (c0048m.f225J != null) {
                Animation a = m399a(c0048m, i, true, i2);
                if (a != null) {
                    c0048m.f225J.startAnimation(a);
                }
                c0048m.f225J.setVisibility(0);
            }
            if (c0048m.f253m && c0048m.f220E && c0048m.f221F) {
                this.f309r = true;
            }
            c0048m.m326a(false);
        }
    }

    void m427d(C0048m c0048m) {
        if (c0048m.f247g >= 0) {
            if (f291a) {
                Log.v("FragmentManager", "Freeing fragment index " + c0048m);
            }
            this.f297f.set(c0048m.f247g, null);
            if (this.f299h == null) {
                this.f299h = new ArrayList();
            }
            this.f299h.add(Integer.valueOf(c0048m.f247g));
            this.f306o.m378a(c0048m.f248h);
            c0048m.m357n();
        }
    }

    public void m428d(C0048m c0048m, int i, int i2) {
        if (f291a) {
            Log.v("FragmentManager", "detach: " + c0048m);
        }
        if (!c0048m.f217B) {
            c0048m.f217B = true;
            if (c0048m.f253m) {
                if (this.f298g != null) {
                    if (f291a) {
                        Log.v("FragmentManager", "remove from detach: " + c0048m);
                    }
                    this.f298g.remove(c0048m);
                }
                if (c0048m.f220E && c0048m.f221F) {
                    this.f309r = true;
                }
                c0048m.f253m = false;
                m409a(c0048m, 1, i, i2, false);
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean m429d() {
        /*
        r6 = this;
        r0 = 1;
        r2 = 0;
        r1 = r6.f296e;
        if (r1 == 0) goto L_0x000e;
    L_0x0006:
        r0 = new java.lang.IllegalStateException;
        r1 = "Recursive entry to executePendingTransactions";
        r0.<init>(r1);
        throw r0;
    L_0x000e:
        r1 = android.os.Looper.myLooper();
        r3 = r6.f306o;
        r3 = r3.f268a;
        r3 = r3.getLooper();
        if (r1 == r3) goto L_0x0024;
    L_0x001c:
        r0 = new java.lang.IllegalStateException;
        r1 = "Must be called from main thread of process";
        r0.<init>(r1);
        throw r0;
    L_0x0024:
        r1 = r2;
    L_0x0025:
        monitor-enter(r6);
        r3 = r6.f294c;	 Catch:{ all -> 0x0097 }
        if (r3 == 0) goto L_0x0032;
    L_0x002a:
        r3 = r6.f294c;	 Catch:{ all -> 0x0097 }
        r3 = r3.size();	 Catch:{ all -> 0x0097 }
        if (r3 != 0) goto L_0x005a;
    L_0x0032:
        monitor-exit(r6);	 Catch:{ all -> 0x0097 }
        r0 = r6.f313v;
        if (r0 == 0) goto L_0x00a5;
    L_0x0037:
        r3 = r2;
        r4 = r2;
    L_0x0039:
        r0 = r6.f297f;
        r0 = r0.size();
        if (r3 >= r0) goto L_0x009e;
    L_0x0041:
        r0 = r6.f297f;
        r0 = r0.get(r3);
        r0 = (android.support.v4.p002a.C0048m) r0;
        if (r0 == 0) goto L_0x0056;
    L_0x004b:
        r5 = r0.f229N;
        if (r5 == 0) goto L_0x0056;
    L_0x004f:
        r0 = r0.f229N;
        r0 = r0.m214a();
        r4 = r4 | r0;
    L_0x0056:
        r0 = r3 + 1;
        r3 = r0;
        goto L_0x0039;
    L_0x005a:
        r1 = r6.f294c;	 Catch:{ all -> 0x0097 }
        r3 = r1.size();	 Catch:{ all -> 0x0097 }
        r1 = r6.f295d;	 Catch:{ all -> 0x0097 }
        if (r1 == 0) goto L_0x0069;
    L_0x0064:
        r1 = r6.f295d;	 Catch:{ all -> 0x0097 }
        r1 = r1.length;	 Catch:{ all -> 0x0097 }
        if (r1 >= r3) goto L_0x006d;
    L_0x0069:
        r1 = new java.lang.Runnable[r3];	 Catch:{ all -> 0x0097 }
        r6.f295d = r1;	 Catch:{ all -> 0x0097 }
    L_0x006d:
        r1 = r6.f294c;	 Catch:{ all -> 0x0097 }
        r4 = r6.f295d;	 Catch:{ all -> 0x0097 }
        r1.toArray(r4);	 Catch:{ all -> 0x0097 }
        r1 = r6.f294c;	 Catch:{ all -> 0x0097 }
        r1.clear();	 Catch:{ all -> 0x0097 }
        r1 = r6.f306o;	 Catch:{ all -> 0x0097 }
        r1 = r1.f268a;	 Catch:{ all -> 0x0097 }
        r4 = r6.f316y;	 Catch:{ all -> 0x0097 }
        r1.removeCallbacks(r4);	 Catch:{ all -> 0x0097 }
        monitor-exit(r6);	 Catch:{ all -> 0x0097 }
        r6.f296e = r0;
        r1 = r2;
    L_0x0086:
        if (r1 >= r3) goto L_0x009a;
    L_0x0088:
        r4 = r6.f295d;
        r4 = r4[r1];
        r4.run();
        r4 = r6.f295d;
        r5 = 0;
        r4[r1] = r5;
        r1 = r1 + 1;
        goto L_0x0086;
    L_0x0097:
        r0 = move-exception;
        monitor-exit(r6);	 Catch:{ all -> 0x0097 }
        throw r0;
    L_0x009a:
        r6.f296e = r2;
        r1 = r0;
        goto L_0x0025;
    L_0x009e:
        if (r4 != 0) goto L_0x00a5;
    L_0x00a0:
        r6.f313v = r2;
        r6.m424c();
    L_0x00a5:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.a.w.d():boolean");
    }

    void m430e() {
        if (this.f304m != null) {
            for (int i = 0; i < this.f304m.size(); i++) {
                ((C0057v) this.f304m.get(i)).m387a();
            }
        }
    }

    void m431e(C0048m c0048m) {
        if (c0048m.f226K != null) {
            if (this.f315x == null) {
                this.f315x = new SparseArray();
            } else {
                this.f315x.clear();
            }
            c0048m.f226K.saveHierarchyState(this.f315x);
            if (this.f315x.size() > 0) {
                c0048m.f246f = this.f315x;
                this.f315x = null;
            }
        }
    }

    public void m432e(C0048m c0048m, int i, int i2) {
        if (f291a) {
            Log.v("FragmentManager", "attach: " + c0048m);
        }
        if (c0048m.f217B) {
            c0048m.f217B = false;
            if (!c0048m.f253m) {
                if (this.f298g == null) {
                    this.f298g = new ArrayList();
                }
                if (this.f298g.contains(c0048m)) {
                    throw new IllegalStateException("Fragment already added: " + c0048m);
                }
                if (f291a) {
                    Log.v("FragmentManager", "add from attach: " + c0048m);
                }
                this.f298g.add(c0048m);
                c0048m.f253m = true;
                if (c0048m.f220E && c0048m.f221F) {
                    this.f309r = true;
                }
                m409a(c0048m, this.f305n, i, i2, false);
            }
        }
    }

    Bundle m433f(C0048m c0048m) {
        Bundle bundle;
        if (this.f314w == null) {
            this.f314w = new Bundle();
        }
        c0048m.m352i(this.f314w);
        if (this.f314w.isEmpty()) {
            bundle = null;
        } else {
            bundle = this.f314w;
            this.f314w = null;
        }
        if (c0048m.f225J != null) {
            m431e(c0048m);
        }
        if (c0048m.f246f != null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putSparseParcelableArray("android:view_state", c0048m.f246f);
        }
        if (!c0048m.f228M) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putBoolean("android:user_visible_hint", c0048m.f228M);
        }
        return bundle;
    }

    ArrayList m434f() {
        ArrayList arrayList = null;
        if (this.f297f != null) {
            for (int i = 0; i < this.f297f.size(); i++) {
                C0048m c0048m = (C0048m) this.f297f.get(i);
                if (c0048m != null && c0048m.f218C) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(c0048m);
                    c0048m.f219D = true;
                    c0048m.f251k = c0048m.f250j != null ? c0048m.f250j.f247g : -1;
                    if (f291a) {
                        Log.v("FragmentManager", "retainNonConfig: keeping retained " + c0048m);
                    }
                }
            }
        }
        return arrayList;
    }

    Parcelable m435g() {
        C0046k[] c0046kArr = null;
        m429d();
        if (f292b) {
            this.f310s = true;
        }
        if (this.f297f == null || this.f297f.size() <= 0) {
            return null;
        }
        int size = this.f297f.size();
        ac[] acVarArr = new ac[size];
        int i = 0;
        boolean z = false;
        while (i < size) {
            boolean z2;
            C0048m c0048m = (C0048m) this.f297f.get(i);
            if (c0048m != null) {
                if (c0048m.f247g < 0) {
                    m391a(new IllegalStateException("Failure saving state: active " + c0048m + " has cleared index: " + c0048m.f247g));
                }
                ac acVar = new ac(c0048m);
                acVarArr[i] = acVar;
                if (c0048m.f242b <= 0 || acVar.f102j != null) {
                    acVar.f102j = c0048m.f245e;
                } else {
                    acVar.f102j = m433f(c0048m);
                    if (c0048m.f250j != null) {
                        if (c0048m.f250j.f247g < 0) {
                            m391a(new IllegalStateException("Failure saving state: " + c0048m + " has target not in fragment manager: " + c0048m.f250j));
                        }
                        if (acVar.f102j == null) {
                            acVar.f102j = new Bundle();
                        }
                        m404a(acVar.f102j, "android:target_state", c0048m.f250j);
                        if (c0048m.f252l != 0) {
                            acVar.f102j.putInt("android:target_req_state", c0048m.f252l);
                        }
                    }
                }
                if (f291a) {
                    Log.v("FragmentManager", "Saved state of " + c0048m + ": " + acVar.f102j);
                }
                z2 = true;
            } else {
                z2 = z;
            }
            i++;
            z = z2;
        }
        if (z) {
            int[] iArr;
            int i2;
            aa aaVar;
            if (this.f298g != null) {
                i = this.f298g.size();
                if (i > 0) {
                    iArr = new int[i];
                    for (i2 = 0; i2 < i; i2++) {
                        iArr[i2] = ((C0048m) this.f298g.get(i2)).f247g;
                        if (iArr[i2] < 0) {
                            m391a(new IllegalStateException("Failure saving state: active " + this.f298g.get(i2) + " has cleared index: " + iArr[i2]));
                        }
                        if (f291a) {
                            Log.v("FragmentManager", "saveAllState: adding fragment #" + i2 + ": " + this.f298g.get(i2));
                        }
                    }
                    if (this.f300i != null) {
                        i = this.f300i.size();
                        if (i > 0) {
                            c0046kArr = new C0046k[i];
                            for (i2 = 0; i2 < i; i2++) {
                                c0046kArr[i2] = new C0046k(this, (C0040e) this.f300i.get(i2));
                                if (f291a) {
                                    Log.v("FragmentManager", "saveAllState: adding back stack #" + i2 + ": " + this.f300i.get(i2));
                                }
                            }
                        }
                    }
                    aaVar = new aa();
                    aaVar.f90a = acVarArr;
                    aaVar.f91b = iArr;
                    aaVar.f92c = c0046kArr;
                    return aaVar;
                }
            }
            iArr = null;
            if (this.f300i != null) {
                i = this.f300i.size();
                if (i > 0) {
                    c0046kArr = new C0046k[i];
                    for (i2 = 0; i2 < i; i2++) {
                        c0046kArr[i2] = new C0046k(this, (C0040e) this.f300i.get(i2));
                        if (f291a) {
                            Log.v("FragmentManager", "saveAllState: adding back stack #" + i2 + ": " + this.f300i.get(i2));
                        }
                    }
                }
            }
            aaVar = new aa();
            aaVar.f90a = acVarArr;
            aaVar.f91b = iArr;
            aaVar.f92c = c0046kArr;
            return aaVar;
        } else if (!f291a) {
            return null;
        } else {
            Log.v("FragmentManager", "saveAllState: no fragments!");
            return null;
        }
    }

    public void m436h() {
        this.f310s = false;
    }

    public void m437i() {
        this.f310s = false;
        m402a(1, false);
    }

    public void m438j() {
        this.f310s = false;
        m402a(2, false);
    }

    public void m439k() {
        this.f310s = false;
        m402a(4, false);
    }

    public void m440l() {
        this.f310s = false;
        m402a(5, false);
    }

    public void m441m() {
        m402a(4, false);
    }

    public void m442n() {
        this.f310s = true;
        m402a(3, false);
    }

    public void m443o() {
        m402a(2, false);
    }

    public void m444p() {
        m402a(1, false);
    }

    public void m445q() {
        this.f311t = true;
        m429d();
        m402a(0, false);
        this.f306o = null;
        this.f307p = null;
        this.f308q = null;
    }

    public void m446r() {
        if (this.f298g != null) {
            for (int i = 0; i < this.f298g.size(); i++) {
                C0048m c0048m = (C0048m) this.f298g.get(i);
                if (c0048m != null) {
                    c0048m.m308B();
                }
            }
        }
    }

    C0058s m447s() {
        return this;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(128);
        stringBuilder.append("FragmentManager{");
        stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
        stringBuilder.append(" in ");
        if (this.f308q != null) {
            C0107d.m591a(this.f308q, stringBuilder);
        } else {
            C0107d.m591a(this.f306o, stringBuilder);
        }
        stringBuilder.append("}}");
        return stringBuilder.toString();
    }
}
