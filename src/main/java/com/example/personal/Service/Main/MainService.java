package com.example.personal.Service.Main;

import com.example.personal.Dto.Information.Information;
import com.example.personal.Dto.Information.QInformationEntity;
import com.example.personal.Dto.Member;
import com.example.personal.Dto.MemberDto;
import com.example.personal.Dto.QMember;
import com.example.personal.MybatisRepository.MainMybatisRepository;
import com.example.personal.Repository.MainRepository;
import com.example.personal.RepositoryImpl.MainRepositoryImpl;
import com.querydsl.core.Tuple;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;import com.example.personal.Dto.Information.InformationEntity;

@Service
@Slf4j
public class MainService extends BaseService {

	@Autowired
	private MainRepository mainRepository;

	@Autowired
	private MainMybatisRepository mainMybatisRepository;

	@Autowired
	private MainRepositoryImpl mainRepositoryImpl;

	@Autowired
	private MessageSourceAccessor messageSourceAccessor;

	/*
	 * 작성일 : 2024.03.04
	 * 내 용 : 메인 페이지 조회
	 **/
	public void initMain(Member member) throws Exception {
		System.out.println("서비스 호출");
		log.info("메시지 다이렉트 사용1={}", messageSourceAccessor.getMessage("main.test", "바보", Locale.US));
		log.info("메시지 다이렉트 사용2={}", messageSourceAccessor.getMessage("root.test", "루트에서 꺼내옴"));
		log.info("메시지 다이렉트 사용3={}", messageSourceAccessor.getMessage("root.korean"));

		log.info("메시지 추상클래스 사용1={}", Message("main.test", "바보", Locale.US));
		log.info("메시지 추상클래스 사용2={}", Message("root.test", "루트에서 꺼내옴"));
		log.info("메시지 추상클래스 사용3={}", Message("root.korean"));

		logger.debug("DEBUG!!!!!");

		/* jpa 사용 */
		List<Member> lMember = mainRepository.findAll();
		for(Member b : lMember) {
			log.info("jpa 기본 메소드 사용했을 때 {}", b);
		}

		/* jpa 커스텀 메소드 사용 */
		List<Member> queryMemberList = mainRepository.findAllMemberList();
		for(Member b : queryMemberList) {
			log.info("jpa 커스텀 메소드 사용했을 때 {}", b);
		}

		/* MyBatis 사용 */
		List<Member> mybatisMemberList = mainMybatisRepository.searchMemberList(member);
		for(Member b : mybatisMemberList) {
			log.info("마이바티스 사용했을 때 {}", b);
		}

		/* queryDSL 사용 */
		List<Member> queryDSLMemberList = mainRepositoryImpl.findAllMembersList();
		for(Member b : queryDSLMemberList) {
			log.info("쿼리DSL 사용했을 때 {}", b);
		}

		/* queryDSL 사용(where 조건문 추가) */
		List<Member> queryDSLMemberOptList = mainRepositoryImpl.findAllMembersList2();
		for(Member b : queryDSLMemberOptList) {
			log.info("쿼리DSL을 활용하여 where 조건문을 반영했을 때 {}", b);
		}

		/* queryDSL -> jpa로 override 사용 */
		List<Member> mainRepositoryOverrideList = mainRepository.findAllMembersList();
		for(Member b : mainRepositoryOverrideList) {
			log.info("쿼리DSL을 Override 하여 사용했을 때 {}", b);
		}

		/* MyBatis join By resultMap */
		MemberDto memberDto = new MemberDto();
		List<Information> memberJoinInformList = mainMybatisRepository.searchMemeberJoinList(memberDto);
		for(Information m : memberJoinInformList) {
			log.info("조인된 memberDto의 값 {}", m.getMemberDto());
			log.info("조인된 information의 사용여부 값 {}", m.getUse_yn());
		}

		/* builder를 통한 option값 추가 시 */
		memberDto = MemberDto.builder().id("jaehyung03").build();
		List<Information> memberJoinInformOptList = mainMybatisRepository.searchMemeberJoinList(memberDto);
		for(Information m : memberJoinInformOptList) {
			log.info("옵션 + 조인된 memberDto의 값 {}", m.getMemberDto());
			log.info("옵션 + 조인된 information의 사용여부 값 {}", m.getUse_yn());
		}

		/*
		 * join id value Change Array
		 **/
		String[] memberIdArray = memberJoinInformList.parallelStream().map(o -> {
			if(!ObjectUtils.isEmpty(o.getMemberDto())){
				return o.getMemberDto();
			}
			return new MemberDto();
		}).map(MemberDto::getId).collect(Collectors.toList()).toArray(new String[]{});

		memberDto = MemberDto.builder().idArrayList(memberIdArray).build();
		List<Information> memberJoinMultiList = mainMybatisRepository.searchMemeberJoinMultiList(memberDto);
		for(Information m : memberJoinMultiList) {
			log.info("다중 memberDto의 값 {}", m.getMemberDto());
			log.info("다중 information의 사용여부 값 {}", m.getUse_yn());
		}

		/* jpq 조인 시 */
		for(Object o : findMemeberJoinList()) {
			logger.debug("jpa 조인했을 때 {}", o);
		}

		/* queryDSL 조인 시(1. InformationEntity의 값만을 가져온다) */
		List<InformationEntity> findJoinMemberList = mainRepositoryImpl.findJoinMemberList();
		for(InformationEntity o : findJoinMemberList) {
			logger.debug("InformEntity의 id값 {}", o.getId());
			logger.debug("InformEntity의 use_yn값 {}", o.getUse_yn());
		}

		/* queryDSL 조인 시(2. InformationEntity, MemberEntity의 값 모두를 가져온다) */
		List<Tuple> findJoinMemberAllColumnList = mainRepositoryImpl.findJoinMemberAllColumnList();
		for(Tuple tuple : findJoinMemberAllColumnList) {
			InformationEntity inform = tuple.get(QInformationEntity.informationEntity);
			Member memberEntity = tuple.get(QMember.member);

			logger.debug("===============================================");
			logger.debug("회원 ID {}", memberEntity.getId());
			logger.debug("회원 PASSWORD {}", memberEntity.getPassword());
			logger.debug("회원 NAME {}", memberEntity.getName());
			logger.debug("회원 USE_YN {}", inform.getUse_yn());
			logger.debug("===============================================");
		}
	}

	/*
	 * 작성일 : 2024.03.07
	 * 내 용 : 회원 리스트 조회 - jpa, queryDSL 사용
	 **/
	public List<Member> returnQueryMemberList(Member member) throws Exception {
		return mainRepositoryImpl.findAllMembersList();
	}

	/*
	 * 작성일 : 2024.03.07
	 * 내 용 : 회원 리스트 조회 - 객체 사용
	 **/
	public List<MemberDto> searchMember(MemberDto member) throws Exception {
		/* Object Builder Use */
		member = MemberDto.builder().name("QQ").build();
		return mainMybatisRepository.searchMemberDtoList(member);
	}

	/*
	 * 작성일 : 2024.03.07
	 * 내 용 : 회원 리스트 조회 - 객체 사용
	 **/
	public List<MemberDto> searchMemberAlias(MemberDto member) throws Exception {
		/* Object Builder Use */
		member = MemberDto.builder().name("QQ").build();
		return mainMybatisRepository.searchMemberDtoAliasList(member);
	}

	/*
	 * 작성일 : 2024.03.07
	 * 내 용 : 회원 리스트 조회 - Entity 사용
	 **/
	public List<Member> searchMember(Member member) throws Exception {
		return mainMybatisRepository.searchMemberList(member);
	}

	/*
	 * 작성일 : 2024.03.08
	 * 내 용 : 회원정보 갱신 - queryDSL을 활용한 update
	 **/
	public void updateMember(Member member) {
		mainRepositoryImpl.updateMember(member);
	}

	/*
	 * 작성일 : 2024.03.08
	 * 내 용 : 회원정보 조회 리스트 - 테이블 JOIN
	 **/
	public List<?> findMemeberJoinList() {
		return mainRepository.findMemeberJoinList();
	}
}