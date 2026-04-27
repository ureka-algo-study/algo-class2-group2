# 프로그래머스 주식가격
'''
문제의 목적
1. 초 단위로 기록된 주식가격이 담긴 배열 prices가 매개변수로 주어질 때, 가격이 떨어지지 않은
기간은 몇 초인지를 return 하도록 solution 함수를 완성하라

'''

import sys

# 1. 일반적인 방법의 직관적인 풀이 (Brute Force)
def solution(prices):
    answer = []

    for i in range(len(prices)):
        time = 0
        for j in range(i + 1, len(prices)):
            # 일단 1초가 지났으므로 시간을 더한다
            time += 1
            # 가격이 떨어졌다 -> 가격을 비교할 필요가 없다
            if prices[i] > prices[j]:
                break
            answer.append(time)

    return answer


# 2. 자료구조 스택을 활용한 방법 (Stack)
def solution2(prices):
    n = len(prices)

    # 1. 정답 리스트를 0으로 초기화
    answer = [0] * n

    # 2. 인덱스를 담을 스택 생성
    stack = []

    for i in range(n):
        # 스택이 비어있지 않고, 현재 가격이 스택 TOP의 가격보다 작다면 (가격 하락)
        while stack and prices[stack[-1]] > prices[i]:
            # 가격이 떨어졌으므로 스택에서 꺼냄
            past_index = stack.pop()

            # 현재 시점(i)과 과거 시점(past_index)의 차이가 유지 기간
            answer[past_index] = i - past_index

        # 현재 인덱스를 스택에 넣음
        stack.append(i)

    while stack:
        past_index = stack.pop()

        # 전체 길이에서 해당 시점을 뺀 값이 유지 기간
        answer[past_index] = n - 1 - past_index

    return answer


if __name__ == "__main__":
    solution()