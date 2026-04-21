# LG U+ URECA Algorithm Study

> LG 유플러스 유레카 과정 알고리즘 스터디 2조 레포지토리입니다.  
> Java/Python을 활용해 꾸준히 문제를 풀이하고 알고리즘 역량을 강화합니다.

## 🔥 이번 주 커밋왕

GitHub Actions가 매일 커밋 수를 집계해 아래 영역을 자동으로 갱신합니다. 집계 기준은 매주 월요일 00:00 KST부터 현재까지의 커밋입니다.

<!-- COMMIT_RANKING:START -->
| 순위 | 이름 | 커밋 수 |
| --- | --- | --- |
| 🥇 | Minhyeok Choi | 5 |
| 🥈 | 김가원(Kimgawon) | 3 |
| 🥉 | HUHGEON | 2 |

마지막 업데이트: 2026-04-21 15:59 KST
<!-- COMMIT_RANKING:END -->

> 커밋 수는 재미용 지표입니다☺️ 실제로는 문제풀이 방식 및 사고과정이 더 중요합니다😆

## 🎯 스터디 목표

- **Java/Python을 활용한 알고리즘 역량 강화**
- 프로그래머스별 권장 문제를 기반으로 단계적인 문제 해결 능력 향상(굿바이 백준...)
- 주차별 풀이 기록을 통해 꾸준한 학습 습관 형성
- 서로의 풀이를 참고하며 다양한 접근 방식 학습

## 🧩 문제 풀이 사이트

- 권장 방식: 프로그래머스의 레벨별 문제선정후 풀이
- 문제 출처: https://school.programmers.co.kr/learn/challenges?order=recent&levels=0

## 🛠 사용 언어

스터디 주력 언어는 **Java**와 **Python**입니다.  
참가자는 본인이 희망하는 언어를 선택하여 풀이를 제출합니다.
그 외에 혹시나 본인이 자신있어 하는 다른 언어 있다면 그걸로 해도 무방합니다.

## 📁 폴더 구조

루트 디렉토리 아래에 각 참가자 이름으로 폴더를 만들고, 그 안에 주차별 폴더를 생성합니다.

```text
algo-class2-group2/
├── README.md
├── 홍길동/
│   ├── week_01/
│   │   ├── 1234_설탕배달.java
│   │   └── 1920_수찾기.java
│   └── week_02/
│       └── 2178_미로탐색.java
└── 김유레카/
    ├── week_01/
    │   ├── 1234_설탕배달.py
    │   └── 1920_수찾기.py
    └── week_02/
        └── 2178_미로탐색.py
```

## 📝 파일 규칙

파일명은 아래 형식을 따릅니다.

```text
문제번호_문제이름.확장자
```

예시:

```text
1234_설탕배달.java
1234_설탕배달.py
```

주의사항:

- 문제 이름의 공백은 제거하거나 `_`로 구분합니다.
- 동일 문제를 여러 방식으로 풀이하는 경우 파일명 뒤에 구분자를 추가할 수 있습니다.

```text
1234_설탕배달_dp.java
1234_설탕배달_greedy.py
```

## 🌿 브랜치 전략

### main 브랜치

- 공용 관리용 브랜치입니다.
- README, 공지, 공통 설정 등 레포지토리 전체에 영향을 주는 내용을 관리합니다.

### 개인 브랜치

각 참가자는 본인 이름으로 브랜치를 생성하여 작업합니다.

```bash
git checkout -b feat/본인이름
```

예시:

```bash
git checkout -b feat/홍길동
```

작업 후 개인 브랜치에 직접 푸시합니다.

```bash
git add .
git commit -m "week_01 문제 풀이 추가"
git push origin feat/본인이름
```

조별 운영 방식에 따라 다음 중 하나를 선택합니다.

- 개인 브랜치를 유지하며 풀이 기록
- PR을 생성한 뒤 `main` 브랜치로 머지

## ☕ Java 컨벤션

- 백준 제출 시 클래스명은 반드시 `Main`으로 작성합니다.
- 빠른 입력이 필요한 경우 `BufferedReader`, `StringTokenizer`를 사용합니다.
- 출력이 많은 경우 `StringBuilder`를 활용합니다.
- 파일명은 문제 번호와 문제 이름을 기준으로 작성하되, 실제 제출 코드의 클래스명은 `Main`으로 유지합니다.

예시:

```java
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        System.out.println(a + b);
    }
}
```

## 🐍 Python 컨벤션

- 빠른 입력이 필요한 경우 `sys.stdin.readline`을 사용합니다.
- 출력이 많은 경우 리스트에 결과를 모아 `'\n'.join()`으로 출력합니다.
- 재귀를 사용하는 문제는 필요 시 `sys.setrecursionlimit()`을 설정합니다.
- 시간 초과가 발생하면 입력 방식, 자료구조, 알고리즘 복잡도를 먼저 점검합니다.

예시:

```python
import sys

input = sys.stdin.readline

a, b = map(int, input().split())
print(a + b)
```

## 👥 참여자 명단

| 이름 | 사용 언어 |
| --- | --- |
| 김가원 | Python |
| 정민주 | Java |
| 김재우 | Java |
| 허건 | Java |
| 최민혁 | Java |

## ✅ 제출 체크리스트

- [ ] 본인 이름 폴더 안에 주차별 폴더를 생성했나요?
- [ ] 파일명을 `문제번호_문제이름.확장자` 형식으로 작성했나요?
- [ ] Java 제출 코드의 클래스명이 `Main`인가요?
- [ ] Python 입력 최적화가 필요한 문제에서 `sys.stdin.readline`을 사용했나요?
- [ ] 풀이가 정상적으로 통과했나요?

## 🚀 스터디 운영 흐름

1. solved.ac Class별 권장 문제를 기준으로 주차별 문제를 선정합니다.
2. 각자 선택한 언어로 문제를 풀이합니다.
3. 본인 이름 폴더의 해당 주차 폴더에 풀이 파일을 추가합니다.
4. 개인 브랜치에 커밋 후 푸시합니다.
5. 필요 시 코드 리뷰 또는 풀이 공유를 진행합니다.
