# 스택수열
# week2.md 파일에서 문제 "스택 수열" 참고

import sys

class Stack:
    def __init__(self):
        self.items = []

    def push(self, data):
        self.items.append(data)

    def pop(self):
        # 비어있을 때 pop을 시도하면 에러가 날 수 있으니 체크는시도
        # 출력은 절대 X
        if not self.isEmpty():
            return self.items.pop()
        return None

    def peek(self):
        # 스택이 비어있지 않을 때만 마지막 요소를 반환하고,
        # 비어있다면 None을 반환한다
        if not self.isEmpty():
            return self.items[-1]
        return None

    def isEmpty(self):
        # 파이썬스럽게(Pythonic) 빈 리스트는 False임을 활용
        return not self.items


def solution() -> None:
    # 1. 첫 번째 줄에서 n을 받는다.
    n: int = int(sys.stdin.readline().strip())

    # 2. 나머지 n개의 숫자를 리스트로 한 번에 받는다.
    # 리스트 내부 요소가 int임을 명시하기 위해 list[int]를 사용한다.
    target_sequence: list[int] = [int(sys.stdin.readline().strip()) for _ in range(n)]

    # 3. 필요한 도구 준비
    stack = Stack()             # 스택 객체 생성 (함수 종료 전까지 안전)
    result: list[str] = []      # '+', '-' 기록용
    current_num: int = 1        # 스택에 넣을 '다음 숫자' (1부터 시작)
    possible: bool = True       # 수열 제작 가능 여부

    # 4. 핵심 로직 수행
    for target in target_sequence:
        # STEP1. Push 단계
        # target이 현재 넣어야 할 숫자(current_num)보다 크거나 같다면
        # target과 같아질 때까지 숫자를 스택에 밀어 넣는다.
        while current_num <= target:
            stack.push(current_num)
            result.append('+')
            current_num += 1

        # STEP2. Check & pop 단계
        if stack.peek() == target:
            stack.pop()
            result.append('-')
        else:
            # 스택의 맨 위가 target과 다른경우
            # 이미 target보다 큰 숫자가 위를 덮고 있다는 뜻
            possible = False
            break

    # 5. 최종 출력
    if not possible:
        print("NO")
    else:
        print("\n".join(result))


if __name__ == "__main__":
    solution()