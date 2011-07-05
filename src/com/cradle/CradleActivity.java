package com.cradle;

import android.app.Activity;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.Menu;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import java.lang.String;

public class CradleActivity extends Activity {
    private final String FIRST_RUN = "FIRST_RUN";
	/************Overridden Callbacks******************/
	
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedPreferences prefs = this.getSharedPreferences("Cradle", MODE_WORLD_READABLE | MODE_WORLD_WRITEABLE);
        
        if (prefs.getBoolean(FIRST_RUN, true)) {
        	
        }
        
        prefs.edit().putBoolean(FIRST_RUN, false);
        prefs.edit().commit();
        
        setContentView(R.layout.main);
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
    				startActivity(intent);
    		}
    		break;
    		case R.id.exit: {
    			this.finish();
    		}
    	default:
    		success = super.onOptionsItemSelected(item);
    	}
    	
    	return success;
    }
    /***************End Menu Callbacks*************/
    
    
}