package com.moviles.b2c.conexion;

import android.app.DownloadManager;
import android.content.Context;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.moviles.b2c.entity.TipoUsuario;
import com.moviles.b2c.entity.Usuario;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by vjrojasb on 6/18/15.
 */
public class JsonSend {


    public  void insertarUsuario(Context context,final Usuario usuario){

        RequestQueue queue = ConexionB2C.getInstance(context).getRequestQueue();

        StringRequest stringRequest = new StringRequest(Request.Method.POST, "http://localhost:8080/B2CWS//user/create", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

            }
        }, new Response.ErrorListener(){

            @Override
            public void onErrorResponse(VolleyError error){
                //msj err
            }
        }){
            @Override
            protected Map<String, String> getParams(){
                Map<String, String> parametros = new HashMap<String, String>();
                parametros.put("usuario", usuario.getNombre());
                parametros.put("password", usuario.getPassword());
                parametros.put("nombre", usuario.getPassword());
                parametros.put("email", usuario.getPassword());
                parametros.put("ruc", usuario.getPassword());
                parametros.put("direccion", usuario.getPassword());
                parametros.put("web", usuario.getWeb());
                parametros.put("telefono", usuario.getTelefono());
                parametros.put("idTipoUsuario", usuario.getIdTipoUsuario().toString());

                return  parametros;
            }

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError{
                Map<String, String> params = new HashMap<String, String>();
                params.put("", "");
                return  params;
            }
        };

        queue.add(stringRequest);

      /*

            private String usuario;
            private String password;
            private String nombre;
            private String email;
            private String ruc;
            private String direccion;
            private String web;
            private String telefono;
            private boolean eliminado;
            private TipoUsuario idTipoUsuario;
     */
    }
}
