package android.support.v4.p009g;

import android.util.Log;
import java.io.Writer;

/* renamed from: android.support.v4.g.e */
public class C0108e extends Writer {
    private final String f358a;
    private StringBuilder f359b;

    public C0108e(String str) {
        this.f359b = new StringBuilder(128);
        this.f358a = str;
    }

    private void m592a() {
        if (this.f359b.length() > 0) {
            Log.d(this.f358a, this.f359b.toString());
            this.f359b.delete(0, this.f359b.length());
        }
    }

    public void close() {
        m592a();
    }

    public void flush() {
        m592a();
    }

    public void write(char[] cArr, int i, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            char c = cArr[i + i3];
            if (c == '\n') {
                m592a();
            } else {
                this.f359b.append(c);
            }
        }
    }
}
