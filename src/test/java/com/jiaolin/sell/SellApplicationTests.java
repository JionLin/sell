package com.jiaolin.sell;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SellApplicationTests {

	@Test
	public void contextLoads() {
		String token = UUID.randomUUID().toString();
//		String s = String.format(RedisConstant.REDIS_PRIFIX, token);
		String s = String.format("123_%s", token);
		System.out.println("token:"+token);
		System.out.println("s:"+s);
		//String token = UUID.randomUUID().toString();

		String format222 = String.format("123", token);
		System.out.println(token);
		System.out.println(format222);
	}

}
