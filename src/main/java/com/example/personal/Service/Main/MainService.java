package com.example.personal.Service.Main;

import java.util.List;
import java.util.Locale;

import com.example.personal.RepositoryImpl.MainRepositoryImpl;
import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.stereotype.Service;

import com.example.personal.Dto.Member;
import com.example.personal.MybatisRepository.MainMybatisRepository;
import com.example.personal.Repository.MainRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class MainService {

	@Autowired
	private MainRepository mainRepository;

	@Autowired
	private MainMybatisRepository mainMybatisRepository;

	@Autowired
	private MainRepositoryImpl mainRepositoryImpl;

	@Autowired
	private MessageSourceAccessor messageSourceAccessor;

	public void initMain(Member member) throws Exception {
		System.out.println("서비스 호출");
		log.info("메시지={}", messageSourceAccessor.getMessage("main.test", "바보", Locale.US));
		log.info("메시지2={}", messageSourceAccessor.getMessage("root.test", "루트에서 꺼내옴"));
		log.info("메시지3={}", messageSourceAccessor.getMessage("root.korean"));

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
//		log.info("password={}", jasyptEncoding("wjswpgud1!"));
	}

	public String jasyptEncoding(String value) {
		String key = "my_jasypt_key";
		StandardPBEStringEncryptor pbeEnc = new StandardPBEStringEncryptor();
		pbeEnc.setAlgorithm("PBEWithMD5AndDES");
		pbeEnc.setPassword(key);
		return pbeEnc.encrypt(value);
	}

	public List<Member> returnQueryMemberList(Member member) throws Exception {
		return mainRepositoryImpl.findAllMembersList();
	}

//	public List<MemberDto> searchMember(Member member) throws Exception {
//		return mainMybatisRepository.searchMemberDtoList(member);
//	}

	public List<Member> searchMember(Member member) throws Exception {
		return mainMybatisRepository.searchMemberList(member);
	}
}