package com.multi.fineapple.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.multi.fineapple.vo.MemberVO;


@Component
public class MemberDAO {
	
	@Autowired
	SqlSessionTemplate my;
	
	public void insert(MemberVO vo) {
		my.insert("member.create", vo);
	}
	
	public MemberVO one(MemberVO vo) {
		return my.selectOne("member.one", vo);
	}
	
	public void update(MemberVO vo) {
		my.update("member.up", vo);
	}
	
	public void delete(MemberVO vo) {
		my.delete("member.delete", vo);
	}
}
