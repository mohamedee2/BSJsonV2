package com.rasd.bsjson.Interface;

public interface BSJsonV2Listener {
    void onLoaded(String response);
    void onError(String error);
}
