package com.example.personal.Repository;

import com.example.personal.Dto.Information.Information;
import com.example.personal.Dto.Information.InformationEntity;
import com.example.personal.Dto.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MainRepository extends JpaRepository<Member, String>, MainCustomRepository {

	/*
	 * 작성일 : 2024.03.07
	 * 내 용 : 회원 리스트 조회 - jpa, @Query Annotation 사용
	 **/
	@Query("SELECT p FROM Member p")
	List<Member> findAllMemberList();

	/*
	 * 작성일 : 2024.03.19
	 * 내 용 : 회원 리스트 조회 - jpa, @Query Annotation 사용, 테이블 조인 케이스
	 **/
	@Query("SELECT a.id, a.password, b.use_yn FROM Member a, InformationEntity b WHERE a.id = b.id AND a.id = 'jaehyung601'")
	List<?> findMemeberJoinList();

	/*
	 * 작성일 : 2024.03.07
	 * 내 용 : 회원 리스트 조회 - queryDSL overriding
	 **/
	@Override
	List<Member> findAllMembersList();
}
