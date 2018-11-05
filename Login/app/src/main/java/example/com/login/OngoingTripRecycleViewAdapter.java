package example.com.login;

import android.app.AlertDialog;
import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnTouch;

public class OngoingTripRecycleViewAdapter extends RecyclerView.Adapter<OngoingTripRecycleViewAdapter.ViewHolder> {

    ArrayList<Trips> TripsData;
    Context context;

    public OngoingTripRecycleViewAdapter(Context context,ArrayList<Trips> TripsData){
        this.TripsData = TripsData;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.ongoingcard_layout,parent,false);
        OngoingTripRecycleViewAdapter.ViewHolder holder = new OngoingTripRecycleViewAdapter.ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {

        holder.tripID.setText(TripsData.get(position).uderid);
        holder.tripType.setText(TripsData.get(position).tripType);
        holder.date.setText(TripsData.get(position).date);

        holder.editImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                holder.editCard.setVisibility(View.VISIBLE);
            }
        });


    }

    @Override
    public int getItemCount() {
        return TripsData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.tripidtxt)
        TextView tripID;

        @BindView(R.id.triptypetxt)
        TextView tripType;

        @BindView(R.id.datetxt)
        TextView date;

        @BindView(R.id.editscreen)
        CardView editCard;

        @BindView(R.id.ongoingtriproot)
        CardView onGoingRoot;

        @BindView(R.id.imageedit)
        ImageView editImage;

        @OnTouch(R.id.ongoingtriproot)
        boolean exampleTouched(View v, MotionEvent ev) {
            editCard.setVisibility(View.GONE);
            return true;
        }

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }

    public void showPopUp(View view,Context context) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View customView = layoutInflater.inflate(R.layout.addingsharedpopup, null);
        builder.setView(customView);
        builder.create();
        builder.show();
    }
}
