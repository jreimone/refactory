package org.emftext.refactoring.languages.java.smell.android.test;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.widget.Toast;

public class InterruptingFromBackgroundServiceTest extends Service {

	public class LocalBinder extends Binder {
		InterruptingFromBackgroundServiceTest getService() {
			return InterruptingFromBackgroundServiceTest.this;
		}
	}

	// This is the object that receives interactions from clients. See
	// RemoteService for a more complete example.
	private final IBinder mBinder = new LocalBinder();

	@Override
	public IBinder onBind(Intent intent) {
		return mBinder;
	}

	@Override
	public void onCreate() {
		super.onCreate();
		Toast.makeText(this, "Hello World!",1000).show();
	}
}
