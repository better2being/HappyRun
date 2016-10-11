package com.tsunami.run.happyrun.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tsunami.run.happyrun.R;

/**
 * Created by 2010330579 on 2016/3/26.
 */
public class run_fragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.page_run, container, false);

        return rootView;
    }


}
