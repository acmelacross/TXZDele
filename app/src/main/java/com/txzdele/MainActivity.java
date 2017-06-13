package com.txzdele;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.txzdele.modle.TXZUsers;
import com.txzdele.utils.LogUtil;

import java.util.List;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;
import cn.bmob.v3.listener.SaveListener;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

    }
    private void init(){
        Bmob.initialize(this, "01930c9d1339e14529d6fe24262c7342");
//        TXZUsers bu2 = new TXZUsers();
//        bu2.setUsername("141592");
//        bu2.setPassword("141592");
//        bu2.login(new SaveListener<TXZUsers>() {
//
//            @Override
//            public void done(TXZUsers bmobUser, BmobException e) {
//                if(e==null){
//
//                }else{
//
//                }
//            }
//        });

        BmobQuery<TXZUsers> query = new BmobQuery<TXZUsers>();
       query.addWhereEqualTo("objectId", "98d8bd642c");
        query.findObjects(new FindListener<TXZUsers>() {
            @Override
            public void done(List<TXZUsers> object, BmobException e) {
                if(e==null){
                   ;
                    TXZUsers user = new TXZUsers();

                    user.setUsername("23846");
                    user.setPassword("23846");
                    user.setFather( object.get(0));
                    user.signUp(new SaveListener<TXZUsers>() {
                        @Override
                        public void done(TXZUsers s, BmobException e) {
                            if(e==null){
                               // toast("注册成功:" +s.toString());
                            }else{
                                LogUtil.d(""+"册成功:信息失败:" + e.getMessage());
                               // loge(e);
                            }
                        }
                    });
                   // toast("查询用户成功:"+object.size());
                }else{
                    LogUtil.d(""+"查询用户信息失败:" + e.getMessage());
                   // toast("更新用户信息失败:" + e.getMessage());
                }
            }
        });
    }
}
