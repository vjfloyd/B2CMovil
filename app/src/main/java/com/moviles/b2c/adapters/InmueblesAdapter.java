package com.moviles.b2c.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.moviles.b2c.R;
import com.moviles.b2c.models.Inmueble;

import java.util.ArrayList;

/**
 * Created by vjrojasb on 6/25/15.
 */
public class InmueblesAdapter extends ArrayAdapter<Inmueble>{

    ArrayList<Inmueble> data;
    LayoutInflater inflater;

    public InmueblesAdapter(Context context, ArrayList<Inmueble> objects){
        super(context,-1, objects);
        this.data = objects;
        this.inflater = LayoutInflater.from(context);

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){

        ViewHolder holder;
        Inmueble inmueble = data.get(position);
        int layout = R.layout.row_inmuebles;

        if ( convertView == null ){
            convertView = inflater.inflate( layout, null);
            holder = new ViewHolder();
            holder.distrito = (TextView) convertView.findViewById(R.id.distrito);
            holder.descripcion = (TextView)convertView.findViewById(R.id.descripcion);
            holder.direccion = (TextView)convertView.findViewById(R.id.direccion);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }

        holder.distrito.setText(inmueble.getDistrito());
        holder.direccion.setText(inmueble.getDireccion());
        holder.descripcion.setText(inmueble.getDescripcion());

        return  convertView;
    }

    public static class ViewHolder{
        public TextView nombre;
        public TextView distrito;
        public TextView direccion;
        public TextView descripcion;

    }

}
