package com.jiaolin.sell.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * @Auther: Joinlin
 * @Descriptional:
 * @Date: Create in 11:35 2018/5/10
 * @Modify By:
 */
public class JsonUtil {
	public static String toJson(Object object){
		GsonBuilder gsonBuilder=new GsonBuilder();
		gsonBuilder.setPrettyPrinting();
		Gson gson=gsonBuilder.create();
		return gson.toJson(object);
	}
}
