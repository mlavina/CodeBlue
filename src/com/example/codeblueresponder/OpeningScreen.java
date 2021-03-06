package com.example.codeblueresponder;

import android.os.Bundle;
import android.os.Handler;
import android.content.Context;
import android.location.*;
import android.app.Activity;
import android.view.*;
import android.view.View.OnClickListener;
import android.widget.*;

import com.example.codeblue.R;
import com.parse.Parse;
import com.parse.ParseObject;
import com.parse.ParseAnalytics;

public class OpeningScreen extends Activity {
	
	private static final long MINIMUM_DISTANCE_CHANGE_FOR_CHANGE_FOR_UPDATES = 1;
<<<<<<< HEAD
<<<<<<< HEAD
	private static final long MINIMUM_TIME_BETWEEN_UPDATES=1000*60;
	
=======
	private static final long MINIMUM_TIME_BETWEEN_UPDATES=100;
>>>>>>> 25154991e8ef92360b86d5fafdb839efe62e078b
=======
	private static final long MINIMUM_TIME_BETWEEN_UPDATES=100;
>>>>>>> 25154991e8ef92360b86d5fafdb839efe62e078b
	protected LocationManager locationManager;
	protected Button retrieveLocationButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Parse.initialize(this, "eocIqgaU4I25C7KpZhbinyr0sankzJeuRVOws2nT", "f5KktjOp6Gy6T6Ll69G5XfpgaD4Aaruc6LnJyVgR");
		ParseAnalytics.trackAppOpened(getIntent());
		setContentView(R.layout.activity_opening_screen);
		
		retrieveLocationButton = (Button) findViewById(R.id.retrieve_location_button);
		
		locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
		locationManager.requestLocationUpdates(
				LocationManager.GPS_PROVIDER,
				MINIMUM_TIME_BETWEEN_UPDATES,
				MINIMUM_DISTANCE_CHANGE_FOR_CHANGE_FOR_UPDATES,
				new MyLocationListener()
				);
		
		retrieveLocationButton.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v){
				showCurrentLocation();
			}
		});
		
		final Handler handler = new Handler(); 
        Runnable runable = new Runnable() { 

            @Override 
            public void run() { 
                try{
                	Location location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
                    //also call the same runnable 
                    handler.postDelayed(this, MINIMUM_TIME_BETWEEN_UPDATES);
                }
                catch (Exception e) {
                    // TODO: handle exception
                }
                finally{
                    //also call the same runnable 
                    handler.postDelayed(this, MINIMUM_TIME_BETWEEN_UPDATES); 
                }
            } 
        }; 
        handler.postDelayed(runable, MINIMUM_TIME_BETWEEN_UPDATES); 
	}
		protected void showCurrentLocation(){
			Location location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
			if(location != null){
				String message = String.format("Current Location\n Longitude: %1$s \n Latitude: %2$s",
												location.getLongitude(), location.getLatitude());
				Toast.makeText(OpeningScreen.this, message, Toast.LENGTH_LONG).show();
		}
	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.opening_screen, menu);
		return true;
	}
	
	private class MyLocationListener implements LocationListener {
		
		@Override
		public void onLocationChanged(Location location){
			String message = String.format("New Location\n Longitude: %1$s \n Latitude: %2$s",
												location.getLongitude(), location.getLatitude());
				Toast.makeText(OpeningScreen.this, message, Toast.LENGTH_LONG).show();
		}
		
		public void onStatusChanged(String s, int i, Bundle b){
			Toast.makeText(OpeningScreen.this, "Provider status changed", Toast.LENGTH_LONG).show();
		}
		
		public void onProviderDisabled(String s){
			Toast.makeText(OpeningScreen.this, "GPS turned off", Toast.LENGTH_LONG).show();
		}
		
		public void onProviderEnabled(String s){
			Toast.makeText(OpeningScreen.this, "GPSTurnedOn", Toast.LENGTH_LONG).show();
		}

		
	}
}
