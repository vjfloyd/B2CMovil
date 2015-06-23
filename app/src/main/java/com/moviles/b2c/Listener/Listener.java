package com.moviles.b2c.Listener;

import android.content.Context;

/**
 * Created by vjrojasb on 6/20/15.
 */
public interface Listener<E, J> {

    void getServicio(String URL, Context context, E e);

}
