package org.api.beacon.member.interfaces;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.api.beacon.member.domain.Member;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class MemberResponseDto {
    private Long id;
    private String name;
    public MemberResponseDto(Member member) {
        this.id = member.getId();
        this.name = member.getName();
    }
}
