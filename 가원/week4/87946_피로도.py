# 프로그래머스 피로도 문제

from typing import List
from itertools import permutations

def solution(k: int, dungeons: List[List[int]]) -> int:
    rows: int = len(dungeons)
    answer_arr: List[int] = []

    for order in permutations(range(rows)):
        count: int = 0
        current_k: int = k
        for i in order:
            if current_k >= dungeons[i][0]:
                current_k -= dungeons[i][1]
                count += 1
            else:
                break

        answer_arr.append(count)

    answer = max(answer_arr)
    return answer


if __name__ == "__main__":
    k: int = 80
    test_list: List[List[int]] = [[80,20],[50,40],[30,10]]
    print(solution(k, test_list))