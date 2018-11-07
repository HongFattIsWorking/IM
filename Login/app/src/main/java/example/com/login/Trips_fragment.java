package example.com.login;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class Trips_fragment extends Fragment {
    TabLayout tabLayout;
    Bundle arg;
    ActionBar actionbar;
    TextView textview;
    RelativeLayout.LayoutParams layoutparams;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){

        View view =  getLayoutInflater().inflate(R.layout.trips_fragment,container,false);
        String strtext = "";
        tabLayout = (TabLayout) view.findViewById(R.id.tlTrips);
        tabLayout.addTab(tabLayout.newTab().setText("Upcoming Trips"));
        tabLayout.addTab(tabLayout.newTab().setText("Trips History"));
        final ViewPager viewPager = (ViewPager) view.findViewById(R.id.vpTrips);
        arg = getArguments();
        initActionBar();
        viewPager.setAdapter(new TripPagerAdapter(getChildFragmentManager(), tabLayout.getTabCount()));
        viewPager.setOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        viewPager.setOffscreenPageLimit(2);
        if(arg != null && arg.containsKey("flag")){

            Log.d("PIGU",getArguments().getString("flag"));

            viewPager.setCurrentItem(1);
        }
        else{
            viewPager.setCurrentItem(0);
        }
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener(){
            public void onTabSelected(TabLayout.Tab tab) {

                    viewPager.setCurrentItem(tab.getPosition());

            }

            public void onTabUnselected(TabLayout.Tab tab) {
            }

            public void onTabReselected(TabLayout.Tab tab) {
            }
        });

        return view;
    }
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        //outState.putInt("curChoice", tab);
    }

    public void initActionBar()
    {
        actionbar = ((AppCompatActivity)getActivity()).getSupportActionBar();
        textview = new TextView(getContext());
        layoutparams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        actionbar.setDisplayShowHomeEnabled(false);
        actionbar.setDisplayHomeAsUpEnabled(false);
        textview.setLayoutParams(layoutparams);
        textview.setText("Your Trips");
        textview.setTextColor(Color.BLACK);
        textview.setGravity(Gravity.CENTER);
        textview.setTextSize(20);
        actionbar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        actionbar.setCustomView(textview);
    }


}
