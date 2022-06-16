package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.GuestBookVo;


@Repository
public class GuestBookDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	
	public List<GuestBookVo> guestBookList() {
		System.out.println("GuestBookDao > guestBookList");
		List<GuestBookVo> guestList = sqlSession.selectList("guestbook.selectList");
		
		return guestList;
	}
	
	public int guestBookInsert(GuestBookVo guestBookVo) {
		System.out.println("GuestBookDao > guestBookInsert");
		int count = sqlSession.insert("guestbook.insert", guestBookVo);
	
		return count;
	}
	
	public int guestBookDelete(GuestBookVo guestBookVo) {
		System.out.println("GuestBookDao > guestBookDelete");
		int count = sqlSession.delete("guestbook.delete", guestBookVo);
		
		return count;
	}
	
	
	public GuestBookVo guestBookList(int no) {
		System.out.println("GuestBookDao > guestBookList(int no)");
		GuestBookVo guest = sqlSession.selectOne("guestbook.selectUser", no);
		
		return guest;
	}
	
	
	
}
