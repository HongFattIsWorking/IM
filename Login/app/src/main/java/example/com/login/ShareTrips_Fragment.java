package example.com.login;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

import java.util.ArrayList;
import java.util.logging.SocketHandler;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class ShareTrips_Fragment extends Fragment implements OnTaskCompleted {

    String msgType;
    JSONArray jsonObject;
    ArrayList<ShareTrips> sharetripslist = new ArrayList<>();
    ActionBar actionbar;
    TextView textview;
    RelativeLayout.LayoutParams layoutparams;


    // Set host address of the Web Server
    public static final String HOST = "pigu.leongwenqing.com";
    // Set virtual directory of the host website
    public static final String DIR = "PIGU";
    //public static JSONObject jsonObject;

    @BindView(R.id.btnFilter)
    Button btnFilter;

    @BindView(R.id.sharedtriprecycle)
    RecyclerView sharedTripRecycleView;

    @OnClick(R.id.btnFilter)
    public void filter(){
        Filter_fragment filterFrag = new Filter_fragment();
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.indexfc, filterFrag);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();

    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = getLayoutInflater().inflate(R.layout.sharetrips_fragment, container, false);
        ButterKnife.bind(this,view);
        // call AsynTask to perform network operation on separate threadHttpAsyncTask task = new HttpAsyncTask(this);
        HttpAsyncTask_Get task = new HttpAsyncTask_Get(ShareTrips_Fragment.this);
        task.execute("https://" + HOST + "/"  + "v1/itinerary/sharetrip");
        initActionBar();


        return view;
    }

    public void retrieveFromJSON(String message) {
        try {
             jsonObject = new JSONArray(message);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public void onTaskCompleted(String response) {
        retrieveFromJSON(response);
        Log.d("teting1234",jsonObject.toString());
        String tripType = "Full Day";
        try {
            for(int i=0;i<jsonObject.length();i++)
            {
                ShareTrips st = new ShareTrips();
                JSONObject jsonObject1 = null;
                jsonObject1 = jsonObject.getJSONObject(i);
                st.setId(jsonObject1.optString("id"));
                st.setUser(jsonObject1.optString("user"));
                st.setPreference(jsonObject1.optString("preference"));
                st.setUserid(jsonObject1.optString("userid"));
                st.setBudget(jsonObject1.optString("budget"));
                st.setIntensity(jsonObject1.optString("3"));
                st.setType(jsonObject1.optString("type"));

                if(jsonObject1.optString("fullday").equals("0"))
                    tripType = "Half Day";

                st.setTripType(tripType);
                st.setPax(jsonObject1.optString("pax"));
                st.setDate(jsonObject1.optString("date"));
                sharetripslist.add(st);
            }
            for(ShareTrips x : sharetripslist)
            {
                Log.d("PIGU",x.getTripType());
            }
            initRecycleView();
        } catch (JSONException e) {
                e.printStackTrace();
            }

        }

    private void initRecycleView(){
        SharedTripRecycleAdapter recycleViewAdapter = new SharedTripRecycleAdapter(getContext(),sharetripslist);
        sharedTripRecycleView.setAdapter(recycleViewAdapter);
        sharedTripRecycleView.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    public void initActionBar()
    {
        actionbar = ((AppCompatActivity)getActivity()).getSupportActionBar();
        textview = new TextView(getContext());
        layoutparams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        actionbar.setDisplayShowHomeEnabled(false);
        actionbar.setDisplayHomeAsUpEnabled(false);
        textview.setLayoutParams(layoutparams);
        textview.setText("Shared Trips");
        textview.setTextColor(Color.BLACK);
        textview.setGravity(Gravity.CENTER);
        textview.setTextSize(20);
        actionbar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        actionbar.setCustomView(textview);
    }
}

