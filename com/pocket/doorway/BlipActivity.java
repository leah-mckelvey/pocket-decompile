package com.pocket.doorway;

import android.os.Bundle;
import android.support.v7.p011a.C0188q;
import com.pocket.doorway.p020a.C0310a;
import com.pocket.doorway.p020a.C0311b;
import java.util.ArrayList;
import java.util.List;

public class BlipActivity extends C0188q {
    private final List f1505n;

    public BlipActivity() {
        this.f1505n = new ArrayList();
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_blip);
        this.f1505n.add(new C0311b((BlipView) findViewById(R.id.blip)));
        this.f1505n.add(new C0310a(this));
    }

    protected void onPause() {
        super.onPause();
        for (C0308m a : this.f1505n) {
            a.m2313a();
        }
    }

    protected void onResume() {
        super.onResume();
        for (C0308m b : this.f1505n) {
            b.m2316b();
        }
    }
}
