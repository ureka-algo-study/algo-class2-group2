# 프로그래머스 메뉴 리뉴얼

from itertools import combinations
from collections import Counter
from typing import List


# 여러분 죄송합니다....ㅠㅠ
def solution(orders: List[str], course: List[int]) -> List[str]:
    answer: List[str] = []

    for c in course:
        counter = Counter()

        for order in orders:
            # 각 주문에서 가능한 조합 생성
            for combo in combinations(sorted(order), c):
                counter[combo] += 1
        
        if not counter:
            continue

        max_count = max(counter.values())
        if max_count < 2:
            continue

        for combo, count in counter.items():
            if count == max_count:
                answer.append(''.join(combo))

    return sorted(answer)


if __name__ == "__main__":
    main_orders: List[str] = ["ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"]
    main_course: List[int] = [2, 3, 4]

    print(solution(main_orders, main_course))