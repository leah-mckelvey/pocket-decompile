package android.support.v4.p009g;

import java.util.Iterator;
import java.util.Map.Entry;

/* renamed from: android.support.v4.g.k */
final class C0113k implements Iterator, Entry {
    int f375a;
    int f376b;
    boolean f377c;
    final /* synthetic */ C0104g f378d;

    C0113k(C0104g c0104g) {
        this.f378d = c0104g;
        this.f377c = false;
        this.f375a = c0104g.m564a() - 1;
        this.f376b = -1;
    }

    public Entry m601a() {
        this.f376b++;
        this.f377c = true;
        return this;
    }

    public final boolean equals(Object obj) {
        boolean z = true;
        if (!this.f377c) {
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        } else if (!(obj instanceof Entry)) {
            return false;
        } else {
            Entry entry = (Entry) obj;
            if (!(C0106c.m589a(entry.getKey(), this.f378d.m566a(this.f376b, 0)) && C0106c.m589a(entry.getValue(), this.f378d.m566a(this.f376b, 1)))) {
                z = false;
            }
            return z;
        }
    }

    public Object getKey() {
        if (this.f377c) {
            return this.f378d.m566a(this.f376b, 0);
        }
        throw new IllegalStateException("This container does not support retaining Map.Entry objects");
    }

    public Object getValue() {
        if (this.f377c) {
            return this.f378d.m566a(this.f376b, 1);
        }
        throw new IllegalStateException("This container does not support retaining Map.Entry objects");
    }

    public boolean hasNext() {
        return this.f376b < this.f375a;
    }

    public final int hashCode() {
        int i = 0;
        if (this.f377c) {
            Object a = this.f378d.m566a(this.f376b, 0);
            Object a2 = this.f378d.m566a(this.f376b, 1);
            int hashCode = a == null ? 0 : a.hashCode();
            if (a2 != null) {
                i = a2.hashCode();
            }
            return i ^ hashCode;
        }
        throw new IllegalStateException("This container does not support retaining Map.Entry objects");
    }

    public /* synthetic */ Object next() {
        return m601a();
    }

    public void remove() {
        if (this.f377c) {
            this.f378d.m568a(this.f376b);
            this.f376b--;
            this.f375a--;
            this.f377c = false;
            return;
        }
        throw new IllegalStateException();
    }

    public Object setValue(Object obj) {
        if (this.f377c) {
            return this.f378d.m567a(this.f376b, obj);
        }
        throw new IllegalStateException("This container does not support retaining Map.Entry objects");
    }

    public final String toString() {
        return getKey() + "=" + getValue();
    }
}
