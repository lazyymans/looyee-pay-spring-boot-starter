package com.looyee.wxpay.common;

import com.alibaba.fastjson.JSON;

public class JsonUtil {

	public static <T> T JsonStr2Object(String jsonStr, Class<T> clazz) {
		JSON json = JsonObjStr2Json(jsonStr);
		return Json2Object(json, clazz);
	}

	public static <T> T Json2Object(JSON json, Class<T> clazz) {
		return JSON.toJavaObject(json, clazz);
	}

	public static JSON Object2Json(Object object) {
		return (JSON) JSON.toJSON(object);
	}

	public static String Object2JsonStr(Object object) {
		return JSON.toJSONString(object);
	}

	public static JSON JsonObjStr2Json(String jsonStr) {
		return JSON.parseObject(jsonStr);
	}

	public static JSON JsonArrayStr2Json(String jsonStr) {
		return JSON.parseArray(jsonStr);
	}

}