package android.support.v4.p009g;

import java.util.Iterator;

/* renamed from: android.support.v4.g.h */
final class C0110h implements Iterator {
    final int f368a;
    int f369b;
    int f370c;
    boolean f371d;
    final /* synthetic */ C0104g f372e;

    C0110h(C0104g c0104g, int i) {
        this.f372e = c0104g;
        this.f371d = false;
        this.f368a = i;
        this.f369b = c0104g.m564a();
    }

    public boolean hasNext() {
        return this.f370c < this.f369b;
    }

    public Object next() {
        Object a = this.f372e.m566a(this.f370c, this.f368a);
        this.f370c++;
        this.f371d = true;
        return a;
    }

    public void remove() {
        if (this.f371d) {
            this.f370c--;
            this.f369b--;
            this.f371d = false;
            this.f372e.m568a(this.f370c);
            return;
        }
        throw new IllegalStateException();
    }
}
