package org.zerock.mapper;

import static org.junit.Assert.assertNotNull;

import java.util.stream.IntStream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardMapperTests {
	
	@Autowired
	private BoardMapper mapper;
	
	@Test
	public void testSelectList() {
		//mapper.selectList(10).forEach(log::info);
	}
	
	@Test
	public void testInsert() {
		IntStream.range(1,101).forEach(i->{
			BoardVO vo = new BoardVO();
			vo.setTitle("제목..."+i);
			vo.setContent("내용......"+i);
			vo.setWriter("user"+i);
			int count = mapper.insert(vo);
			log.info(count);
		});
	}
	
	@Test
	public void test1() {
		log.info(mapper);
		assertNotNull(mapper);
	}
	
}
