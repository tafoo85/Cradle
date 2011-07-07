package com.cradle;

import android.app.Activity;
import android.os.Bundle;

public class SettingsActivity extends Activity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.getSharedPreferences("Cradle", MODE_WORLD_WRITEABLE | MODE_WORLD_READABLE); 	
		this.setContentView(R.layout.settings);
	}
}
