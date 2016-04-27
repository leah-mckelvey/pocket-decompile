package android.support.v7.internal.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build.VERSION;
import android.support.v4.p001b.C0034a;
import android.support.v4.p003c.C0090a;
import android.support.v4.p003c.p004a.C0073a;
import android.support.v7.p013b.C0200b;
import android.support.v7.p013b.C0204f;
import android.util.SparseArray;
import android.view.View;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

public final class bi {
    public static final boolean f1214a;
    private static final Mode f1215b;
    private static final WeakHashMap f1216c;
    private static final bj f1217d;
    private static final int[] f1218e;
    private static final int[] f1219f;
    private static final int[] f1220g;
    private static final int[] f1221h;
    private static final int[] f1222i;
    private static final int[] f1223j;
    private final WeakReference f1224k;
    private SparseArray f1225l;
    private ColorStateList f1226m;

    static {
        f1214a = VERSION.SDK_INT < 21;
        f1215b = Mode.SRC_IN;
        f1216c = new WeakHashMap();
        f1217d = new bj(6);
        f1218e = new int[]{C0204f.abc_textfield_search_default_mtrl_alpha, C0204f.abc_textfield_default_mtrl_alpha, C0204f.abc_ab_share_pack_mtrl_alpha};
        f1219f = new int[]{C0204f.abc_ic_ab_back_mtrl_am_alpha, C0204f.abc_ic_go_search_api_mtrl_alpha, C0204f.abc_ic_search_api_mtrl_alpha, C0204f.abc_ic_commit_search_api_mtrl_alpha, C0204f.abc_ic_clear_mtrl_alpha, C0204f.abc_ic_menu_share_mtrl_alpha, C0204f.abc_ic_menu_copy_mtrl_am_alpha, C0204f.abc_ic_menu_cut_mtrl_alpha, C0204f.abc_ic_menu_selectall_mtrl_alpha, C0204f.abc_ic_menu_paste_mtrl_am_alpha, C0204f.abc_ic_menu_moreoverflow_mtrl_alpha, C0204f.abc_ic_voice_search_api_mtrl_alpha};
        f1220g = new int[]{C0204f.abc_textfield_activated_mtrl_alpha, C0204f.abc_textfield_search_activated_mtrl_alpha, C0204f.abc_cab_background_top_mtrl_alpha, C0204f.abc_text_cursor_mtrl_alpha};
        f1221h = new int[]{C0204f.abc_popup_background_mtrl_mult, C0204f.abc_cab_background_internal_bg, C0204f.abc_menu_hardkey_panel_mtrl_mult};
        f1222i = new int[]{C0204f.abc_edit_text_material, C0204f.abc_tab_indicator_material, C0204f.abc_textfield_search_material, C0204f.abc_spinner_mtrl_am_alpha, C0204f.abc_spinner_textfield_background_material, C0204f.abc_ratingbar_full_material, C0204f.abc_switch_track_mtrl_alpha, C0204f.abc_switch_thumb_material, C0204f.abc_btn_default_mtrl_shape, C0204f.abc_btn_borderless_material};
        f1223j = new int[]{C0204f.abc_btn_check_material, C0204f.abc_btn_radio_material};
    }

    private bi(Context context) {
        this.f1224k = new WeakReference(context);
    }

    public static Drawable m1978a(Context context, int i) {
        return m1986d(i) ? m1979a(context).m1991a(i) : C0034a.m179a(context, i);
    }

    public static bi m1979a(Context context) {
        bi biVar = (bi) f1216c.get(context);
        if (biVar != null) {
            return biVar;
        }
        biVar = new bi(context);
        f1216c.put(context, biVar);
        return biVar;
    }

    private static void m1980a(Drawable drawable, int i, Mode mode) {
        if (mode == null) {
            mode = f1215b;
        }
        ColorFilter a = f1217d.m1997a(i, mode);
        if (a == null) {
            a = new PorterDuffColorFilter(i, mode);
            f1217d.m1998a(i, mode, a);
        }
        drawable.setColorFilter(a);
    }

    public static void m1981a(View view, bh bhVar) {
        Drawable background = view.getBackground();
        if (bhVar.f1213d) {
            m1980a(background, bhVar.f1210a.getColorForState(view.getDrawableState(), bhVar.f1210a.getDefaultColor()), bhVar.f1212c ? bhVar.f1211b : null);
        } else {
            background.clearColorFilter();
        }
        if (VERSION.SDK_INT <= 10) {
            view.invalidate();
        }
    }

    private static boolean m1982a(int[] iArr, int i) {
        for (int i2 : iArr) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }

    private ColorStateList m1983b(Context context) {
        if (this.f1226m == null) {
            int a = be.m1971a(context, C0200b.colorControlNormal);
            int a2 = be.m1971a(context, C0200b.colorControlActivated);
            r2 = new int[7][];
            int[] iArr = new int[]{be.f1198a, be.m1976c(context, C0200b.colorControlNormal), be.f1199b, a2, be.f1200c, a2, be.f1201d};
            iArr[3] = a2;
            r2[4] = be.f1202e;
            iArr[4] = a2;
            r2[5] = be.f1203f;
            iArr[5] = a2;
            r2[6] = be.f1205h;
            iArr[6] = a;
            this.f1226m = new ColorStateList(r2, iArr);
        }
        return this.f1226m;
    }

    private ColorStateList m1984c(Context context) {
        r0 = new int[3][];
        int[] iArr = new int[]{be.f1198a, be.m1976c(context, C0200b.colorControlNormal), be.f1202e};
        iArr[1] = be.m1971a(context, C0200b.colorControlActivated);
        r0[2] = be.f1205h;
        iArr[2] = be.m1971a(context, C0200b.colorControlNormal);
        return new ColorStateList(r0, iArr);
    }

    private ColorStateList m1985d(Context context) {
        r0 = new int[3][];
        int[] iArr = new int[]{be.f1198a, be.m1972a(context, 16842800, 0.1f), be.f1202e};
        iArr[1] = be.m1972a(context, C0200b.colorControlActivated, 0.3f);
        r0[2] = be.f1205h;
        iArr[2] = be.m1972a(context, 16842800, 0.3f);
        return new ColorStateList(r0, iArr);
    }

    private static boolean m1986d(int i) {
        return m1982a(f1219f, i) || m1982a(f1218e, i) || m1982a(f1220g, i) || m1982a(f1222i, i) || m1982a(f1221h, i) || m1982a(f1223j, i) || i == C0204f.abc_cab_background_top_material;
    }

    private ColorStateList m1987e(Context context) {
        int[][] iArr = new int[3][];
        int[] iArr2 = new int[3];
        ColorStateList b = be.m1975b(context, C0200b.colorSwitchThumbNormal);
        if (b == null || !b.isStateful()) {
            iArr[0] = be.f1198a;
            iArr2[0] = be.m1976c(context, C0200b.colorSwitchThumbNormal);
            iArr[1] = be.f1202e;
            iArr2[1] = be.m1971a(context, C0200b.colorControlActivated);
            iArr[2] = be.f1205h;
            iArr2[2] = be.m1971a(context, C0200b.colorSwitchThumbNormal);
        } else {
            iArr[0] = be.f1198a;
            iArr2[0] = b.getColorForState(iArr[0], 0);
            iArr[1] = be.f1202e;
            iArr2[1] = be.m1971a(context, C0200b.colorControlActivated);
            iArr[2] = be.f1205h;
            iArr2[2] = b.getDefaultColor();
        }
        return new ColorStateList(iArr, iArr2);
    }

    private ColorStateList m1988f(Context context) {
        r0 = new int[3][];
        int[] iArr = new int[]{be.f1198a, be.m1976c(context, C0200b.colorControlNormal), be.f1204g};
        iArr[1] = be.m1971a(context, C0200b.colorControlNormal);
        r0[2] = be.f1205h;
        iArr[2] = be.m1971a(context, C0200b.colorControlActivated);
        return new ColorStateList(r0, iArr);
    }

    private ColorStateList m1989g(Context context) {
        r0 = new int[4][];
        r1 = new int[4];
        int a = be.m1971a(context, C0200b.colorButtonNormal);
        int a2 = be.m1971a(context, C0200b.colorControlHighlight);
        r0[0] = be.f1198a;
        r1[0] = be.m1976c(context, C0200b.colorButtonNormal);
        r0[1] = be.f1201d;
        r1[1] = C0090a.m526a(a2, a);
        r0[2] = be.f1199b;
        r1[2] = C0090a.m526a(a2, a);
        r0[3] = be.f1205h;
        r1[3] = a;
        return new ColorStateList(r0, r1);
    }

    private ColorStateList m1990h(Context context) {
        r0 = new int[3][];
        int[] iArr = new int[]{be.f1198a, be.m1976c(context, C0200b.colorControlNormal), be.f1204g};
        iArr[1] = be.m1971a(context, C0200b.colorControlNormal);
        r0[2] = be.f1205h;
        iArr[2] = be.m1971a(context, C0200b.colorControlActivated);
        return new ColorStateList(r0, iArr);
    }

    public Drawable m1991a(int i) {
        return m1992a(i, false);
    }

    public Drawable m1992a(int i, boolean z) {
        Context context = (Context) this.f1224k.get();
        if (context == null) {
            return null;
        }
        Drawable a = C0034a.m179a(context, i);
        if (a != null) {
            if (VERSION.SDK_INT >= 8) {
                a = a.mutate();
            }
            ColorStateList c = m1995c(i);
            if (c != null) {
                a = C0073a.m474c(a);
                C0073a.m470a(a, c);
                Mode b = m1994b(i);
                if (b != null) {
                    C0073a.m471a(a, b);
                }
            } else if (i == C0204f.abc_cab_background_top_material) {
                return new LayerDrawable(new Drawable[]{m1991a(C0204f.abc_cab_background_internal_bg), m1991a(C0204f.abc_cab_background_top_mtrl_alpha)});
            } else if (!m1993a(i, a) && z) {
                a = null;
            }
        }
        return a;
    }

    public final boolean m1993a(int i, Drawable drawable) {
        Context context = (Context) this.f1224k.get();
        if (context == null) {
            return false;
        }
        int i2;
        Mode mode;
        Object obj;
        int i3;
        if (m1982a(f1218e, i)) {
            i2 = C0200b.colorControlNormal;
            mode = null;
            obj = 1;
            i3 = -1;
        } else if (m1982a(f1220g, i)) {
            i2 = C0200b.colorControlActivated;
            mode = null;
            r6 = 1;
            i3 = -1;
        } else if (m1982a(f1221h, i)) {
            r6 = 1;
            mode = Mode.MULTIPLY;
            i2 = 16842801;
            i3 = -1;
        } else if (i == C0204f.abc_list_divider_mtrl_alpha) {
            i2 = 16842800;
            i3 = Math.round(40.8f);
            mode = null;
            r6 = 1;
        } else {
            i3 = -1;
            i2 = 0;
            mode = null;
            obj = null;
        }
        if (obj == null) {
            return false;
        }
        m1980a(drawable, be.m1971a(context, i2), mode);
        if (i3 != -1) {
            drawable.setAlpha(i3);
        }
        return true;
    }

    final Mode m1994b(int i) {
        return i == C0204f.abc_switch_thumb_material ? Mode.MULTIPLY : null;
    }

    public final ColorStateList m1995c(int i) {
        ColorStateList colorStateList = null;
        Context context = (Context) this.f1224k.get();
        if (context == null) {
            return null;
        }
        if (this.f1225l != null) {
            colorStateList = (ColorStateList) this.f1225l.get(i);
        }
        if (colorStateList != null) {
            return colorStateList;
        }
        ColorStateList f = i == C0204f.abc_edit_text_material ? m1988f(context) : i == C0204f.abc_switch_track_mtrl_alpha ? m1985d(context) : i == C0204f.abc_switch_thumb_material ? m1987e(context) : (i == C0204f.abc_btn_default_mtrl_shape || i == C0204f.abc_btn_borderless_material) ? m1989g(context) : (i == C0204f.abc_spinner_mtrl_am_alpha || i == C0204f.abc_spinner_textfield_background_material) ? m1990h(context) : m1982a(f1219f, i) ? be.m1975b(context, C0200b.colorControlNormal) : m1982a(f1222i, i) ? m1983b(context) : m1982a(f1223j, i) ? m1984c(context) : colorStateList;
        if (f == null) {
            return f;
        }
        if (this.f1225l == null) {
            this.f1225l = new SparseArray();
        }
        this.f1225l.append(i, f);
        return f;
    }
}
