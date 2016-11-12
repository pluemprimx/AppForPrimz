package ptph.pluemprimz.appforprimz;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class SingUpActivity extends AppCompatActivity {

    //ตัวแปล
    private EditText nameEditText, phoneEditText, userEditText, passwordEditext;
    private ImageView imageView;
    private Button button;
    private String nameString,phoneString,userString, passwordString;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sing_up);


        //bind widget
        nameEditText = (EditText) findViewById(R.id.editText);
        phoneEditText = (EditText) findViewById(R.id.editText2);
        userEditText = (EditText) findViewById(R.id.editText3);
        passwordEditext = (EditText) findViewById(R.id.editText4);
        imageView = (ImageView) findViewById(R.id.imageView2);
        button = (Button) findViewById(R.id.button);

        //sing up con
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //get value from edittext
                nameString = nameEditText.getText().toString().trim();
                phoneString = phoneEditText.getText().toString().trim();
                userString = userEditText.getText().toString().trim();
                passwordString = passwordEditext.getText().toString().trim();

                //Check space
                if (nameString.equals("") || phoneString.equals("") || userString.equals("") || passwordString.equals("")) {
                    //have space
                    Log.d("12novV1", "Have space");
                    MyAlart myAlart = new MyAlart(SingUpActivity.this, R.drawable.bird48, "มัช่องว่าง", "กรุณากรอกให้ครบค่ะ อิดอก");
                    myAlart.myDirlog();


                }



            } //on click
        });


    } //main method


}   //main class
