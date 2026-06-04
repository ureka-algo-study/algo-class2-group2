# 프로그래머스 43238 입국심사

# 이분탐색 문제

from typing import List


# 기본적으로 이진트리 탐색과 유사한 방식으로 접근하지만, 
# 실제로 트리를 구성하는 것이 아니라 범위를 좁혀가는 방식으로 풀이
def solution(n: int, times: List[int]) -> int:
    left: int = 1   # 최소 시간은 1분 (모든 사람이 동시에 심사받는 경우)
    right: int = max(times) * n # 최악의 경우, 가장 느린 심사관이 모든 사람을 심사하는 경우

    # 이분탐색을 통해 최소 시간을 찾음
    while left < right:
        # 중간값 계산
        mid: int = (left + right) // 2

        # mid 시간 동안 심사관들이 처리할 수 있는 총 사람 수 계산
        total: int = sum(mid // time for time in times)

        # total이 n 이상이면, mid 시간 내에 모든 사람이 심사될 수 있으므로, 더 짧은 시간도 가능할 수 있음
        if total >= n:
            right = mid
        else:
            left = mid + 1
    
    return left


if __name__ == "__main__":
    main_n: int = 6
    main_times: List[int] = [7, 10]

    print(solution(main_n, main_times))