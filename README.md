### 설계
- TABLE
  - reply_id : 댓글 아이디
  - study_id : 스터디 아이디
  - member_id : 회원 아이디
  - reply_detail : 댓글 내용
  - parent_reply : 상위 댓글 아이디(임시, 적용전)
  - reply_level : 댓글 레벨(임시, 적용전)
  - crt_id : 작성자 아이디
  - crt_dt : 작성일
  - upd_id : 수정자 아이디
  - upd_dt : 수정일

### 기능 명세
| **API 명**              | **설명**                 |
|:-------------------|:-----------------------|
| `retrieveAllReply` | 게시물 id에 해당하는 모든 댓글 조회  |
| `createReply`      | 댓글 작성                  |
| `updateReply`      | 댓글 내용 수정               |

### 수정사항
- 댓글 수정 API 수정 : getter로 필드별 파라미터 만들어둔 것 DTO로 처리
- 댓글 삽입 API 수정 : reply_id를 만드는 곳은 DB로 결정 후 builder에 id 생성하는 부분 삭제 처리
- 댓글 조회 API 수정중 : study id를 URI로 받아오는 것이 아닌 BODY에서 study_id를 받아와 처리하게끔 수정 예정
- 필요없는 함수, 주석 삭제 : 테스트용 주석 삭제처리, 사용하지 않는 vdildate 함수 삭제 처리

### 버전 관리 방식에 대해서
- issue -> commit -> PR -> review -> merge
- 모든 PR 전에 로컬에서 ./gradlew test 가 통과하는 지 검증할 것
