package com.ict.delivirko.Interfaces;

public interface UniversalStringCallBack {
    void OnError(String str);

    void onFailure(String str);

    void onFinish();

    void onResponse(String str);
}
