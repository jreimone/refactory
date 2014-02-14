package org.emftext.refactoring.languages.java.smell.android.test;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.format.DateUtils;

public class RigidAlarmManagerTest extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		AlarmManager am = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
		
		Intent intent = new Intent(this, InterruptingFromBackgroundServiceTest.class);
		PendingIntent pendingIntent = PendingIntent.getService(this,0, intent,0);
		
		long interval = DateUtils.MINUTE_IN_MILLIS * 30;
		long firstWake = System.currentTimeMillis() + interval;
		
		am.setRepeating(AlarmManager.RTC_WAKEUP, firstWake, interval, pendingIntent);
	}
}
