package com.moviles.b2c.fragments;


import android.app.DownloadManager;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.moviles.b2c.R;
import com.moviles.b2c.adapters.FavoritosAdapter;
import com.moviles.b2c.models.Favorito;
import com.moviles.b2c.models.Inmueble;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Date;

/**
 * A simple {@link Fragment} subclass.
 */
public class FavoritosFragment extends Fragment {

    ArrayList<Favorito> dataset;

    public FavoritosFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_favoritos, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //Un fragmento no tiene el contexto , como si lo tiene un Activity
        String URL = "mi url";
        RequestQueue queue = Volley.newRequestQueue(getActivity());

        final ProgressDialog progressDialog = ProgressDialog.show(getActivity(), "Espere ...", "Cargando datos...");

        JsonArrayRequest req = new JsonArrayRequest(URL, new Response.Listener<JSONArray>() {

            @Override
            public void onResponse(JSONArray response) {
                Log.e("mirespuesta", response.toString());
                progressDialog.cancel();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                progressDialog.cancel();

            }
        });

        queue.add(req);



        ArrayList<Favorito> favoritosArray = new ArrayList<Favorito>();

        Inmueble inm1 = new Inmueble();
        inm1.setIdInmueble(1);
        inm1.setDistrito("Surco");
        inm1.setDireccion("Av primavera");
        inm1.setDescripcion("Departamento de 3 ambientes");
        Favorito favorito1 = new Favorito();
        favorito1.setIdInmueble(inm1);
        favoritosArray.add(favorito1);


        Inmueble inm2 = new Inmueble();
        inm2.setIdInmueble(2);
        inm2.setDistrito("Surco");
        inm2.setDireccion("Av primavera");
        inm2.setDescripcion("Departamento de 3 ambientes");
        Favorito favorito2 = new Favorito();
        favorito2.setIdInmueble(inm2);
        favoritosArray.add(favorito2);


        Inmueble inm3 = new Inmueble();
        inm3.setIdInmueble(3);
        inm3.setDistrito("Surco");
        inm3.setDireccion("Av primavera");
        inm3.setDescripcion("Departamento de 3 ambientes");
        Favorito favorito3 = new Favorito();
        favorito3.setIdInmueble(inm3);
        favoritosArray.add(favorito3);


        Inmueble inm4 = new Inmueble();
        inm4.setIdInmueble(4);
        inm4.setDistrito("Surco");
        inm4.setDireccion("Av primavera");
        inm4.setDescripcion("Departamento de 3 ambientes");
        Favorito favorito = new Favorito();
        favorito.setIdInmueble(inm4);
        favoritosArray.add(favorito);


        /*
        * holder.textViewLarge.setText( favorito.getIdinmueble().getDistrito() );
          holder.textViewMedium.setText( favorito.getIdinmueble().getDescripcion());
          holder.textViewSmall.setText( favorito.getIdinmueble().getDireccion());
        *
        * */




        RecyclerView recyclerView = (RecyclerView) getActivity().findViewById(R.id.mi_recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(new FavoritosAdapter(favoritosArray, R.layout.row_favoritos));
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
    }


    public ArrayList<Favorito> parser (JSONArray response){

        ArrayList<Favorito> songsAux = new ArrayList<Favorito>();

        for(int i = 0; i<response.length(); i++){

            Favorito favorito = new Favorito();

            try {

                JSONObject jsonObject = (JSONObject) response.get(i);

                //favorito.setSongName(jsonObject.getString("cancion"));
                //favorito.setSongArtist(jsonObject.getString("artista"));
                //favorito.setStars(jsonObject.getInt("estrellas"));

                //Log.e("dato",favorito.getSongName().toString());

                songsAux.add(favorito);

            } catch (JSONException e) {
                e.printStackTrace();
            }


        }


        return songsAux;
    }
}
