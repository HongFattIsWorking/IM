package example.com.login;

import android.app.FragmentManager;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;


public class Index extends AppCompatActivity {
    ActionBar actionbar;
    TextView textview;
    LayoutParams layoutparams;

    public interface IOnBackPressed {
        boolean onBackPressed();
    }

    @Override
    public void onBackPressed() {
        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.indexfc);
        if (!(fragment instanceof IOnBackPressed) || !((IOnBackPressed) fragment).onBackPressed()) {
            getSupportActionBar().setDisplayShowHomeEnabled(false);
            getSupportActionBar().setDisplayHomeAsUpEnabled(false);
            super.onBackPressed();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            //Title bar back press triggers onBackPressed()
            getSupportActionBar().setDisplayShowHomeEnabled(false);
            getSupportActionBar().setDisplayHomeAsUpEnabled(false);
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected( item);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);
        BottomNavigationView bottomNav = findViewById(R.id.indexbn);
        bottomNav.setOnNavigationItemSelectedListener(navListener);
        getSupportFragmentManager().beginTransaction().replace(R.id.indexfc,new Index_Fragment()).commit();
        SharedPreferences preferences = getSharedPreferences("myPrefs",MODE_PRIVATE);

   }
    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;
                    switch (item.getItemId()){
                        case R.id.nav_index:
                            selectedFragment = new Index_Fragment();
                            break;
                        case R.id.nav_trips:
                            selectedFragment = new Trips_fragment();
                            break;
                        case R.id.nav_strips:
                            selectedFragment = new ShareTrips_Fragment();
                            break;
                        case R.id.nav_profile:
                            selectedFragment = new Profile_Fragment();
                            break;

                    }

                    getSupportFragmentManager().beginTransaction().replace(R.id.indexfc,
                            selectedFragment).commit();


                    return true;
                }
            };



}
