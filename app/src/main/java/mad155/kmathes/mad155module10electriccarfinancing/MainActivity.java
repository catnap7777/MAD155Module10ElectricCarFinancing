package mad155.kmathes.mad155module10electriccarfinancing;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    //.. App to show how data (presistant data) can be saved to an XML file using SharedPreferences
    int intYears;
    int intLoan;
    float decInterest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText years = (EditText) findViewById(R.id.txtYears);
        final EditText loan = (EditText) findViewById(R.id.txtLoan);
        final EditText interest = (EditText) findViewById(R.id.txtInterest);

        Button button = (Button) findViewById(R.id.btnPayment);

        //.. instantiate the SharedPrefences object
        final SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                intYears = Integer.parseInt(years.getText().toString());
                intLoan = Integer.parseInt(loan.getText().toString());
                decInterest = Float.parseFloat(interest.getText().toString());

                //.. write the data
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putInt("key1", intYears);
                editor.putInt("key2", intLoan);
                editor.putFloat("key3", decInterest);
                editor.commit();

                startActivity(new Intent(MainActivity.this, Payment.class));


            }
        });


    }
}
