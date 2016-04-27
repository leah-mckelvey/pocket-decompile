package android.support.v7.internal.view;

import android.view.ActionMode;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window.Callback;
import android.view.WindowManager.LayoutParams;
import android.view.accessibility.AccessibilityEvent;

/* renamed from: android.support.v7.internal.view.k */
public class C0191k implements Callback {
    final Callback f640c;

    public C0191k(Callback callback) {
        if (callback == null) {
            throw new IllegalArgumentException("Window callback may not be null");
        }
        this.f640c = callback;
    }

    public boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        return this.f640c.dispatchGenericMotionEvent(motionEvent);
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return this.f640c.dispatchKeyEvent(keyEvent);
    }

    public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        return this.f640c.dispatchKeyShortcutEvent(keyEvent);
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return this.f640c.dispatchPopulateAccessibilityEvent(accessibilityEvent);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return this.f640c.dispatchTouchEvent(motionEvent);
    }

    public boolean dispatchTrackballEvent(MotionEvent motionEvent) {
        return this.f640c.dispatchTrackballEvent(motionEvent);
    }

    public void onActionModeFinished(ActionMode actionMode) {
        this.f640c.onActionModeFinished(actionMode);
    }

    public void onActionModeStarted(ActionMode actionMode) {
        this.f640c.onActionModeStarted(actionMode);
    }

    public void onAttachedToWindow() {
        this.f640c.onAttachedToWindow();
    }

    public void onContentChanged() {
        this.f640c.onContentChanged();
    }

    public boolean onCreatePanelMenu(int i, Menu menu) {
        return this.f640c.onCreatePanelMenu(i, menu);
    }

    public View onCreatePanelView(int i) {
        return this.f640c.onCreatePanelView(i);
    }

    public void onDetachedFromWindow() {
        this.f640c.onDetachedFromWindow();
    }

    public boolean onMenuItemSelected(int i, MenuItem menuItem) {
        return this.f640c.onMenuItemSelected(i, menuItem);
    }

    public boolean onMenuOpened(int i, Menu menu) {
        return this.f640c.onMenuOpened(i, menu);
    }

    public void onPanelClosed(int i, Menu menu) {
        this.f640c.onPanelClosed(i, menu);
    }

    public boolean onPreparePanel(int i, View view, Menu menu) {
        return this.f640c.onPreparePanel(i, view, menu);
    }

    public boolean onSearchRequested() {
        return this.f640c.onSearchRequested();
    }

    public void onWindowAttributesChanged(LayoutParams layoutParams) {
        this.f640c.onWindowAttributesChanged(layoutParams);
    }

    public void onWindowFocusChanged(boolean z) {
        this.f640c.onWindowFocusChanged(z);
    }

    public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
        return this.f640c.onWindowStartingActionMode(callback);
    }
}
