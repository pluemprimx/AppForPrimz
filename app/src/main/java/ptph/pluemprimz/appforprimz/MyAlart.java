package ptph.pluemprimz.appforprimz;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

/**
 * Created by CSITGIS on 12/11/2559.
 */

public class MyAlart {

    //explicit
    private Context context;
    private int anInt;
    private String titleString, massageString;

    public MyAlart(Context context, int anInt, String titleString, String massageString) {
        this.context = context;
        this.anInt = anInt;
        this.titleString = titleString;
        this.massageString = massageString;
    }

    public void myDirlog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setCancelable(false);
        builder.setIcon(anInt);
        builder.setTitle(titleString);
        builder.setMessage(massageString);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.show();
    }
} //main class
