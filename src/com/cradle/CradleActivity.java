package com.cradle;

import android.app.Activity;
import android.app.AlertDialog;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import java.lang.String;

public class CradleActivity extends Activity implements OnClickListener {
    private final String FIRST_RUN = "FIRST_RUN";
	/************Overridden Callbacks******************/
	
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedPreferences prefs = this.getSharedPreferences("Cradle", MODE_WORLD_READABLE | MODE_WORLD_WRITEABLE);
        int layout = prefs.getBoolean(FIRST_RUN, true) ? R.layout.firstrun : R.layout.main;
        setContentView(layout);
        
        if (prefs.getBoolean(FIRST_RUN, true)) {  //setup buttons for first run and flag first run off
        	final Button continueButton = (Button)this.findViewById(R.id.continue_button);
        	continueButton.setOnClickListener(this);
        	prefs.edit().putBoolean(FIRST_RUN, false);
        }
    }
    /**Called when the activity resumes after being paused.**/
    @Override
    protected void onResume() {
    	super.onResume();
    }
    /**Called when the activity has been stopped, but before it has been killed**/
    @Override
    protected void onStop() {
    	super.onStop();
    }
    /**Called when the class is killed**/
    @Override 
    protected void onDestroy() {
    	super.onDestroy();
    }
    /**Called when the activity is paused**/
    @Override 
    protected void onPause() {
    	super.onPause();
    }
    
    @Override
    protected void onRestart() {
    	setContentView(R.layout.main);
    	super.onRestart();
    }
    
    /*********End Extended Callbacks***************/
    
    /*****************Menu Callbacks***************/
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
    	MenuInflater inflater = this.getMenuInflater();
    	inflater.inflate(R.menu.menu, menu);    	
    	return true;
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
    	boolean success = true;
    	
    	switch(item.getItemId()) {
    		case R.id.settings: {
    				Intent intent = new Intent(CradleActivity.this, SettingsActivity.class);
    				this.startActivity(intent);
    		}
    		break;
    		case R.id.exit: {
    			this.finish();
    		}
    		case R.id.help: {
    			Intent intent = new Intent(CradleActivity.this, SettingsActivity.class);
    			this.startActivity(intent);
    		}
    	default:
    		success = super.onOptionsItemSelected(item);
    	}
    	
    	return success;
    }
    /***************End Menu Callbacks*************/
	public void onClick(View v) {
		this.startActivity(new Intent(CradleActivity.this, SettingsActivity.class));
	}
}