package com.moviles.b2c.Listener;

import java.util.List;

/**
 * Created by vjrojasb on 6/20/15.
 */
public interface Parser<E, J> {

    void  insertar(E e);
    void actualizar(E e);
    void eliminar(J id);
    E obtener();
    List<E> listar();

}
