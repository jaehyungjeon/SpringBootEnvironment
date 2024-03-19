package com.example.personal.Dto;

import lombok.*;

import java.io.Serializable;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MemberDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;
	private String password;
	private String name;

	private String[] idArrayList;
}
