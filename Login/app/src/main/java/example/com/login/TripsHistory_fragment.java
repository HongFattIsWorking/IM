package example.com.login;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TripsHistory_fragment extends Fragment implements OnTaskCompleted {
    // Set host address of the Web Server
    public static final String HOST = "pigu.leongwenqing.com";
    // Set virtual directory of the host website
    public static final String DIR = "PIGU";
    //public static JSONObject jsonObject;
    ArrayList<TripHistory> tripshistory = new ArrayList<>();
    //ArrayList<Activity> activitylist = new ArrayList<>();
    //Activity activity = new Activity();
    JSONArray jsonObject;

    TripHistory th = new TripHistory();

    @BindView(R.id.historyrecycleview)
    RecyclerView historyRecycleView;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        View view =  getLayoutInflater().inflate(R.layout.tripshistory_fragment,container,false);
        ButterKnife.bind(this,view);


        // call AsynTask to perform network operation on separate threadHttpAsyncTask task = new HttpAsyncTask(this);
        HttpAsyncTask_Get task = new HttpAsyncTask_Get(this);
        task.execute("https://" + HOST + "/"  + "v1/itinerary/triphistory");

        initRecycleView();

        return view;
    }


    public void retrieveFromJSON(String message) {
        try {
            jsonObject = new JSONArray(message);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void initRecycleView(){
        HistoryRecycleViewAdapter recycleViewAdapter = new HistoryRecycleViewAdapter(getContext(),tripshistory);
        historyRecycleView.setAdapter(recycleViewAdapter);
        historyRecycleView.setLayoutManager(new LinearLayoutManager(getContext()));
    }


    @Override
    public void onTaskCompleted(String response) {
        retrieveFromJSON(response);
        try {
            for(int i=0;i<jsonObject.length();i++)
            {
                TripHistory st  = new TripHistory();
                JSONObject jsonObject1 = null;
                jsonObject1 = jsonObject.getJSONObject(i);
                st.setId(jsonObject1.optString("id"));
                st.setActivity(jsonObject1.optString("activity"));
                st.setPreference(jsonObject1.optString("preference"));
                st.setActivity_Order(jsonObject1.optString("activity_order"));
                st.setUserId(jsonObject1.optString("userid"));
                st.setBudget(jsonObject1.optString("budget"));
                st.setMeal_pref(jsonObject1.optString("meal_preference"));
                st.setMeal_comments(jsonObject1.optString("meal_comments"));
                st.setType(jsonObject1.optString("type"));
                st.setDate(jsonObject1.optString("date"));

                tripshistory.add(st);
            }

            initRecycleView();
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}
