package example.com.login;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HistoryRecycleViewAdapter extends RecyclerView.Adapter<HistoryRecycleViewAdapter.ViewHolder> {

    ArrayList<Trips> tripsHistoryData;
    Context context;


    public HistoryRecycleViewAdapter(Context context, ArrayList<Trips> tripsHistoryData){
        this.tripsHistoryData = tripsHistoryData;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.historycard_layout, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {

        holder.tripID.setText(tripsHistoryData.get(position).uderid);
        holder.tripType.setText(tripsHistoryData.get(position).tripType);
        holder.date.setText(tripsHistoryData.get(position).date);

        holder.historyTrip.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                AppCompatActivity sctivity = (AppCompatActivity) view.getContext();
                ActivityHistoryFragment myFrag = new ActivityHistoryFragment();
                sctivity.getSupportFragmentManager().beginTransaction().replace(R.id.indexfc, myFrag).addToBackStack(null).commit();
            }
        });
    }

    @Override
    public int getItemCount() {
        return tripsHistoryData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {


        @BindView(R.id.tripidtxt)
        TextView tripID;

        @BindView(R.id.triptypetxt)
        TextView tripType;

        @BindView(R.id.datetxt)
        TextView date;

        @BindView(R.id.historytriproot)
        CardView historyTrip;



        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);

        }

    }

}
