package com.example.seogiwon.four_points;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by seogiwon on 2016. 8. 3..
 */
public class FirstOutFragment extends Fragment {
    ViewGroup rootView;

    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        rootView = (ViewGroup) inflater.inflate(R.layout.fragment_first_out, container, false);
     //   ImageView imageView = (ImageView) rootView.findViewById(R.id.heart);
      //  imageView.setImageResource(R.drawable.heart);

        return rootView;
    }
}
