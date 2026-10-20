# TJ1F

[솔트룩스] AI 에이전트 개발자 부트캠프 1차 프로젝트 구현 저장소입니다.


# 📝 Git Convention!!

## 1. Commit Message Convention

### 커밋 메시지 형식

`type: 작업 내용`

**규칙**

- type은 소문자로 작성합니다.
- 작업 내용은 한글로 간결하고 명확하게 작성합니다.
- 하나의 커밋에는 하나의 논리적 작업을 담습니다.

### 커밋 타입

| Type       | 설명                     |
| ---------- | ------------------------ |
| `feat`     | 새로운 기능 추가         |
| `fix`      | 버그 수정                |
| `refactor` | 코드 리팩토링            |
| `docs`     | 문서 수정                |
| `style`    | 코드 포맷팅              |
| `test`     | 테스트 코드 추가 및 수정 |
| `chore`    | 설정 및 기타 작업        |
| `perf`     | 성능 개선                |
| `ci`       | CI/CD 설정 및 수정       |

### 커밋 메시지 예시

```bash
feat: 회원가입 API 구현
fix: 로그인 오류 수정
refactor: 회원 서비스 로직 분리
docs: README 수정
test: 회원가입 단위 테스트 추가
chore: GitHub 템플릿 추가
```

---

## 2. Branch Naming Convention

### 브랜치 이름 형식

`type/#이슈번호-작업내용`

**규칙**

- 브랜치 이름은 영문 소문자로 작성합니다.
- 단어 사이는 하이픈(`-`)으로 구분합니다.
- 이슈 번호를 포함하여 작업을 추적할 수 있도록 합니다.
- 브랜치 이름은 간결하고 명확하게 작성합니다.

### 브랜치 타입

| Type       | 설명                   |
| ---------- | ---------------------- |
| `feat`     | 새로운 기능 개발       |
| `fix`      | 버그 수정              |
| `refactor` | 코드 리팩토링          |
| `docs`     | 문서 수정              |
| `test`     | 테스트 코드 작업       |
| `chore`    | 환경 설정 및 기타 작업 |
| `ci`       | CI/CD 관련 작업        |

### 브랜치 이름 예시

```text
feat/#12-signup
feat/#13-jwt-auth
fix/#14-login-error
refactor/#15-user-service
docs/#16-update-readme
chore/#17-project-setup
```

### 주요 브랜치

| 브랜치       | 설명                      |
| ------------ | ------------------------- |
| `main`       | 배포 가능한 안정적인 코드 |
| `develop`    | 개발 코드 통합 (선택)     |
| `feat/*`     | 새로운 기능 개발          |
| `fix/*`      | 버그 수정                 |
| `refactor/*` | 리팩토링                  |

---

## 3. Git Workflow

1. GitHub Issue 생성
2. Issue 번호를 포함한 작업 브랜치 생성
3. 기능 개발 및 커밋
4. 원격 저장소에 브랜치 Push
5. Pull Request 생성
6. 코드 리뷰 후 Merge

### 작업 예시

```bash
# 작업 브랜치 생성
git switch -c feat/#12-signup

# 변경 사항 커밋
git add .
git commit -m "feat: 회원가입 API 구현"

# 원격 저장소에 Push
git push -u origin feat/#12-signup
```

PR 작성 시 관련 이슈를 연결합니다.

`Closes #12`

PR이 기본 브랜치에 병합되면 연결된 이슈가 자동으로 닫힐 수 있습니다.