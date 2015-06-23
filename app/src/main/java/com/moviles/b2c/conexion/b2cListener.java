package com.moviles.b2c.conexion;

import android.app.ProgressDialog;
import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;

/**
 * Created by vjrojasb on 6/20/15.
 */
public class b2cListener {


    private  void getService( String URL, Context context){

        RequestQueue queue = Volley.newRequestQueue(context);
        final ProgressDialog progressDialog = ProgressDialog.show(context, "Esperar ...", "Descargando datos ...", true);

        JsonArrayRequest consulta = new JsonArrayRequest(URL, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {



            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.e("ERROR", error.getMessage());
                progressDialog.dismiss();
            }



        });


    }

}
