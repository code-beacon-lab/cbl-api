package org.api.beacon.member.infrastructure.reader;

import org.api.beacon.member.domain.Member;
import org.api.beacon.member.domain.MemberReader;
import org.api.beacon.member.infrastructure.MemberRepository;
import org.springframework.stereotype.Component;

@Component
public class MemberReaderImpl implements MemberReader {

    private final MemberRepository memberRepository;

    public MemberReaderImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public Member getMemberById(Long memberId) {
        return memberRepository.findById(memberId).orElseThrow(IllegalStateException::new); // TODO 공통 예외 클래스로 처리
    }
}
