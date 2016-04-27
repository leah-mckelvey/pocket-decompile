package android.support.v7.internal.widget;

class ae implements Runnable {
    final /* synthetic */ C0261y f1061a;

    private ae(C0261y c0261y) {
        this.f1061a = c0261y;
    }

    public void run() {
        if (!this.f1061a.f1124u) {
            this.f1061a.m1895a();
        } else if (this.f1061a.getAdapter() != null) {
            this.f1061a.post(this);
        }
    }
}
