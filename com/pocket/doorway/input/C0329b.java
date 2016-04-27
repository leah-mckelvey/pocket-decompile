package com.pocket.doorway.input;

import android.os.Handler;
import android.os.Message;
import com.pocket.doorway.p020a.C0311b;

/* renamed from: com.pocket.doorway.input.b */
class C0329b extends Handler {
    final /* synthetic */ TractorBeamTargetingService f1561a;

    C0329b(TractorBeamTargetingService tractorBeamTargetingService) {
        this.f1561a = tractorBeamTargetingService;
    }

    public void handleMessage(Message message) {
        int i = message.what;
        int i2 = message.arg1;
        int i3 = message.arg2;
        boolean a = this.f1561a.f1557b.m2369a();
        if (TractorBeamTargetingService.f1556a == null) {
            return;
        }
        if (a) {
            TractorBeamTargetingService.f1556a.m2370a();
            C0311b.m2329a("Too many commands sent per second. FAB Vortex OVERLOAD!");
            return;
        }
        TractorBeamTargetingService.f1556a.m2371a(i2, i3, i, 0.0f);
    }
}
