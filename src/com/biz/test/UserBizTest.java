package com.biz.test;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import com.biz.UserBiz;

class UserBizTest {

	@Test
	void testIdCheck() throws ClassNotFoundException, SQLException {
		UserBiz biz = new UserBiz();
		try {
			String id = null;
			id = biz.idCheck("id789");
			System.out.println(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
