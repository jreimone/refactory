package org.emftext.refactoring.languages.java.smell.android.test;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.telephony.TelephonyManager;

public class TrackingHardwareIdTest extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		TelephonyManager tm = (TelephonyManager) 
				getSystemService(Context.TELEPHONY_SERVICE);
		String id = tm.getDeviceId();
	}
	
}
