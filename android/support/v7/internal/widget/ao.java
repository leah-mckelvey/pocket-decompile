package android.support.v7.internal.widget;

public class ao {
    private int f1076a;
    private int f1077b;
    private int f1078c;
    private int f1079d;
    private int f1080e;
    private int f1081f;
    private boolean f1082g;
    private boolean f1083h;

    public ao() {
        this.f1076a = 0;
        this.f1077b = 0;
        this.f1078c = Integer.MIN_VALUE;
        this.f1079d = Integer.MIN_VALUE;
        this.f1080e = 0;
        this.f1081f = 0;
        this.f1082g = false;
        this.f1083h = false;
    }

    public int m1875a() {
        return this.f1076a;
    }

    public void m1876a(int i, int i2) {
        this.f1078c = i;
        this.f1079d = i2;
        this.f1083h = true;
        if (this.f1082g) {
            if (i2 != Integer.MIN_VALUE) {
                this.f1076a = i2;
            }
            if (i != Integer.MIN_VALUE) {
                this.f1077b = i;
                return;
            }
            return;
        }
        if (i != Integer.MIN_VALUE) {
            this.f1076a = i;
        }
        if (i2 != Integer.MIN_VALUE) {
            this.f1077b = i2;
        }
    }

    public void m1877a(boolean z) {
        if (z != this.f1082g) {
            this.f1082g = z;
            if (!this.f1083h) {
                this.f1076a = this.f1080e;
                this.f1077b = this.f1081f;
            } else if (z) {
                this.f1076a = this.f1079d != Integer.MIN_VALUE ? this.f1079d : this.f1080e;
                this.f1077b = this.f1078c != Integer.MIN_VALUE ? this.f1078c : this.f1081f;
            } else {
                this.f1076a = this.f1078c != Integer.MIN_VALUE ? this.f1078c : this.f1080e;
                this.f1077b = this.f1079d != Integer.MIN_VALUE ? this.f1079d : this.f1081f;
            }
        }
    }

    public int m1878b() {
        return this.f1077b;
    }

    public void m1879b(int i, int i2) {
        this.f1083h = false;
        if (i != Integer.MIN_VALUE) {
            this.f1080e = i;
            this.f1076a = i;
        }
        if (i2 != Integer.MIN_VALUE) {
            this.f1081f = i2;
            this.f1077b = i2;
        }
    }

    public int m1880c() {
        return this.f1082g ? this.f1077b : this.f1076a;
    }

    public int m1881d() {
        return this.f1082g ? this.f1076a : this.f1077b;
    }
}
