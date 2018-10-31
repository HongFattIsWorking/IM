package example.com.login;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomList extends ArrayAdapter<String> {

    private final Activity context;
    private final String[] maintitle;
    private final String[] subtitle;
    private final String[] budget;
    private final String[] tripType;


    public CustomList(Activity context, String[] maintitle, String[] subtitle,String[] budget,String[] tripType) {
        super(context, R.layout.customlist, maintitle);
        // TODO Auto-generated constructor stub

        this.context=context;
        this.maintitle=maintitle;
        this.subtitle=subtitle;
        this.tripType = tripType;
        this.budget = budget;

    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.customlist, null,true);
        TextView numberOfPaxResult = (TextView) rowView.findViewById(R.id.numOfPaxResult);
        TextView activityIntensityResult = (TextView) rowView.findViewById(R.id.activityIntensityResult);
        TextView budgetResult = (TextView) rowView.findViewById(R.id.budgetResult);
        TextView tripTypeResult = (TextView) rowView.findViewById(R.id.tripTypeResult);



        // ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);
        //TextView subtitleText = (TextView) rowView.findViewById(R.id.subtitle);

        numberOfPaxResult.setText(maintitle[position]);
        activityIntensityResult.setText(subtitle[position]);
        budgetResult.setText(budget[position]);
        tripTypeResult.setText(tripType[position]);
        //imageView.setImageResource(imgid[position]);


        return rowView;

    };
}

