package hci2.group5.a2part2;

import com.google.android.gms.maps.GoogleMap.OnMarkerClickListener;
import com.google.android.gms.maps.model.Marker;

class MyMarkClickListener implements OnMarkerClickListener{

	public MyMarkClickListener()
	{
		
	}
	
	@Override
	public boolean onMarkerClick(Marker myMarker) {
		if(myMarker.isInfoWindowShown())
			myMarker.hideInfoWindow();//close info window if it is shown
		else
			myMarker.showInfoWindow();//open info window if it is close
		return false;
	}

}
