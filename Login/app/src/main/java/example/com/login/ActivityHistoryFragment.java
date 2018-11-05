package example.com.login;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ActivityHistoryFragment extends Fragment implements Index.IOnBackPressed {





    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        View view =  getLayoutInflater().inflate(R.layout.activity_history_layout,container,false);
        return view;
    }


    @Override
    public boolean onBackPressed() {
            AppCompatActivity sctivity = (AppCompatActivity) getContext();
            Trips_fragment myFrag = new Trips_fragment();
            Bundle args = new Bundle();
            args.putString("flag","1" );
            myFrag.setArguments(args);
            sctivity.getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.indexfc, myFrag)
                    .addToBackStack(null).commit();
            return true;
    }
}
