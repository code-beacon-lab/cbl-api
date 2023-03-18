package org.api.beacon.enrollment.interfaces;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EnrollResponseDto {
	
	private Long id;            
	
	private String memberId;   /*회원 아이디*/
	
	private int studyId;       /*스터디 아이디*/
    
	private String joinYn;     /*승인 상태*/
}
