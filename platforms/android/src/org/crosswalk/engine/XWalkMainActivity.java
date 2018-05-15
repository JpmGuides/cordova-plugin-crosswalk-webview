package org.crosswalk.engine;

import android.os.Bundle;

import org.apache.cordova.CordovaActivity;

/**
 * Created by lundfall on 26/07/2017.
 */

public class XWalkMainActivity extends CordovaActivity {
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        // enable Cordova apps to be started in the background
        Bundle extras = getIntent().getExtras();
        if (extras != null && extras.getBoolean("cdvStartInBackground", false)) {
            moveTaskToBack(true);
        }
        if(!XWalkBridgeEngine.shouldMakeXwalkWebView(getApplicationContext())){
            String modernChromeEntryString = preferences.getString("modernChromeEntry", null);
            if(modernChromeEntryString != null){
                launchUrl = "file:///android_asset/www/" + modernChromeEntryString;
            }
        }

        loadUrl(launchUrl);
    }
}
