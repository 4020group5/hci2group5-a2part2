package hci2.group5.a2part2;

import android.location.Location;

import com.google.android.gms.maps.GoogleMap.OnMyLocationChangeListener;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

class MyOnLocationChangeListener implements OnMyLocationChangeListener{
	MainActivity activity;
	boolean isShown;
	
	public MyOnLocationChangeListener(MainActivity activity)
	{
		this.activity=activity;
		isShown=false;
	}
	
	@Override
	public void onMyLocationChange(Location location) {
		if(location!=null){
			String latitude="Latitude: ";
			String longitude="Longitude: ";
			this.activity.location=location;//update lat & lng
			this.activity.position=new LatLng(location.getLatitude(), location.getLongitude());//change the cur position
			latitude=latitude+(location.getLatitude());
			longitude=longitude+(location.getLongitude());
			String info=latitude+"\n"+longitude;
			
			if(activity.myMarker!=null)
			{
				isShown=this.activity.myMarker.isInfoWindowShown();//record previous marke info window state
				activity.myMarker.remove();
			}
			//update marker
			this.activity.myMarker = this.activity.myMap.addMarker(new MarkerOptions()
										.position(this.activity.position)
										.title("Your Current Location:")
										.snippet(info));
			//keep pre state
			if(isShown)
			{
				this.activity.myMarker.showInfoWindow();
			}
			
			if(this.activity.polyline!=null)
				this.activity.polyline.remove();//clear the previous polyline
			
			this.activity.pts.add(new LatLng(location.getLatitude(), location.getLongitude()));//add the new current pt
			this.activity.polyline = this.activity.myMap.addPolyline(this.activity.pts);//update polyline
			this.activity.polyline.setColor(0x800000ff);//set color to blue
		}
	}

}
