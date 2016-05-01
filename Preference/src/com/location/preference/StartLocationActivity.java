package com.location.preference;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;

public class StartLocationActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		findViewById(R.id.user).setVisibility(View.VISIBLE);
		((TextView) findViewById(R.id.user)).setText("Welcome "
				+ Utils.getUserName(this)
				+ ", Pls press the button to start tracker");
		findViewById(R.id.mobile).setVisibility(View.GONE);
		findViewById(R.id.loginbutton).setVisibility(View.GONE);
		findViewById(R.id.startbutton).setVisibility(View.VISIBLE);
		findViewById(R.id.startbutton).setOnClickListener(
				new OnClickListener() {

					@Override
					public void onClick(View v) {
						Utils.cancelAlarm(StartLocationActivity.this);
						Utils.scheduleAlarm(StartLocationActivity.this);
						Toast.makeText(StartLocationActivity.this,
								"Location tracker started", Toast.LENGTH_SHORT)
								.show();
					}
				});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

}
