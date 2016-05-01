package com.location.preference;

import android.app.IntentService;
import android.content.Intent;
import android.location.Location;

public class UpdateLocationService extends IntentService {

	public UpdateLocationService() {
		super(UpdateLocationService.class.getName());

	}

	@Override
	protected void onHandleIntent(Intent intent) {
		if (!Utils.isDeviceLocationOn(this)) {
			CustomLogger.getInsatance(this).putLog(" Location is off");
			return;
		}
		Location location = LocationTracker.getLocationTrackerInstance(this)
				.getLocation();
		if (location == null) {
			CustomLogger.getInsatance(this).putLog("Location not Found");
			return;
		}
		Utils.sendLocation(this, location);
	}

}
