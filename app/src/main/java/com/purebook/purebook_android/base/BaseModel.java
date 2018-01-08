package com.purebook.purebook_android.base;

/**
 * Created by chrischen on 2018/1/7.
 */

public class BaseModel {

    private BaseRequestCallBack callBack;
    //public NetworkRequestClient httpClient;

    public BaseModel(BaseRequestCallBack callBack) {
        this.callBack = callBack;
        //httpClient = NetworkRequestClient.getInstance();
    }

    /**public NetworkExecutor getExecutor(Class<?> mClass) {
        NetworkExecutor networkExecutor = new NetworkExecutor(new NetworkRequestListener() {
            @Override
            public void onRequestBefore() {
                callBack.RequestBefore();
            }

            @Override
            public void onRequestSuccess(Object object) {
                callBack.RequestSuccess(object);
            }

            @Override
            public void onRequestFail(String msg) {
                callBack.RequestFail(msg);
            }

            @Override
            public void onRequestComplete() {
                callBack.RequestComplete();
            }
        }, mClass);
        return networkExecutor;
    }
     **/
}
