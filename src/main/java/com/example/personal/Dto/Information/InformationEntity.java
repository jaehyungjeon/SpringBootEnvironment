package com.example.personal.Dto.Information;

import com.example.personal.Dto.Member;
import com.example.personal.Dto.MemberDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "information")
public class InformationEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private String id;
    private String use_yn;

    // 영속성으로 주지 않으면, jpa에서 해당 객체 값을 읽어올 수 없으므로 오류가 발생.
    @Transient
    private MemberDto memberDto;
}
