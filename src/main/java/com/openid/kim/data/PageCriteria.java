package com.openid.kim.data;

/**
 * 저장소(Repository) 연산에서 사용하기 위한 
 * 페이지 기준에 대한 interface이다. 
 * @author dream
 *
 */
public interface PageCriteria {
	public int getPageNumber();
	public int getPageSize();
}
