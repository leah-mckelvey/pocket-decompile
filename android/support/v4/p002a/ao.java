package android.support.v4.p002a;

import android.support.v4.p009g.C0107d;
import android.support.v4.p009g.C0115n;
import android.util.Log;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* renamed from: android.support.v4.a.ao */
class ao extends am {
    static boolean f126a;
    final C0115n f127b;
    final C0115n f128c;
    final String f129d;
    C0052p f130e;
    boolean f131f;
    boolean f132g;

    static {
        f126a = false;
    }

    ao(String str, C0052p c0052p, boolean z) {
        this.f127b = new C0115n();
        this.f128c = new C0115n();
        this.f129d = str;
        this.f130e = c0052p;
        this.f131f = z;
    }

    void m212a(C0052p c0052p) {
        this.f130e = c0052p;
    }

    public void m213a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int i = 0;
        if (this.f127b.m605b() > 0) {
            printWriter.print(str);
            printWriter.println("Active Loaders:");
            String str2 = str + "    ";
            for (int i2 = 0; i2 < this.f127b.m605b(); i2++) {
                ap apVar = (ap) this.f127b.m606b(i2);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(this.f127b.m603a(i2));
                printWriter.print(": ");
                printWriter.println(apVar.toString());
                apVar.m224a(str2, fileDescriptor, printWriter, strArr);
            }
        }
        if (this.f128c.m605b() > 0) {
            printWriter.print(str);
            printWriter.println("Inactive Loaders:");
            String str3 = str + "    ";
            while (i < this.f128c.m605b()) {
                apVar = (ap) this.f128c.m606b(i);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(this.f128c.m603a(i));
                printWriter.print(": ");
                printWriter.println(apVar.toString());
                apVar.m224a(str3, fileDescriptor, printWriter, strArr);
                i++;
            }
        }
    }

    public boolean m214a() {
        int b = this.f127b.m605b();
        boolean z = false;
        for (int i = 0; i < b; i++) {
            ap apVar = (ap) this.f127b.m606b(i);
            int i2 = (!apVar.f140h || apVar.f138f) ? 0 : 1;
            z |= i2;
        }
        return z;
    }

    void m215b() {
        if (f126a) {
            Log.v("LoaderManager", "Starting in " + this);
        }
        if (this.f131f) {
            Throwable runtimeException = new RuntimeException("here");
            runtimeException.fillInStackTrace();
            Log.w("LoaderManager", "Called doStart when already started: " + this, runtimeException);
            return;
        }
        this.f131f = true;
        for (int b = this.f127b.m605b() - 1; b >= 0; b--) {
            ((ap) this.f127b.m606b(b)).m222a();
        }
    }

    void m216c() {
        if (f126a) {
            Log.v("LoaderManager", "Stopping in " + this);
        }
        if (this.f131f) {
            for (int b = this.f127b.m605b() - 1; b >= 0; b--) {
                ((ap) this.f127b.m606b(b)).m228e();
            }
            this.f131f = false;
            return;
        }
        Throwable runtimeException = new RuntimeException("here");
        runtimeException.fillInStackTrace();
        Log.w("LoaderManager", "Called doStop when not started: " + this, runtimeException);
    }

    void m217d() {
        if (f126a) {
            Log.v("LoaderManager", "Retaining in " + this);
        }
        if (this.f131f) {
            this.f132g = true;
            this.f131f = false;
            for (int b = this.f127b.m605b() - 1; b >= 0; b--) {
                ((ap) this.f127b.m606b(b)).m225b();
            }
            return;
        }
        Throwable runtimeException = new RuntimeException("here");
        runtimeException.fillInStackTrace();
        Log.w("LoaderManager", "Called doRetain when not started: " + this, runtimeException);
    }

    void m218e() {
        if (this.f132g) {
            if (f126a) {
                Log.v("LoaderManager", "Finished Retaining in " + this);
            }
            this.f132g = false;
            for (int b = this.f127b.m605b() - 1; b >= 0; b--) {
                ((ap) this.f127b.m606b(b)).m226c();
            }
        }
    }

    void m219f() {
        for (int b = this.f127b.m605b() - 1; b >= 0; b--) {
            ((ap) this.f127b.m606b(b)).f143k = true;
        }
    }

    void m220g() {
        for (int b = this.f127b.m605b() - 1; b >= 0; b--) {
            ((ap) this.f127b.m606b(b)).m227d();
        }
    }

    void m221h() {
        int b;
        if (!this.f132g) {
            if (f126a) {
                Log.v("LoaderManager", "Destroying Active in " + this);
            }
            for (b = this.f127b.m605b() - 1; b >= 0; b--) {
                ((ap) this.f127b.m606b(b)).m229f();
            }
            this.f127b.m607c();
        }
        if (f126a) {
            Log.v("LoaderManager", "Destroying Inactive in " + this);
        }
        for (b = this.f128c.m605b() - 1; b >= 0; b--) {
            ((ap) this.f128c.m606b(b)).m229f();
        }
        this.f128c.m607c();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(128);
        stringBuilder.append("LoaderManager{");
        stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
        stringBuilder.append(" in ");
        C0107d.m591a(this.f130e, stringBuilder);
        stringBuilder.append("}}");
        return stringBuilder.toString();
    }
}
