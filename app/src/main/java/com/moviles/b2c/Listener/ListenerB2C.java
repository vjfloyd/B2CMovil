package com.moviles.b2c.Listener;

import android.app.ProgressDialog;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Adapter;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;

import java.util.ArrayList;

/**
 * Created by vjrojasb on 6/20/15.
 */
public class ListenerB2C  {

    private  void getService( String URL, Context context, Class adapter){

        RequestQueue queue = Volley.newRequestQueue(context);
        final ProgressDialog progressDialog = ProgressDialog.show(context, "Please wait ...", "Downloading Data ...", true);

        JsonArrayRequest consulta = new JsonArrayRequest(URL, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                Log.e("rpta", response.toString());
            }

             adapter = new CustomAdapter( getApplication(), parser(response));

        }, new Response.ErrorListener() {
            @Override
                public void onErrorResponse(VolleyError error) {
                    VolleyLog.e("ERROR", error.getMessage());
                    progressDialog.dismiss();
                }



        });


    }

    public ArrayList<E> parsearInfo (){

    }


}
