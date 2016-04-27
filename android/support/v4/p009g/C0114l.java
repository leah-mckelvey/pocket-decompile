package android.support.v4.p009g;

import java.util.Collection;
import java.util.Iterator;

/* renamed from: android.support.v4.g.l */
final class C0114l implements Collection {
    final /* synthetic */ C0104g f379a;

    C0114l(C0104g c0104g) {
        this.f379a = c0104g;
    }

    public boolean add(Object obj) {
        throw new UnsupportedOperationException();
    }

    public boolean addAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    public void clear() {
        this.f379a.m574c();
    }

    public boolean contains(Object obj) {
        return this.f379a.m571b(obj) >= 0;
    }

    public boolean containsAll(Collection collection) {
        for (Object contains : collection) {
            if (!contains(contains)) {
                return false;
            }
        }
        return true;
    }

    public boolean isEmpty() {
        return this.f379a.m564a() == 0;
    }

    public Iterator iterator() {
        return new C0110h(this.f379a, 1);
    }

    public boolean remove(Object obj) {
        int b = this.f379a.m571b(obj);
        if (b < 0) {
            return false;
        }
        this.f379a.m568a(b);
        return true;
    }

    public boolean removeAll(Collection collection) {
        int i = 0;
        int a = this.f379a.m564a();
        boolean z = false;
        while (i < a) {
            if (collection.contains(this.f379a.m566a(i, 1))) {
                this.f379a.m568a(i);
                i--;
                a--;
                z = true;
            }
            i++;
        }
        return z;
    }

    public boolean retainAll(Collection collection) {
        int i = 0;
        int a = this.f379a.m564a();
        boolean z = false;
        while (i < a) {
            if (!collection.contains(this.f379a.m566a(i, 1))) {
                this.f379a.m568a(i);
                i--;
                a--;
                z = true;
            }
            i++;
        }
        return z;
    }

    public int size() {
        return this.f379a.m564a();
    }

    public Object[] toArray() {
        return this.f379a.m573b(1);
    }

    public Object[] toArray(Object[] objArr) {
        return this.f379a.m570a(objArr, 1);
    }
}
