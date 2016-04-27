package android.support.v4.p009g;

/* renamed from: android.support.v4.g.n */
public class C0115n implements Cloneable {
    private static final Object f380a;
    private boolean f381b;
    private int[] f382c;
    private Object[] f383d;
    private int f384e;

    static {
        f380a = new Object();
    }

    public C0115n() {
        this(10);
    }

    public C0115n(int i) {
        this.f381b = false;
        if (i == 0) {
            this.f382c = C0106c.f355a;
            this.f383d = C0106c.f357c;
        } else {
            int a = C0106c.m587a(i);
            this.f382c = new int[a];
            this.f383d = new Object[a];
        }
        this.f384e = 0;
    }

    private void m602d() {
        int i = this.f384e;
        int[] iArr = this.f382c;
        Object[] objArr = this.f383d;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            Object obj = objArr[i3];
            if (obj != f380a) {
                if (i3 != i2) {
                    iArr[i2] = iArr[i3];
                    objArr[i2] = obj;
                    objArr[i3] = null;
                }
                i2++;
            }
        }
        this.f381b = false;
        this.f384e = i2;
    }

    public int m603a(int i) {
        if (this.f381b) {
            m602d();
        }
        return this.f382c[i];
    }

    public C0115n m604a() {
        try {
            C0115n c0115n = (C0115n) super.clone();
            try {
                c0115n.f382c = (int[]) this.f382c.clone();
                c0115n.f383d = (Object[]) this.f383d.clone();
                return c0115n;
            } catch (CloneNotSupportedException e) {
                return c0115n;
            }
        } catch (CloneNotSupportedException e2) {
            return null;
        }
    }

    public int m605b() {
        if (this.f381b) {
            m602d();
        }
        return this.f384e;
    }

    public Object m606b(int i) {
        if (this.f381b) {
            m602d();
        }
        return this.f383d[i];
    }

    public void m607c() {
        int i = this.f384e;
        Object[] objArr = this.f383d;
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = null;
        }
        this.f384e = 0;
        this.f381b = false;
    }

    public /* synthetic */ Object clone() {
        return m604a();
    }

    public String toString() {
        if (m605b() <= 0) {
            return "{}";
        }
        StringBuilder stringBuilder = new StringBuilder(this.f384e * 28);
        stringBuilder.append('{');
        for (int i = 0; i < this.f384e; i++) {
            if (i > 0) {
                stringBuilder.append(", ");
            }
            stringBuilder.append(m603a(i));
            stringBuilder.append('=');
            C0115n b = m606b(i);
            if (b != this) {
                stringBuilder.append(b);
            } else {
                stringBuilder.append("(this Map)");
            }
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
