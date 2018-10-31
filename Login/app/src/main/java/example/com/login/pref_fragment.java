package example.com.login;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Calendar;

public class pref_fragment extends Fragment {
    private EditText date;
    DatePickerDialog datePickerDialog;
    TextView tvResult;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = getLayoutInflater().inflate(R.layout.preference_fragment, container, false);
        date = view.findViewById(R.id.etDate);
        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar calendar = Calendar.getInstance();
                final int year = calendar.get(Calendar.YEAR);
                final int month = calendar.get(Calendar.MONTH);
                final int day = calendar.get(Calendar.DAY_OF_MONTH);
                datePickerDialog = new DatePickerDialog(getContext(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                        String dateresult = i2+"-"+(i1+1)+"-"+i;
                        date.setText(dateresult.toString());

                        Log.d("PIGU",i2+ "-" +(i1+1)+ "-" +i);


                    }


                },year,month,day);
                datePickerDialog.show();


            }
        });

        Spinner ddlpax = view.findViewById(R.id.spinner1);
        Spinner ddlActivityIntensity = view.findViewById(R.id.spinner2);
        String[] numberOfPax = new String[]{"1-2", "3-4", "4-5"," > 6"};
        String[] activityIntensityList = new String[]{"1","2","3","4"};
        ArrayAdapter<String> numberOfPaxAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_dropdown_item, numberOfPax);
        ArrayAdapter<String> activityIntensityAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_dropdown_item, activityIntensityList);
        ddlpax.setAdapter(numberOfPaxAdapter);
        ddlActivityIntensity.setAdapter(activityIntensityAdapter);
        return view;
    }
}
