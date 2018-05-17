package com.jiaolin.sell;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.*;

/**
 * @Auther: Joinlin
 * @Descriptional: List Map转Json字符串
 * @Date: Create in 10:56 2018/4/28
 * @Modify By:
 */
public class JsonTest1 {
	private static void log(String msg) {
		System.out.println(msg);
	}


	public static void main(String[] args) throws Exception {
		Gson gson = new Gson();

		//List Map转Json字符串
		/*
		List<String> list = Arrays.asList("1", "a", "3", "rt", "5");
		log("---->list convert jsonStr:" + gson.toJson(list));

		Map<String, Object> content = new HashMap<String, Object>();
		content.put("name", "xuanyouwu");
		content.put("age", "26");
		log("---->map convert jsonStr:" + gson.toJson(content));*/

		//把json转换为对象
	/*
	String studentJsonStr="{\"name\":\"xuanyouwu\",\"age\":26}";

		Student student1 = gson.fromJson(studentJsonStr, Student.class);
		log("------->json convert JavaBean:"+student1);*/

		//把json转换为list
		String listJsonStr = "[\"1\",\"a\",\"3\",\"rt\",\"5\"]";
		Type type = new TypeToken<ArrayList<String>>() {
		}.getType();
		ArrayList<String> sList=gson.fromJson(listJsonStr, type);
		log("------->json convert List:"+sList);
	}
}
