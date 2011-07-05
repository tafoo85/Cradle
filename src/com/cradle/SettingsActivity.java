package com.cradle;

import android.app.Activity;
import android.os.Bundle;

public class SettingsActivity extends Activity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//this.getSharedPreferences("@strings/app_name", MODE_PRIVATE); 	
		this.setContentView(R.layout.settings);
	}
}
