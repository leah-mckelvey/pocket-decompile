package android.support.v4.p007e;

import android.os.AsyncTask;

/* renamed from: android.support.v4.e.b */
class C0095b {
    static void m534a(AsyncTask asyncTask, Object... objArr) {
        asyncTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, objArr);
    }
}
