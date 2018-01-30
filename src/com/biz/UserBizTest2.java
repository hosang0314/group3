package com.biz;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import com.vo.MovieVO;

class UserBizTest2 {

	@Test
	void testRegisterUser() {
		UserBiz biz = null;
		ArrayList<MovieVO> list = null;
		try {
			biz = new UserBiz();
			biz.registerUser("iu", 25);
		} catch(Exception e) {
			
		}
	}

}
