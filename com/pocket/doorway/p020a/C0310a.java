package com.pocket.doorway.p020a;

import android.content.Context;
import android.content.Intent;
import com.pocket.doorway.App;
import com.pocket.doorway.GameActivity;
import com.pocket.doorway.input.TractorBeamTargetingService;
import com.pocket.doorway.p019b.C0309b;
import java.util.GregorianCalendar;
import java.util.List;

/* renamed from: com.pocket.doorway.a.a */
public class C0310a extends C0309b {
    private final Context f1519a;

    public C0310a(Context context) {
        super(5000);
        this.f1519a = context;
    }

    public static boolean m2326d() {
        List queryBroadcastReceivers = App.m2304a().getPackageManager().queryBroadcastReceivers(new Intent("com.pocket.commander.uplink.TRANSMIT"), 0);
        return (queryBroadcastReceivers == null || queryBroadcastReceivers.isEmpty()) ? false : true;
    }

    public static String m2327e() {
        int i = GregorianCalendar.getInstance().get(11);
        return (i < 4 || i > 23) ? "Good evening Androidian Commander Leah." : (i < 4 || i > 17) ? "Good evening Androidian Commander Leah." : i > 12 ? "Good afternoon Androidian Commander Leah." : "Good morning Androidian Commander Leah.";
    }

    public void m2328c() {
        if (C0310a.m2326d()) {
            Intent intent = new Intent("com.pocket.commander.uplink.TRANSMIT");
            intent.putExtra("message", new String[]{C0310a.m2327e(), "Now this is what I call an uplink! Sure beats those old LogCat Radios.", "~", "YOUR MISSION", "The FABs are out of control and running havoc in the " + this.f1519a.getPackageName() + " package.", "We need you to start the " + GameActivity.class.getCanonicalName() + " and capture those FABs!", "Once all the FABs are captured, the mission will be complete!", "~", "We've deployed some FAB vortexes into the corners of the activity ahead of your arrival.", "Use them to capture the FABs.", "Each vortex has a tractor beam that can grab hold of a FAB.", "Use the beam to bring the FAB into the vortex to capture it.", "Each vortex can capture a single FAB of the same color.", "Careful though, if a vortex captures a FAB of a different color, we are all going to have a really bad day...", "Reports are coming in that the raw colors are #EF4056, #83EDB8, #50bcb6, and #FCB643.", "~", "AIMING A TRACTOR BEAM", "Aim a vortex tractor beam by sending a Message via Messenger to the " + TractorBeamTargetingService.class.getCanonicalName(), "Message.what : The vortex to aim from, as represented by its Color.", "Message.arg1 : The x coordinate to aim at", "Message.arg2 : The y coordinate to aim at", "~", "Oh and these vortexes will get overloaded if you send more than 60 messages a second.", "If that happens, we will be forced to retreat.", "~", "Good luck!"});
            this.f1519a.sendBroadcast(intent);
        }
    }
}
