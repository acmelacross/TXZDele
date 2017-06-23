package com.txzdele.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.txzdele.R;
import com.txzdele.modle.TXZOrders;
import com.txzdele.modle.TXZUsers;
import com.txzdele.utils.LogUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.datatype.BmobDate;
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

        initDaiLiData();


//以下是测试数据
        TXZOrders gameScore = new TXZOrders();
        gameScore.setAccount("01234");
        gameScore.setPassword("12345");
        gameScore.setTxzuser(BmobUser.getCurrentUser(TXZUsers.class));
        gameScore.save(new SaveListener<String>() {

            @Override
            public void done(String objectId, BmobException e) {
                if(e==null){
                    LogUtil.i("bmob","数据成功 ："+e.getMessage()+","+e.getErrorCode());
                }else{
                    LogUtil.i("bmob","失败："+e.getMessage()+","+e.getErrorCode());
                }
            }
        });
    }
private String strData="您现在共有  ";
    private void initOrderData() {







        BmobQuery<TXZOrders> query = new BmobQuery<TXZOrders>();
//查询playerName叫“比目”的数据
//        query.addWhereEqualTo("txzuser", BmobUser.getCurrentUser(TXZUsers.class));
//返回50条数据，如果不加上这条语句，默认返回10条数据
        query.setLimit(99999);
        query.order("createdAt");
if(firstDaili.size() == 0){//木有代理 计算自己的业绩
    query.addWhereEqualTo("txzuser", BmobUser.getCurrentUser(TXZUsers.class));
}else{//有代理 计算代理和自己的业绩
    ArrayList<String> arr = new ArrayList<>();
    String[] names = new   String[firstDaili.size()];
    for (int i = 0;i<firstDaili.size();i++ ){
       // names[i] = firstDaili.get(i).getObjectId();
        arr.add(firstDaili.get(i).getObjectId());
    }
//最后加一下自己的业绩
    arr.add(BmobUser.getCurrentUser(TXZUsers.class).getObjectId());
    query.addWhereContainedIn("txzuser", arr);
}
//计算一下 当月的 数据
        String currentMouth  = new  SimpleDateFormat("yyyy-MM").format(new Date()) +"-01 00:00:00";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date currentMouthDate  = null;
        try {
            currentMouthDate = new  SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(currentMouth);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        query.addWhereGreaterThanOrEqualTo("createdAt",new BmobDate(currentMouthDate));
//执行查询方法

        query.findObjects(new FindListener<TXZOrders>() {
            @Override
            public void done(List<TXZOrders> object, BmobException e) {
                if(e==null){
                   // toast("查询成功：共"+object.size()+"条数据。");
                    LogUtil.d("查询成功：共"+object.size()+"条数据。");
                    strData+=" 总销售业绩 "+object.size()+"个, ";
                    int myYeJiCount = 0;
                    for (TXZOrders gameScore : object) {
                        //获得数据的objectId信息
                        gameScore.getObjectId();
                        //获得createdAt数据创建时间（注意是：createdAt，不是createAt）
                        gameScore.getCreatedAt();
                        if(gameScore.getTxzuser().getObjectId().equals(BmobUser.getCurrentUser(TXZUsers.class).getObjectId())){
                            myYeJiCount++;
                        }
                    }
                    strData+="个人业绩 "+myYeJiCount+"个";
                    tvYejiInfo.setText(strData);
                }else{
                    LogUtil.i("bmob","失败："+e.getMessage()+","+e.getErrorCode());
                }
            }
        });



    }
    List<TXZUsers> firstDaili ;
    private void initDaiLiData() {
//        BmobQuery<TXZUsers> query = new BmobQuery<TXZUsers>();
//        query.addWhereEqualTo("father", BmobUser.getCurrentUser(TXZUsers.class));
////返回50条数据，如果不加上这条语句，默认返回10条数据
//        query.setLimit(99999);
////执行查询方法
//        query.findObjects(new FindListener<TXZUsers>() {
//            @Override
//            public void done(List<TXZUsers> object, BmobException e) {
//                if(e==null){
//                    // toast("查询成功：共"+object.size()+"条数据。");
//                    LogUtil.d("查询成功：共"+object.size()+"条数据。");
//                    strData+="一级代理 "+object.size()+"名";
//                    for (TXZUsers gameScore : object) {
//                        //获得数据的objectId信息
//                        gameScore.getObjectId();
//                        //获得createdAt数据创建时间（注意是：createdAt，不是createAt）
//                        gameScore.getCreatedAt();
//                    }
//                    tvYejiInfo.setText(strData);
//                }else{
//                    LogUtil.i("bmob","失败："+e.getMessage()+","+e.getErrorCode());
//                }
//            }
//        });



        BmobQuery<TXZUsers> query = new BmobQuery<TXZUsers>();
        query.addWhereEqualTo("father", BmobUser.getCurrentUser(TXZUsers.class));
//返回50条数据，如果不加上这条语句，默认返回10条数据
        query.setLimit(99999);


//执行查询方法
        query.findObjects(new FindListener<TXZUsers>() {
            @Override
            public void done(List<TXZUsers> object, BmobException e) {
                if(e==null){
                    // toast("查询成功：共"+object.size()+"条数据。");
                    LogUtil.d("查询成功：共"+object.size()+"条数据。");
                    strData+="一级代理 "+object.size()+"名, ";
                    for (TXZUsers gameScore : object) {
                        //获得数据的objectId信息
                        gameScore.getObjectId();
                        //获得createdAt数据创建时间（注意是：createdAt，不是createAt）
                        gameScore.getCreatedAt();
                    }
                    firstDaili = object;
                    if(object.size()==0){
                        firstDaili = new ArrayList<TXZUsers>();
                    }
                    initOrderData();
                }else{
                    LogUtil.i("bmob","失败："+e.getMessage()+","+e.getErrorCode());
                    firstDaili = new ArrayList<TXZUsers>();
                }
            }
        });
    }

}
