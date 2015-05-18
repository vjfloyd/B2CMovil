package com.moviles.b2c.models;

/**
 * Created by vjrojasb on 5/17/15.
 */
public class TipoTransaccion {

    private  int idTipoTransaccion;
    private String descripcion;

    public int getIdTipoTransaccion() {
        return idTipoTransaccion;
    }

    public void setIdTipoTransaccion(int idTipoTransaccion) {
        this.idTipoTransaccion = idTipoTransaccion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
