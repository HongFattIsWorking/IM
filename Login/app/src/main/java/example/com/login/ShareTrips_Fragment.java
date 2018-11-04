package example.com.login;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class ShareTrips_Fragment extends Fragment {
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
}

