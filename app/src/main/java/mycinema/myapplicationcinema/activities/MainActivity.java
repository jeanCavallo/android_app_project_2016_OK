package mycinema.myapplicationcinema.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import mycinema.myapplicationcinema.R;

public class MainActivity extends Activity implements View.OnClickListener {

    private static final String TAG = "MyActivity";
    Button monBouton1 = null;
    Button monBouton2 = null;
    Button monBouton3 = null;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(!isOnline()){
            Context context = getApplicationContext();
            CharSequence text = "Internet is disable, you do not have the updated news !";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }

        monBouton1 = (Button) findViewById(R.id.seancesButton);
        monBouton1.setOnClickListener(this);
        monBouton2 = (Button) findViewById(R.id.soonButton);
        monBouton2.setOnClickListener(this);
        monBouton3 = (Button) findViewById(R.id.evenementsButton);
        monBouton3.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
// TODO Auto-generated method stub
        if (v == monBouton1) {
            Intent intent = new Intent(MainActivity.this,SeancesActivity.class);
            startActivity(intent);
        }
        if (v == monBouton2) {
            Intent intent = new Intent(MainActivity.this,SoonActivity.class);
            startActivity(intent);
        }
        if (v == monBouton3) {
            Intent intent = new Intent(MainActivity.this,EventsActivity.class);
            startActivity(intent);
        }
    }

    // METHOD TO TEST IF THERE IS A CONNECTION TO INTERNET AVAILABLE
    public boolean isOnline() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        return netInfo != null && netInfo.isConnectedOrConnecting();
    }
}
