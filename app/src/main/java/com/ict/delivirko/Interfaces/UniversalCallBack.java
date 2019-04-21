package com.ict.delivirko.Interfaces;

public interface UniversalCallBack {
    void OnError(String str);

    void onFailure(Object obj);

    void onFinish();

    void onResponse(Object obj);
}
