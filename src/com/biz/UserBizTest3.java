package com.biz;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import com.vo.TimetableVO;

class UserBizTest3 {

	@Test
	void testSelectMoiveTime() {
		UserBiz biz = null;
		ArrayList<TimetableVO> list = null;
		try {
			biz = new UserBiz();
			list= biz.SelectMoiveTime("m001");
			for (TimetableVO t : list) {
				System.out.println(t);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
