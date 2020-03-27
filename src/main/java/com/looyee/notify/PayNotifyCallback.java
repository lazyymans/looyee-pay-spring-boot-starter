package com.looyee.notify;

public interface PayNotifyCallback<T> {

    default boolean doInNotifyBusiness(T resData) {
        return true;
    }

}
