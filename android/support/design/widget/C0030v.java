package android.support.design.widget;

import android.os.Handler.Callback;
import android.os.Message;
import com.pocket.doorway.C0339o;

/* renamed from: android.support.design.widget.v */
class C0030v implements Callback {
    final /* synthetic */ C0029u f85a;

    C0030v(C0029u c0029u) {
        this.f85a = c0029u;
    }

    public boolean handleMessage(Message message) {
        switch (message.what) {
            case C0339o.View_android_theme /*0*/:
                this.f85a.m145c((C0032x) message.obj);
                return true;
            default:
                return false;
        }
    }
}
