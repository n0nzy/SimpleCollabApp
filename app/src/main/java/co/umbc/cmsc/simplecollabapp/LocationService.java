package co.umbc.cmsc.simplecollabapp;

import android.Manifest;
import android.app.Service;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class LocationService extends AppCompatActivity implements LocationListener,View.OnClickListener {
    LocationManager locationManager;
    EditText lat, longitude;
    float latitude_, longitude_;
    Button button;
    Handler myhandler = new Handler(Looper.getMainLooper());

    @Override
    protected void onResume() {
        super.onResume();
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            //ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.INTERNET}, PackageManager.PERMISSION_GRANTED);
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION}, 0);
            return;
        }
        locationManager.requestLocationUpdates(locationManager.NETWORK_PROVIDER, 0, 0, this);
        Log.d("Network", "enabled");

    }


    @Override
    protected void onPause() {
        super.onPause();
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION}, 0);
            return;
        }
        locationManager.removeUpdates(this);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_page);
        lat = (EditText) findViewById(R.id.editText);
        longitude = (EditText) findViewById(R.id.editText2);
        button = (Button) findViewById(R.id.button);
        locationManager = (LocationManager)getSystemService(LOCATION_SERVICE);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.button:
                lat.setText(String.valueOf(latitude_));
                longitude.setText(String.valueOf(longitude_));
                break;
        }
    }

   /* public class LocationWork implements OnClickListener{

       *//* @Override
        public void run() {
            lat.setText(String.valueOf(latitude_));
            longitude.setText(String.valueOf(longitude_));
        }*//*

        @Override
        public void onClick(View view) {
            switch(view.getId()){
                case R.id.button:
                    lat.setText(String.valueOf(latitude_));
                    longitude.setText(String.valueOf(longitude_));
                    break;
            }
        }
    }*/


    @Override
    public void onLocationChanged(Location location) {
        latitude_ = (float)location.getLatitude();
        longitude_= (float)location.getLongitude();

        onClick(lat);
    }



    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {

    }

    @Override
    public void onProviderEnabled(String s) {

    }

    @Override
    public void onProviderDisabled(String s) {

    }
}
