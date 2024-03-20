package com.example.personal.Dto.Information;

import com.example.personal.Dto.MemberDto;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

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
    
    private MemberDto memberDto;
}
