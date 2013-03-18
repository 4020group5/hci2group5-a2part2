package hci2.group5.a2part2;

import com.google.android.gms.maps.GoogleMap.OnMapLongClickListener;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.PolylineOptions;

class MyLongClickListener implements OnMapLongClickListener{
	MainActivity activity;
	
	public MyLongClickListener(MainActivity activity)
	{
		this.activity=activity;
	}

	@Override
	public void onMapLongClick(LatLng position) {
		if(this.activity.clickListener.myMarker!=null)
		{
			this.activity.clickListener.myMarker.remove();//remove blue marker
		}
		this.activity.myMarker.hideInfoWindow();//close info window of red marker
		
		if(this.activity.polyline!=null)
		{
			this.activity.pts=new PolylineOptions();//clear pts
		}
	}

}

