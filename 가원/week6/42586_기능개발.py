# 프로그래머스 기능개발

from typing import List

import math

def solution(progress: List[int], speeds: List[int]) -> List[int]:
    answer: List[int] = []

    # 1. 각 기능의 남은 작업 일수 계산 (올림 처리)
    # List Comprehension을 사용하여 계산 후 가독성을 위해 reverse 시켜 스택 (LIFO) 활용
    days_left: List[int] = [ math.ceil((100 - p) / s) for p, s in zip(progress, speeds)]
    # print(days_left)

    days_left.reverse()
    # print(days_left)

    # 2. 스택을 활용한 배포 그룹화
    while days_left:
        # 현재 배포 차례의 기준이 되는 기능의 남은 일수
        deploy_day: int = days_left.pop()
        count: int = 1  # 함께 배포될 기능의 수 (자신 포함)

        while days_left and days_left[-1] <= deploy_day:
            days_left.pop()
            count += 1

        answer.append(count)

    return answer


if __name__ == "__main__":
    main_progress: List[int] = [93, 30, 55]
    main_speeds: List[int] = [1, 30, 5]

    solution(main_progress, main_speeds)

