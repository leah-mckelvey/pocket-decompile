package com.pocket.doorway.p020a;

import android.content.Context;
import android.util.Log;
import com.pocket.doorway.BlipView;
import com.pocket.doorway.p019b.C0309b;

/* renamed from: com.pocket.doorway.a.b */
public class C0311b extends C0309b {
    private static final String[] f1520a;
    private final Context f1521b;
    private final BlipView f1522c;
    private int f1523d;

    static {
        f1520a = new String[]{"Androidian Commander Leah...", "Come in...  can you read me? ..", "...We're transmitting a full uplink... via.. com.pocket.commander.uplink.TRANSMIT .. b....cast..."};
    }

    public C0311b(BlipView blipView) {
        super(2000);
        this.f1523d = 0;
        this.f1521b = blipView.getContext();
        this.f1522c = blipView;
    }

    public static void m2329a(String str) {
        Log.w("PocketHQ", str);
    }

    public void m2330c() {
        String str = f1520a[this.f1523d];
        this.f1523d++;
        if (this.f1523d >= f1520a.length) {
            this.f1523d = 0;
        }
        Log.e("PocketHQ", str);
        this.f1522c.setActive(true);
        this.f1522c.m2308a();
    }
}
