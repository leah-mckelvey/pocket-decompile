package android.support.v7.widget;

class an implements Runnable {
    final /* synthetic */ ab f1425a;

    private an(ab abVar) {
        this.f1425a = abVar;
    }

    public void run() {
        if (this.f1425a.f1166f != null && this.f1425a.f1166f.getCount() > this.f1425a.f1166f.getChildCount() && this.f1425a.f1166f.getChildCount() <= this.f1425a.f1162b) {
            this.f1425a.f1164d.setInputMethodMode(2);
            this.f1425a.m1954c();
        }
    }
}
