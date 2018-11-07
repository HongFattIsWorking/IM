package example.com.login;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class login_fragment extends Fragment implements OnTaskCompleted{
    String msgType;
    JSONObject jsonObject;

    // Set host address of the Web Server
    public static final String HOST = "pigu.leongwenqing.com";
    // Set virtual directory of the host website
    public static final String DIR = "PIGU";

    @BindView(R.id.txtEmail)
    EditText etEmail;

    @BindView(R.id.txtPassword)
    EditText etPassword;

    @BindView(R.id.tvForgetPw)
    TextView tvForget;


    @BindView(R.id.loadingProgress)
    ProgressBar pb;

    @OnClick(R.id.btnSubmit)
    void signUP (){

        if(etEmail.getText().length() >= 1 && etPassword.getText().length() >= 1){
            String jsonString = convertToJSON();
            HttpAsyncTask task = new HttpAsyncTask(login_fragment.this);
            task.execute("https://" + HOST + "/"  + "v1/user/login", jsonString);
            pb.setVisibility(View.VISIBLE);
        }
        else
        {
            //popup dialog
        }

//        Intent intent = new Intent(getContext(), Index.class);
//        startActivity(intent);

    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.login_fragment, container, false);

        TextView clickTextView = (TextView) view.findViewById(R.id.tvForgetPw);
        clickTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), Index.class);
                startActivity(intent);
            }
        });

        final Button submitButton = (Button) view.findViewById(R.id.btnSubmit);
        ButterKnife.bind(this, view);



        return view;
    }
    public String convertToJSON() {
        JSONStringer jsonText = new JSONStringer();
        try {
            jsonText.object();
            jsonText.key("email");
            jsonText.value(etEmail.getText().toString());
            jsonText.key("password");
            jsonText.value(etPassword.getText().toString());
            jsonText.endObject();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonText.toString();
    }
    public void retrieveFromJSON(String message) {
        try {
             jsonObject = new JSONObject(message);
            msgType = jsonObject.getString("token");
            Log.d(DIR,msgType);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    @Override
    public void onTaskCompleted(String response) {
        retrieveFromJSON(response);
        pb.setVisibility(View.GONE);
        try {
            if(jsonObject.getString("token")!= null){

                Intent intent = new Intent(getContext(), Index.class);
                SharedPreferences myPrefs = getActivity().getSharedPreferences("myPrefs", getActivity().MODE_PRIVATE);
                SharedPreferences.Editor editor = myPrefs.edit();
                editor.putString("token", jsonObject.getString("token"));
                editor.commit();
                startActivity(intent);

            }
            else
            {
                //pop up login failed
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

}
