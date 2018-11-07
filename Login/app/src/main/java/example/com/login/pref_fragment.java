package example.com.login;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnTouch;

public class pref_fragment extends Fragment {
    DatePickerDialog datePickerDialog;

    ActionBar actionbar;
    TextView textview;
    RelativeLayout.LayoutParams layoutparams;

    private ArrayList<String> intensity = new ArrayList<>();
    private ArrayList<String> numberOfPax = new ArrayList<>();

    @BindView(R.id.recycleview1)
    RecyclerView recyclerView;

    @BindView(R.id.recycleview2)
    RecyclerView recyclerView2;

    @BindView(R.id.dropdown1)
    TextView textDropDown1;

    @BindView(R.id.dropdown2)
    TextView textDropDown2;

    @BindView(R.id.dropdown3)
    TextView textDropDown3;

    @BindView(R.id.dropdown4)
    EditText budget;

    @BindView(R.id.btnGenTrip)
    TextView generateTrips;

    @OnClick(R.id.btnGenTrip)
    void generateTrips(){

    }

    @OnClick(R.id.dropdown1)
    void showDropdown(){
        if(recyclerView.getVisibility() == View.GONE){
            recyclerView.setVisibility(View.VISIBLE);
        }
        else{
            recyclerView.setVisibility(View.GONE);
        }
        recyclerView2.setVisibility(View.GONE);

    }
    @OnClick(R.id.dropdown2)
    void showDropdown2(){
        if(recyclerView2.getVisibility() == View.GONE){
            recyclerView2.setVisibility(View.VISIBLE);
        }
        else{
            recyclerView2.setVisibility(View.GONE);
        }

    }

    @OnTouch(R.id.perfrenceroot)
    boolean exampleTouched(View v, MotionEvent ev) {
        //if(!(v instanceof RecyclerView)){
            recyclerView.setVisibility(View.GONE);
            recyclerView2.setVisibility(View.GONE);
        //}
        return true;
    }

    @OnClick(R.id.dropdown3)
    void selectDate(){
        Calendar calendar = Calendar.getInstance();
                final int year = calendar.get(Calendar.YEAR);
                final int month = calendar.get(Calendar.MONTH);
                final int day = calendar.get(Calendar.DAY_OF_MONTH);
                datePickerDialog = new DatePickerDialog(getContext(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                        String dateresult = i2+"-"+(i1+1)+"-"+i;
                        textDropDown3.setText(dateresult.toString());
                        Log.d("PIGU",i2+ "-" +(i1+1)+ "-" +i);
                    }
                },year,month,day);
                datePickerDialog.show();

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = getLayoutInflater().inflate(R.layout.preference_fragment, container, false);
        ButterKnife.bind(this,view);
        initActionBar();
        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayShowHomeEnabled(true);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        initIntensityData();
        initRecycleView();
        initNumberOfPaxData();
        initRecycleView2();

        return view;
    }

    private void initIntensityData(){
        intensity.add("Water event1");
        intensity.add("Water event2");
        intensity.add("Water event3");
        intensity.add("Water event4");
    }

    private void initNumberOfPaxData(){
        numberOfPax.add("1 - 2");
        numberOfPax.add("3 - 4");
        numberOfPax.add("5 - 6");
        numberOfPax.add(">6");
    }

    private void initRecycleView(){
        RecycleViewAdapter recycleViewAdapter = new RecycleViewAdapter(getContext(),intensity,textDropDown1,recyclerView);
        recyclerView.setAdapter(recycleViewAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    private void initRecycleView2(){
        RecycleViewAdapter recycleViewAdapter = new RecycleViewAdapter(getContext(),numberOfPax,textDropDown2,recyclerView2 );
        recyclerView2.setAdapter(recycleViewAdapter);
        recyclerView2.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    public void initActionBar()
    {
        actionbar = ((AppCompatActivity)getActivity()).getSupportActionBar();
        textview = new TextView(getContext());
        layoutparams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        textview.setLayoutParams(layoutparams);
        textview.setText("Preference");
        textview.setTextColor(Color.BLACK);
        textview.setGravity(Gravity.CENTER);
        textview.setTextSize(20);
        actionbar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        actionbar.setCustomView(textview);
    }
}
