package example.com.login;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SharedTripRecycleAdapter extends RecyclerView.Adapter<SharedTripRecycleAdapter.ViewHolder> {

    ArrayList<ShareTrips> shareTripsData;
    Context context;





    public SharedTripRecycleAdapter(Context context,ArrayList<ShareTrips> shareTripsData){
        this.shareTripsData = shareTripsData;
        this.context = context;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.shared_trip_card_layout,parent,false);
        SharedTripRecycleAdapter.ViewHolder holder = new SharedTripRecycleAdapter.ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.numberOFPax.setText(shareTripsData.get(position).pax);
        holder.budgettxt.setText("$ " + shareTripsData.get(position).budget);
        holder.intensityText.setText("wet sport activity");

        holder.tripDuration.setText(shareTripsData.get(position).tripType);

    }

    @Override
    public int getItemCount() {
        return shareTripsData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.numberofpaxtext)
        TextView numberOFPax;

        @BindView(R.id.budgettext)
        TextView budgettxt;

        @BindView(R.id.sharedtriproot)
        CardView sharedTripRoot;

        @BindView(R.id.activityintensitytext)
        TextView intensityText;

        @BindView(R.id.tripdurationtext)
        TextView tripDuration;


        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }

}
