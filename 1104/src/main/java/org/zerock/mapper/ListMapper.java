package org.zerock.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface ListMapper<E> {
	
	//���� ������ �Է� �� �����θ������
	public List<E> selectList(@Param("skip") int skip, @Param("��") int skip);
	
}
