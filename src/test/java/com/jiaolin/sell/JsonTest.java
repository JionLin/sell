package com.jiaolin.sell;

import com.google.gson.Gson;
import org.junit.Assert;

/**
 * @Auther: Joinlin
 * @Descriptional:
 * @Date: Create in 10:53 2018/4/28
 * @Modify By:
 */
public class JsonTest {
	private static void log(String msg) {
		System.out.println(msg);
	}

	public static void main(String[] args) throws Exception {
		Gson gson = new Gson();
		Student student = new Student();
		student.setName("xuanyouwu");
		student.setAge(26);
		String jsonStr = gson.toJson(student);
		log("---->javabean convert jsonStr:" + jsonStr);
		Assert.assertTrue("测试所有",student.getAge()>28);
	}

}
