package android.support.v7.internal.view.menu;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnKeyListener;
import android.os.IBinder;
import android.support.v7.p011a.C0186o;
import android.support.v7.p011a.C0187p;
import android.support.v7.p013b.C0207i;
import android.view.KeyEvent;
import android.view.KeyEvent.DispatcherState;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;

/* renamed from: android.support.v7.internal.view.menu.l */
public class C0247l implements OnClickListener, OnDismissListener, OnKeyListener, C0170y {
    C0245g f885a;
    private C0240i f886b;
    private C0186o f887c;
    private C0170y f888d;

    public C0247l(C0240i c0240i) {
        this.f886b = c0240i;
    }

    public void m1666a() {
        if (this.f887c != null) {
            this.f887c.dismiss();
        }
    }

    public void m1667a(IBinder iBinder) {
        C0240i c0240i = this.f886b;
        C0187p c0187p = new C0187p(c0240i.m1589e());
        this.f885a = new C0245g(c0187p.m1230a(), C0207i.abc_list_menu_item_layout);
        this.f885a.m1658a((C0170y) this);
        this.f886b.m1569a(this.f885a);
        c0187p.m1234a(this.f885a.m1655a(), this);
        View o = c0240i.m1599o();
        if (o != null) {
            c0187p.m1233a(o);
        } else {
            c0187p.m1232a(c0240i.m1598n()).m1235a(c0240i.m1597m());
        }
        c0187p.m1231a((OnKeyListener) this);
        this.f887c = c0187p.m1236b();
        this.f887c.setOnDismissListener(this);
        LayoutParams attributes = this.f887c.getWindow().getAttributes();
        attributes.type = 1003;
        if (iBinder != null) {
            attributes.token = iBinder;
        }
        attributes.flags |= 131072;
        this.f887c.show();
    }

    public void m1668a(C0240i c0240i, boolean z) {
        if (z || c0240i == this.f886b) {
            m1666a();
        }
        if (this.f888d != null) {
            this.f888d.m1155a(c0240i, z);
        }
    }

    public boolean m1669a(C0240i c0240i) {
        return this.f888d != null ? this.f888d.m1156a(c0240i) : false;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        this.f886b.m1575a((C0248m) this.f885a.m1655a().getItem(i), 0);
    }

    public void onDismiss(DialogInterface dialogInterface) {
        this.f885a.m1657a(this.f886b, true);
    }

    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        if (i == 82 || i == 4) {
            Window window;
            View decorView;
            DispatcherState keyDispatcherState;
            if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                window = this.f887c.getWindow();
                if (window != null) {
                    decorView = window.getDecorView();
                    if (decorView != null) {
                        keyDispatcherState = decorView.getKeyDispatcherState();
                        if (keyDispatcherState != null) {
                            keyDispatcherState.startTracking(keyEvent, this);
                            return true;
                        }
                    }
                }
            } else if (keyEvent.getAction() == 1 && !keyEvent.isCanceled()) {
                window = this.f887c.getWindow();
                if (window != null) {
                    decorView = window.getDecorView();
                    if (decorView != null) {
                        keyDispatcherState = decorView.getKeyDispatcherState();
                        if (keyDispatcherState != null && keyDispatcherState.isTracking(keyEvent)) {
                            this.f886b.m1573a(true);
                            dialogInterface.dismiss();
                            return true;
                        }
                    }
                }
            }
        }
        return this.f886b.performShortcut(i, keyEvent, 0);
    }
}
