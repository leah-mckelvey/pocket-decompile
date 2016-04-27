package android.support.v7.p011a;

import android.support.v7.internal.view.C0191k;
import android.support.v7.internal.view.menu.C0240i;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.Window.Callback;

/* renamed from: android.support.v7.a.u */
class C0192u extends C0191k {
    final /* synthetic */ C0190t f641a;

    C0192u(C0190t c0190t, Callback callback) {
        this.f641a = c0190t;
        super(callback);
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) ? true : this.f641a.m1276a(keyEvent);
    }

    public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        return this.f641a.m1274a(keyEvent.getKeyCode(), keyEvent) ? true : super.dispatchKeyShortcutEvent(keyEvent);
    }

    public void onContentChanged() {
    }

    public boolean onCreatePanelMenu(int i, Menu menu) {
        return (i != 0 || (menu instanceof C0240i)) ? super.onCreatePanelMenu(i, menu) : false;
    }

    public boolean onMenuOpened(int i, Menu menu) {
        return this.f641a.m1279b(i, menu) ? true : super.onMenuOpened(i, menu);
    }

    public void onPanelClosed(int i, Menu menu) {
        if (!this.f641a.m1275a(i, menu)) {
            super.onPanelClosed(i, menu);
        }
    }

    public boolean onPreparePanel(int i, View view, Menu menu) {
        C0240i c0240i = menu instanceof C0240i ? (C0240i) menu : null;
        if (i == 0 && c0240i == null) {
            return false;
        }
        if (c0240i != null) {
            c0240i.m1584c(true);
        }
        boolean onPreparePanel = super.onPreparePanel(i, view, menu);
        if (c0240i == null) {
            return onPreparePanel;
        }
        c0240i.m1584c(false);
        return onPreparePanel;
    }
}
