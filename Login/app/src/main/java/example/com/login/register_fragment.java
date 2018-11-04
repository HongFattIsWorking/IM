package example.com.login;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import org.json.JSONObject;
import org.json.JSONStringer;

import butterknife.BindView;
import butterknife.ButterKnife;

public class register_fragment extends Fragment implements OnTaskCompleted {
    // Set host address of the Web Server
    public static final String HOST = "pigu.leongwenqing.com";
    // Set virtual directory of the host website
    public static final String TAG = "STEADYBO";

    @BindView(R.id.txtEmail)
    EditText etEmail;

    @BindView(R.id.txtName)
    EditText etName;

    @BindView(R.id.txtAge)
    EditText etAge;

    @BindView(R.id.txtGender)
    EditText etGender;

    @BindView(R.id.txtContact)
    EditText etContact;

    @BindView(R.id.txtpassword)
    EditText etPassword;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){

        View view = inflater.inflate(R.layout.register_fragment,container,false);
        ButterKnife.bind(this,view);

        final Button submitButton = (Button) view.findViewById(R.id.btnRegister);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //create data in JSON format
                 String jsonString = convertToJSON();
                // call AsynTask to perform network operation on separate threadHttpAsyncTask task = new HttpAsyncTask(this);
                HttpAsyncTask task = new HttpAsyncTask(register_fragment.this);
                task.execute("https://" + HOST + "/"  + "v1/user/login", jsonString);
                //\\Toast.makeText(getContext(), "created " , Toast.LENGTH_LONG).show();
            }
        });
        return view;

    }

    // HTTP POST METHODS - CONVERT DATA TO JSON
    public String convertToJSON() {
        JSONStringer jsonText = new JSONStringer();
        try {
            jsonText.object();
            jsonText.key("name");
            jsonText.value(etName.getText().toString());
            jsonText.key("age");
            jsonText.value(etAge.getText().toString());
            jsonText.key("gender");
            jsonText.value(etGender.getText().toString());
            jsonText.key("email");
            jsonText.value(etEmail);
            jsonText.key("phone");
            jsonText.value(etContact.getText().toString());
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
