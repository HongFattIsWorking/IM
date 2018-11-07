package example.com.login;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONObject;
import org.json.JSONStringer;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class register_fragment extends Fragment implements OnTaskCompleted {
    // Set host address of the Web Server
    public static final String HOST = "pigu.leongwenqing.com";
    // Set virtual directory of the host website
    public static final String TAG = "PIGU";

    @BindView(R.id.txtEmail)
    EditText email;

    @BindView(R.id.txtName)
    EditText name;

    @BindView(R.id.txtPassword)
    EditText password;

    @BindView(R.id.txtconfirmPassword)
    EditText confirmPassword;

    @BindView(R.id.btnRegister)
    Button register;
    @OnClick(R.id.btnRegister)
    public void onRegisterClicked(View v) {
        if (email.getText().toString().length() > 1 && name.getText().length() > 1 && password.getText().toString().length() > 1 && confirmPassword.getText().toString().length() > 1) {
            if (password.getText().equals(confirmPassword.getText())) {
                // create data in JSON format
                String jsonString = convertToJSON();
                // call AsynTask to perform network operation on separate threadHttpAsyncTask task = new HttpAsyncTask(this);
                HttpAsyncTask task = new HttpAsyncTask(this);
                task.execute("https://" + HOST + "/" + "v1/user/register", jsonString);
                //Toast.makeText(this, "Profile created \n successfully!", Toast.LENGTH_LONG).show();

            } else {
                //popup
            }
        } else {
            //Pop up
        }
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){

        View view = inflater.inflate(R.layout.register_fragment,container,false);
        ButterKnife.bind(this,view);
        return view;

    }

    public String convertToJSON() {
        JSONStringer jsonText = new JSONStringer();
        try {
            jsonText.object();
            jsonText.key("name");
            jsonText.value(name.getText().toString());
            jsonText.key("dob");
            jsonText.value("1995-11-20");
            jsonText.key("gender");
            jsonText.value("M");
            jsonText.key("email");
            jsonText.value(email.getText().toString());
            jsonText.key("contact_no");
            jsonText.value("96338031");
            jsonText.key("password");
            jsonText.value(password.getText().toString());
            jsonText.endObject();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonText.toString();
    }
    public void retrieveFromJSON(String message) {
        try {
            JSONObject jsonObject = new JSONObject(message);
            String msgType = jsonObject.getString("token");
            Log.d("PIGU",msgType);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public void onTaskCompleted(String response) {
        retrieveFromJSON(response);
    }

}
