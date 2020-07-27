package com.taha.noticeboardapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class RegisterPage extends AppCompatActivity {

    EditText username, password, contact, email;
    Spinner usertype;
    Button register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_page);
        Toast.makeText(getApplicationContext(), "Fill all details", Toast.LENGTH_LONG).show();

        username = findViewById(R.id.et_uname);
        password = findViewById(R.id.et_pass);
        contact = findViewById(R.id.et_contact);
        email = findViewById(R.id.et_email);
        usertype = findViewById(R.id.sp_usertype);
        register = findViewById(R.id.bt_register);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String str_uname, str_cont, str_pass, str_email, str_usertype;
                str_uname = username.getText().toString();
                str_cont = contact.getText().toString();
                str_email = email.getText().toString();
                str_pass = password.getText().toString();
                int pos = usertype.getSelectedItemPosition();
                if (pos == 0) {
                    Toast.makeText(getApplicationContext(), "Please select type", Toast.LENGTH_LONG);
                } else {
                    str_usertype = usertype.getSelectedItem().toString();
                    String url = "http://172.20.10.2/taha/register.php";
                    StringRequest stringRequest = new StringRequest(Request.Method.POST,
                            url,
                            new Response.Listener<String>() {
                                @Override
                                public void onResponse(String response) {
                                    System.out.println("Request Placed" + response);
                                    if(response.contains("Successful")){
                                        Toast.makeText(getApplicationContext(),
                                                "Registration Successful",
                                                Toast.LENGTH_LONG).show();
                                    }
                                    else {
                                        Toast.makeText(getApplicationContext(),
                                                "Registration Failed",
                                                Toast.LENGTH_LONG).show();
                                    }

                                }
                            }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {

                            Toast.makeText(getApplicationContext(),
                                    "Internet Connectivity Error",
                                    Toast.LENGTH_LONG).show();
                            error.printStackTrace();
                        }
                    }) {
                        @Override
                        protected Map<String, String> getParams() {
                            Map<String,String> data = new HashMap<>();
                            data.put("username", str_uname);
                            data.put("password", str_pass);
                            data.put("contact", str_cont);
                            data.put("email", str_email);
                            data.put("usertype", str_usertype);

                            return data;
                        }
                    };

                    RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
                    requestQueue.add(stringRequest);
                }
            }
        });
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Toast.makeText(getApplicationContext(), "You pressed back button once",Toast.LENGTH_SHORT).show();
    }
}
