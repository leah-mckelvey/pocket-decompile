package android.support.v7.widget;

class ah implements Runnable {
    final /* synthetic */ ag f1419a;

    private ah(ag agVar) {
        this.f1419a = agVar;
    }

    public void run() {
        this.f1419a.f856d.getParent().requestDisallowInterceptTouchEvent(true);
    }
}
