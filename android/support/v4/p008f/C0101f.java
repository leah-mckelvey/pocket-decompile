package android.support.v4.p008f;

import com.pocket.doorway.C0339o;
import java.util.Locale;

/* renamed from: android.support.v4.f.f */
public class C0101f {
    public static final Locale f340a;
    private static String f341b;
    private static String f342c;

    static {
        f340a = new Locale("", "");
        f341b = "Arab";
        f342c = "Hebr";
    }

    public static int m545a(Locale locale) {
        if (!(locale == null || locale.equals(f340a))) {
            String a = C0096a.m535a(C0096a.m536b(locale.toString()));
            if (a == null) {
                return C0101f.m546b(locale);
            }
            if (a.equalsIgnoreCase(f341b) || a.equalsIgnoreCase(f342c)) {
                return 1;
            }
        }
        return 0;
    }

    private static int m546b(Locale locale) {
        switch (Character.getDirectionality(locale.getDisplayName(locale).charAt(0))) {
            case C0339o.View_android_focusable /*1*/:
            case C0339o.View_paddingStart /*2*/:
                return 1;
            default:
                return 0;
        }
    }
}
