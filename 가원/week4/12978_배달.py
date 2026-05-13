# 프로그래머스 배달 문제풀이

import heapq

from typing import List


def solution(N: int, road: List[List[int]], K: int) -> int:
    answer: int = 0

    # 그래프 초기화
    graph: List[List[int]] = [[] for _ in range(N + 1)]

    # STEP1. 그래프 구성 -> 인접 리스트로 표현
    for a, b, cost in road:
        graph[a].append((b, cost))
        graph[b].append((a, cost))
    
    print(graph)

    distance = [float("inf")] * (N + 1)
    distance[1] = 0

    # 우선순위 큐 생성
    q: List[int] = []

    # 시작 마을 넣기 -> 1번 마을까지 가는 거리는 0이다.
    heapq.heappush(q, (0, 1))

    # 우선순위 큐가 빌 때까지 반복
    while q:
        # 가장 가까운 마을 꺼내기
        dist, now = heapq.heappop(q)
        # -> 가장 가까운 마을 꺼내기
        # 첫 단계로 우선순위 큐에 시작점 넣기
        # print(dist, now)

        if distance[now] < dist:
            continue

        # 꺼낸 마을에서 연결된 마을들을 확인 후 현재 마을을 거쳐 다음 마을까지 가는 비용 계산
        for next_node, cost in graph[now]:
            new_cost: int = dist + cost

           # 지금 알고 있는 거리보다 더 짧은가?
            if new_cost < distance[next_node]:
                distance[next_node] = new_cost  # 갱신
                heapq.heappush(q, (new_cost, next_node))  # 새로운 최단거리를 발견했으니 우선순위 큐에도 삽입

    answer = sum(1 for d in distance if d <= K)
    return answer


if __name__ == "__main__":
    N: int = 5
    road = [
        [1, 2, 1],
        [2, 3, 3],
        [5, 2, 2],
        [1, 4, 2],
        [5, 3, 1],
        [5, 4, 2]
    ]
    K: int = 3

    print(solution(N, road, K))
