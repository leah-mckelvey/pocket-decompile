package com.pocket.doorway;

import android.os.Bundle;
import android.support.v7.p011a.C0188q;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

public class GameActivity extends C0188q {
    private ViewGroup f1510n;
    private View f1511o;
    private View f1512p;
    private C0322e f1513q;
    private C0337l f1514r;

    private void m2310a(Bundle bundle) {
        if (this.f1513q != null) {
            this.f1513q.m2357d();
            this.f1510n.removeView(this.f1513q.m2354a());
        }
        this.f1514r = new C0337l();
        this.f1513q = new C0322e(this.f1510n, this.f1514r, bundle);
        this.f1510n.addView(this.f1513q.m2354a(), 0);
        this.f1511o.setVisibility(8);
        this.f1512p.setVisibility(8);
        Toast.makeText(this, R.string.game_start_instructions_1, 1).show();
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_game);
        this.f1510n = (ViewGroup) findViewById(R.id.root);
        this.f1511o = findViewById(R.id.game_over);
        this.f1512p = findViewById(R.id.victory);
        m2310a(bundle);
    }

    protected void onPause() {
        super.onPause();
        this.f1513q.m2356c();
    }

    protected void onResume() {
        super.onResume();
        this.f1513q.m2355b();
    }
}
