package example.com.login;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Trips_fragment extends Fragment {
    TabLayout tabLayout;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){

        View view =  getLayoutInflater().inflate(R.layout.trips_fragment,container,false);
        getActivity().setTitle("Your Trips");
        tabLayout = (TabLayout) view.findViewById(R.id.tlTrips);
        tabLayout.addTab(tabLayout.newTab().setText("Upcoming Trips"));
        tabLayout.addTab(tabLayout.newTab().setText("Trips History"));

        final ViewPager viewPager = (ViewPager) view.findViewById(R.id.vpTrips);
        viewPager.setAdapter(new TripPagerAdapter(getChildFragmentManager(), tabLayout.getTabCount()));
        viewPager.setOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        viewPager.setOffscreenPageLimit(2);
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
}
