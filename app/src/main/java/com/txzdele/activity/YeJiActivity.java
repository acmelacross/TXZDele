package com.txzdele.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.txzdele.R;
import com.txzdele.modle.TXZOrders;
import com.txzdele.modle.TXZUsers;
import com.txzdele.utils.LogUtil;

import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;
import cn.bmob.v3.listener.SaveListener;

public class YeJiActivity extends AppCompatActivity {
TextView tvYejiInfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ye_ji);
        initView();
    }

    private void initView() {
        tvYejiInfo = (TextView)findViewById(R.id.tvYejiInfo);
        initData();
    }

    private void initData() {


//        TXZOrders gameScore = new TXZOrders();
//        gameScore.setAccount("0123");
//        gameScore.setPassword("1234");
//        gameScore.setTxzuser(BmobUser.getCurrentUser(TXZUsers.class));
//        gameScore.save(new SaveListener<String>() {
//
//            @Override
//            public void done(String objectId, BmobException e) {
//                if(e==null){
//                    LogUtil.i("bmob","数据成功 ："+e.getMessage()+","+e.getErrorCode());
//                }else{
//                    LogUtil.i("bmob","失败："+e.getMessage()+","+e.getErrorCode());
//                }
//            }
//        });

        BmobQuery<TXZOrders> query = new BmobQuery<TXZOrders>();
//查询playerName叫“比目”的数据
        query.addWhereEqualTo("txzuser", BmobUser.getCurrentUser(TXZUsers.class));
//返回50条数据，如果不加上这条语句，默认返回10条数据
        query.setLimit(99999);
//执行查询方法
        query.findObjects(new FindListener<TXZOrders>() {
            @Override
            public void done(List<TXZOrders> object, BmobException e) {
                if(e==null){
                   // toast("查询成功：共"+object.size()+"条数据。");
                    LogUtil.d("查询成功：共"+object.size()+"条数据。");
                    for (TXZOrders gameScore : object) {


                        //获得数据的objectId信息
                        gameScore.getObjectId();
                        //获得createdAt数据创建时间（注意是：createdAt，不是createAt）
                        gameScore.getCreatedAt();
                    }
                }else{
                    LogUtil.i("bmob","失败："+e.getMessage()+","+e.getErrorCode());
                }
            }
        });
    }

}
