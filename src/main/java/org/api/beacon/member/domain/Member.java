package org.api.beacon.member.domain;

import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity(name = "TB_MEMBER")
public class Member  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    @Column(name = "member_name")
    private String name;

    @Column(name = "member_phone")
    private String phoneNumber;

    @Column(name = "member_company")
    private String company;

    @Column(name = "member_address")
    private String address;
}
