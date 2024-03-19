package com.example.personal.Dto.Information;

import com.example.personal.Dto.MemberDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Information implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;
    private String use_yn;

    private MemberDto memberDto;
}
