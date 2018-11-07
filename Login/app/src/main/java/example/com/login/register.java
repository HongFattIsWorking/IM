package example.com.login;

import android.nfc.Tag;
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

public class register extends AppCompatActivity implements OnTaskCompleted {

    // Set host address of the Web Server
    public static final String HOST = "pigu.leongwenqing.com";
    // Set virtual directory of the host website
    public static final String TAG = "PIGU";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);
    }

    @BindView(R.id.txtEmail)
    EditText etEmail;

    @BindView(R.id.txtName)
    EditText etName;

    @BindView(R.id.txtpassword)
    EditText etPassword;



   // HTTP POST METHODS - CONVERT DATA TO JSON
    public String convertToJSON() {
        JSONStringer jsonText = new JSONStringer();
        try {
            jsonText.object();
            jsonText.key("name");
            jsonText.value(etName.getText().toString());
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
            String msgType = jsonObject.getString("token");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTaskCompleted(String response) {
        retrieveFromJSON(response);
    }
}
