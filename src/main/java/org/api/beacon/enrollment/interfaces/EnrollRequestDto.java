package org.api.beacon.enrollment.interfaces;

import org.api.beacon.member.domain.Member;
import org.api.beacon.member.interfaces.MemberRequestDto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
public class EnrollRequestDto {
	
	private Long id;            
	
	private String memberId;   /*회원 아이디*/
	
	private int studyId;       /*스터디 아이디*/
    
	private String joinYn;     /*승인 상태*/

	public static Object builder() {
		// TODO Auto-generated method stub
		return null;
	}
//    public static EnrollRequestDto createEnrollRequestDto(EnrollRequestDto enrollRequestDto) {
//        return EnrollRequestDto.builder()
//    }
	
}
