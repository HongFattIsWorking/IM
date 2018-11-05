package example.com.login;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TripsHistory_fragment extends Fragment {


    ArrayList<Trips> trips = new ArrayList<>();
    ArrayList<Activity> activitylist = new ArrayList<>();
    Trips trip = new Trips();
    Activity activity = new Activity();


    @BindView(R.id.historyrecycleview)
    RecyclerView historyRecycleView;


    @Override
    public void onStop() {
        super.onStop();
        historyRecycleView.clearOnChildAttachStateChangeListeners();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        View view =  getLayoutInflater().inflate(R.layout.tripshistory_fragment,container,false);
        ButterKnife.bind(this,view);


        activity.setActivityName("Activity 2");
        activity.setAddress("ABC");
        activity.setId("ABC");
        activity.setLatitude("300");
        activity.setLongtitude("400");
        activitylist.add(activity);

        trip.setDate("02-11-2018");
        trip.setTripType("Half day");
        trip.setUderid("1");
        trip.setActivities(activitylist);
        trips.add(trip);

        initRecycleView();

        return view;
    }

    private void initRecycleView(){
        HistoryRecycleViewAdapter recycleViewAdapter = new HistoryRecycleViewAdapter(getContext(),trips);
        historyRecycleView.setAdapter(recycleViewAdapter);
        historyRecycleView.setLayoutManager(new LinearLayoutManager(getContext()));
    }
}
