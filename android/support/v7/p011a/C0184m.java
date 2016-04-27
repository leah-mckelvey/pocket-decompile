package android.support.v7.p011a;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Handler;
import android.os.Message;
import com.pocket.doorway.C0339o;
import java.lang.ref.WeakReference;

/* renamed from: android.support.v7.a.m */
final class C0184m extends Handler {
    private WeakReference f622a;

    public C0184m(DialogInterface dialogInterface) {
        this.f622a = new WeakReference(dialogInterface);
    }

    public void handleMessage(Message message) {
        switch (message.what) {
            case -3:
            case -2:
            case -1:
                ((OnClickListener) message.obj).onClick((DialogInterface) this.f622a.get(), message.what);
            case C0339o.View_android_focusable /*1*/:
                ((DialogInterface) message.obj).dismiss();
            default:
        }
    }
}
