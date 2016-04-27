package android.support.v4.p009g;

import java.util.LinkedHashMap;

/* renamed from: android.support.v4.g.f */
public class C0109f {
    private final LinkedHashMap f360a;
    private int f361b;
    private int f362c;
    private int f363d;
    private int f364e;
    private int f365f;
    private int f366g;
    private int f367h;

    public C0109f(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        this.f362c = i;
        this.f360a = new LinkedHashMap(0, 0.75f, true);
    }

    private int m593c(Object obj, Object obj2) {
        int b = m598b(obj, obj2);
        if (b >= 0) {
            return b;
        }
        throw new IllegalStateException("Negative size: " + obj + "=" + obj2);
    }

    public final Object m594a(Object obj) {
        if (obj == null) {
            throw new NullPointerException("key == null");
        }
        synchronized (this) {
            Object obj2 = this.f360a.get(obj);
            if (obj2 != null) {
                this.f366g++;
                return obj2;
            }
            this.f367h++;
            Object b = m599b(obj);
            if (b == null) {
                return null;
            }
            synchronized (this) {
                this.f364e++;
                obj2 = this.f360a.put(obj, b);
                if (obj2 != null) {
                    this.f360a.put(obj, obj2);
                } else {
                    this.f361b += m593c(obj, b);
                }
            }
            if (obj2 != null) {
                m597a(false, obj, b, obj2);
                return obj2;
            }
            m596a(this.f362c);
            return b;
        }
    }

    public final Object m595a(Object obj, Object obj2) {
        if (obj == null || obj2 == null) {
            throw new NullPointerException("key == null || value == null");
        }
        Object put;
        synchronized (this) {
            this.f363d++;
            this.f361b += m593c(obj, obj2);
            put = this.f360a.put(obj, obj2);
            if (put != null) {
                this.f361b -= m593c(obj, put);
            }
        }
        if (put != null) {
            m597a(false, obj, put, obj2);
        }
        m596a(this.f362c);
        return put;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void m596a(int r5) {
        /*
        r4 = this;
    L_0x0000:
        monitor-enter(r4);
        r0 = r4.f361b;	 Catch:{ all -> 0x0032 }
        if (r0 < 0) goto L_0x0011;
    L_0x0005:
        r0 = r4.f360a;	 Catch:{ all -> 0x0032 }
        r0 = r0.isEmpty();	 Catch:{ all -> 0x0032 }
        if (r0 == 0) goto L_0x0035;
    L_0x000d:
        r0 = r4.f361b;	 Catch:{ all -> 0x0032 }
        if (r0 == 0) goto L_0x0035;
    L_0x0011:
        r0 = new java.lang.IllegalStateException;	 Catch:{ all -> 0x0032 }
        r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0032 }
        r1.<init>();	 Catch:{ all -> 0x0032 }
        r2 = r4.getClass();	 Catch:{ all -> 0x0032 }
        r2 = r2.getName();	 Catch:{ all -> 0x0032 }
        r1 = r1.append(r2);	 Catch:{ all -> 0x0032 }
        r2 = ".sizeOf() is reporting inconsistent results!";
        r1 = r1.append(r2);	 Catch:{ all -> 0x0032 }
        r1 = r1.toString();	 Catch:{ all -> 0x0032 }
        r0.<init>(r1);	 Catch:{ all -> 0x0032 }
        throw r0;	 Catch:{ all -> 0x0032 }
    L_0x0032:
        r0 = move-exception;
        monitor-exit(r4);	 Catch:{ all -> 0x0032 }
        throw r0;
    L_0x0035:
        r0 = r4.f361b;	 Catch:{ all -> 0x0032 }
        if (r0 <= r5) goto L_0x0041;
    L_0x0039:
        r0 = r4.f360a;	 Catch:{ all -> 0x0032 }
        r0 = r0.isEmpty();	 Catch:{ all -> 0x0032 }
        if (r0 == 0) goto L_0x0043;
    L_0x0041:
        monitor-exit(r4);	 Catch:{ all -> 0x0032 }
        return;
    L_0x0043:
        r0 = r4.f360a;	 Catch:{ all -> 0x0032 }
        r0 = r0.entrySet();	 Catch:{ all -> 0x0032 }
        r0 = r0.iterator();	 Catch:{ all -> 0x0032 }
        r0 = r0.next();	 Catch:{ all -> 0x0032 }
        r0 = (java.util.Map.Entry) r0;	 Catch:{ all -> 0x0032 }
        r1 = r0.getKey();	 Catch:{ all -> 0x0032 }
        r0 = r0.getValue();	 Catch:{ all -> 0x0032 }
        r2 = r4.f360a;	 Catch:{ all -> 0x0032 }
        r2.remove(r1);	 Catch:{ all -> 0x0032 }
        r2 = r4.f361b;	 Catch:{ all -> 0x0032 }
        r3 = r4.m593c(r1, r0);	 Catch:{ all -> 0x0032 }
        r2 = r2 - r3;
        r4.f361b = r2;	 Catch:{ all -> 0x0032 }
        r2 = r4.f365f;	 Catch:{ all -> 0x0032 }
        r2 = r2 + 1;
        r4.f365f = r2;	 Catch:{ all -> 0x0032 }
        monitor-exit(r4);	 Catch:{ all -> 0x0032 }
        r2 = 1;
        r3 = 0;
        r4.m597a(r2, r1, r0, r3);
        goto L_0x0000;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.g.f.a(int):void");
    }

    protected void m597a(boolean z, Object obj, Object obj2, Object obj3) {
    }

    protected int m598b(Object obj, Object obj2) {
        return 1;
    }

    protected Object m599b(Object obj) {
        return null;
    }

    public final synchronized String toString() {
        String format;
        int i = 0;
        synchronized (this) {
            int i2 = this.f366g + this.f367h;
            if (i2 != 0) {
                i = (this.f366g * 100) / i2;
            }
            format = String.format("LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", new Object[]{Integer.valueOf(this.f362c), Integer.valueOf(this.f366g), Integer.valueOf(this.f367h), Integer.valueOf(i)});
        }
        return format;
    }
}
