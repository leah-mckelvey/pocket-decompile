package android.support.v4.p002a;

import android.app.Activity;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.p000h.C0126i;
import android.support.v4.p009g.C0102m;
import android.support.v4.p009g.C0107d;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* renamed from: android.support.v4.a.m */
public class C0048m implements ComponentCallbacks, OnCreateContextMenuListener {
    static final Object f215a;
    private static final C0102m aa;
    boolean f216A;
    boolean f217B;
    boolean f218C;
    boolean f219D;
    boolean f220E;
    boolean f221F;
    boolean f222G;
    int f223H;
    ViewGroup f224I;
    View f225J;
    View f226K;
    boolean f227L;
    boolean f228M;
    ao f229N;
    boolean f230O;
    boolean f231P;
    Object f232Q;
    Object f233R;
    Object f234S;
    Object f235T;
    Object f236U;
    Object f237V;
    Boolean f238W;
    Boolean f239X;
    aw f240Y;
    aw f241Z;
    int f242b;
    View f243c;
    int f244d;
    Bundle f245e;
    SparseArray f246f;
    int f247g;
    String f248h;
    Bundle f249i;
    C0048m f250j;
    int f251k;
    int f252l;
    boolean f253m;
    boolean f254n;
    boolean f255o;
    boolean f256p;
    boolean f257q;
    boolean f258r;
    int f259s;
    C0059w f260t;
    C0052p f261u;
    C0059w f262v;
    C0048m f263w;
    int f264x;
    int f265y;
    String f266z;

    static {
        aa = new C0102m();
        f215a = new Object();
    }

    public C0048m() {
        this.f242b = 0;
        this.f247g = -1;
        this.f251k = -1;
        this.f221F = true;
        this.f228M = true;
        this.f232Q = null;
        this.f233R = f215a;
        this.f234S = null;
        this.f235T = f215a;
        this.f236U = null;
        this.f237V = f215a;
        this.f240Y = null;
        this.f241Z = null;
    }

    public static C0048m m304a(Context context, String str) {
        return C0048m.m305a(context, str, null);
    }

    public static C0048m m305a(Context context, String str, Bundle bundle) {
        try {
            Class cls = (Class) aa.get(str);
            if (cls == null) {
                cls = context.getClassLoader().loadClass(str);
                aa.put(str, cls);
            }
            C0048m c0048m = (C0048m) cls.newInstance();
            if (bundle != null) {
                bundle.setClassLoader(c0048m.getClass().getClassLoader());
                c0048m.f249i = bundle;
            }
            return c0048m;
        } catch (Exception e) {
            throw new C0051o("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an" + " empty constructor that is public", e);
        } catch (Exception e2) {
            throw new C0051o("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an" + " empty constructor that is public", e2);
        } catch (Exception e22) {
            throw new C0051o("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an" + " empty constructor that is public", e22);
        }
    }

    static boolean m306b(Context context, String str) {
        try {
            Class cls = (Class) aa.get(str);
            if (cls == null) {
                cls = context.getClassLoader().loadClass(str);
                aa.put(str, cls);
            }
            return C0048m.class.isAssignableFrom(cls);
        } catch (ClassNotFoundException e) {
            return false;
        }
    }

    void m307A() {
        if (this.f262v != null) {
            this.f262v.m436h();
            this.f262v.m429d();
        }
        this.f222G = false;
        m351i();
        if (!this.f222G) {
            throw new ax("Fragment " + this + " did not call through to super.onResume()");
        } else if (this.f262v != null) {
            this.f262v.m440l();
            this.f262v.m429d();
        }
    }

    void m308B() {
        onLowMemory();
        if (this.f262v != null) {
            this.f262v.m446r();
        }
    }

    void m309C() {
        if (this.f262v != null) {
            this.f262v.m441m();
        }
        this.f222G = false;
        m353j();
        if (!this.f222G) {
            throw new ax("Fragment " + this + " did not call through to super.onPause()");
        }
    }

    void m310D() {
        if (this.f262v != null) {
            this.f262v.m442n();
        }
        this.f222G = false;
        m354k();
        if (!this.f222G) {
            throw new ax("Fragment " + this + " did not call through to super.onStop()");
        }
    }

    void m311E() {
        if (this.f262v != null) {
            this.f262v.m443o();
        }
        if (this.f230O) {
            this.f230O = false;
            if (!this.f231P) {
                this.f231P = true;
                this.f229N = this.f261u.m376a(this.f248h, this.f230O, false);
            }
            if (this.f229N == null) {
                return;
            }
            if (this.f261u.f275h) {
                this.f229N.m217d();
            } else {
                this.f229N.m216c();
            }
        }
    }

    void m312F() {
        if (this.f262v != null) {
            this.f262v.m444p();
        }
        this.f222G = false;
        m355l();
        if (!this.f222G) {
            throw new ax("Fragment " + this + " did not call through to super.onDestroyView()");
        } else if (this.f229N != null) {
            this.f229N.m219f();
        }
    }

    void m313G() {
        if (this.f262v != null) {
            this.f262v.m445q();
        }
        this.f222G = false;
        m356m();
        if (!this.f222G) {
            throw new ax("Fragment " + this + " did not call through to super.onDestroy()");
        }
    }

    public View m314a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return null;
    }

    public Animation m315a(int i, boolean z, int i2) {
        return null;
    }

    public void m316a(int i, int i2, Intent intent) {
    }

    final void m317a(int i, C0048m c0048m) {
        this.f247g = i;
        if (c0048m != null) {
            this.f248h = c0048m.f248h + ":" + this.f247g;
        } else {
            this.f248h = "android:fragment:" + this.f247g;
        }
    }

    public void m318a(Activity activity) {
        this.f222G = true;
    }

    public void m319a(Activity activity, AttributeSet attributeSet, Bundle bundle) {
        this.f222G = true;
    }

    void m320a(Configuration configuration) {
        onConfigurationChanged(configuration);
        if (this.f262v != null) {
            this.f262v.m403a(configuration);
        }
    }

    final void m321a(Bundle bundle) {
        if (this.f246f != null) {
            this.f226K.restoreHierarchyState(this.f246f);
            this.f246f = null;
        }
        this.f222G = false;
        m343e(bundle);
        if (!this.f222G) {
            throw new ax("Fragment " + this + " did not call through to super.onViewStateRestored()");
        }
    }

    public void m322a(Menu menu) {
    }

    public void m323a(Menu menu, MenuInflater menuInflater) {
    }

    public void m324a(View view, Bundle bundle) {
    }

    public void m325a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mFragmentId=#");
        printWriter.print(Integer.toHexString(this.f264x));
        printWriter.print(" mContainerId=#");
        printWriter.print(Integer.toHexString(this.f265y));
        printWriter.print(" mTag=");
        printWriter.println(this.f266z);
        printWriter.print(str);
        printWriter.print("mState=");
        printWriter.print(this.f242b);
        printWriter.print(" mIndex=");
        printWriter.print(this.f247g);
        printWriter.print(" mWho=");
        printWriter.print(this.f248h);
        printWriter.print(" mBackStackNesting=");
        printWriter.println(this.f259s);
        printWriter.print(str);
        printWriter.print("mAdded=");
        printWriter.print(this.f253m);
        printWriter.print(" mRemoving=");
        printWriter.print(this.f254n);
        printWriter.print(" mResumed=");
        printWriter.print(this.f255o);
        printWriter.print(" mFromLayout=");
        printWriter.print(this.f256p);
        printWriter.print(" mInLayout=");
        printWriter.println(this.f257q);
        printWriter.print(str);
        printWriter.print("mHidden=");
        printWriter.print(this.f216A);
        printWriter.print(" mDetached=");
        printWriter.print(this.f217B);
        printWriter.print(" mMenuVisible=");
        printWriter.print(this.f221F);
        printWriter.print(" mHasMenu=");
        printWriter.println(this.f220E);
        printWriter.print(str);
        printWriter.print("mRetainInstance=");
        printWriter.print(this.f218C);
        printWriter.print(" mRetaining=");
        printWriter.print(this.f219D);
        printWriter.print(" mUserVisibleHint=");
        printWriter.println(this.f228M);
        if (this.f260t != null) {
            printWriter.print(str);
            printWriter.print("mFragmentManager=");
            printWriter.println(this.f260t);
        }
        if (this.f261u != null) {
            printWriter.print(str);
            printWriter.print("mActivity=");
            printWriter.println(this.f261u);
        }
        if (this.f263w != null) {
            printWriter.print(str);
            printWriter.print("mParentFragment=");
            printWriter.println(this.f263w);
        }
        if (this.f249i != null) {
            printWriter.print(str);
            printWriter.print("mArguments=");
            printWriter.println(this.f249i);
        }
        if (this.f245e != null) {
            printWriter.print(str);
            printWriter.print("mSavedFragmentState=");
            printWriter.println(this.f245e);
        }
        if (this.f246f != null) {
            printWriter.print(str);
            printWriter.print("mSavedViewState=");
            printWriter.println(this.f246f);
        }
        if (this.f250j != null) {
            printWriter.print(str);
            printWriter.print("mTarget=");
            printWriter.print(this.f250j);
            printWriter.print(" mTargetRequestCode=");
            printWriter.println(this.f252l);
        }
        if (this.f223H != 0) {
            printWriter.print(str);
            printWriter.print("mNextAnim=");
            printWriter.println(this.f223H);
        }
        if (this.f224I != null) {
            printWriter.print(str);
            printWriter.print("mContainer=");
            printWriter.println(this.f224I);
        }
        if (this.f225J != null) {
            printWriter.print(str);
            printWriter.print("mView=");
            printWriter.println(this.f225J);
        }
        if (this.f226K != null) {
            printWriter.print(str);
            printWriter.print("mInnerView=");
            printWriter.println(this.f225J);
        }
        if (this.f243c != null) {
            printWriter.print(str);
            printWriter.print("mAnimatingAway=");
            printWriter.println(this.f243c);
            printWriter.print(str);
            printWriter.print("mStateAfterAnimating=");
            printWriter.println(this.f244d);
        }
        if (this.f229N != null) {
            printWriter.print(str);
            printWriter.println("Loader Manager:");
            this.f229N.m213a(str + "  ", fileDescriptor, printWriter, strArr);
        }
        if (this.f262v != null) {
            printWriter.print(str);
            printWriter.println("Child " + this.f262v + ":");
            this.f262v.m412a(str + "  ", fileDescriptor, printWriter, strArr);
        }
    }

    public void m326a(boolean z) {
    }

    final boolean m327a() {
        return this.f259s > 0;
    }

    public boolean m328a(MenuItem menuItem) {
        return false;
    }

    public final C0052p m329b() {
        return this.f261u;
    }

    public LayoutInflater m330b(Bundle bundle) {
        LayoutInflater cloneInContext = this.f261u.getLayoutInflater().cloneInContext(this.f261u);
        m339d();
        C0126i.m949a(cloneInContext, this.f262v.m447s());
        return cloneInContext;
    }

    View m331b(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.f262v != null) {
            this.f262v.m436h();
        }
        return m314a(layoutInflater, viewGroup, bundle);
    }

    public void m332b(Menu menu) {
    }

    boolean m333b(Menu menu, MenuInflater menuInflater) {
        boolean z = false;
        if (this.f216A) {
            return false;
        }
        if (this.f220E && this.f221F) {
            z = true;
            m323a(menu, menuInflater);
        }
        return this.f262v != null ? z | this.f262v.m416a(menu, menuInflater) : z;
    }

    public boolean m334b(MenuItem menuItem) {
        return false;
    }

    public final Resources m335c() {
        if (this.f261u != null) {
            return this.f261u.getResources();
        }
        throw new IllegalStateException("Fragment " + this + " not attached to Activity");
    }

    public void m336c(Bundle bundle) {
        this.f222G = true;
    }

    boolean m337c(Menu menu) {
        boolean z = false;
        if (this.f216A) {
            return false;
        }
        if (this.f220E && this.f221F) {
            z = true;
            m322a(menu);
        }
        return this.f262v != null ? z | this.f262v.m415a(menu) : z;
    }

    boolean m338c(MenuItem menuItem) {
        if (!this.f216A) {
            if (this.f220E && this.f221F && m328a(menuItem)) {
                return true;
            }
            if (this.f262v != null && this.f262v.m417a(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public final C0056u m339d() {
        if (this.f262v == null) {
            m368y();
            if (this.f242b >= 5) {
                this.f262v.m440l();
            } else if (this.f242b >= 4) {
                this.f262v.m439k();
            } else if (this.f242b >= 2) {
                this.f262v.m438j();
            } else if (this.f242b >= 1) {
                this.f262v.m437i();
            }
        }
        return this.f262v;
    }

    public void m340d(Bundle bundle) {
        this.f222G = true;
    }

    void m341d(Menu menu) {
        if (!this.f216A) {
            if (this.f220E && this.f221F) {
                m332b(menu);
            }
            if (this.f262v != null) {
                this.f262v.m421b(menu);
            }
        }
    }

    boolean m342d(MenuItem menuItem) {
        if (!this.f216A) {
            if (m334b(menuItem)) {
                return true;
            }
            if (this.f262v != null && this.f262v.m423b(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public void m343e(Bundle bundle) {
        this.f222G = true;
    }

    public final boolean m344e() {
        return this.f261u != null && this.f253m;
    }

    public final boolean equals(Object obj) {
        return super.equals(obj);
    }

    public void m345f(Bundle bundle) {
    }

    public final boolean m346f() {
        return this.f216A;
    }

    public View m347g() {
        return this.f225J;
    }

    void m348g(Bundle bundle) {
        if (this.f262v != null) {
            this.f262v.m436h();
        }
        this.f222G = false;
        m336c(bundle);
        if (!this.f222G) {
            throw new ax("Fragment " + this + " did not call through to super.onCreate()");
        } else if (bundle != null) {
            Parcelable parcelable = bundle.getParcelable("android:support:fragments");
            if (parcelable != null) {
                if (this.f262v == null) {
                    m368y();
                }
                this.f262v.m405a(parcelable, null);
                this.f262v.m437i();
            }
        }
    }

    public void m349h() {
        this.f222G = true;
        if (!this.f230O) {
            this.f230O = true;
            if (!this.f231P) {
                this.f231P = true;
                this.f229N = this.f261u.m376a(this.f248h, this.f230O, false);
            }
            if (this.f229N != null) {
                this.f229N.m215b();
            }
        }
    }

    void m350h(Bundle bundle) {
        if (this.f262v != null) {
            this.f262v.m436h();
        }
        this.f222G = false;
        m340d(bundle);
        if (!this.f222G) {
            throw new ax("Fragment " + this + " did not call through to super.onActivityCreated()");
        } else if (this.f262v != null) {
            this.f262v.m438j();
        }
    }

    public final int hashCode() {
        return super.hashCode();
    }

    public void m351i() {
        this.f222G = true;
    }

    void m352i(Bundle bundle) {
        m345f(bundle);
        if (this.f262v != null) {
            Parcelable g = this.f262v.m435g();
            if (g != null) {
                bundle.putParcelable("android:support:fragments", g);
            }
        }
    }

    public void m353j() {
        this.f222G = true;
    }

    public void m354k() {
        this.f222G = true;
    }

    public void m355l() {
        this.f222G = true;
    }

    public void m356m() {
        this.f222G = true;
        if (!this.f231P) {
            this.f231P = true;
            this.f229N = this.f261u.m376a(this.f248h, this.f230O, false);
        }
        if (this.f229N != null) {
            this.f229N.m221h();
        }
    }

    void m357n() {
        this.f247g = -1;
        this.f248h = null;
        this.f253m = false;
        this.f254n = false;
        this.f255o = false;
        this.f256p = false;
        this.f257q = false;
        this.f258r = false;
        this.f259s = 0;
        this.f260t = null;
        this.f262v = null;
        this.f261u = null;
        this.f264x = 0;
        this.f265y = 0;
        this.f266z = null;
        this.f216A = false;
        this.f217B = false;
        this.f219D = false;
        this.f229N = null;
        this.f230O = false;
        this.f231P = false;
    }

    public void m358o() {
        this.f222G = true;
    }

    public void onConfigurationChanged(Configuration configuration) {
        this.f222G = true;
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        m329b().onCreateContextMenu(contextMenu, view, contextMenuInfo);
    }

    public void onLowMemory() {
        this.f222G = true;
    }

    public void m359p() {
    }

    public Object m360q() {
        return this.f232Q;
    }

    public Object m361r() {
        return this.f233R == f215a ? m360q() : this.f233R;
    }

    public Object m362s() {
        return this.f234S;
    }

    public Object m363t() {
        return this.f235T == f215a ? m362s() : this.f235T;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(128);
        C0107d.m591a(this, stringBuilder);
        if (this.f247g >= 0) {
            stringBuilder.append(" #");
            stringBuilder.append(this.f247g);
        }
        if (this.f264x != 0) {
            stringBuilder.append(" id=0x");
            stringBuilder.append(Integer.toHexString(this.f264x));
        }
        if (this.f266z != null) {
            stringBuilder.append(" ");
            stringBuilder.append(this.f266z);
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    public Object m364u() {
        return this.f236U;
    }

    public Object m365v() {
        return this.f237V == f215a ? m364u() : this.f237V;
    }

    public boolean m366w() {
        return this.f239X == null ? true : this.f239X.booleanValue();
    }

    public boolean m367x() {
        return this.f238W == null ? true : this.f238W.booleanValue();
    }

    void m368y() {
        this.f262v = new C0059w();
        this.f262v.m411a(this.f261u, new C0050n(this), this);
    }

    void m369z() {
        if (this.f262v != null) {
            this.f262v.m436h();
            this.f262v.m429d();
        }
        this.f222G = false;
        m349h();
        if (this.f222G) {
            if (this.f262v != null) {
                this.f262v.m439k();
            }
            if (this.f229N != null) {
                this.f229N.m220g();
                return;
            }
            return;
        }
        throw new ax("Fragment " + this + " did not call through to super.onStart()");
    }
}
