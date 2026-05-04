# 프로그래머스 게임맵 최단거리 문제

from collections import deque
from typing import List, Tuple

def solution(maps: List[List[int]]) -> int:
    rows: int = len(maps)
    cols: int = len(maps[0])  # 격자 가로 길이
    visited: List[List[bool]] = [[False] * cols for _ in range(rows)]

    dr: List[int] = [-1, 1, 0, 0]
    dc: List[int] = [0, 0, -1, 1]

    queue = deque()
    queue.append((0, 0, 1))  # 시작점, 거리 1
    visited[0][0] = True

    while queue:
        # 1. 큐에서 좌표 꺼냄
        r, c, dist = queue.popleft()   # 큐에서 꺼냄 -> 좌표값(r,c) 거리

        # 2. 목적지 도달 체크
        if (r == rows -1) and (c == cols - 1):
            return dist

        # 3. 4방향 탐색
        for i in range(4):
            next_r: int = r + dr[i]
            next_c: int = c + dc[i]

            # 4. 범위 체크 + 벽 체크 + 방문체크
            if (0 <= next_r < rows) and (0 <= next_c < cols):  # -> 범위 체크
                if (maps[next_r][next_c] == 1) and (visited[next_r][next_c] == False):

                    # 5. 큐에 추가
                    queue.append((next_r, next_c, dist + 1))
                    visited[next_r][next_c] = True

    # 해당 경우의 리턴은 벽에 가로막혀서 상대방에게 가지 못했을 경우
    return -1


if __name__ == "__main__":
    # 테스트 케이스 정의 (입력값, 기대값)
    test_cases = [
        (
            [[1, 0, 1, 1, 1], [1, 0, 1, 0, 1], [1, 0, 1, 1, 1], [1, 1, 1, 0, 1], [0, 0, 0, 0, 1]],
            11
        ),
        (
            [[1, 0, 1, 1, 1], [1, 0, 1, 0, 1], [1, 0, 1, 1, 1], [1, 1, 1, 0, 0], [0, 0, 0, 0, 1]],
            -1
        )
    ]

    print("--- 알고리즘 테스트 시작 ---")
    for i, (maps_input, expected) in enumerate(test_cases, 1):
        result = solution(maps_input)

        # 결과 비교 및 출력
        is_correct = "✅ Pass" if result == expected else "❌ Fail"
        print(f"Case {i}: Result = {result} | Expected = {expected} [{is_correct}]")
    print("---------------------------")
