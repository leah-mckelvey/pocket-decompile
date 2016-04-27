package android.support.v4.p009g;

import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/* renamed from: android.support.v4.g.a */
public class C0103a extends C0102m implements Map {
    C0104g f350a;

    private C0104g m558b() {
        if (this.f350a == null) {
            this.f350a = new C0105b(this);
        }
        return this.f350a;
    }

    public boolean m559a(Collection collection) {
        return C0104g.m563c(this, collection);
    }

    public Set entrySet() {
        return m558b().m575d();
    }

    public Set keySet() {
        return m558b().m576e();
    }

    public void putAll(Map map) {
        m553a(this.h + map.size());
        for (Entry entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    public Collection values() {
        return m558b().m577f();
    }
}
