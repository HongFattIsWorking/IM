package example.com.login;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

public class Index extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);

        BottomNavigationView bottomNav = findViewById(R.id.indexbn);
        bottomNav.setOnNavigationItemSelectedListener(navListener);

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
