# 프로그래머스 혼자놀기의 달인

import heapq

from typing import List

def solution(cards) -> int:
    answer: int = 0

    visited: List[int] = [False] * (len(cards) + 1)
    cycle_sizes: List[int] = []

    for i in range(1, len(cards) + 1):
        if not visited[i]:
            cur: int = i
            size: int = 0

            while not visited[cur]:
                visited[cur] = True
                cur = cards[cur - 1]
                size += 1

            cycle_sizes.append(size)

    # 결과 확인
    if len(cycle_sizes) < 2:
        return 0
    else:
        top2 = heapq.nlargest(2, cycle_sizes)
        answer = top2[0] * top2[1]

    return answer


if __name__ == "__main__":
    # 테스트 케이스
    cards1 = [8, 6, 3, 7, 2, 5, 1, 4]   # 사이클 1개 → 기대값: 0
    cards2 = [2, 1, 4, 3, 6, 5] # 사이클 3개 → 기대값: 4
    cards3 = [3, 1, 2, 5, 6, 4] # 사이클 2개 → 기대값: 9

    # print("=== cards1 ===")
    result: int = solution(cards1)

    print(result)
    # print("=== cards2 ===")
    # solution(cards2)
