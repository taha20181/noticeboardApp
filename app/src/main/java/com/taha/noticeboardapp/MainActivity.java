package com.taha.noticeboardapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

public class MainActivity extends AppCompatActivity {

    EditText username,password,title,content,user_name,pass_word;
    Button login,register,submit;
    Spinner logintype,noticetype,login_type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        username = findViewById(R.id.et_uname);
//        password = findViewById(R.id.et_pass);
//        login = findViewById(R.id.bt_sub);
//        logintype = findViewById(R.id.sp_logintype);
        register = findViewById(R.id.bt_reg);

        user_name = findViewById(R.id.et_username);
        pass_word = findViewById(R.id.et_password);
//        title = findViewById(R.id.et_title);
//        content = findViewById(R.id.et_content);
//        noticetype = findViewById(R.id.sp_noticetype);
        submit = findViewById(R.id.bt_sub);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent myintent = new Intent(getApplicationContext(), RegisterPage.class);
                startActivity(myintent);
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(getApplicationContext(),
//                        "you pressed submit",
//                        Toast.LENGTH_SHORT).show();
//
//                final String str_username, str_password, str_logintype;
//                str_username = user_name.getText().toString();
//                str_password = pass_word.getText().toString();
//                if(str_username == "HOD_IT"){
//                    if(str_password == "IMHODOFIT"){
//                        int pos2 = logintype.getSelectedItemPosition();
//                        if (pos2 == 0){
//                            Toast.makeText(getApplicationContext(),
//                                    "Please Select Type",
//                                    Toast.LENGTH_SHORT).show();
//                        } else if(pos2 == 3) {
//                            Intent myintent1 = new Intent(getApplicationContext(), HODPage.class);
//                            startActivity(myintent1);
//                        }
//                    } else{
//                        Toast.makeText(getApplicationContext(),
//                                "Incorrect Password",
//                                Toast.LENGTH_SHORT).show();
//                    }
//                } else{
//                    Toast.makeText(getApplicationContext(),
//                            "Incorrect Username",
//                            Toast.LENGTH_SHORT).show();
//                }
//                int pos2 = logintype.getSelectedItemPosition();
//                if(pos2 == 2){
//                    Intent myintent1 = new Intent(getApplicationContext(), HODPage.class);
//                    startActivity(myintent1);
//
//                } else if(pos2 == 1){
//                    Intent myintent1 = new Intent(getApplicationContext(), Student_Page.class);
//                    startActivity(myintent1);
//                }
            }
        });
    }
}


//                    str_logintype = login_type.getSelectedItem().toString();
//                    String url = "http://192.168.137.1/taha/register.php";
//                    StringRequest stringRequest = new StringRequest(Request.Method.POST,
//                            url,
//                            new Response.Listener<String>() {
//                                @Override
//                                public void onResponse(String response) {
//
//                                }
//                            })