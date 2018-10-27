package example.com.login;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class PagerAdapter extends FragmentPagerAdapter {
    int numOfTaps;

    public PagerAdapter(FragmentManager fm, int NumberOfTabs) {
        super(fm);
        this.numOfTaps = NumberOfTabs;
    }

    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new login_fragment();
            case 1:
                return new register_fragment();
            default:
                return null;
        }
    }

    public int getCount() {
        return this.numOfTaps;
    }
}
