package example.com.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONObject;
import org.json.JSONStringer;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements OnTaskCompleted {

    String msgType;
    // Set host address of the Web Server
    public static final String HOST = "pigu.leongwenqing.com";
    // Set virtual directory of the host website
    public static final String DIR = "PIGU";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }
    @BindView(R.id.txtEmail)
    EditText etEmail;

    @BindView(R.id.txtPassword)
    EditText etPassword;

    @OnClick(R.id.btnSubmit)
    public void onSubmitClicked(View v) {



        // create data in JSON format
        String jsonString = convertToJSON();

        // call AsynTask to perform network operation on separate threadHttpAsyncTask task = new HttpAsyncTask(this);
        HttpAsyncTask task = new HttpAsyncTask(this);
        task.execute("https://" + HOST + "/"  + "v1/user/login", jsonString);
        Toast.makeText(this, "Profile created \n successfully!", Toast.LENGTH_LONG).show();
        // finish();
    }
    @OnClick(R.id.btnSignUp)
    public void onSignUpClicked(View v){
        Intent intent = new Intent(this, register.class);
        startActivity(intent);
    }


    //HTTP POST METHODS - CONVERT DATA TO JSON
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
