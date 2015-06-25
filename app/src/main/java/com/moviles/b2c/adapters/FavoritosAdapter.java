package com.moviles.b2c.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.moviles.b2c.R;
import com.moviles.b2c.entity.Favorito;

import java.util.ArrayList;

/**
 * Created by vjrojasb on 5/18/15.
 */
public class FavoritosAdapter extends RecyclerView.Adapter<FavoritosAdapter.ViewHolder> {

    private ArrayList<Favorito> favoritos;
    private int itemLayout;

    public FavoritosAdapter(ArrayList<Favorito> favoritos, int itemLayout){
        this.favoritos = favoritos;
        this.itemLayout = itemLayout;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(itemLayout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Favorito favorito =  favoritos.get(position);

        holder.textViewLarge.setText( favorito.getIdInmueble().getDistrito() );
        holder.textViewMedium.setText( favorito.getIdInmueble().getDescripcion());
        holder.textViewSmall.setText( favorito.getIdInmueble().getDireccion());
    }

    @Override
    public int getItemCount() {
        return favoritos.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView textViewLarge;
        public TextView textViewMedium;
        public TextView textViewSmall;

        public ViewHolder(View itemView) {
            super(itemView);

            textViewLarge = (TextView) itemView.findViewById(R.id.textViewL);
            textViewMedium = (TextView) itemView.findViewById(R.id.textViewM);
            textViewSmall = (TextView) itemView.findViewById(R.id.textViewS);
        }

    }
}
