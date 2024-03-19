package com.example.personal.MybatisRepository;

import java.util.List;

import com.example.personal.Boot.CustomMapper;

import com.example.personal.Dto.Information.Information;
import com.example.personal.Dto.Member;
import com.example.personal.Dto.MemberDto;

//@Mapper
@CustomMapper // CUSTOM하여 MAPPER 어노테이션 재정의
public interface MainMybatisRepository {

	/*
	 * 작성일 : 2024.03.07
	 * 내 용 : 회원 리스트 조회 - Entity 사용
	 **/
	List<Member> searchMemberList(Member member);

	/*
	 * 작성일 : 2024.03.07
	 * 내 용 : 회원 리스트 조회 - 객체 사용
	 **/
	List<MemberDto> searchMemberDtoList(MemberDto member);

	/*
	 * 작성일 : 2024.03.19
	 * 내 용 : 회원 리스트 조회 - Member, Information 테이블 조인
	 **/
	List<Information> searchMemeberJoinList(MemberDto member);
}
