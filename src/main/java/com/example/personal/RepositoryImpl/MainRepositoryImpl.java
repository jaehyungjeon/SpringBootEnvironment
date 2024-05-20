package com.example.personal.RepositoryImpl;

import com.example.personal.Dto.Information.InformationEntity;
import com.example.personal.Dto.Member;
import com.example.personal.Repository.MainCustomRepository;
import com.querydsl.core.Tuple;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.thymeleaf.util.StringUtils;

import java.util.List;

import static com.example.personal.Dto.Information.QInformationEntity.informationEntity;
import static com.example.personal.Dto.QMember.member;

@Repository
@RequiredArgsConstructor
public class MainRepositoryImpl implements MainCustomRepository {
	private final JPAQueryFactory jpaQueryFactory;

	/*
	 * 작성일 : 2024.03.07
	 * 내 용 : 회원 리스트 조회 - jpa, queryDSL 사용
	 **/
	@Override
	public List<Member> findAllMembersList() {
		return jpaQueryFactory.select(member).from(member).fetch();
	};

	/*
	 * 작성일 : 2024.03.07
	 * 내 용 : 회원 리스트 조회 - jpa, queryDSL 사용, 옵션정보 추가
	 **/
	@Override
	public List<Member> findAllMembersList2() {
		return jpaQueryFactory.selectFrom(member).where(member.name.eq("전제형")).fetch();
	}

	@Override
	public List<InformationEntity> findJoinMemberList() {
		return jpaQueryFactory.select(informationEntity)
				.from(informationEntity)
				.join(member)
				.on(informationEntity.id.eq(member.id))
				.fetch();
	}

	/*
	 * 작성일 : 2024.03.07
	 * 내 용 : 회원 리스트 조회 - jpa, queryDSL 사용, 전체 컬럼
	 **/
	@Override
	public List<Tuple> findJoinMemberAllColumnList() {
		return jpaQueryFactory.select(informationEntity, member)
				.from(informationEntity)
				.join(member)
				.on(informationEntity.id.eq(member.id))
				.fetch();
	}

	/*
	 * 작성일 : 2024.03.08
	 * 내 용 : 회원정보 갱신 - queryDSL을 활용한 update
	 **/
	@Transactional
	public void updateMember(Member mem) {
		String id = StringUtils.isEmpty(mem.getId()) ? "TestTest" : mem.getId();
		jpaQueryFactory.update(member).
				set(member.id, id).
				where(member.name.eq("테스트")).
				execute();
	}
}
