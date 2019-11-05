package org.zerock.mapper;

public interface CrudMapper<E, K> {
	
	public int insert(E vo);
	
	public E select(K key);
	
	public int update(E vo);
	
	public int delete(K key);
	
}
