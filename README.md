## 설계
- TABLE
  - reply_id : 댓글 아이디
  - study_id : 스터디 아이디
  - member_id : 회원 아이디
  - reply_detail : 댓글 내용
  - parent_reply : 상위 댓글 아이디(임시)
  - reply_level : 댓글 레벨(임시)
  - crt_id : 작성자 아이디
  - crt_dt : 작성일
  - upd_id : 수정자 아이디
  - upd_dt : 수정일

### 기능 명세
- 댓글 아이디로 조회
- 댓글 전체 조회(수정 예정 - `해당 게시물의 댓글을 모두 조회`)
- 댓글 내용 수정

### 버전 관리 방식에 대해서
- issue -> commit -> PR -> review -> merge
- 모든 PR 전에 로컬에서 ./gradlew test 가 통과하는 지 검증할 것
