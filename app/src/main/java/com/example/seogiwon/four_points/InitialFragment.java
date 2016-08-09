package com.example.seogiwon.four_points;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class InitialFragment  extends Fragment {

    ViewGroup rootView;

    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        rootView = (ViewGroup) inflater.inflate(R.layout.fragment_initial, container, false);
//    ImageView imageView = (ImageView) rootView.findViewById(R.id.cross);
//    imageView.setImageResource(R.drawable.cross);

        return rootView;
    }
}
