package com.location.preference;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class BootBroadcastReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		CustomLogger.getInsatance(context).putLog("Deive Restarted");
		Utils.cancelAlarm(context);
		Utils.scheduleAlarm(context);

	}

}
