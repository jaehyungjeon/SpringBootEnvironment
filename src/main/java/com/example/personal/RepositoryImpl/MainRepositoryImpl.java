package com.example.personal.RepositoryImpl;

import com.example.personal.Dto.Member;
import com.example.personal.Repository.MainCustomRepository;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.example.personal.Dto.QMember.member;

@Repository
@RequiredArgsConstructor
public class MainRepositoryImpl implements MainCustomRepository {
	private final JPAQueryFactory jpaQueryFactory;

	@Override
	public List<Member> findAllMembersList() {
		return jpaQueryFactory.select(member).from(member).fetch();
	};

	@Override
	public List<Member> findAllMembersList2() {
		return jpaQueryFactory.selectFrom(member).where(member.name.eq("전제형")).fetch();
	}

	@Transactional
	public void updateMember() {
		jpaQueryFactory.update(member).
				set(member.id, "id변경").
				where(member.name.eq("테스트")).
				execute();
	}
}
