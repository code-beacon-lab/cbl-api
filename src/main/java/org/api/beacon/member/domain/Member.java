package org.api.beacon.member.domain;

import lombok.*;
import org.api.beacon.member.interfaces.MemberRequestDto;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@Getter
@Entity(name = "TB_MEMBER")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    @Column(name = "member_name")
    private String name;

    @NotNull
    @Column(name = "member_login_id")
    private String loginId;

    @NotNull
    @Column(name = "member_email")
    private String email; // TODO email VO 형식 검증

    @Column(name = "member_phone")
    private String phoneNumber;

    @Column(name = "member_company")
    private String company;

    @Column(name = "member_address") // TODO 주소, 상세 주소 분리
    private String address;

    public static Member createMember(MemberRequestDto memberRequestDto) {
        return Member.builder()
                .name(memberRequestDto.getName())
                .loginId(memberRequestDto.getLoginId())
                .email(memberRequestDto.getEmail())
                .phoneNumber(memberRequestDto.getPhoneNumber())
                .company(memberRequestDto.getCompany())
                .address(memberRequestDto.getAddress())
                .build();
    }
}
