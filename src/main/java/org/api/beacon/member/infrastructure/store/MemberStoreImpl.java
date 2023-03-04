package org.api.beacon.member.infrastructure.store;

import lombok.RequiredArgsConstructor;
import org.api.beacon.member.domain.Member;
import org.api.beacon.member.domain.MemberStore;
import org.api.beacon.member.infrastructure.MemberRepository;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class MemberStoreImpl implements MemberStore {
    private final MemberRepository memberRepository;
    @Override
    public Member store(Member member) {
        validate(member);
        return memberRepository.save(member);
    }

    private void validate(Member member) {
        if(member.getLoginId() == null) {
            throw new IllegalArgumentException("Member.loginId");} // TODO InvalidParameterException
    }
}
