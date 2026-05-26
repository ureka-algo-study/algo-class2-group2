# 프로그래머스 숫자블록

from typing import List


def solution(begin: int, end: int) -> List[int]:
    answer: List[int] = []
    
    for num in range(begin, end + 1):
        # 1번 위치는 무조건 0
        if num == 1:
            answer.append(0)
            continue
            
        max_divisor = 1  # 기본값: 소수일 경우 1번 블록
        
        # 2부터 루트 num까지 약수를 찾기.
        for i in range(2, int(num**0.5) + 1):
            if num % i == 0:
                # 짝꿍 약수(num // i)가 천만 이하인지 확인
                if num // i <= 10000000:
                    max_divisor = num // i
                    break  # 가장 큰 약수를 찾았으니 바로 종료
                else:
                    # 짝꿍 약수가 천만보다 크면, 일단 작은 약수(i)라도 저장해두기
                    # i가 커질수록 작은 약수는 점점 커지므로 계속 업데이트
                    max_divisor = i
        answer.append(max_divisor)
        
    return answer

    
if __name__ == "__main__":
    main_begin: int = 1
    main_end: int = 10
    main_result: List[int] = solution(main_begin, main_end)
    print(main_result)