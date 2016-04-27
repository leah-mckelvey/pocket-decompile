package android.support.v4.p001b;

import android.support.v4.p009g.C0107d;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* renamed from: android.support.v4.b.k */
public class C0072k {
    int f322a;
    C0036l f323b;
    boolean f324c;
    boolean f325d;
    boolean f326e;
    boolean f327f;
    boolean f328g;

    public String m456a(Object obj) {
        StringBuilder stringBuilder = new StringBuilder(64);
        C0107d.m591a(obj, stringBuilder);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public final void m457a() {
        this.f324c = true;
        this.f326e = false;
        this.f325d = false;
        m461b();
    }

    public void m458a(int i, C0036l c0036l) {
        if (this.f323b != null) {
            throw new IllegalStateException("There is already a listener registered");
        }
        this.f323b = c0036l;
        this.f322a = i;
    }

    public void m459a(C0036l c0036l) {
        if (this.f323b == null) {
            throw new IllegalStateException("No listener register");
        } else if (this.f323b != c0036l) {
            throw new IllegalArgumentException("Attempting to unregister the wrong listener");
        } else {
            this.f323b = null;
        }
    }

    public void m460a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mId=");
        printWriter.print(this.f322a);
        printWriter.print(" mListener=");
        printWriter.println(this.f323b);
        if (this.f324c || this.f327f || this.f328g) {
            printWriter.print(str);
            printWriter.print("mStarted=");
            printWriter.print(this.f324c);
            printWriter.print(" mContentChanged=");
            printWriter.print(this.f327f);
            printWriter.print(" mProcessingChange=");
            printWriter.println(this.f328g);
        }
        if (this.f325d || this.f326e) {
            printWriter.print(str);
            printWriter.print("mAbandoned=");
            printWriter.print(this.f325d);
            printWriter.print(" mReset=");
            printWriter.println(this.f326e);
        }
    }

    protected void m461b() {
    }

    public void m462c() {
        this.f324c = false;
        m463d();
    }

    protected void m463d() {
    }

    public void m464e() {
        m465f();
        this.f326e = true;
        this.f324c = false;
        this.f325d = false;
        this.f327f = false;
        this.f328g = false;
    }

    protected void m465f() {
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(64);
        C0107d.m591a(this, stringBuilder);
        stringBuilder.append(" id=");
        stringBuilder.append(this.f322a);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
