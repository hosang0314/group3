package com.biz;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import com.vo.TimetableVO;

class UserBizTestTimeList {

	@Test
	void test() {
		UserBiz biz = null;
		ArrayList<TimetableVO> list = null;
		try {
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
