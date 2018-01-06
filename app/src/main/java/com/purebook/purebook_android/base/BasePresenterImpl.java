package com.purebook.purebook_android.base;

/**
 * Created by chrischen on 2018/1/6.
 */

public class BasePresenterImpl<V extends BaseView> implements BasePresenter<V> {
    protected V mView;

    @Override
    public void attachView(V view) {
        this.mView=view;
    }

    @Override
    public void detachView() {
        this.mView=null;
    }
}
