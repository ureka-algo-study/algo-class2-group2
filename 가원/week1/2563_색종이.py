# 백준 2563 색종이

'''
내 생각

1. 문제를 먼저 이해해보자.
- 우선은 100 x 100 평면에서 10 x 10 인 색종이 여러장을 겹쳐서 붙힌후
색종이가 붙은 부분의 넓이를 구하는 것이다.

2. 중복은 어떻게 처리할지?
- 색종이를 붙히면 중복되는 부분이 무조건 나온다. 그 부분에 대해서는 
어떻게 한번 처리할까?

3. 그냥 직관적으로 떠오르는 내 생각
- 흠...그냥 생각난건데 우선 2차원 배열 100 x 100을 0으로 전부 초기화
진행하고 그냥 색종이 붙는 곳을 1로 바꾸고, 그 1로 된 부분의 카운트만
세어주면 되지 않을까?
'''

import sys


# 100 x 100 크기의 도화지를 0으로 초기화 코드
# 이를 전역변수로 선언
paper = [[0] * 100 for _ in range(100)]


def solution() -> int:
    paper_num = int(sys.stdin.readline())
    

    # 색종이 붙은 부분 넓이 구하기
    for i in range(paper_num):
        x, y = map(int, sys.stdin.readline().split())

        for j in range(x, x + 10):
            for k in range(y, y + 10):
                paper[j][k] = 1
    
    
    # 색종이 넓이 부분 count 세기
    count = 0
    for i in range(100):
        for j in range(100):
            if paper[i][j] == 1:
                count += 1
    
    return count



if __name__ == "__main__":
    result = solution()
    print(result)
