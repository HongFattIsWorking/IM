package example.com.login;

import android.app.AlertDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;

public class CustomDateSelectorPopUp extends AlertDialog.Builder {

    @BindView(R.id.addtxt)
    TextView positiveButton;

    @BindView(R.id.dateselector)
    TextView dateSelector;




    public CustomDateSelectorPopUp(Context context) {
        super(context);

    }


}
