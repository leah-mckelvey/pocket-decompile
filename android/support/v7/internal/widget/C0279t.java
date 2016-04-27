package android.support.v7.internal.widget;

import android.content.ComponentName;
import java.math.BigDecimal;

/* renamed from: android.support.v7.internal.widget.t */
public final class C0279t {
    public final ComponentName f1282a;
    public final long f1283b;
    public final float f1284c;

    public C0279t(ComponentName componentName, long j, float f) {
        this.f1282a = componentName;
        this.f1283b = j;
        this.f1284c = f;
    }

    public C0279t(String str, long j, float f) {
        this(ComponentName.unflattenFromString(str), j, f);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        C0279t c0279t = (C0279t) obj;
        if (this.f1282a == null) {
            if (c0279t.f1282a != null) {
                return false;
            }
        } else if (!this.f1282a.equals(c0279t.f1282a)) {
            return false;
        }
        return this.f1283b != c0279t.f1283b ? false : Float.floatToIntBits(this.f1284c) == Float.floatToIntBits(c0279t.f1284c);
    }

    public int hashCode() {
        return (((((this.f1282a == null ? 0 : this.f1282a.hashCode()) + 31) * 31) + ((int) (this.f1283b ^ (this.f1283b >>> 32)))) * 31) + Float.floatToIntBits(this.f1284c);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        stringBuilder.append("; activity:").append(this.f1282a);
        stringBuilder.append("; time:").append(this.f1283b);
        stringBuilder.append("; weight:").append(new BigDecimal((double) this.f1284c));
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
