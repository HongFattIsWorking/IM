package example.com.login;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;

public class PopUpDiagram extends AlertDialog.Builder {

    public PopUpDiagram(Context context) {
        super(context);
    }

    public void displayDialog(String title , String dialogMsg){
        setTitle(title);
        setMessage(dialogMsg);
        setPositiveButton("yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        show();

    }
}
