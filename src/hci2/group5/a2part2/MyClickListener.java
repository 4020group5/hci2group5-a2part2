package hci2.group5.a2part2;

import com.google.android.gms.maps.GoogleMap.OnMapClickListener;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

class MyClickListener implements OnMapClickListener{
	MainActivity activity;
	Marker myMarker;
	
	public MyClickListener(MainActivity activity)
	{
		this.activity=activity;
	}

	@Override
	public void onMapClick(LatLng position) {
		if(position!=null)
		{
			if(this.myMarker!=null)
				this.myMarker.remove();
			
			String latitude="Latitude: ";
			String longitude="Longitude: ";
			latitude=latitude+(position.latitude);
			longitude=longitude+(position.longitude);
			String info=latitude+"\n"+longitude;
			this.myMarker = this.activity.myMap.addMarker(new MarkerOptions()
            .position(position)
            .title("Selected Location:")
            .snippet(info)
            .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));//show blue marker on position selected
			
			//this.myMarker.showInfoWindow();
			this.myMarker.setDraggable(true);
		}
	}
	
}


