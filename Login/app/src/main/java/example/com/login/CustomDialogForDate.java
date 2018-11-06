package example.com.login;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.OnClick;

public class CustomDialogForDate extends Dialog {



    public Dialog d;

    @BindView(R.id.canceltxt)
    TextView canceltxt;

    @BindView(R.id.dateselector)
    TextView dateSelector;

    @BindView(R.id.addtxt)
    TextView positiveButton;

    public CustomDialogForDate(@NonNull Context context) {
        super(context);
    }

    @OnClick(R.id.addtxt)
    void positiveAction(){
        if(positiveButton.getText() == "Add"){

        }
        if(positiveButton.getText() == "Change Date"){

        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.addingsharedpopup);
    }

    public void setTextForPositiveButton(String text){
        positiveButton.setText(text);
    }
}