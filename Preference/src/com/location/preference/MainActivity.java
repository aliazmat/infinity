package com.location.preference;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		findViewById(R.id.loginbutton).setOnClickListener(
				new OnClickListener() {

					@Override
					public void onClick(View v) {
						EditText mobileText = (EditText) findViewById(R.id.mobile);
						String mobileNumber = mobileText.getText().toString();
						if (mobileNumber.isEmpty()) {
							Toast.makeText(MainActivity.this,
									"Enter Mobile Number", Toast.LENGTH_SHORT)
									.show();
						} else {
							new LoginTask(MainActivity.this, mobileNumber)
									.execute();
						}

					}
				});
		findViewById(R.id.startbutton).setOnClickListener(
				new OnClickListener() {

					@Override
					public void onClick(View v) {
						Utils.cancelAlarm(MainActivity.this);
						Utils.scheduleAlarm(MainActivity.this);

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
