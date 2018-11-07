package example.com.login;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class Profile_Fragment extends Fragment {
    ActionBar actionbar;
    TextView textview;
    RelativeLayout.LayoutParams layoutparams;

    @BindView(R.id.btnUpdateEmail)
    ImageView btnUpdateEmail;

    @BindView(R.id.btnChangePassword)
    ImageView UpdatePassword;

    @OnClick(R.id.btnUpdateEmail)
    public void updateEmail(){
        final FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.indexfc, new UpdateEmail_fragment());
        ft.commit();
    }

    @OnClick(R.id.btnChangePassword)
    public void changePassword(){
        final FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.indexfc, new ChangePassword_fragment());
        ft.commit();
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        View view =  getLayoutInflater().inflate(R.layout.profile_fragment,container,false);
        ButterKnife.bind(this, view);
        initActionBar();
        return view;

    }
    public void initActionBar()
    {
        actionbar = ((AppCompatActivity)getActivity()).getSupportActionBar();
        textview = new TextView(getContext());
        layoutparams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        actionbar.setDisplayShowHomeEnabled(false);
        actionbar.setDisplayHomeAsUpEnabled(false);
        textview.setLayoutParams(layoutparams);
        textview.setText("Profile");
        textview.setTextColor(Color.BLACK);
        textview.setGravity(Gravity.CENTER);
        textview.setTextSize(20);
        actionbar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        actionbar.setCustomView(textview);
    }
}
