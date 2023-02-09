package org.api.beacon.member.application.impl;

import org.api.beacon.member.application.MemberService;
import org.api.beacon.member.domain.MemberReader;
import org.api.beacon.member.interfaces.MemberResponseDto;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {
    private final MemberReader memberReader; // DDD CQRS

    public MemberServiceImpl(MemberReader memberReader) {
        this.memberReader = memberReader;
    }

    @Override
    public MemberResponseDto retrieveMember(Long memberId) {
        var member = memberReader.getMemberById(memberId);
        return new MemberResponseDto(member);
    }
}
