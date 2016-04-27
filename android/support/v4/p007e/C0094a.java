package android.support.v4.p007e;

import android.os.AsyncTask;
import android.os.Build.VERSION;

/* renamed from: android.support.v4.e.a */
public class C0094a {
    public static AsyncTask m533a(AsyncTask asyncTask, Object... objArr) {
        if (asyncTask == null) {
            throw new IllegalArgumentException("task can not be null");
        }
        if (VERSION.SDK_INT >= 11) {
            C0095b.m534a(asyncTask, objArr);
        } else {
            asyncTask.execute(objArr);
        }
        return asyncTask;
    }
}
