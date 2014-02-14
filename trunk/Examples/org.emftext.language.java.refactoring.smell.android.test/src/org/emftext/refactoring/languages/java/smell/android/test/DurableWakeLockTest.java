package org.emftext.refactoring.languages.java.smell.android.test;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;

public class DurableWakeLockTest extends Activity implements LocationListener {

	private final static String TAG = "DURABLEWAKELOCK_TEST";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		doSetWakeLock();
	}

	private void doSetWakeLock() {
		PowerManager pm = (PowerManager) getSystemService(Context.POWER_SERVICE);
		WakeLock wl = pm.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK
				| PowerManager.ON_AFTER_RELEASE, TAG);

		wl.acquire();
	}

	@Override
	public void onLocationChanged(Location arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onProviderDisabled(String arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onProviderEnabled(String arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStatusChanged(String arg0, int arg1, Bundle arg2) {
		// TODO Auto-generated method stub
	}
		
	
}
