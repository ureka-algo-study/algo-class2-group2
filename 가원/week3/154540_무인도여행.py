# 프로그래머스 154540 무인도 여행
from typing import List, Tuple

def solution(maps: List[str]) -> List[int]:
    rows:int = len(maps)     # 격자 세로 길이
    cols:int = len(maps[0])  # 격자 가로 길이
    visited: List[List[bool]] = [[False] * cols for _ in range(rows)]  # 스택 방문 체크판

    answer: List[int] = []
    # 1단계 : 시작점 찾기 -> 격자를 위 -> 아래, 왼 -> 오른쪽으로 쭉 훓기, 칸이 x면 스킵, 숫자면서 아직 방문
    # 안했다면 -> 여기서 새 섬 탐색 시작
    for r in range(rows):
        for c in range(cols):
            if maps[r][c] != 'X' and not visited[r][c]:   # 숫자 + 미방문
                # 새 섬 발견! 스택에 시작점 넣기
                stack: List[Tuple[int, int]] = [(r, c)]
                visited[r][c] = True

                total = 0

                while stack:
                    current_x, current_y = stack.pop()
                    total += int(maps[current_x][current_y])

                    directions = [(-1, 0), (1, 0), (0, -1), (0, 1)]

                    for direction_x, direction_y in directions:
                        next_x = current_x + direction_x
                        next_y = current_y + direction_y

                        if (0 <= next_x < rows) and (0 <= next_y < cols):
                            if (not visited[next_x][next_y]) and (maps[next_x][next_y] != 'X'):
                                visited[next_x][next_y] = True
                                stack.append((next_x, next_y))

                answer.append(total)

    return sorted(answer)


if __name__ == "__main__":
    # 프로그래머스 예제 1번 데이터
    sample_maps = ["X591X", "X1X5X", "X231X", "1XXX1"]

    print(solution(sample_maps))