package org.zerock.mapper;

import org.springframework.stereotype.Repository;
import org.zerock.domain.BoardVO;

@Repository
public interface BoardMapper extends CrudMapper<BoardVO, Integer>, ListMapper<BoardVO> {
	
}
