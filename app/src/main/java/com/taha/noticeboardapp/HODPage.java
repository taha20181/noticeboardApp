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

public class HODPage extends AppCompatActivity {

    EditText title, content;
    Spinner noticetype;
    Button sub_notice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hodpage);
        Toast.makeText(getApplicationContext(),
                "Fill up the Details",
                Toast.LENGTH_SHORT).show();

        title = findViewById(R.id.et_title);
        content = findViewById(R.id.et_content);
        noticetype = findViewById(R.id.sp_noticetype);
        sub_notice = findViewById(R.id.bt_sub_notice);

        final String str_title,str_content,str_noticetype,str_sub_notice;

        str_title = title.getText().toString();
        str_content = content.getText().toString();
        int pos1 = noticetype.getSelectedItemPosition();
        if(pos1 == 0){
            Toast.makeText(getApplicationContext(),
                    "Select an Option",
                    Toast.LENGTH_SHORT).show();
        } else {
            str_noticetype = noticetype.getSelectedItem().toString();
            String url ="http:192.168.137.1/taha/genNotice.php";
            StringRequest stringRequest = new StringRequest(Request.Method.POST,
                    url,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            System.out.println("Request Placed" + response);
                            if(response.contains("Notice Generated")){
                                Toast.makeText(getApplicationContext(),
                                        "Notice Successfully Generated",
                                        Toast.LENGTH_SHORT).show();
                            }
                            else{
                                Toast.makeText(getApplicationContext(),
                                        "Notice Not Generated",
                                        Toast.LENGTH_SHORT).show();
                            }
                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(getApplicationContext(),
                            "Internet Connectivity Error",
                            Toast.LENGTH_SHORT).show();
                    error.printStackTrace();
                }
            }){
                @Override
                protected Map<String, String> getParams() {
                    Map<String,String> data = new HashMap<>();
                    data.put("title", str_title);
                    data.put("content", str_content);
                    data.put("noticetype", str_noticetype);

                    return data;
                }
            };

            RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
            requestQueue.add(stringRequest);
        }

    }
}
