package example.com.login;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.DatePicker;
import android.widget.TextView;

import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CustomDialogForDate extends Dialog {


    DatePickerDialog datePickerDialog;
    AlertDialog d = new AlertDialog.Builder(getContext()).create();

    @OnClick(R.id.canceltxt)
    void dismissDialog(){
        d.dismiss();
    }

    @BindView(R.id.dateselector)
    TextView dateSelector;

    @BindView(R.id.addtxt)
    TextView positiveButton;


    public CustomDialogForDate(@NonNull Context context) {
        super(context);


    }

    public void show(){
        View view = View.inflate(getContext(), R.layout.addingsharedpopup, null);
        ButterKnife.bind(this, view);
        d.setView(view);
        d.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        d.show();
        d.getWindow().setLayout(900, 600);
    }

    @OnClick(R.id.addtxt)
    void positiveAction(){
        if(positiveButton.getText() == "Add"){

        }
        if(positiveButton.getText() == "Change Date"){

        }
    }

    @OnClick(R.id.dateselector)
    void selectDate(){
        Calendar calendar = Calendar.getInstance();
        final int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        final int day = calendar.get(Calendar.DAY_OF_MONTH);
        datePickerDialog = new DatePickerDialog(getContext(), new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                String dateresult = i2+"-"+(i1+1)+"-"+i;
                dateSelector.setText(dateresult.toString());

                Log.d("PIGU",i2+ "-" +(i1+1)+ "-" +i);


            }
        },year,month,day);
        datePickerDialog.show();
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