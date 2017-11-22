package com.springtest.chapter5.one;

import java.util.List;

public interface SpittleRepository {

	List<Spittle> findSpittles(long max,int count);
	
	
	
	
}
