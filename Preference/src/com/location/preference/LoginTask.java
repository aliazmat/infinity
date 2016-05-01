package com.location.preference;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

public class LoginTask extends AsyncTask<Void, Void, Void> {

	private final Context context;
	private final String mobileNumber;
	private ProgressDialog dialog;
	private String responseString;

	public LoginTask(Context pContext, String mobileNumber) {
		context = pContext;
		this.mobileNumber = mobileNumber;
	}

	@Override
	protected void onPreExecute() {

		super.onPreExecute();

		dialog = new ProgressDialog(context);
		dialog.setMessage("Please wait...");
		dialog.setCancelable(false);
		dialog.show();
	}

	@Override
	protected Void doInBackground(Void... params) {
		List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
		nameValuePairs.add(new BasicNameValuePair("mobile", mobileNumber));
		responseString = Utils.sendRequestLegacy(Constants.LOGIN_URL,
				nameValuePairs, context);
		return null;
	}

	@Override
	protected void onPostExecute(Void result) {

		super.onPostExecute(result);

		try {
			dialog.dismiss();
			JSONObject json_data = new JSONObject(responseString);

			String resultValue = (String) json_data.get("re");
			if (resultValue.equals("0")) {
				Toast.makeText(context, "Wrong Mobile Number ",
						Toast.LENGTH_SHORT).show();
			} else {
				new GetUserDetailTask(context, mobileNumber).execute();
			}

		} catch (Exception e) {
			CustomLogger.getInsatance(context).putLog(
					"::Exception::" + e.getMessage());
		}
	}

}
