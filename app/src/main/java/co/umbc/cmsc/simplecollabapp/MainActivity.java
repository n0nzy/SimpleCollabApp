package co.umbc.cmsc.simplecollabapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button button_input, button_sensors, button_location, button_storage;

    /**
     * Called when a view has been clicked.
     *
     * @param selectedView The view that was clicked.
     */
    @Override
    public void onClick(View selectedView) {
        switch (selectedView.getId()) {
            case R.id.button_main_toast:
                Intent InputIntent = new Intent(this, InputPageActivity.class);
                startActivity(InputIntent);
                break;
	    case R.id.button_main_sensors:
                Intent SensorIntent = new Intent(this, SensorPageActivity.class);
                startActivity(SensorIntent);
                break;
            case R.id.button_main_location:
                Intent LocationIntent = new Intent(this,LocationService.class);
                startActivity(LocationIntent);
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button_input = (Button) findViewById(R.id.button_main_toast);
        button_input.setOnClickListener(this);

        button_sensors = (Button) findViewById(R.id.button_main_sensors);
        button_sensors.setOnClickListener(this);

        button_location = (Button) findViewById(R.id.button_main_location);
        button_location.setOnClickListener(this);

        button_storage = (Button) findViewById(R.id.button_main_storage);
        button_storage.setOnClickListener(this);

    }

}