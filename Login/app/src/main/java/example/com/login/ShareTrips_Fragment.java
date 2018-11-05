package example.com.login;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
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
                st.setMeal_pref(jsonObject1.optString("meal_preference"));
                st.setMeal_comment(jsonObject1.optString("meal_comments"));
                st.setType(jsonObject1.optString("type"));
                st.setDate(jsonObject1.optString("date"));
                sharetripslist.add(st);
            }

            initRecycleView();
        } catch (JSONException e) {
                e.printStackTrace();
            }

//            for(ShareTrips x : sharetripslist){
//                Log.d(DIR,x.getBudget());
//            }
        }

    private void initRecycleView(){
        SharedTripRecycleAdapter recycleViewAdapter = new SharedTripRecycleAdapter(getContext(),sharetripslist);
        sharedTripRecycleView.setAdapter(recycleViewAdapter);
        sharedTripRecycleView.setLayoutManager(new LinearLayoutManager(getContext()));
    }
}

