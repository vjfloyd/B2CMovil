package com.moviles.b2c.parse.base;

import android.widget.ArrayAdapter;

import org.json.JSONArray;

import java.util.List;

/**
 * Created by vjrojasb on 6/20/15.
 */
public interface EntityParser<E, J> {
    void  insertar(E e);
    void actualizar(E e);
    void eliminar(J id);
    E obtener();
    public ArrayAdapter<E> listar(JSONArray respuesta);
}
