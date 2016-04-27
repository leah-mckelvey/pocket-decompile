package android.support.v4.p002a;

import android.os.Handler;
import android.os.Message;
import com.pocket.doorway.C0339o;

/* renamed from: android.support.v4.a.q */
class C0053q extends Handler {
    final /* synthetic */ C0052p f281a;

    C0053q(C0052p c0052p) {
        this.f281a = c0052p;
    }

    public void handleMessage(Message message) {
        switch (message.what) {
            case C0339o.View_android_focusable /*1*/:
                if (this.f281a.f273f) {
                    this.f281a.m379a(false);
                }
            case C0339o.View_paddingStart /*2*/:
                this.f281a.m381b();
                this.f281a.f269b.m429d();
            default:
                super.handleMessage(message);
        }
    }
}
