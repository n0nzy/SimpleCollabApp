package co.umbc.cmsc.simplecollabapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class InputPageActivity extends AppCompatActivity implements View.OnClickListener {

    EditText edittextInputPage;
    Button buttonInputPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_input_page);


        buttonInputPage = (Button) findViewById(R.id.button_inputPage_toClick);
        buttonInputPage.setOnClickListener(this);

        edittextInputPage = (EditText) findViewById(R.id.editText_inputPage_toInput);

    }

    /**
     * Called when a view has been clicked.
     *
     * @param selectedView The view that was clicked.
     */
    @Override
    public void onClick(View selectedView) {

        switch (selectedView.getId()) {
            case R.id.button_inputPage_toClick:
                String enteredText = edittextInputPage.getText().toString();
                if (enteredText.matches("")) {
                    Toast.makeText(InputPageActivity.this, "You have not entered anything", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(InputPageActivity.this, "You entered "+edittextInputPage.getText(), Toast.LENGTH_SHORT).show();
                }
             break;
        } // end switch

    } // end onClick()

}