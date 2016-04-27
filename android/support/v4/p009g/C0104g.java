package android.support.v4.p009g;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* renamed from: android.support.v4.g.g */
abstract class C0104g {
    C0111i f351b;
    C0112j f352c;
    C0114l f353d;

    C0104g() {
    }

    public static boolean m560a(Map map, Collection collection) {
        for (Object containsKey : collection) {
            if (!map.containsKey(containsKey)) {
                return false;
            }
        }
        return true;
    }

    public static boolean m561a(Set set, Object obj) {
        boolean z = true;
        if (set == obj) {
            return true;
        }
        if (!(obj instanceof Set)) {
            return false;
        }
        Set set2 = (Set) obj;
        try {
            if (!(set.size() == set2.size() && set.containsAll(set2))) {
                z = false;
            }
            return z;
        } catch (NullPointerException e) {
            return false;
        } catch (ClassCastException e2) {
            return false;
        }
    }

    public static boolean m562b(Map map, Collection collection) {
        int size = map.size();
        for (Object remove : collection) {
            map.remove(remove);
        }
        return size != map.size();
    }

    public static boolean m563c(Map map, Collection collection) {
        int size = map.size();
        Iterator it = map.keySet().iterator();
        while (it.hasNext()) {
            if (!collection.contains(it.next())) {
                it.remove();
            }
        }
        return size != map.size();
    }

    protected abstract int m564a();

    protected abstract int m565a(Object obj);

    protected abstract Object m566a(int i, int i2);

    protected abstract Object m567a(int i, Object obj);

    protected abstract void m568a(int i);

    protected abstract void m569a(Object obj, Object obj2);

    public Object[] m570a(Object[] objArr, int i) {
        int a = m564a();
        Object[] objArr2 = objArr.length < a ? (Object[]) Array.newInstance(objArr.getClass().getComponentType(), a) : objArr;
        for (int i2 = 0; i2 < a; i2++) {
            objArr2[i2] = m566a(i2, i);
        }
        if (objArr2.length > a) {
            objArr2[a] = null;
        }
        return objArr2;
    }

    protected abstract int m571b(Object obj);

    protected abstract Map m572b();

    public Object[] m573b(int i) {
        int a = m564a();
        Object[] objArr = new Object[a];
        for (int i2 = 0; i2 < a; i2++) {
            objArr[i2] = m566a(i2, i);
        }
        return objArr;
    }

    protected abstract void m574c();

    public Set m575d() {
        if (this.f351b == null) {
            this.f351b = new C0111i(this);
        }
        return this.f351b;
    }

    public Set m576e() {
        if (this.f352c == null) {
            this.f352c = new C0112j(this);
        }
        return this.f352c;
    }

    public Collection m577f() {
        if (this.f353d == null) {
            this.f353d = new C0114l(this);
        }
        return this.f353d;
    }
}
