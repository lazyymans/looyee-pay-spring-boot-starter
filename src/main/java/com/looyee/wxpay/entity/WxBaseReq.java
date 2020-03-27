package com.looyee.wxpay.entity;

import lombok.Getter;
import lombok.Setter;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * 描述: 微信请求基本实体</br>
 * 功能：微信请求基本实体封装</br>
 * 作者：luoyc</br>
 * 时间:2018-5-31 14:21:00</br>
 */
@Setter
@Getter
public class WxBaseReq {

    public String key;

    public String requestUrl;

    public Map<String, Object> toMap() {
        Map<String, Object> map = new HashMap<>();
        Field[] fields = this.getClass().getDeclaredFields();
        Field[] declaredFields = this.getClass().getSuperclass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            Object obj;
            try {
                //得到变量对应的值
                obj = field.get(this);
                if (obj != null) {
                    map.put(field.getName(), obj);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        for (Field declaredField : declaredFields) {
            declaredField.setAccessible(true);
            Object obj;
            try {
                //得到变量对应的值
                obj = declaredField.get(this);
                if (obj != null) {
                    if (declaredField.getName().equals("key")) {
                        map.put(declaredField.getName(), obj);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return map;
    }


}
