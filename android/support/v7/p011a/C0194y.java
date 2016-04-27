package android.support.v7.p011a;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.media.AudioManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.p000h.C0058s;
import android.support.v4.p000h.C0126i;
import android.support.v4.p000h.au;
import android.support.v4.p000h.bm;
import android.support.v4.p002a.aq;
import android.support.v7.internal.p016a.C0214a;
import android.support.v7.internal.p016a.C0216b;
import android.support.v7.internal.view.C0225b;
import android.support.v7.internal.view.C0226c;
import android.support.v7.internal.view.menu.C0193j;
import android.support.v7.internal.view.menu.C0240i;
import android.support.v7.internal.widget.ActionBarContextView;
import android.support.v7.internal.widget.ContentFrameLayout;
import android.support.v7.internal.widget.ViewStubCompat;
import android.support.v7.internal.widget.ah;
import android.support.v7.internal.widget.aj;
import android.support.v7.internal.widget.bq;
import android.support.v7.p012d.C0171b;
import android.support.v7.p012d.C0212a;
import android.support.v7.p013b.C0200b;
import android.support.v7.p013b.C0202d;
import android.support.v7.p013b.C0205g;
import android.support.v7.p013b.C0207i;
import android.support.v7.p013b.C0210l;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.LayoutInflater.Factory;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.Window;
import android.view.Window.Callback;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.pocket.doorway.C0339o;

/* renamed from: android.support.v7.a.y */
class C0194y extends C0190t implements C0058s, C0193j {
    private boolean f642A;
    private int f643B;
    private final Runnable f644C;
    private boolean f645D;
    private Rect f646E;
    private Rect f647F;
    private C0214a f648G;
    C0212a f649j;
    ActionBarContextView f650k;
    PopupWindow f651l;
    Runnable f652m;
    private ah f653n;
    private ad f654o;
    private ah f655p;
    private boolean f656q;
    private ViewGroup f657r;
    private ViewGroup f658s;
    private TextView f659t;
    private View f660u;
    private boolean f661v;
    private boolean f662w;
    private boolean f663x;
    private ag[] f664y;
    private ag f665z;

    C0194y(Context context, Window window, C0172r c0172r) {
        super(context, window, c0172r);
        this.f644C = new C0198z(this);
    }

    private ag m1290a(int i, boolean z) {
        Object obj = this.f664y;
        if (obj == null || obj.length <= i) {
            Object obj2 = new ag[(i + 1)];
            if (obj != null) {
                System.arraycopy(obj, 0, obj2, 0, obj.length);
            }
            this.f664y = obj2;
            obj = obj2;
        }
        ag agVar = obj[i];
        if (agVar != null) {
            return agVar;
        }
        agVar = new ag(i);
        obj[i] = agVar;
        return agVar;
    }

    private ag m1292a(Menu menu) {
        ag[] agVarArr = this.f664y;
        int length = agVarArr != null ? agVarArr.length : 0;
        for (int i = 0; i < length; i++) {
            ag agVar = agVarArr[i];
            if (agVar != null && agVar.f517j == menu) {
                return agVar;
            }
        }
        return null;
    }

    private void m1293a(int i, ag agVar, Menu menu) {
        if (menu == null) {
            if (agVar == null && i >= 0 && i < this.f664y.length) {
                agVar = this.f664y[i];
            }
            if (agVar != null) {
                menu = agVar.f517j;
            }
        }
        if (agVar == null || agVar.f522o) {
            Callback l = m1285l();
            if (l != null) {
                l.onPanelClosed(i, menu);
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m1294a(android.support.v7.p011a.ag r11, android.view.KeyEvent r12) {
        /*
        r10 = this;
        r1 = -1;
        r3 = 0;
        r9 = 1;
        r2 = -2;
        r0 = r11.f522o;
        if (r0 != 0) goto L_0x000e;
    L_0x0008:
        r0 = r10.m1284k();
        if (r0 == 0) goto L_0x000f;
    L_0x000e:
        return;
    L_0x000f:
        r0 = r11.f508a;
        if (r0 != 0) goto L_0x0034;
    L_0x0013:
        r4 = r10.a;
        r0 = r4.getResources();
        r0 = r0.getConfiguration();
        r0 = r0.screenLayout;
        r0 = r0 & 15;
        r5 = 4;
        if (r0 != r5) goto L_0x0048;
    L_0x0024:
        r0 = r9;
    L_0x0025:
        r4 = r4.getApplicationInfo();
        r4 = r4.targetSdkVersion;
        r5 = 11;
        if (r4 < r5) goto L_0x004a;
    L_0x002f:
        r4 = r9;
    L_0x0030:
        if (r0 == 0) goto L_0x0034;
    L_0x0032:
        if (r4 != 0) goto L_0x000e;
    L_0x0034:
        r0 = r10.m1285l();
        if (r0 == 0) goto L_0x004c;
    L_0x003a:
        r4 = r11.f508a;
        r5 = r11.f517j;
        r0 = r0.onMenuOpened(r4, r5);
        if (r0 != 0) goto L_0x004c;
    L_0x0044:
        r10.m1295a(r11, r9);
        goto L_0x000e;
    L_0x0048:
        r0 = r3;
        goto L_0x0025;
    L_0x004a:
        r4 = r3;
        goto L_0x0030;
    L_0x004c:
        r0 = r10.a;
        r4 = "window";
        r0 = r0.getSystemService(r4);
        r8 = r0;
        r8 = (android.view.WindowManager) r8;
        if (r8 == 0) goto L_0x000e;
    L_0x0059:
        r0 = r10.m1308b(r11, r12);
        if (r0 == 0) goto L_0x000e;
    L_0x005f:
        r0 = r11.f514g;
        if (r0 == 0) goto L_0x0067;
    L_0x0063:
        r0 = r11.f524q;
        if (r0 == 0) goto L_0x00f1;
    L_0x0067:
        r0 = r11.f514g;
        if (r0 != 0) goto L_0x00df;
    L_0x006b:
        r0 = r10.m1302a(r11);
        if (r0 == 0) goto L_0x000e;
    L_0x0071:
        r0 = r11.f514g;
        if (r0 == 0) goto L_0x000e;
    L_0x0075:
        r0 = r10.m1311c(r11);
        if (r0 == 0) goto L_0x000e;
    L_0x007b:
        r0 = r11.m1171a();
        if (r0 == 0) goto L_0x000e;
    L_0x0081:
        r0 = r11.f515h;
        r0 = r0.getLayoutParams();
        if (r0 != 0) goto L_0x0103;
    L_0x0089:
        r0 = new android.view.ViewGroup$LayoutParams;
        r0.<init>(r2, r2);
        r1 = r0;
    L_0x008f:
        r0 = r11.f509b;
        r4 = r11.f514g;
        r4.setBackgroundResource(r0);
        r0 = r11.f515h;
        r0 = r0.getParent();
        if (r0 == 0) goto L_0x00a9;
    L_0x009e:
        r4 = r0 instanceof android.view.ViewGroup;
        if (r4 == 0) goto L_0x00a9;
    L_0x00a2:
        r0 = (android.view.ViewGroup) r0;
        r4 = r11.f515h;
        r0.removeView(r4);
    L_0x00a9:
        r0 = r11.f514g;
        r4 = r11.f515h;
        r0.addView(r4, r1);
        r0 = r11.f515h;
        r0 = r0.hasFocus();
        if (r0 != 0) goto L_0x00bd;
    L_0x00b8:
        r0 = r11.f515h;
        r0.requestFocus();
    L_0x00bd:
        r1 = r2;
    L_0x00be:
        r11.f521n = r3;
        r0 = new android.view.WindowManager$LayoutParams;
        r3 = r11.f511d;
        r4 = r11.f512e;
        r5 = 1002; // 0x3ea float:1.404E-42 double:4.95E-321;
        r6 = 8519680; // 0x820000 float:1.1938615E-38 double:4.209281E-317;
        r7 = -3;
        r0.<init>(r1, r2, r3, r4, r5, r6, r7);
        r1 = r11.f510c;
        r0.gravity = r1;
        r1 = r11.f513f;
        r0.windowAnimations = r1;
        r1 = r11.f514g;
        r8.addView(r1, r0);
        r11.f522o = r9;
        goto L_0x000e;
    L_0x00df:
        r0 = r11.f524q;
        if (r0 == 0) goto L_0x0075;
    L_0x00e3:
        r0 = r11.f514g;
        r0 = r0.getChildCount();
        if (r0 <= 0) goto L_0x0075;
    L_0x00eb:
        r0 = r11.f514g;
        r0.removeAllViews();
        goto L_0x0075;
    L_0x00f1:
        r0 = r11.f516i;
        if (r0 == 0) goto L_0x0101;
    L_0x00f5:
        r0 = r11.f516i;
        r0 = r0.getLayoutParams();
        if (r0 == 0) goto L_0x0101;
    L_0x00fd:
        r0 = r0.width;
        if (r0 == r1) goto L_0x00be;
    L_0x0101:
        r1 = r2;
        goto L_0x00be;
    L_0x0103:
        r1 = r0;
        goto L_0x008f;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.a.y.a(android.support.v7.a.ag, android.view.KeyEvent):void");
    }

    private void m1295a(ag agVar, boolean z) {
        if (z && agVar.f508a == 0 && this.f653n != null && this.f653n.m1761e()) {
            m1306b(agVar.f517j);
            return;
        }
        boolean z2 = agVar.f522o;
        WindowManager windowManager = (WindowManager) this.a.getSystemService("window");
        if (!(windowManager == null || !z2 || agVar.f514g == null)) {
            windowManager.removeView(agVar.f514g);
        }
        agVar.f520m = false;
        agVar.f521n = false;
        agVar.f522o = false;
        if (z2 && z) {
            m1293a(agVar.f508a, agVar, null);
        }
        agVar.f515h = null;
        agVar.f524q = true;
        if (this.f665z == agVar) {
            this.f665z = null;
        }
    }

    private void m1300a(C0240i c0240i, boolean z) {
        if (this.f653n == null || !this.f653n.m1760d() || (bm.m850a(ViewConfiguration.get(this.a)) && !this.f653n.m1762f())) {
            ag a = m1290a(0, true);
            a.f524q = true;
            m1295a(a, false);
            m1294a(a, null);
            return;
        }
        Callback l = m1285l();
        if (this.f653n.m1761e() && z) {
            this.f653n.m1764h();
            if (!m1284k()) {
                l.onPanelClosed(8, m1290a(0, true).f517j);
            }
        } else if (l != null && !m1284k()) {
            if (this.f642A && (this.f643B & 1) != 0) {
                this.f657r.removeCallbacks(this.f644C);
                this.f644C.run();
            }
            ag a2 = m1290a(0, true);
            if (a2.f517j != null && !a2.f525r && l.onPreparePanel(0, a2.f516i, a2.f517j)) {
                l.onMenuOpened(8, a2.f517j);
                this.f653n.m1763g();
            }
        }
    }

    private void m1301a(ContentFrameLayout contentFrameLayout) {
        contentFrameLayout.m1831a(this.f657r.getPaddingLeft(), this.f657r.getPaddingTop(), this.f657r.getPaddingRight(), this.f657r.getPaddingBottom());
        TypedArray obtainStyledAttributes = this.a.obtainStyledAttributes(C0210l.Theme);
        obtainStyledAttributes.getValue(C0210l.Theme_windowMinWidthMajor, contentFrameLayout.getMinWidthMajor());
        obtainStyledAttributes.getValue(C0210l.Theme_windowMinWidthMinor, contentFrameLayout.getMinWidthMinor());
        if (obtainStyledAttributes.hasValue(C0210l.Theme_windowFixedWidthMajor)) {
            obtainStyledAttributes.getValue(C0210l.Theme_windowFixedWidthMajor, contentFrameLayout.getFixedWidthMajor());
        }
        if (obtainStyledAttributes.hasValue(C0210l.Theme_windowFixedWidthMinor)) {
            obtainStyledAttributes.getValue(C0210l.Theme_windowFixedWidthMinor, contentFrameLayout.getFixedWidthMinor());
        }
        if (obtainStyledAttributes.hasValue(C0210l.Theme_windowFixedHeightMajor)) {
            obtainStyledAttributes.getValue(C0210l.Theme_windowFixedHeightMajor, contentFrameLayout.getFixedHeightMajor());
        }
        if (obtainStyledAttributes.hasValue(C0210l.Theme_windowFixedHeightMinor)) {
            obtainStyledAttributes.getValue(C0210l.Theme_windowFixedHeightMinor, contentFrameLayout.getFixedHeightMinor());
        }
        obtainStyledAttributes.recycle();
        contentFrameLayout.requestLayout();
    }

    private boolean m1302a(ag agVar) {
        agVar.m1169a(m1283j());
        agVar.f514g = new af(this, agVar.f519l);
        agVar.f510c = 81;
        return true;
    }

    private boolean m1303a(ag agVar, int i, KeyEvent keyEvent, int i2) {
        boolean z = false;
        if (!keyEvent.isSystem()) {
            if ((agVar.f520m || m1308b(agVar, keyEvent)) && agVar.f517j != null) {
                z = agVar.f517j.performShortcut(i, keyEvent, i2);
            }
            if (z && (i2 & 1) == 0 && this.f653n == null) {
                m1295a(agVar, true);
            }
        }
        return z;
    }

    private void m1306b(C0240i c0240i) {
        if (!this.f663x) {
            this.f663x = true;
            this.f653n.m1766j();
            Callback l = m1285l();
            if (!(l == null || m1284k())) {
                l.onPanelClosed(8, c0240i);
            }
            this.f663x = false;
        }
    }

    private boolean m1307b(ag agVar) {
        Context c0225b;
        C0240i c0240i;
        Context context = this.a;
        if ((agVar.f508a == 0 || agVar.f508a == 8) && this.f653n != null) {
            TypedValue typedValue = new TypedValue();
            Theme theme = context.getTheme();
            theme.resolveAttribute(C0200b.actionBarTheme, typedValue, true);
            Theme theme2 = null;
            if (typedValue.resourceId != 0) {
                theme2 = context.getResources().newTheme();
                theme2.setTo(theme);
                theme2.applyStyle(typedValue.resourceId, true);
                theme2.resolveAttribute(C0200b.actionBarWidgetTheme, typedValue, true);
            } else {
                theme.resolveAttribute(C0200b.actionBarWidgetTheme, typedValue, true);
            }
            if (typedValue.resourceId != 0) {
                if (theme2 == null) {
                    theme2 = context.getResources().newTheme();
                    theme2.setTo(theme);
                }
                theme2.applyStyle(typedValue.resourceId, true);
            }
            Theme theme3 = theme2;
            if (theme3 != null) {
                c0225b = new C0225b(context, 0);
                c0225b.getTheme().setTo(theme3);
                c0240i = new C0240i(c0225b);
                c0240i.m1567a((C0193j) this);
                agVar.m1170a(c0240i);
                return true;
            }
        }
        c0225b = context;
        c0240i = new C0240i(c0225b);
        c0240i.m1567a((C0193j) this);
        agVar.m1170a(c0240i);
        return true;
    }

    private boolean m1308b(ag agVar, KeyEvent keyEvent) {
        if (m1284k()) {
            return false;
        }
        if (agVar.f520m) {
            return true;
        }
        if (!(this.f665z == null || this.f665z == agVar)) {
            m1295a(this.f665z, false);
        }
        Callback l = m1285l();
        if (l != null) {
            agVar.f516i = l.onCreatePanelView(agVar.f508a);
        }
        boolean z = agVar.f508a == 0 || agVar.f508a == 8;
        if (z && this.f653n != null) {
            this.f653n.m1765i();
        }
        if (agVar.f516i == null) {
            if (agVar.f517j == null || agVar.f525r) {
                if (agVar.f517j == null && (!m1307b(agVar) || agVar.f517j == null)) {
                    return false;
                }
                if (z && this.f653n != null) {
                    if (this.f654o == null) {
                        this.f654o = new ad();
                    }
                    this.f653n.m1759a(agVar.f517j, this.f654o);
                }
                agVar.f517j.m1591g();
                if (l.onCreatePanelMenu(agVar.f508a, agVar.f517j)) {
                    agVar.f525r = false;
                } else {
                    agVar.m1170a(null);
                    if (!z || this.f653n == null) {
                        return false;
                    }
                    this.f653n.m1759a(null, this.f654o);
                    return false;
                }
            }
            agVar.f517j.m1591g();
            if (agVar.f526s != null) {
                agVar.f517j.m1578b(agVar.f526s);
                agVar.f526s = null;
            }
            if (l.onPreparePanel(0, agVar.f516i, agVar.f517j)) {
                agVar.f523p = KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1;
                agVar.f517j.setQwertyMode(agVar.f523p);
                agVar.f517j.m1592h();
            } else {
                if (z && this.f653n != null) {
                    this.f653n.m1759a(null, this.f654o);
                }
                agVar.f517j.m1592h();
                return false;
            }
        }
        agVar.f520m = true;
        agVar.f521n = false;
        this.f665z = agVar;
        return true;
    }

    private void m1310c(int i) {
        m1295a(m1290a(i, true), true);
    }

    private boolean m1311c(ag agVar) {
        if (agVar.f516i != null) {
            agVar.f515h = agVar.f516i;
            return true;
        } else if (agVar.f517j == null) {
            return false;
        } else {
            if (this.f655p == null) {
                this.f655p = new ah();
            }
            agVar.f515h = (View) agVar.m1168a(this.f655p);
            return agVar.f515h != null;
        }
    }

    private void m1312d(int i) {
        this.f643B |= 1 << i;
        if (!this.f642A && this.f657r != null) {
            au.m689a(this.f657r, this.f644C);
            this.f642A = true;
        }
    }

    private boolean m1314d(int i, KeyEvent keyEvent) {
        if (keyEvent.getRepeatCount() == 0) {
            ag a = m1290a(i, true);
            if (!a.f522o) {
                return m1308b(a, keyEvent);
            }
        }
        return false;
    }

    private void m1315e(int i) {
        ag a = m1290a(i, true);
        if (a.f517j != null) {
            Bundle bundle = new Bundle();
            a.f517j.m1566a(bundle);
            if (bundle.size() > 0) {
                a.f526s = bundle;
            }
            a.f517j.m1591g();
            a.f517j.clear();
        }
        a.f525r = true;
        a.f524q = true;
        if ((i == 8 || i == 0) && this.f653n != null) {
            a = m1290a(0, false);
            if (a != null) {
                a.f520m = false;
                m1308b(a, null);
            }
        }
    }

    private void m1316e(int i, KeyEvent keyEvent) {
        boolean z = true;
        if (this.f649j == null) {
            ag a = m1290a(i, true);
            if (i != 0 || this.f653n == null || !this.f653n.m1760d() || bm.m850a(ViewConfiguration.get(this.a))) {
                boolean z2;
                if (a.f522o || a.f521n) {
                    z2 = a.f522o;
                    m1295a(a, true);
                    z = z2;
                } else {
                    if (a.f520m) {
                        if (a.f525r) {
                            a.f520m = false;
                            z2 = m1308b(a, keyEvent);
                        } else {
                            z2 = true;
                        }
                        if (z2) {
                            m1294a(a, keyEvent);
                        }
                    }
                    z = false;
                }
            } else if (this.f653n.m1761e()) {
                z = this.f653n.m1764h();
            } else {
                if (!m1284k() && m1308b(a, keyEvent)) {
                    z = this.f653n.m1763g();
                }
                z = false;
            }
            if (z) {
                AudioManager audioManager = (AudioManager) this.a.getSystemService("audio");
                if (audioManager != null) {
                    audioManager.playSoundEffect(0);
                } else {
                    Log.w("AppCompatDelegate", "Couldn't get audio manager");
                }
            }
        }
    }

    private int m1317f(int i) {
        int i2;
        int i3 = 1;
        int i4 = 0;
        if (this.f650k == null || !(this.f650k.getLayoutParams() instanceof MarginLayoutParams)) {
            i2 = 0;
        } else {
            int i5;
            MarginLayoutParams marginLayoutParams = (MarginLayoutParams) this.f650k.getLayoutParams();
            if (this.f650k.isShown()) {
                if (this.f646E == null) {
                    this.f646E = new Rect();
                    this.f647F = new Rect();
                }
                Rect rect = this.f646E;
                Rect rect2 = this.f647F;
                rect.set(0, i, 0, 0);
                bq.m2068a(this.f658s, rect, rect2);
                if (marginLayoutParams.topMargin != (rect2.top == 0 ? i : 0)) {
                    marginLayoutParams.topMargin = i;
                    if (this.f660u == null) {
                        this.f660u = new View(this.a);
                        this.f660u.setBackgroundColor(this.a.getResources().getColor(C0202d.abc_input_method_navigation_guard));
                        this.f658s.addView(this.f660u, -1, new LayoutParams(-1, i));
                        i5 = 1;
                    } else {
                        LayoutParams layoutParams = this.f660u.getLayoutParams();
                        if (layoutParams.height != i) {
                            layoutParams.height = i;
                            this.f660u.setLayoutParams(layoutParams);
                        }
                        i5 = 1;
                    }
                } else {
                    i5 = 0;
                }
                if (this.f660u == null) {
                    i3 = 0;
                }
                if (!(this.g || i3 == 0)) {
                    i = 0;
                }
                int i6 = i5;
                i5 = i3;
                i3 = i6;
            } else if (marginLayoutParams.topMargin != 0) {
                marginLayoutParams.topMargin = 0;
                i5 = 0;
            } else {
                i3 = 0;
                i5 = 0;
            }
            if (i3 != 0) {
                this.f650k.setLayoutParams(marginLayoutParams);
            }
            i2 = i5;
        }
        if (this.f660u != null) {
            View view = this.f660u;
            if (i2 == 0) {
                i4 = 8;
            }
            view.setVisibility(i4);
        }
        return i;
    }

    private void m1318o() {
        if (!this.f656q) {
            LayoutInflater from = LayoutInflater.from(this.a);
            if (this.i) {
                if (this.g) {
                    this.f658s = (ViewGroup) from.inflate(C0207i.abc_screen_simple_overlay_action_mode, null);
                } else {
                    this.f658s = (ViewGroup) from.inflate(C0207i.abc_screen_simple, null);
                }
                if (VERSION.SDK_INT >= 21) {
                    au.m688a(this.f658s, new aa(this));
                } else {
                    ((aj) this.f658s).setOnFitSystemWindowsListener(new ab(this));
                }
            } else if (this.h) {
                this.f658s = (ViewGroup) from.inflate(C0207i.abc_dialog_title_material, null);
                this.f = false;
                this.e = false;
            } else if (this.e) {
                TypedValue typedValue = new TypedValue();
                this.a.getTheme().resolveAttribute(C0200b.actionBarTheme, typedValue, true);
                this.f658s = (ViewGroup) LayoutInflater.from(typedValue.resourceId != 0 ? new C0225b(this.a, typedValue.resourceId) : this.a).inflate(C0207i.abc_screen_toolbar, null);
                this.f653n = (ah) this.f658s.findViewById(C0205g.decor_content_parent);
                this.f653n.setWindowCallback(m1285l());
                if (this.f) {
                    this.f653n.m1758a(9);
                }
                if (this.f661v) {
                    this.f653n.m1758a(2);
                }
                if (this.f662w) {
                    this.f653n.m1758a(5);
                }
            }
            if (this.f658s == null) {
                throw new IllegalArgumentException("AppCompat does not support the current theme features");
            }
            if (this.f653n == null) {
                this.f659t = (TextView) this.f658s.findViewById(C0205g.title);
            }
            bq.m2070b(this.f658s);
            ViewGroup viewGroup = (ViewGroup) this.b.findViewById(16908290);
            ContentFrameLayout contentFrameLayout = (ContentFrameLayout) this.f658s.findViewById(C0205g.action_bar_activity_content);
            while (viewGroup.getChildCount() > 0) {
                View childAt = viewGroup.getChildAt(0);
                viewGroup.removeViewAt(0);
                contentFrameLayout.addView(childAt);
            }
            this.b.setContentView(this.f658s);
            viewGroup.setId(-1);
            contentFrameLayout.setId(16908290);
            if (viewGroup instanceof FrameLayout) {
                ((FrameLayout) viewGroup).setForeground(null);
            }
            CharSequence m = m1286m();
            if (!TextUtils.isEmpty(m)) {
                m1337b(m);
            }
            m1301a(contentFrameLayout);
            m1328a(this.f658s);
            this.f656q = true;
            ag a = m1290a(0, false);
            if (!m1284k()) {
                if (a == null || a.f517j == null) {
                    m1312d(8);
                }
            }
        }
    }

    private void m1319p() {
        if (this.f656q) {
            throw new AndroidRuntimeException("Window feature must be requested before adding content");
        }
    }

    C0212a m1320a(C0171b c0171b) {
        C0212a c0212a;
        if (this.f649j != null) {
            this.f649j.m1363c();
        }
        C0171b aeVar = new ae(this, c0171b);
        if (this.d == null || m1284k()) {
            c0212a = null;
        } else {
            try {
                c0212a = this.d.m1174a(aeVar);
            } catch (AbstractMethodError e) {
                c0212a = null;
            }
        }
        if (c0212a != null) {
            this.f649j = c0212a;
        } else {
            if (this.f650k == null) {
                if (this.h) {
                    Context c0225b;
                    TypedValue typedValue = new TypedValue();
                    Theme theme = this.a.getTheme();
                    theme.resolveAttribute(C0200b.actionBarTheme, typedValue, true);
                    if (typedValue.resourceId != 0) {
                        Theme newTheme = this.a.getResources().newTheme();
                        newTheme.setTo(theme);
                        newTheme.applyStyle(typedValue.resourceId, true);
                        c0225b = new C0225b(this.a, 0);
                        c0225b.getTheme().setTo(newTheme);
                    } else {
                        c0225b = this.a;
                    }
                    this.f650k = new ActionBarContextView(c0225b);
                    this.f651l = new PopupWindow(c0225b, null, C0200b.actionModePopupWindowStyle);
                    this.f651l.setContentView(this.f650k);
                    this.f651l.setWidth(-1);
                    c0225b.getTheme().resolveAttribute(C0200b.actionBarSize, typedValue, true);
                    this.f650k.setContentHeight(TypedValue.complexToDimensionPixelSize(typedValue.data, c0225b.getResources().getDisplayMetrics()));
                    this.f651l.setHeight(-2);
                    this.f652m = new ac(this);
                } else {
                    ViewStubCompat viewStubCompat = (ViewStubCompat) this.f658s.findViewById(C0205g.action_mode_bar_stub);
                    if (viewStubCompat != null) {
                        viewStubCompat.setLayoutInflater(LayoutInflater.from(m1283j()));
                        this.f650k = (ActionBarContextView) viewStubCompat.m1833a();
                    }
                }
            }
            if (this.f650k != null) {
                this.f650k.m1755c();
                C0212a c0226c = new C0226c(this.f650k.getContext(), this.f650k, aeVar, this.f651l == null);
                if (c0171b.m1160a(c0226c, c0226c.m1360b())) {
                    c0226c.m1364d();
                    this.f650k.m1750a(c0226c);
                    this.f650k.setVisibility(0);
                    this.f649j = c0226c;
                    if (this.f651l != null) {
                        this.b.getDecorView().post(this.f652m);
                    }
                    this.f650k.sendAccessibilityEvent(32);
                    if (this.f650k.getParent() != null) {
                        au.m705i((View) this.f650k.getParent());
                    }
                } else {
                    this.f649j = null;
                }
            }
        }
        if (!(this.f649j == null || this.d == null)) {
            this.d.m1175a(this.f649j);
        }
        return this.f649j;
    }

    public final View m1321a(View view, String str, Context context, AttributeSet attributeSet) {
        View b = m1334b(view, str, context, attributeSet);
        return b != null ? b : m1341c(view, str, context, attributeSet);
    }

    public void m1322a(int i) {
        m1318o();
        ViewGroup viewGroup = (ViewGroup) this.f658s.findViewById(16908290);
        viewGroup.removeAllViews();
        LayoutInflater.from(this.a).inflate(i, viewGroup);
        this.c.onContentChanged();
    }

    public void m1323a(Configuration configuration) {
        if (this.e && this.f656q) {
            C0169a a = m1269a();
            if (a != null) {
                a.m1141a(configuration);
            }
        }
    }

    public void m1324a(Bundle bundle) {
        super.m1272a(bundle);
        this.f657r = (ViewGroup) this.b.getDecorView();
        if ((this.c instanceof Activity) && aq.m233b((Activity) this.c) != null) {
            C0169a i = m1282i();
            if (i == null) {
                this.f645D = true;
            } else {
                i.m1147c(true);
            }
        }
    }

    public void m1325a(C0240i c0240i) {
        m1300a(c0240i, true);
    }

    public void m1326a(View view) {
        m1318o();
        ViewGroup viewGroup = (ViewGroup) this.f658s.findViewById(16908290);
        viewGroup.removeAllViews();
        viewGroup.addView(view);
        this.c.onContentChanged();
    }

    public void m1327a(View view, LayoutParams layoutParams) {
        m1318o();
        ViewGroup viewGroup = (ViewGroup) this.f658s.findViewById(16908290);
        viewGroup.removeAllViews();
        viewGroup.addView(view, layoutParams);
        this.c.onContentChanged();
    }

    void m1328a(ViewGroup viewGroup) {
    }

    boolean m1329a(int i, KeyEvent keyEvent) {
        C0169a a = m1269a();
        if (a != null && a.m1144a(i, keyEvent)) {
            return true;
        }
        if (this.f665z == null || !m1303a(this.f665z, keyEvent.getKeyCode(), keyEvent, 1)) {
            if (this.f665z == null) {
                ag a2 = m1290a(0, true);
                m1308b(a2, keyEvent);
                boolean a3 = m1303a(a2, keyEvent.getKeyCode(), keyEvent, 1);
                a2.f520m = false;
                if (a3) {
                    return true;
                }
            }
            return false;
        } else if (this.f665z == null) {
            return true;
        } else {
            this.f665z.f521n = true;
            return true;
        }
    }

    boolean m1330a(int i, Menu menu) {
        if (i == 8) {
            C0169a a = m1269a();
            if (a == null) {
                return true;
            }
            a.m1151e(false);
            return true;
        }
        if (i == 0) {
            ag a2 = m1290a(i, true);
            if (a2.f522o) {
                m1295a(a2, false);
            }
        }
        return false;
    }

    public boolean m1331a(C0240i c0240i, MenuItem menuItem) {
        Callback l = m1285l();
        if (!(l == null || m1284k())) {
            ag a = m1292a(c0240i.m1600p());
            if (a != null) {
                return l.onMenuItemSelected(a.f508a, menuItem);
            }
        }
        return false;
    }

    boolean m1332a(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        return (keyEvent.getAction() == 0 ? 1 : null) != null ? m1343c(keyCode, keyEvent) : m1339b(keyCode, keyEvent);
    }

    public C0212a m1333b(C0171b c0171b) {
        if (c0171b == null) {
            throw new IllegalArgumentException("ActionMode callback can not be null.");
        }
        if (this.f649j != null) {
            this.f649j.m1363c();
        }
        C0171b aeVar = new ae(this, c0171b);
        C0169a a = m1269a();
        if (a != null) {
            this.f649j = a.m1139a(aeVar);
            if (!(this.f649j == null || this.d == null)) {
                this.d.m1175a(this.f649j);
            }
        }
        if (this.f649j == null) {
            this.f649j = m1320a(aeVar);
        }
        return this.f649j;
    }

    View m1334b(View view, String str, Context context, AttributeSet attributeSet) {
        if (this.c instanceof Factory) {
            View onCreateView = ((Factory) this.c).onCreateView(str, context, attributeSet);
            if (onCreateView != null) {
                return onCreateView;
            }
        }
        return null;
    }

    public void m1335b(Bundle bundle) {
        m1318o();
    }

    public void m1336b(View view, LayoutParams layoutParams) {
        m1318o();
        ((ViewGroup) this.f658s.findViewById(16908290)).addView(view, layoutParams);
        this.c.onContentChanged();
    }

    void m1337b(CharSequence charSequence) {
        if (this.f653n != null) {
            this.f653n.setWindowTitle(charSequence);
        } else if (m1282i() != null) {
            m1282i().m1142a(charSequence);
        } else if (this.f659t != null) {
            this.f659t.setText(charSequence);
        }
    }

    public boolean m1338b(int i) {
        switch (i) {
            case C0339o.View_android_focusable /*1*/:
                m1319p();
                this.i = true;
                return true;
            case C0339o.View_paddingStart /*2*/:
                m1319p();
                this.f661v = true;
                return true;
            case C0339o.View_backgroundTint /*5*/:
                m1319p();
                this.f662w = true;
                return true;
            case C0339o.Toolbar_popupTheme /*8*/:
                m1319p();
                this.e = true;
                return true;
            case C0339o.Toolbar_titleTextAppearance /*9*/:
                m1319p();
                this.f = true;
                return true;
            case C0339o.Toolbar_subtitleTextAppearance /*10*/:
                m1319p();
                this.g = true;
                return true;
            default:
                return this.b.requestFeature(i);
        }
    }

    boolean m1339b(int i, KeyEvent keyEvent) {
        switch (i) {
            case C0339o.View_theme /*4*/:
                ag a = m1290a(0, false);
                if (a != null && a.f522o) {
                    m1295a(a, true);
                    return true;
                } else if (m1348n()) {
                    return true;
                }
                break;
            case C0339o.Theme_colorPrimaryDark /*82*/:
                m1316e(0, keyEvent);
                return true;
        }
        return false;
    }

    boolean m1340b(int i, Menu menu) {
        if (i != 8) {
            return false;
        }
        C0169a a = m1269a();
        if (a == null) {
            return true;
        }
        a.m1151e(true);
        return true;
    }

    public View m1341c(View view, String str, Context context, AttributeSet attributeSet) {
        boolean z = VERSION.SDK_INT < 21;
        if (this.f648G == null) {
            this.f648G = new C0214a();
        }
        boolean z2 = (!z || !this.f656q || view == null || view.getId() == 16908290 || au.m711o(view)) ? false : true;
        return this.f648G.m1376a(view, str, context, attributeSet, z2, z, true);
    }

    public void m1342c() {
        C0169a a = m1269a();
        if (a != null) {
            a.m1149d(false);
        }
    }

    boolean m1343c(int i, KeyEvent keyEvent) {
        switch (i) {
            case C0339o.Theme_colorPrimaryDark /*82*/:
                m1314d(0, keyEvent);
                return true;
            default:
                return VERSION.SDK_INT < 11 ? m1329a(i, keyEvent) : false;
        }
    }

    public void m1344d() {
        C0169a a = m1269a();
        if (a != null) {
            a.m1149d(true);
        }
    }

    public void m1345e() {
        C0169a a = m1269a();
        if (a == null || !a.m1148c()) {
            m1312d(0);
        }
    }

    public void m1346g() {
        LayoutInflater from = LayoutInflater.from(this.a);
        if (from.getFactory() == null) {
            C0126i.m949a(from, this);
        } else {
            Log.i("AppCompatDelegate", "The Activity's LayoutInflater already has a Factory installed so we can not install AppCompat's");
        }
    }

    public C0169a m1347h() {
        m1318o();
        C0169a c0169a = null;
        if (this.c instanceof Activity) {
            c0169a = new C0216b((Activity) this.c, this.f);
        } else if (this.c instanceof Dialog) {
            c0169a = new C0216b((Dialog) this.c);
        }
        if (c0169a != null) {
            c0169a.m1147c(this.f645D);
        }
        return c0169a;
    }

    boolean m1348n() {
        if (this.f649j != null) {
            this.f649j.m1363c();
            return true;
        }
        C0169a a = m1269a();
        return a != null && a.m1150d();
    }
}
