# 프로그래머스 할인 행사

from typing import List, Dict
from collections import Counter


def solution(want: List[str], number: List[int], discount: List[str]) -> int:
    answer: int = 0

    # 1. 원한는 제품과 수량을 하나의 딕셔너리 쌍으로 묶음
    users_want_dict: Dict = Counter({want[i]: number[i] for i in range(len(want))})

    for i in range(len(discount) - 9):
        window_dict: Dict = Counter(discount[i : i + 10])

        # 2. want의 모든 수량이 윈도우에서 충족되는가?
        if users_want_dict <= window_dict:
            answer += 1

    return answer


if __name__ == "__main__":
    want_args: List[str] = [
        "banana", "apple", "rice", "pork", "pot"
    ]

    numbers_args: List[int] = [3, 2, 2, 2, 1]

    discount_args: List[str] = [
        "chicken", "apple", "apple",
        "banana", "rice", "apple", "pork",
        "banana", "pork", "rice", "pot",
        "banana", "apple", "banana"
    ]

    result: int = solution(want_args, numbers_args, discount_args)
    print(result)