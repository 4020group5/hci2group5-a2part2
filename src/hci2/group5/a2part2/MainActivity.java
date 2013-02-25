package hci2.group5.a2part2;

import hci2.group5.a2part2.util.NetworkUtil;
import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		if ( ! NetworkUtil.isNetworkAvailable(this)) {
			Toast toast = Toast.makeText(getApplicationContext(), "no internet...", Toast.LENGTH_SHORT);
			toast.show();
		}
	}
}
