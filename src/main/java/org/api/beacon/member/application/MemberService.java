package org.api.beacon.member.application;

import org.api.beacon.member.domain.Member;
import org.api.beacon.member.interfaces.MemberRequestDto;
import org.api.beacon.member.interfaces.MemberResponseDto;

public interface MemberService {
    MemberResponseDto retrieveMember(Long memberId);

    Member signUp(MemberRequestDto memberRequestDto);
}
