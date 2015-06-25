package com.moviles.b2c;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.moviles.b2c.models.Inmueble;


public class WelcomeB2CActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_welcomeb2c);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    public void conectarse(View view){
        Intent intent = new Intent(this, ConectateActivity.class);//nos permite comunicacion entre vistas, un activity solo puede vivir una vez, no se puede correr 2 activities
        startActivity(intent);
    }
    public void registrarse(View view){
        Intent intent =  new Intent(this, RegistrateActivity.class);
        startActivity(intent);
    }
    public void favoritos(View view){// metodo que escucha el metodo onClick del boton favoritos
        Intent intent = new Intent(this, FavoritosActivity.class);
        startActivity(intent);

    }
    public void inmuebles(View view){
        Intent intent = new Intent(this, InmueblesActivity.class);
        startActivity(intent);
    }

    /*Ejm toast
    * this o getBaseContext() : contexto de la actividad , cada actividad tiene su propio contexto
    * mensaje
    * duracion
    * Toast.makeToast(this, " mensaje " , Toast.LENGTH_LONG )
    *
    *
    * */


}
