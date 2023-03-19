package org.api.beacon.member.interfaces;
import org.api.beacon.member.application.MemberService;
import org.api.beacon.member.domain.Member;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.net.URI;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
@RequestMapping(value = "/api/member")
@RestController
public class MemberApiController {
    private final MemberService memberService;
    public MemberApiController(MemberService memberService) {
        this.memberService = memberService;
    }
    // TODO 아이디 중복체크
    // TODO 이메일 중복체크
    // 회원 가입
    @PostMapping
    public ResponseEntity<Member> signUp(@RequestBody MemberRequestDto memberRequestDto) {
        Member newMember = memberService.signUp(memberRequestDto);
        WebMvcLinkBuilder selfLinkBuilder = linkTo(MemberApiController.class).slash(newMember.getId());
        URI createUri = selfLinkBuilder.toUri();
        return ResponseEntity.created(createUri).body(newMember);
    }
    // TODO 로그아웃
    // TODO 로그인
    // 회원 정보 조회(마이페이지) -> TODO 로그인 정보 기반으로 조회
    @GetMapping
    public ResponseEntity<MemberResponseDto> retrieveMember(@RequestBody String memberId) {
        return ResponseEntity.ok(memberService.retrieveMember(Long.valueOf(memberId)));
    }
}