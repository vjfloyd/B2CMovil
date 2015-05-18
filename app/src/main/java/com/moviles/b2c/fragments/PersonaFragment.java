package com.moviles.b2c.fragments;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.moviles.b2c.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class PersonaFragment extends Fragment {


    public PersonaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_persona, container, false);
    }


}
