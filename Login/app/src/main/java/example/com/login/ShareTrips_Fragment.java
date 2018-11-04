package example.com.login;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONObject;
import org.json.JSONStringer;

import java.util.ArrayList;
import java.util.logging.SocketHandler;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class ShareTrips_Fragment extends Fragment implements OnTaskCompleted {
    String id;
    String user;
    String userid;
    String preference;
    String budget;
    String meal_preference;
    String meal_comments;
    String type ;
    String date;

    ArrayList<ShareTrips> sharetripslist = new ArrayList<>();


    // Set host address of the Web Server
    public static final String HOST = "pigu.leongwenqing.com";
    // Set virtual directory of the host website
    public static final String DIR = "PIGU";
    public static JSONObject jsonObject;

    @BindView(R.id.btnFilter)
    Button btnFilter;

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
        ListView list;
        String[] maintitle = {
                "Title 1", "Title 2",
                "Title 3", "Title 4",
                "Title 5",
        };

        String[] subtitle = {
                "Sub Title 1", "Sub Title 2",
                "Sub Title 3", "Sub Title 4",
                "Sub Title 5",
        };
        String[] budget = {
                "10", "20",
                "30", "40",
                "50",
        };
        String[] tripType = {
                "Half day", "Full day",
                "Full day", "Full day",
                "Full day",
        };
        CustomList adapter = new CustomList(getActivity(), maintitle, subtitle, budget, tripType);
        list = (ListView) view.findViewById(R.id.list);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // TODO Auto-generated method stub
                if (position == 0) {
                    //code specific to first list item
                    Toast.makeText(getContext(), "Place Your First Option Code", Toast.LENGTH_SHORT).show();
                } else if (position == 1) {
                    //code specific to 2nd list item
                    Toast.makeText(getContext(), "Place Your Second Option Code", Toast.LENGTH_SHORT).show();
                } else if (position == 2) {

                    Toast.makeText(getContext(), "Place Your Third Option Code", Toast.LENGTH_SHORT).show();
                } else if (position == 3) {

                    Toast.makeText(getContext(), "Place Your Forth Option Code", Toast.LENGTH_SHORT).show();
                } else if (position == 4) {

                    Toast.makeText(getContext(), "Place Your Fifth Option Code", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return view;
    }
    public String convertToJSON() {
        JSONStringer jsonText = new JSONStringer();
        try {
            jsonText.object();
            jsonText.key("id");
            jsonText.value(id);
            jsonText.key("user");
            jsonText.value(userid);
            jsonText.key("userid");
            jsonText.value(userid);
            jsonText.key("preference");
            jsonText.value(preference);
            jsonText.key("budget");
            jsonText.value(budget);
            jsonText.key("meal_preference");
            jsonText.value(meal_preference);
            jsonText.key("meal_comments");
            jsonText.value(meal_comments);
            jsonText.key("type");
            jsonText.value(type);
            jsonText.key("date");
            jsonText.value(date);
            jsonText.endObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonText.toString();
    }
    @Override
    public void onTaskCompleted(String response) {
        Log.d(DIR,response);


    }

}

