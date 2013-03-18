package hci2.group5.a2part2;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

import hci2.group5.a2part2.util.NetworkUtil;
import android.app.Activity;
import android.location.Location;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends Activity{
	
	GoogleMap myMap;
	UiSettings mySettings;
	LatLng position;
	Location location;
	CameraPosition cameraPosition;
	Marker myMarker;
	MyClickListener clickListener;
	MyOnLocationChangeListener locationListener;
	MyLongClickListener longClickListener;
	MyMarkClickListener markClickListener;
	PolylineOptions pts;
	Polyline polyline;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//check the network
		if ( ! NetworkUtil.isNetworkAvailable(this)) {
			Toast toast = Toast.makeText(getApplicationContext(), "no internet...", Toast.LENGTH_SHORT);
			toast.show();
		}
		
		//initial the map
		myMap = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();
		myMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);//set to normal type
		myMap.setMyLocationEnabled(true);//disable location layer
		
		mySettings= myMap.getUiSettings();//settings for map	
		mySettings.setMyLocationButtonEnabled(true);//enable location button
		
		clickListener=new MyClickListener(this);//initiate click listener
		locationListener=new MyOnLocationChangeListener(this);//initiate location listener
		longClickListener=new MyLongClickListener(this);
		markClickListener=new MyMarkClickListener();
		
		pts=new PolylineOptions();
		
		myMap.setOnMapClickListener(clickListener);//activate click listener
		myMap.setOnMyLocationChangeListener(locationListener);//activate location listener
		myMap.setOnMapLongClickListener(longClickListener);
		myMap.setOnMarkerClickListener(markClickListener);
		 
	}

}
