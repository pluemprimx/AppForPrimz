package ptph.pluemprimz.appforprimz;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.net.Uri;
import android.provider.MediaStore;
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
    private String nameString,phoneString,userString, passwordString,imagePathSring,imageNameString;
    private Uri uri;
    private boolean aBoolean = true;



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

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("image/*");
                startActivityForResult(intent.createChooser(intent, "โปรดเลือกรูปภาพ"), 0);
            }
        }

    } //main method

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if ((requestCode == 0) && (resultCode == RESULT_OK)) {
            Log.d("12novV1", "Result OK");
            aBoolean = false;

            //show img
            uri = data.getData();
            try {
                Bitmap bitmap = BitmapFactory.decodeStream(getContentResolver().openInputStream(uri));
                imageView.setImageBitmap(bitmap);

            } catch (Exception e) {
                e.printStackTrace();
            }

            //Path pic
            imagePathSring = myFindpath(uri);
            Log.d("12novV1", "imagePath ==> " + imagePathSring);

            //name
            imageNameString =  imagePathSring(uri);
            Log.d("12novV1", "imageName ==> " + imageNameString);

            }

    }

    private String myFindpath(Uri uri) {
        String result = null;
        String[] strings = MediaStore.Images.Media;
        Cursor cursor = getContentResolver().query(uri, strings, null, null, null);

        if (cursor != null) {
            cursor.moveToFirst();
            int index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);.
            result = cursor.getString(index);
        }else {
            result = uri.getPath();
        }


        return result;
    }
}   //main class
