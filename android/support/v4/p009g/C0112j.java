package android.support.v4.p009g;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

/* renamed from: android.support.v4.g.j */
final class C0112j implements Set {
    final /* synthetic */ C0104g f374a;

    C0112j(C0104g c0104g) {
        this.f374a = c0104g;
    }

    public boolean add(Object obj) {
        throw new UnsupportedOperationException();
    }

    public boolean addAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    public void clear() {
        this.f374a.m574c();
    }

    public boolean contains(Object obj) {
        return this.f374a.m565a(obj) >= 0;
    }

    public boolean containsAll(Collection collection) {
        return C0104g.m560a(this.f374a.m572b(), collection);
    }

    public boolean equals(Object obj) {
        return C0104g.m561a((Set) this, obj);
    }

    public int hashCode() {
        int i = 0;
        for (int a = this.f374a.m564a() - 1; a >= 0; a--) {
            Object a2 = this.f374a.m566a(a, 0);
            i += a2 == null ? 0 : a2.hashCode();
        }
        return i;
    }

    public boolean isEmpty() {
        return this.f374a.m564a() == 0;
    }

    public Iterator iterator() {
        return new C0110h(this.f374a, 0);
    }

    public boolean remove(Object obj) {
        int a = this.f374a.m565a(obj);
        if (a < 0) {
            return false;
        }
        this.f374a.m568a(a);
        return true;
    }

    public boolean removeAll(Collection collection) {
        return C0104g.m562b(this.f374a.m572b(), collection);
    }

    public boolean retainAll(Collection collection) {
        return C0104g.m563c(this.f374a.m572b(), collection);
    }

    public int size() {
        return this.f374a.m564a();
    }

    public Object[] toArray() {
        return this.f374a.m573b(0);
    }

    public Object[] toArray(Object[] objArr) {
        return this.f374a.m570a(objArr, 0);
    }
}
