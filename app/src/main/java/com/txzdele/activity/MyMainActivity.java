package com.txzdele.activity;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.txzdele.R;
import com.txzdele.fragment.FragmentTwo;
import com.txzdele.fragment.FragmentOne;


public class MyMainActivity extends AppCompatActivity {
    FragmentManager fragmentManager;
    FragmentOne   fragmentOne;
    FragmentTwo  fragmentTwo;
    FragmentOne fragmentThree;
    Fragment fragments[];
    private int index;
    private int currentTabIndex;
    TextView tvTitleMain;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_main);
        setDefaultFragment();
        initView();
    }
    private void initView(){
        tvTitleMain = (TextView)findViewById(R.id.tvTitleMain);
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.item1:
                        index = 0;
                        tvTitleMain.setText("业绩");
                        break;
                    case R.id.item2:
                        tvTitleMain.setText("暂无");
                        index = 1;
                        break;
                    case R.id.item3:
                        tvTitleMain.setText("账户");
                        index = 2;
                        break;
                }
                try {
                    if (currentTabIndex != index) {
                        FragmentTransaction trx = getSupportFragmentManager().beginTransaction();
                        trx.hide(fragments[currentTabIndex]);
                        if (!fragments[index].isAdded()) {
                            trx.add(R.id.fragment_content, fragments[index]);
                        }
                        trx.show(fragments[index]).commit();
                    }
                    currentTabIndex = index;
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                return false;
            }
        });
    }


    private void setDefaultFragment(){
        fragmentOne = new FragmentOne();
        fragmentTwo = new  FragmentTwo();
        fragmentThree = new FragmentOne();
        fragmentManager = getSupportFragmentManager();
        fragments = new Fragment[] { fragmentOne, fragmentTwo,fragmentThree };
        // 添加显示第一个fragment，
        getSupportFragmentManager().beginTransaction().add(R.id.fragment_content, fragmentOne)//.add(R.id.fragment_container, two).hide(two).show(two)
                .commit();

    }
}