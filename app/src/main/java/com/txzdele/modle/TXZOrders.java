package com.txzdele.modle;

import cn.bmob.v3.BmobUser;

/**
 * 作者--> coding  on 2017/6/13.
 * com.txzdele.modle
 *
 * 邮箱--> www14159@163.com
 * Created by coding on 2017/6/13.
 */

public class TXZOrders extends BmobUser {
    private String account;
    private String password;
    private TXZUsers txzuser;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public TXZUsers getTxzuser() {
        return txzuser;
    }

    public void setTxzuser(TXZUsers txzuser) {
        this.txzuser = txzuser;
    }
}
