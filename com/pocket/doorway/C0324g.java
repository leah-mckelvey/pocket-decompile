package com.pocket.doorway;

import com.pocket.doorway.target.C0340a;
import java.util.Comparator;

/* renamed from: com.pocket.doorway.g */
final class C0324g implements Comparator {
    C0324g() {
    }

    public int m2358a(C0340a c0340a, C0340a c0340a2) {
        return Integer.signum(c0340a2.m2414i() - c0340a.m2414i());
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return m2358a((C0340a) obj, (C0340a) obj2);
    }
}
