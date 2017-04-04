package co.umbc.cmsc.simplecollabapp;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SensorPageActivity extends AppCompatActivity implements View.OnClickListener, SensorEventListener {

    EditText acc_x, acc_y, acc_z;
    Float accx_, accy_, accz_;
    Button mybutton;
    Sensor accelerometer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor_page);

        mybutton = (Button) findViewById(R.id.button);
        mybutton.setOnClickListener(this);

        acc_x = (EditText) findViewById(R.id.acc_x);
        acc_y = (EditText) findViewById(R.id.acc_y);
        acc_z = (EditText) findViewById(R.id.acc_z);

        SensorManager sensormanager_ = (SensorManager) getSystemService(SENSOR_SERVICE);
        accelerometer = sensormanager_.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sensormanager_.registerListener(this, accelerometer,SensorManager.SENSOR_DELAY_FASTEST);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button:
                acc_x.setText(accx_.toString());
                acc_y.setText(accy_.toString());
                acc_z.setText(accz_.toString());
                break;
        }
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        accx_ = event.values[0];
        accy_ = event.values[1];
        accz_ = event.values[2];
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}
