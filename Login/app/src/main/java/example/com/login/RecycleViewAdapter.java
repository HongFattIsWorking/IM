package example.com.login;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.ViewHolder> {


    private ArrayList<String> displayString = new ArrayList<String>();
    Context context;
    TextView textBox;
    RecyclerView recyclerView;





    public RecycleViewAdapter(Context context, ArrayList<String> intensity ,TextView textbox, RecyclerView recyclerView){
        this.displayString = intensity;
        this.context = context;
        textBox = textbox;
        this.recyclerView = recyclerView;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.dropdown_recycleview,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.dropDownText.setText(displayString.get(position));
        holder.rootRecycleView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textBox.setText(displayString.get(position));
                recyclerView.setVisibility(View.GONE);
            }
        });


    }

    @Override
    public int getItemCount() {
        return displayString.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.dropdown_text)
        TextView dropDownText;

        @BindView(R.id.rootrecycleview)
        RelativeLayout rootRecycleView;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }

}
