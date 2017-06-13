package com.txzdele.utils;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * User: F1330296
 * Date: 2017/2/21 10:28
 * Function:万能ViewHolder
 */

public class ViewHolder {
    private final SparseArray<View> sparseArray;
    private View mview;

    /**
     * 实例化
     *
     * @param context
     * @param viewGroup
     * @param Layout
     * @param postsion
     */
    public ViewHolder(Context context, ViewGroup viewGroup, int Layout, int postsion) {
        this.sparseArray = new SparseArray<>();
        mview = LayoutInflater.from(context).inflate(Layout, viewGroup, false);
        mview.setTag(this);
    }

    /**
     * 拿到 Viewholder对象
     *
     * @param context
     * @param convertview
     * @param viewGroup
     * @param layout
     * @param posttion
     * @return
     */
    public static ViewHolder getView(Context context, View convertview, ViewGroup viewGroup, int layout, int posttion) {
        if (convertview == null) {
            return new ViewHolder(context, viewGroup, layout, posttion);
        }
        return (ViewHolder) convertview.getTag();
    }

    /**
     * 通过ID获取控件,没有则加入sparseArray
     *
     * @param id
     * @param <T>
     * @return
     */
    public <T extends View> T getId(int id) {
        View view = sparseArray.get(id);
        if (view == null) {
            view = mview.findViewById(id);
            sparseArray.put(id, view);
        }
        return (T) view;
    }

    /**
     * 返回
     *
     * @return
     */
    public View getconverView() {
        return mview;
    }
}
