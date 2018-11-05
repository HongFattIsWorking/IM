package example.com.login;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CurrentTrips_fragment extends Fragment {


    ArrayList<Trips> trips = new ArrayList<>();
    ArrayList<Activity> activitylist = new ArrayList<>();
    Trips trip = new Trips();
    Activity activity = new Activity();


    @BindView(R.id.ongoingrecycleview)
    RecyclerView ongoingRecycleView;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        View view =  getLayoutInflater().inflate(R.layout.currenttrips_fragment,container,false);
        ButterKnife.bind(this,view);






        activity.setActivityName("Activity 1");
        activity.setAddress("ABC");
        activity.setId("ABC");
        activity.setLatitude("100");
        activity.setLongtitude("100");
        activitylist.add(activity);

        trip.setDate("Today");
        trip.setTripType("Fullday");
        trip.setUderid("1");
        trip.setActivities(activitylist);
        trips.add(trip);


        initRecycleView();

        return view;



    }

    private void initRecycleView(){
        OngoingTripRecycleViewAdapter recycleViewAdapter = new OngoingTripRecycleViewAdapter(getContext(),trips);
        ongoingRecycleView.setAdapter(recycleViewAdapter);
        ongoingRecycleView.setLayoutManager(new LinearLayoutManager(getContext()));
    }
}
