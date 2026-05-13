# 프로그래머스 과제 진행하기

from typing import List, Tuple


def solution(plans: List[List[str]]) -> List[str]:
    answer: List[str] = []
    # 1. 과제 시간순 정렬하기
    plans.sort(key=lambda x: x[1])

    # 2. 시간 변환하는 부분에서는 AI 도움받음
    def to_min(time: str) -> int:
        h, m = map(int, time.split(":"))
        return h * 60 + m

    # 1. 시간 변환 + 정렬
    new_plans: List[Tuple[str, int, int]] = []
    for name, start, playtime in plans:
        new_plans.append((name, to_min(start), int(playtime)))

    new_plans.sort(key=lambda x: x[1])

    # 2. 스택 리스트 하나 놔두고 그곳에 key, value 저장
    # - key, value 쌍이라고 해서 딕셔너리가 아님
    # - key: subject_name, value: 남은시간
    stack: List[Tuple[str, int]] = []

    for i in range(len(new_plans) - 1):
        name, start, playtime = new_plans[i]
        next_start: int = new_plans[i + 1][1]

        current_available_time = next_start - start

        # 현재 과제를 끝낼 수 없는 경우
        if playtime > current_available_time:
            remain_time: int = playtime - current_available_time
            stack.append((name, remain_time))

        # 과제를 끝낼 수 있는 경우
        else:
            answer.append(name)
            remain_time: int = current_available_time - playtime

            # 여기서 이제 남은 기간동안 멈춘 과제 처리
            while stack and remain_time > 0:
                prev_name, prev_time = stack.pop()

                if prev_time <= remain_time:
                    answer.append(prev_name)
                    remain_time -= prev_time
                else:
                    stack.append((prev_name, prev_time - remain_time))
                    remain_time = 0

    # 마지막 과제는 무조건 시작
    answer.append(plans[-1][0])

    # 남아있는 멈춘 과제 처리
    while stack:
        name, _ = stack.pop()
        answer.append(name)

    return answer

if __name__ == "__main__":
    plan = [
        ["science", "12:40", "50"],
        ["music", "12:20", "40"],
        ["history", "14:00", "30"],
        ["computer", "12:30", "100"]
    ]
    print(solution(plan))
