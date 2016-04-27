package android.support.v7.internal.widget;

import android.content.pm.ResolveInfo;
import java.math.BigDecimal;

/* renamed from: android.support.v7.internal.widget.r */
public final class C0277r implements Comparable {
    public final ResolveInfo f1279a;
    public float f1280b;
    final /* synthetic */ C0275p f1281c;

    public C0277r(C0275p c0275p, ResolveInfo resolveInfo) {
        this.f1281c = c0275p;
        this.f1279a = resolveInfo;
    }

    public int m2098a(C0277r c0277r) {
        return Float.floatToIntBits(c0277r.f1280b) - Float.floatToIntBits(this.f1280b);
    }

    public /* synthetic */ int compareTo(Object obj) {
        return m2098a((C0277r) obj);
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
        return Float.floatToIntBits(this.f1280b) == Float.floatToIntBits(((C0277r) obj).f1280b);
    }

    public int hashCode() {
        return Float.floatToIntBits(this.f1280b) + 31;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        stringBuilder.append("resolveInfo:").append(this.f1279a.toString());
        stringBuilder.append("; weight:").append(new BigDecimal((double) this.f1280b));
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
