package com.example.personal.Repository;

import com.example.personal.Dto.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MainRepository extends JpaRepository<Member, String>, MainCustomRepository {

	@Query("SELECT p FROM Member p")
	List<Member> findAllMemberList();

	@Override
	List<Member> findAllMembersList();
}
