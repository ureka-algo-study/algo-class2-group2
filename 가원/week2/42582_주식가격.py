# 프로그래머스 주식가격
'''
문제의 목적
1. 초 단위로 기록된 주식가격이 담긴 배열 prices가 매개변수로 주어질 때, 가격이 떨어지지 않은
기간은 몇 초인지를 return 하도록 solution 함수를 완성하라

'''

import random
import timeit

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


def trace_solution(prices):
    print("\n[Brute Force 과정]")
    answer = []

    for i in range(len(prices)):
        time = 0
        print(f"i={i}, 기준가격={prices[i]}")

        for j in range(i + 1, len(prices)):
            time += 1
            print(f"  j={j}, 비교가격={prices[j]}, 지난시간={time}", end="")

            if prices[i] > prices[j]:
                print(" -> 가격 하락, 중단")
                break

            print(" -> 유지")

        answer.append(time)
        print(f"  answer[{i}] = {time}")

    print("최종 결과:", answer)
    return answer


def trace_solution2(prices):
    print("\n[Stack 과정]")
    n = len(prices)
    answer = [0] * n
    stack = []

    for i in range(n):
        print(f"i={i}, 현재가격={prices[i]}, stack={stack}")

        while stack and prices[stack[-1]] > prices[i]:
            past_index = stack.pop()
            answer[past_index] = i - past_index
            print(
                f"  pop={past_index}, "
                f"{prices[past_index]} > {prices[i]} 이므로 "
                f"answer[{past_index}] = {answer[past_index]}"
            )

        stack.append(i)
        print(f"  push={i}, stack={stack}")

    print("남은 stack 처리")
    while stack:
        past_index = stack.pop()
        answer[past_index] = n - 1 - past_index
        print(f"  pop={past_index}, answer[{past_index}] = {answer[past_index]}")

    print("최종 결과:", answer)
    return answer


def benchmark(name, prices, repeat=10):
    brute_force_time = timeit.timeit(lambda: solution(prices), number=repeat)
    stack_time = timeit.timeit(lambda: solution2(prices), number=repeat)
    is_same = solution(prices) == solution2(prices)

    print(f"\n[{name}]")
    print(f"입력 길이: {len(prices):,}")
    print(f"반복 횟수: {repeat}")
    print(f"결과 동일 여부: {is_same}")
    print(f"Brute Force 총 시간: {brute_force_time:.6f}초")
    print(f"Stack 총 시간:       {stack_time:.6f}초")
    print(f"Brute Force 평균:   {brute_force_time / repeat:.8f}초")
    print(f"Stack 평균:         {stack_time / repeat:.8f}초")
    print(f"속도 차이:           {brute_force_time / stack_time:.2f}배")


def main():
    sample = [1, 2, 3, 2, 3]

    print("예제 입력:", sample)
    trace_solution(sample)
    trace_solution2(sample)

    benchmark("랜덤 입력", [random.randint(1, 10000) for _ in range(10000)])
    benchmark("계속 상승하는 입력", list(range(3000)))
    benchmark("계속 하락하는 입력", list(range(10000, 0, -1)))
    benchmark("가격이 전부 같은 입력", [10000] * 3000)


if __name__ == "__main__":
    main()
