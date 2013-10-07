package org.qualitune.refactoring.energy.test;

import android.app.Activity;
import android.content.Context;
import android.location.GpsStatus.Listener;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class GpsPrint extends Activity implements OnClickListener, Listener, LocationListener {

	private TextView statusView;
	private Button saveLocationButton;
	private LocationManager lm;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		lm = (LocationManager)this.getSystemService(Context.LOCATION_SERVICE);
        if(lm.getAllProviders().contains(LocationManager.GPS_PROVIDER)){
            if(lm.isProviderEnabled(LocationManager.GPS_PROVIDER)){
                lm.addGpsStatusListener(this);
                // here the physical component is requested and consumes energy 
                // but the user cannot yet interact with the app in this state
                lm.requestLocationUpdates(LocationManager.GPS_PROVIDER,1000,0, this);
                statusView.setText("GPS service started");
            } else {
                statusView.setText("Please enable GPS");
                saveLocationButton.setEnabled(false); 
            }
        }
	}
	
    public void onPause() {
        lm.removeUpdates(this);
    }

	@Override
	public void onLocationChanged(Location arg0) {

	}

	@Override
	public void onProviderDisabled(String arg0) {

	}

	@Override
	public void onProviderEnabled(String arg0) {

	}

	@Override
	public void onStatusChanged(String arg0, int arg1, Bundle arg2) {

	}

	@Override
	public void onGpsStatusChanged(int arg0) {

	}

	@Override
	public void onClick(View arg0) {

	}
}
