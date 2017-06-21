package com.txzdele.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


import com.txzdele.R;
import com.txzdele.activity.YeJiActivity;



public class FragmentOne extends Fragment {
   ImageView ivFramentYeji;
    View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_one,container,false);
        initView(view);
        return view;
    }
    private void initView(View v){
        ivFramentYeji =(ImageView) view.findViewById(R.id.ivFramentYeji);
        ivFramentYeji.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent().setClass(getActivity(), YeJiActivity.class));
            }
        });
    }

    @Override
    public void onDestroyView() {
        ((ViewGroup)view.getParent()).removeView(view);
        super.onDestroyView();
    }
}