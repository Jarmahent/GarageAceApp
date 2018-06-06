package io.nanoapp.rockzom.garageace;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import android.support.design.widget.Snackbar;
import android.widget.Toast;

public class landingPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing_page);
    }

    public void closeGarageDoor(final View v){
        final Context context = getApplicationContext();
        CharSequence text = "Closing Garage Door...";
        final int duration = Toast.LENGTH_SHORT;
        Toast.makeText(context, text, duration).show();

        String closeGarageDoorUrl = "http://linkforclosedoor";
        RequestQueue queue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.GET, closeGarageDoorUrl,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(context, response, duration).show();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                String requestError = String.format("Error: %s", error.toString());
                Toast.makeText(context, requestError, duration).show();
            }
        }
        );
        //queue.add(stringRequest);
    }

    public void openGarageDoor(final View v){
        final Context context = getApplicationContext();
        CharSequence text = "Opening Garage Door...";
        final int duration = Toast.LENGTH_SHORT;
        Toast.makeText(context, text, duration).show();

        String openGarageDoorUrl = "http://linkforopendoor";
        RequestQueue queue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.GET, openGarageDoorUrl,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(context, response, duration).show();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                String requestError = String.format("Error: %s", error.toString());
                Toast.makeText(context, requestError, duration).show();

            }
        }
        );
        //queue.add(stringRequest);
    }
}




