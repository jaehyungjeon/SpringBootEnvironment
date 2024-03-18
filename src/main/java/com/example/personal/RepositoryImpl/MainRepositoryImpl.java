package com.example.personal.RepositoryImpl;

import com.example.personal.Dto.Member;
import com.example.personal.Dto.QMember;
import com.example.personal.Repository.MainCustomRepository;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.thymeleaf.util.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	public void updateMember(Member mem) {
		String id = StringUtils.isEmpty(mem.getId()) ? "TestTest" : mem.getId();
		jpaQueryFactory.update(member).
				set(member.id, id).
				where(member.name.eq("테스트")).
				execute();
	}
}
