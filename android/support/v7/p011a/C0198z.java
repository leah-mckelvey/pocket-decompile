package android.support.v7.p011a;

/* renamed from: android.support.v7.a.z */
class C0198z implements Runnable {
    final /* synthetic */ C0194y f668a;

    C0198z(C0194y c0194y) {
        this.f668a = c0194y;
    }

    public void run() {
        if ((this.f668a.f643B & 1) != 0) {
            this.f668a.m1315e(0);
        }
        if ((this.f668a.f643B & 256) != 0) {
            this.f668a.m1315e(8);
        }
        this.f668a.f642A = false;
        this.f668a.f643B = 0;
    }
}
