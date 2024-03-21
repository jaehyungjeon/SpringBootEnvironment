package com.example.personal.Repository;

import com.example.personal.Dto.Information.InformationEntity;
import com.example.personal.Dto.Member;
import com.querydsl.core.Tuple;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MainCustomRepository {

	/*
	 * 작성일 : 2024.03.07
	 * 내 용 : 회원 리스트 조회 - queryDSL 사용을 위한 repository 선언
	 **/
	List<Member> findAllMembersList();

	/*
	 * 작성일 : 2024.03.07
	 * 내 용 : 회원 리스트 조회 - queryDSL 사용을 위한 repository 선언(옵션 반영)
	 **/
	List<Member> findAllMembersList2();

	/*
	 * 작성일 : 2024.03.21
	 * 내 용 : 회원 리스트 조회 - queryDSL Join 조회
	 **/
	List<InformationEntity> findJoinMemberList();

	List<Tuple> findJoinMemberAllColumnList();
}
