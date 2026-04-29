import sys
import time

from itertools import product

# 1. CPython 을 적용한 브루트 포스 방법 (무식하게 빠른 브루트포스)
def solution(numbers, target):
    # 각 숫자마다 (+ , -) 를 선택할 수 있는 옵션들
    # [(1, -1), (2, -2), (-1, 1), ...]
    options = [(x, -x) for x in numbers]

    # 모든 조합의 합계를 구함
    # product(*options)는 모든 (+1, -2, +1, ...) 조합을 생성
    case_sums = [sum(case) for case in product(*options)]

    return case_sums.count(target)


# 2. 그냥 일반 반복문을 적용한 브루트 포스 방법 (정석 풀이의 브루트 포스)
def brute_force_for(numbers, target):
    count = 0
    n = len(numbers)

    # 0부터 2^n - 1까지의 숫자를 부호 조합으로 보고 전부 확인
    # 예: n=3일 때 000, 001, 010, ... 111
    for mask in range(1 << n):
        total = 0

        for i in range(n):
            if mask & (1 << i):
                total += numbers[i]
            else:
                total -= numbers[i]

        if total == target:
            count += 1

    return count


# 3. DFS 문제풀이를 이용한 방법
def solution2_dfs(numbers, target) -> int:
    answer = dfs_solution(numbers, 0, target, 0)
    return answer


# 4. DFS 문제풀이 방법을 이용하는 solution2 에서 호출할 DFS 함수
def dfs_solution(numbers, depth, target, result) -> int:
    if depth == len(numbers):   # 마지막 노드까지 진행했을 때
        if target == result:    # target 값과 합계가 같다면 True값 1 반환
            return 1
        else:
            return 0    # target 과 같은 값이 없다면 0 반환

    plus = dfs_solution(numbers, depth + 1, target, result + numbers[depth])
    minus = dfs_solution(numbers, depth + 1, target, result - numbers[depth])

    return plus + minus


# 5. 성능 측정 벤치마킹
def measure_time(func, numbers, target, repeat=1000):
    start = time.perf_counter()

    for _ in range(repeat):
        func(numbers, target)

    end = time.perf_counter()
    return end - start


if __name__ == "__main__":
    test_number = [1, 1, 1, 1, 1]
    test_target_num = 3

    product_result = solution(test_number, test_target_num)
    brute_force_result = brute_force_for(test_number, test_target_num)

    print(f"product + list comprehension 결과: {product_result}")
    print(f"일반 for 브루트포스 결과: {brute_force_result}")

    repeat = 10000
    product_time = measure_time(solution, test_number, test_target_num, repeat)
    brute_force_time = measure_time(brute_force_for, test_number, test_target_num, repeat)
    product_avg_time = product_time / repeat
    brute_force_avg_time = brute_force_time / repeat
    time_difference = abs(product_time - brute_force_time)

    print(f"\n반복 횟수: {repeat}")
    print(f"product + list comprehension 실행 시간: {product_time:.6f}초")
    print(f"일반 for 브루트포스 실행 시간: {brute_force_time:.6f}초")
    print(f"product + list comprehension 1회 평균 시간: {product_avg_time:.10f}초")
    print(f"일반 for 브루트포스 1회 평균 시간: {brute_force_avg_time:.10f}초")
    print(f"두 방식의 총 실행 시간 차이: {time_difference:.6f}초")

    if product_time < brute_force_time:
        speed_ratio = brute_force_time / product_time
        print(f"product + list comprehension 방식이 약 {speed_ratio:.2f}배 빠릅니다.")
    elif product_time > brute_force_time:
        speed_ratio = product_time / brute_force_time
        print(f"일반 for 브루트포스 방식이 약 {speed_ratio:.2f}배 빠릅니다.")
    else:
        print("두 방식의 실행 시간이 거의 같습니다.")
