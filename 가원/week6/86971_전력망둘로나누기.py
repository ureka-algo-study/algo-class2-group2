# 프로그래머스 전력망 둘로 나누기 문제

from typing import List
from collections import deque


# 1 BFS 노드 카운트 함수 (외부로 완전히 분리)
def get_node_count_bfs(start: int, ignore_edge: List[int], n: int, graph: List[List[int]]) -> int:
    '''
    - start: 시작 노드 번호
    - ignore_edge: 끊어버린 전선의 양 끝 노드 번호
    - n: 총 노드 개수
    - graph: 인접 리스트
    - 반환: 시작 노드에서부터 연결된 노드의 개수
    '''

    # 방문 체크 리스트
    visited = [False] * (n + 1)
    
    # 큐에 시작 노드 추가
    queue = deque([start])
    visited[start] = True
    count = 1

    while queue:
        # 큐에서 노드 하나를 꺼낸다
        curr = queue.popleft()

        # 꺼낸 노드와 연결된 노드들을 순회한다.
        for neighbor in graph[curr]:
            # 끊어버린 전선인지 확인 (양방향 체크)
            if (curr == ignore_edge[0] and neighbor == ignore_edge[1]) or \
               (curr == ignore_edge[1] and neighbor == ignore_edge[0]):
                continue

            # 아직 방문하지 않은 노드라면
            if not visited[neighbor]:
                visited[neighbor] = True
                queue.append(neighbor)
                count += 1
    
    return count
            

# 2. 메인 솔루션 함수
def solution(n: int, wires: List[List[int]]) -> int:
    answer = n

    # 그래프 빌드
    graph = [[] for _ in range(n + 1)]
    for v1, v2 in wires:
        graph[v1].append(v2)
        graph[v2].append(v1)

    # 모든 전선을 하나씩 끊어보며 완전탐색  
    for v1, v2 in wires:
        # 외부 함수를 호출할 때 n과 graph를 인자로 넘겨준다
        count = get_node_count_bfs(v1, [v1, v2], n, graph)
        
        # 두 전력망의 차이 계산
        diff = abs(count - (n - count))
        
        # 최소값 갱신
        if diff < answer:
            answer = diff
            
    return answer
    

if __name__ == "__main__":
    main_n: int = 9
    main_wires: List[List[int]] = [[1,3],[2,3],[3,4],[4,5],[4,6],[4,7],[7,8],[7,9]]
    main_result = solution(main_n, main_wires)
    print(main_result)