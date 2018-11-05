package example.com.login;

import android.app.AlertDialog;
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
        holder.numberOFPax.setText("4 - 5");
        holder.budgettxt.setText(shareTripsData.get(position).budget);
        holder.intensityText.setText("wet sport activity");
        holder.tripDuration.setText("Full Day");
        holder.sharedTripRoot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               showPopUp(view,context);
            }
        });

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

    public void showPopUp(View view,Context context) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService( Context.LAYOUT_INFLATER_SERVICE );
        View customView = layoutInflater.inflate(R.layout.addingsharedpopup, null);
        builder.setView(customView);
        builder.create();
        builder.show();

    }
}
