package com.txzdele.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.txzdele.R;
import com.txzdele.utils.LogUtil;


public class FragmentTwo extends Fragment {

    View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_two,container,false);
        LogUtil.d("view   " +view);
        return view;
    }

    @Override
    public void onDestroyView() {
        ((ViewGroup)view.getParent()).removeView(view);
        super.onDestroyView();
    }
}