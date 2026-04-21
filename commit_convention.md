---

# 📝 Git & PR 컨벤션 가이드

## 🌿 Branch 전략
- **개인별 고유 브랜치 사용 (재활용)**
- 형식: `feat/영문이름` (예: `feat/hurgeon`)
- **구조:** 브랜치 내에서 `week1/`, `week2/` 폴더를 생성하여 문제 풀이

---

## 💻 작업 프로세스

### 1. 작업 전 최신 상태 유지 (필수)
새로운 주차나 문제를 풀기 전, **반드시** `main`의 최신 내용을 반영해야 합니다.

```bash
# 현재 본인 브랜치에서 실행
git pull origin main
```
> **이유:** 내 PR이 `Rebase and merge`로 합쳐지면 `main`의 커밋 해시가 달라집니다. 이를 `pull`로 다시 가져와야 다음 작업 시 충돌이 없습니다.

---

### 2. 변경 사항 추가 및 커밋 (폴더로 주차 구분)

```bash
# 해당 주차 폴더에 문제 풀이 후
git add .
git commit -m "feat: weekN 문제 풀이 작성"
```

---

### 3. 원격 저장소 업로드 (Push)

```bash
git push
```
* 만약 `Rebase and merge` 이후 첫 `push`에서 에러가 발생하면: `git push --force-with-lease`

---

## 🚀 Pull Request (PR) & 리뷰 프로세스

### 1. Draft PR 생성
GitHub에서 PR 생성 시 **[Create Draft Pull Request]** 선택
- 아직 문제를 다 못 풀었어도 중간 공유를 위해 미리 올려둡니다.
- 완료되면 **[Ready for review]**로 상태 변경!

### 2. 코드 리뷰 & Merge
- 팀원들과 리뷰 후, GitHub 페이지 하단에서 **[Rebase and merge]** 클릭
- **장점:** `Merge branch...` 같은 불필요한 커밋 없이, 내 풀이 기록만 `main`에 일직선으로 예쁘게 쌓입니다.

---

## 📌 주의사항 요약 (스터디원 필독)

1. **무한 재활용:** 브랜치 삭제하지 말고 계속 쓰되, **시작 전 `pull origin main`**은 절대 잊지 말 것.
2. **폴더 관리:** `week1/`, `week2/` 폴더 명칭을 통일해서 관리할 것.
3. **병합 방식:** 무조건 **`Rebase and merge`** 버튼만 누를 것 (일반 Merge 금지).

---

### 💡 브랜치 재활용 팁
`Rebase and merge`를 하면 깃허브가 "내 브랜치가 `main`보다 뒤처졌다"고 착각할 때가 있습니다. 이때 당황하지 말고 그냥 **`git pull origin main`**을 하면 로컬이 다시 최신 상태가 됩니다. 이 루틴만 익숙해지면 브랜치 하나로 스터디 끝까지 가장 깔끔하게 관리할 수 있습니다!