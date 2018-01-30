package com.biz;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import com.vo.MovieVO;

class UserBizTest {

	@Test
	void testGanreSelectMoives() {
		UserBiz biz = null;
		ArrayList<MovieVO> list = null;
		try {
			biz = new UserBiz();
			list = biz.ganreSelectMoives("애니메이션");
			for (MovieVO movieVO : list) {
				System.out.println(movieVO);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
