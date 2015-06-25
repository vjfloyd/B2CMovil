package com.moviles.b2c.Listener;

import android.app.ProgressDialog;
import android.content.Context;
import android.util.Log;
import android.widget.ArrayAdapter;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.moviles.b2c.adapters.CustomAdapter;
import com.moviles.b2c.parse.base.EntityParser;

import org.json.JSONArray;

/**
 * Created by vjrojasb on 6/20/15.
 */
public  class ListenerB2C  implements   EntityParser{

    private  void getService( String URL, final Context context, final Class adapter){

        RequestQueue queue = Volley.newRequestQueue(context);
        final ProgressDialog progressDialog = ProgressDialog.show(context, "Please wait ...", "Downloading Data ...", true);

        JsonArrayRequest consulta = new JsonArrayRequest(URL, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                CustomAdapter adapter = new CustomAdapter(  context , listar(response));

            }

<<<<<<< HEAD
             //adapter = new CustomAdapter( getApplication(), parser(response));
=======

>>>>>>> 3f4b12176ef72f289cca83842aa1213dc23b9189

        }, new Response.ErrorListener() {
            @Override
                public void onErrorResponse(VolleyError error) {
                    VolleyLog.e("ERROR", error.getMessage());
                    progressDialog.dismiss();
                }



        });


    }
<<<<<<< HEAD
/*
    public ArrayList<E> parsearInfo (){

    }
*/
=======


    @Override
    public void insertar(Object o) {

    }

    @Override
    public void actualizar(Object o) {

    }

    @Override
    public void eliminar(Object id) {

    }

    @Override
    public Object obtener() {
        return null;
    }
>>>>>>> 3f4b12176ef72f289cca83842aa1213dc23b9189

    @Override
    public ArrayAdapter listar(JSONArray respuesta) {
        return null;
    }
}
