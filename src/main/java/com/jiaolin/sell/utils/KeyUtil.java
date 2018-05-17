package com.jiaolin.sell.utils;

import java.util.Random;

/**
 * @Auther: Joinlin
 * @Descriptional: 生产随机数
 * @Date: Create in 10:07 2018/4/26
 * @Modify By:
 */
public class KeyUtil {

	/**
	 * random.nextInt(900000) 从0到900000的数字,包含0 不包含900000
	 * +100000一定为6位数
	 * 生成唯一的主键
	 * @return
	 */
	public static synchronized String  getUniqueKey(){
		Random random=new Random();
		int number = random.nextInt(900000) + 100000;
		return System.currentTimeMillis()+String.valueOf(number);
	}
}
