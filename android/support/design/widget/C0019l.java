package android.support.design.widget;

import android.os.Handler.Callback;
import android.os.Message;
import com.pocket.doorway.C0339o;

/* renamed from: android.support.design.widget.l */
final class C0019l implements Callback {
    C0019l() {
    }

    public boolean handleMessage(Message message) {
        switch (message.what) {
            case C0339o.View_android_theme /*0*/:
                ((Snackbar) message.obj).m20b();
                return true;
            case C0339o.View_android_focusable /*1*/:
                ((Snackbar) message.obj).m21c();
                return true;
            default:
                return false;
        }
    }
}
