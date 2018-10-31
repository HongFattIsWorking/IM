package example.com.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONObject;
import org.json.JSONStringer;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class login_fragment extends Fragment implements OnTaskCompleted{
    String msgType;
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

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //create data in JSON format
               // String jsonString = convertToJSON();
                // call AsynTask to perform network operation on separate threadHttpAsyncTask task = new HttpAsyncTask(this);
             //  HttpAsyncTask task = new HttpAsyncTask(login_fragment.this);
               // task.execute("https://" + HOST + "/"  + "v1/user/login", jsonString);
                //Toast.makeText(getContext(), "created " , Toast.LENGTH_LONG).show();
                Intent intent = new Intent(view.getContext(), Index.class);
                startActivity(intent);
            }
        });
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
            JSONObject jsonObject = new JSONObject(message);
            msgType = jsonObject.getString("token");
            Log.d(DIR,msgType);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    @Override
    public void onTaskCompleted(String response) {
        retrieveFromJSON(response);
    }
}
