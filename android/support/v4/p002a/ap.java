package android.support.v4.p002a;

import android.os.Bundle;
import android.support.v4.p001b.C0036l;
import android.support.v4.p001b.C0072k;
import android.support.v4.p009g.C0107d;
import android.util.Log;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;

/* renamed from: android.support.v4.a.ap */
final class ap implements C0036l {
    final int f133a;
    final Bundle f134b;
    an f135c;
    C0072k f136d;
    boolean f137e;
    boolean f138f;
    Object f139g;
    boolean f140h;
    boolean f141i;
    boolean f142j;
    boolean f143k;
    boolean f144l;
    boolean f145m;
    ap f146n;
    final /* synthetic */ ao f147o;

    void m222a() {
        if (this.f141i && this.f142j) {
            this.f140h = true;
        } else if (!this.f140h) {
            this.f140h = true;
            if (ao.f126a) {
                Log.v("LoaderManager", "  Starting: " + this);
            }
            if (this.f136d == null && this.f135c != null) {
                this.f136d = this.f135c.m209a(this.f133a, this.f134b);
            }
            if (this.f136d == null) {
                return;
            }
            if (!this.f136d.getClass().isMemberClass() || Modifier.isStatic(this.f136d.getClass().getModifiers())) {
                if (!this.f145m) {
                    this.f136d.m458a(this.f133a, this);
                    this.f145m = true;
                }
                this.f136d.m457a();
                return;
            }
            throw new IllegalArgumentException("Object returned from onCreateLoader must not be a non-static inner member class: " + this.f136d);
        }
    }

    void m223a(C0072k c0072k, Object obj) {
        String str;
        if (this.f135c != null) {
            if (this.f147o.f130e != null) {
                String str2 = this.f147o.f130e.f269b.f312u;
                this.f147o.f130e.f269b.f312u = "onLoadFinished";
                str = str2;
            } else {
                str = null;
            }
            try {
                if (ao.f126a) {
                    Log.v("LoaderManager", "  onLoadFinished in " + c0072k + ": " + c0072k.m456a(obj));
                }
                this.f135c.m211a(c0072k, obj);
                this.f138f = true;
            } finally {
                if (this.f147o.f130e != null) {
                    this.f147o.f130e.f269b.f312u = str;
                }
            }
        }
    }

    public void m224a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mId=");
        printWriter.print(this.f133a);
        printWriter.print(" mArgs=");
        printWriter.println(this.f134b);
        printWriter.print(str);
        printWriter.print("mCallbacks=");
        printWriter.println(this.f135c);
        printWriter.print(str);
        printWriter.print("mLoader=");
        printWriter.println(this.f136d);
        if (this.f136d != null) {
            this.f136d.m460a(str + "  ", fileDescriptor, printWriter, strArr);
        }
        if (this.f137e || this.f138f) {
            printWriter.print(str);
            printWriter.print("mHaveData=");
            printWriter.print(this.f137e);
            printWriter.print("  mDeliveredData=");
            printWriter.println(this.f138f);
            printWriter.print(str);
            printWriter.print("mData=");
            printWriter.println(this.f139g);
        }
        printWriter.print(str);
        printWriter.print("mStarted=");
        printWriter.print(this.f140h);
        printWriter.print(" mReportNextStart=");
        printWriter.print(this.f143k);
        printWriter.print(" mDestroyed=");
        printWriter.println(this.f144l);
        printWriter.print(str);
        printWriter.print("mRetaining=");
        printWriter.print(this.f141i);
        printWriter.print(" mRetainingStarted=");
        printWriter.print(this.f142j);
        printWriter.print(" mListenerRegistered=");
        printWriter.println(this.f145m);
        if (this.f146n != null) {
            printWriter.print(str);
            printWriter.println("Pending Loader ");
            printWriter.print(this.f146n);
            printWriter.println(":");
            this.f146n.m224a(str + "  ", fileDescriptor, printWriter, strArr);
        }
    }

    void m225b() {
        if (ao.f126a) {
            Log.v("LoaderManager", "  Retaining: " + this);
        }
        this.f141i = true;
        this.f142j = this.f140h;
        this.f140h = false;
        this.f135c = null;
    }

    void m226c() {
        if (this.f141i) {
            if (ao.f126a) {
                Log.v("LoaderManager", "  Finished Retaining: " + this);
            }
            this.f141i = false;
            if (!(this.f140h == this.f142j || this.f140h)) {
                m228e();
            }
        }
        if (this.f140h && this.f137e && !this.f143k) {
            m223a(this.f136d, this.f139g);
        }
    }

    void m227d() {
        if (this.f140h && this.f143k) {
            this.f143k = false;
            if (this.f137e) {
                m223a(this.f136d, this.f139g);
            }
        }
    }

    void m228e() {
        if (ao.f126a) {
            Log.v("LoaderManager", "  Stopping: " + this);
        }
        this.f140h = false;
        if (!this.f141i && this.f136d != null && this.f145m) {
            this.f145m = false;
            this.f136d.m459a((C0036l) this);
            this.f136d.m462c();
        }
    }

    void m229f() {
        String str;
        an anVar = null;
        if (ao.f126a) {
            Log.v("LoaderManager", "  Destroying: " + this);
        }
        this.f144l = true;
        boolean z = this.f138f;
        this.f138f = false;
        if (this.f135c != null && this.f136d != null && this.f137e && z) {
            if (ao.f126a) {
                Log.v("LoaderManager", "  Reseting: " + this);
            }
            if (this.f147o.f130e != null) {
                String str2 = this.f147o.f130e.f269b.f312u;
                this.f147o.f130e.f269b.f312u = "onLoaderReset";
                str = str2;
            } else {
                str = null;
            }
            try {
                this.f135c.m210a(this.f136d);
            } finally {
                anVar = this.f147o.f130e;
                if (anVar != null) {
                    anVar = this.f147o.f130e.f269b;
                    anVar.f312u = str;
                }
            }
        }
        this.f135c = anVar;
        this.f139g = anVar;
        this.f137e = false;
        if (this.f136d != null) {
            if (this.f145m) {
                this.f145m = false;
                this.f136d.m459a((C0036l) this);
            }
            this.f136d.m464e();
        }
        if (this.f146n != null) {
            this.f146n.m229f();
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(64);
        stringBuilder.append("LoaderInfo{");
        stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
        stringBuilder.append(" #");
        stringBuilder.append(this.f133a);
        stringBuilder.append(" : ");
        C0107d.m591a(this.f136d, stringBuilder);
        stringBuilder.append("}}");
        return stringBuilder.toString();
    }
}
