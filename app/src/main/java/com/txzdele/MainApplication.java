package com.txzdele;

import android.app.Application;

import com.txzdele.utils.LogUtil;

import cn.bmob.v3.Bmob;

public class MainApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        initAllSDKS();
    }

    private void initAllSDKS() {
        LogUtil.d("initAllSDKS");
        //SMSSDK.initSDK(this, "1b6ff869a9c09", "fbf6bcdfe2edb9b9f404af9dd62c4e2");
        initBmob();
        Config.getInstance().application = this;
//		initTalkingdata();
    }

//	private void initTalkingdata() {
//		TCAgent.LOG_ON=true;
//		// App ID: 在TalkingData创建应用后，进入数据报表页中，在“系统设置”-“编辑应用”页面里查看App ID。
//		// 渠道 ID: 是渠道标识符，可通过不同渠道单独追踪数据。
//		TCAgent.init(this);
//		// 如果已经在AndroidManifest.xml配置了App ID和渠道ID，调用TCAgent.init(this)即可；或与AndroidManifest.xml中的对应参数保持一致。
//		TCAgent.setReportUncaughtExceptions(true);
//	}

    //	private void initZx() {
//		ZXingLibrary.initDisplayOpinion(this);
//	}

    private  void initBmob(){
        //第一：默认初始化
        Bmob.initialize(this, "01930c9d1339e14529d6fe24262c7342");

        //第二：自v3.4.7版本开始,设置BmobConfig,允许设置请求超时时间、文件分片上传时每片的大小、文件的过期时间(单位为秒)，
        //BmobConfig config =new BmobConfig.Builder(this)
        ////设置appkey
        //.setApplicationId("Your Application ID")
        ////请求超时时间（单位为秒）：默认15s
        //.setConnectTimeout(30)
        ////文件分片上传时每片的大小（单位字节），默认512*1024
        //.setUploadBlockSize(1024*1024)
        ////文件的过期时间(单位为秒)：默认1800s
        //.setFileExpiration(2500)
        //.build();
        //Bmob.initialize(config);

//        TXZUsers us = new TXZUsers();
//        us.setUserName("aaaaaaaaaaaaaaa");
//        us.setUserNumber("bbbb");
//        us.save(new SaveListener<String>() {
//            @Override
//            public void done(String objectId,BmobException e) {
//                if(e==null){
//                    LogUtil.d("添加数据成功，返回objectId为："+objectId);
//                    System.out.print("添加数据成功，返回objectId为："+objectId);
//                   // toast("添加数据成功，返回objectId为："+objectId);
//                }else{
//                    LogUtil.d("创建数据失败：" + e.getMessage());
//                    System.out.print("创建数据失败：" + e.getMessage());
//                  //  toast("创建数据失败：" + e.getMessage());
//                }
//            }
//        });

//        Person p2 = new Person();
//        p2.setName("lucky");
//        p2.setAddress("北京海淀");
//        p2.save(new SaveListener<String>() {
//            @Override
//            public void done(String objectId,BmobException e) {
//                if(e==null){
//                    System.out.print("添加数据成功，返回objectId为："+objectId);
//                   // toast("添加数据成功，返回objectId为："+objectId);
//                }else{
//                    System.out.print("创建数据失败：" + e.getMessage());
//                  //  toast("创建数据失败：" + e.getMessage());
//                }
//            }
//        });
        System.out.println("initBMOB");
    }
}