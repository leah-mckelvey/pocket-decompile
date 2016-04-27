package android.support.v4.p001b;

import android.content.ComponentName;
import android.content.Intent;

/* renamed from: android.support.v4.b.g */
class C0068g implements C0067f {
    C0068g() {
    }

    public Intent m453a(ComponentName componentName) {
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.setComponent(componentName);
        intent.addCategory("android.intent.category.LAUNCHER");
        return intent;
    }
}
