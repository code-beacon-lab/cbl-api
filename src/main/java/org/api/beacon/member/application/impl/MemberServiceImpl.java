package org.api.beacon.member.application.impl;

import lombok.RequiredArgsConstructor;
import org.api.beacon.member.application.MemberService;
import org.api.beacon.member.domain.Member;
import org.api.beacon.member.domain.MemberReader;
import org.api.beacon.member.domain.MemberStore;
import org.api.beacon.member.interfaces.MemberRequestDto;
import org.api.beacon.member.interfaces.MemberResponseDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class MemberServiceImpl implements MemberService {
    private final MemberReader memberReader; // DDD CQRS
    private final MemberStore memberStore;

    @Override
    @Transactional(readOnly = true)
    public MemberResponseDto retrieveMember(Long memberId) {
        var member = memberReader.getMemberById(memberId);
        return new MemberResponseDto(member);
    }

    @Override
    @Transactional
    public Member signUp(MemberRequestDto memberRequestDto) {
        var newMember = Member.createMember(memberRequestDto);
        return memberStore.store(newMember);
    }
}
