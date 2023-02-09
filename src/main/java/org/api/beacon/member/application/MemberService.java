package org.api.beacon.member.application;

import org.api.beacon.member.interfaces.MemberResponseDto;

public interface MemberService {
    MemberResponseDto retrieveMember(Long requestDto);
}
