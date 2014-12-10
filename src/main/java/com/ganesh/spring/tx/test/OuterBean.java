package com.ganesh.spring.tx.test;

import com.ganesh.spring.tx.model.User;

public interface OuterBean {

	void testRequired(User user);
	
	void testRequiresNew(User user);

}
