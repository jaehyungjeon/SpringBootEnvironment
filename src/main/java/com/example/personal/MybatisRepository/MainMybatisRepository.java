package com.example.personal.MybatisRepository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.personal.Dto.Member;
import com.example.personal.Dto.MemberDto;

@Mapper
public interface MainMybatisRepository {
	List<Member> searchMemberList(Member member);
	List<MemberDto> searchMemberDtoList(Member member);
}
