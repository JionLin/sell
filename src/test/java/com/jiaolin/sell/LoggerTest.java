package com.jiaolin.sell;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class LoggerTest {

	@Test
	public void testLogger(){
		String username="root";
		String password="root";
		log.info("username : {},password: {}",username,password);
		log.debug("11");
		log.info("222");
		log.error("33");

	}

}
