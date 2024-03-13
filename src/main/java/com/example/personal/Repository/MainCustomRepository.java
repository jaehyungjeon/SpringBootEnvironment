package com.example.personal.Repository;

import com.example.personal.Dto.Member;
import com.querydsl.core.Tuple;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MainCustomRepository {
    List<Member> findAllMembersList();
    List<Member> findAllMembersList2();
}
