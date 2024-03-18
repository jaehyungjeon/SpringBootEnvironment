package com.example.personal.MybatisRepository;

import java.util.List;

import com.example.personal.Boot.CustomMapper;
import org.apache.ibatis.annotations.Mapper;

import com.example.personal.Dto.Member;
import com.example.personal.Dto.MemberDto;

//@Mapper
@CustomMapper // CUSTOM하여 MAPPER 어노테이션 재정의
public interface MainMybatisRepository {
	List<Member> searchMemberList(Member member);

	List<MemberDto> searchMemberDtoList(MemberDto member);
}
