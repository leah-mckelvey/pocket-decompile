package android.support.v4.p009g;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

/* renamed from: android.support.v4.g.i */
final class C0111i implements Set {
    final /* synthetic */ C0104g f373a;

    C0111i(C0104g c0104g) {
        this.f373a = c0104g;
    }

    public boolean m600a(Entry entry) {
        throw new UnsupportedOperationException();
    }

    public /* synthetic */ boolean add(Object obj) {
        return m600a((Entry) obj);
    }

    public boolean addAll(Collection collection) {
        int a = this.f373a.m564a();
        for (Entry entry : collection) {
            this.f373a.m569a(entry.getKey(), entry.getValue());
        }
        return a != this.f373a.m564a();
    }

    public void clear() {
        this.f373a.m574c();
    }

    public boolean contains(Object obj) {
        if (!(obj instanceof Entry)) {
            return false;
        }
        Entry entry = (Entry) obj;
        int a = this.f373a.m565a(entry.getKey());
        return a >= 0 ? C0106c.m589a(this.f373a.m566a(a, 1), entry.getValue()) : false;
    }

    public boolean containsAll(Collection collection) {
        for (Object contains : collection) {
            if (!contains(contains)) {
                return false;
            }
        }
        return true;
    }

    public boolean equals(Object obj) {
        return C0104g.m561a((Set) this, obj);
    }

    public int hashCode() {
        int a = this.f373a.m564a() - 1;
        int i = 0;
        while (a >= 0) {
            Object a2 = this.f373a.m566a(a, 0);
            Object a3 = this.f373a.m566a(a, 1);
            a--;
            i += (a3 == null ? 0 : a3.hashCode()) ^ (a2 == null ? 0 : a2.hashCode());
        }
        return i;
    }

    public boolean isEmpty() {
        return this.f373a.m564a() == 0;
    }

    public Iterator iterator() {
        return new C0113k(this.f373a);
    }

    public boolean remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    public boolean removeAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    public boolean retainAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    public int size() {
        return this.f373a.m564a();
    }

    public Object[] toArray() {
        throw new UnsupportedOperationException();
    }

    public Object[] toArray(Object[] objArr) {
        throw new UnsupportedOperationException();
    }
}
