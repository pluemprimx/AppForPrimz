package ptph.pluemprimz.appforprimz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PrimzKKU extends AppCompatActivity {


    //explicit
    private Button signInButton, singUpButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_primz_kku);

        //Bind widget
        signInButton = (Button) findViewById(R.id.button6);
        singUpButton = (Button) findViewById(R.id.button5);

        //SIGN Up controller
        singUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PrimzKKU.this, SingUpActivity.class));
            }
        });



    } //main method

} /*main class นี่คือ คลาสหลัก*/
