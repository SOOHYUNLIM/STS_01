package org.zerock.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface ListMapper<E> {
	
	//변수 여러개 입력 시 맵으로만들어줌
	public List<E> selectList(@Param("skip") int skip, @Param("므") int skip);
	
}
