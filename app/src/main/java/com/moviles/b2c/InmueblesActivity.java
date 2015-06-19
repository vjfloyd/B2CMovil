package com.moviles.b2c;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.moviles.b2c.Listener.ApplicationController;
//import com.moviles.b2c.Listener.CustomRequest;
import com.moviles.b2c.Listener.CustomRequest;
import com.moviles.b2c.adapters.InmueblesAdapter;
import com.moviles.b2c.entity.Favorito;
import com.moviles.b2c.entity.Inmueble;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class InmueblesActivity extends Activity {

    private static String TAG = "deded";
    private String jsonResponse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inmuebles);


 /*--------------------------------------- Enviar JsonArray-------------------------------------------*/

            RequestQueue queue = Volley.newRequestQueue(this);
            String URL = "http://10.11.80.19:8080/B2CWS/favoritos/1";
          //String URL = "https://script.google.com/macros/s/AKfycbwTbXryiP8K_8z8QdGNBeos8yGuvFPtaANwNCJUPI4b4QBTYg/exec";

            final ProgressDialog progressDialog = ProgressDialog.show(this, "Esperar  ...", "Descargando Datos ...", true);

            JsonArrayRequest request = new JsonArrayRequest(URL, new Response.Listener<JSONArray>() {
                @Override
                public void onResponse(JSONArray response) {
                    Log.e("Respuesta", response.toString());


                    ListView list = (ListView) findViewById(R.id.list_view);
                    InmueblesAdapter inmueblesAdapter = new InmueblesAdapter(getApplicationContext(), parserJSONArray(response));

                    list.setAdapter(inmueblesAdapter);

                   progressDialog.dismiss();
                }

            }, new  Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.e("Error: ", error.getMessage());
                progressDialog.dismiss();


            }
        });

        queue.add(request);



 /*--------------------------------------- Enviar JsonObject -------------------------------------------*/

      //  String jsonUrl = "http://localhost:8080/B2CWS/inmuebles";

        HashMap<String, String> params = new HashMap<String, String>();
        params.put("titulo", "xxx");
        params.put("distrito","");
        params.put("titulo", "xxx");
        params.put("descripcion","xx");
        params.put("precio", "xxx");
        params.put("titulo","");


        /**
         *
         *  private  int idInmueble;
         private  String titulo;
         private String titulo;
         private  String distrito;
         private int latitud;
         private int longitud;
         private String descripcion;
         private double precio;
         *
         */


       // AppController.getInstance().addToRequestQueue(jsObjRequest, tag_json_obj);


    }


    public ArrayList<Inmueble> parserJSONArray(JSONArray respuesta){
         ArrayList<Inmueble> inmueblesLista = new ArrayList<Inmueble>();
         ArrayList<Favorito> favoritosLista = new ArrayList<Favorito>();

        for( int i=0; i < respuesta.length(); i++){
            JSONObject jsonObject;
            //Inmueble inmueble = new Inmueble();
            Inmueble inmueble = new Inmueble();
            Favorito favorito = new Favorito();
            try {
                    /*
                 jsonObject = (JSONObject) respuesta.get(i);
                 inmueble.setDistrito(jsonObject.getString("distrito"));
                 inmueble.setDireccion(jsonObject.getString("direccion"));
                 inmueble.setDescripcion(jsonObject.getString("descripcion"));
                 inmueblesLista.add(inmueble);

                    */

                // EXTRAER DEL SERVIDOR

                jsonObject = (JSONObject) respuesta.get(i);
                favorito.setIdfavoritos(Integer.parseInt(jsonObject.getString("id")));
                inmueble.setTitulo(jsonObject.getString("titulo"));
                inmueble.setDireccion(jsonObject.getString("direccion"));
                //inmueble.setPrecio(Double.parseDouble(jsonObject.getString("precio")));
                //inmueble.setDescripcion(jsonObject.getString("descripcion"));

                inmueblesLista.add(inmueble);



            }catch (JSONException e){
                Log.e("peticion", "Error al parsear");
            }
        }
        return  inmueblesLista;
    }








    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_inmuebles, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }




}
