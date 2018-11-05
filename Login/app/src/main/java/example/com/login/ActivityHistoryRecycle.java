package example.com.login;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ActivityHistoryRecycle extends RecyclerView.Adapter<ActivityHistoryRecycle.ViewHolder>{






    ArrayList<Activity> tripActivityData;
    Context context;


    public ActivityHistoryRecycle(Context context, ArrayList<Activity> tripActivityData){
        this.tripActivityData = tripActivityData;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_inside_trip_layout, parent, false);
        ActivityHistoryRecycle.ViewHolder holder = new ActivityHistoryRecycle.ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.activityName.setText(tripActivityData.get(position).activityName);
        holder.addressText.setText(tripActivityData.get(position).address);
    }

    @Override
    public int getItemCount() {
        return tripActivityData.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder {


        @BindView(R.id.activitnametxt)
        TextView activityName;

        @BindView(R.id.addresstxt)
        TextView addressText;


        @BindView(R.id.activitytriproot)
        CardView root;


        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);

        }

    }


}
