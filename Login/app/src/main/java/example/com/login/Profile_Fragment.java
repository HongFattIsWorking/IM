package example.com.login;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class Profile_Fragment extends Fragment {

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
        getActivity().setTitle("Profile");
        return view;


    }
}
