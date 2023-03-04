package org.api.beacon.member.interfaces;

import org.api.beacon.member.application.MemberService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "/api/member")
@RestController
public class MemberApiController {

    private final MemberService memberService;

    public MemberApiController(MemberService memberService) {
        this.memberService = memberService;
    }

    // 회원 정보 조회(마이페이지) -> TODO 로그인 정보 기반으로 조회
    @GetMapping
    public ResponseEntity<MemberResponseDto> retrieveMember(@RequestBody String memberId) {
        return ResponseEntity.ok(memberService.retrieveMember(Long.valueOf(memberId)));
    }

    // TODO 아이디 중복체크
    // TODO 이메일 중복체크
    // TODO 회원 가입
    // TODO 로그인
    // TODO 로그아웃
}
