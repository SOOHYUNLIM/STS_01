package org.zerock.controller;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class LoadingTests {

	@Autowired	//inject = javax
	private ApplicationContext ctx;
	
	@Test
	public void test1() {
		//sprig은 정상일시 어플리케이션 컨택스트 생성!
		assertNotNull(ctx);
		log.info(ctx);
	}
	
}
