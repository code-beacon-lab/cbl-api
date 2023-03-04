package org.api.beacon.member.interfaces;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class MemberRequestDto {
    private String name;
    private String loginId;

    private String email; // TODO email VO 형식 검증

    private String phoneNumber;

    private String company;

    private String address;
}
