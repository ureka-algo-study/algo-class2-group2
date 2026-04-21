import sys


def solution(schedules, timelogs, startday):
    '''
    params
    - schedules: 1차원 배열 형태의 각 직원이 원하는 출근 희망 시간
    - timelogs: 직원들이 일주일 동안 출근한 시각을 담은 2차원 정수 배열 (실제 직원들 출근시간)
    - startday: 이벤트 시작한 요일을 의미하는 정수
    
    우리가 원하는 결과값은 일주일동안 직원들이 자기가 원하는 출근 희망 시간 지각안하고
    재시간에 출근한 직원의 수
    '''
    answer = 0

    for i in range(len(schedules)):
        goal_time = schedules[i]

        # 지각 허용 시간 계산(희망 시간 + 10분)
        h, m = divmod(goal_time, 100)
        m += 10

        if m >= 60:
            h += 1
            m -= 60
          
        limit_time = h * 100 + m   # 지각 허용시간 완성 -> 이제부터 limit_time  이 마지노선 시간

        # 상품받을 자격 적격 심사
        is_eligible = True
        
        # 이제 지각 마지노선 시간과 실제 직원의 출근시간 비교
        for j in range(7):
            # 현재 요일 계산 (1: 월, 2: 화, 3: 수,...., 7: 일) 
            current_day = (startday + j - 1) % 7 + 1

            # 주말(6, 7)은 패스
            if current_day >= 6:
                continue

            # 평일인데 지각 있으면 탈락
            if timelogs[i][j] > limit_time:
                is_eligible = False
                break

        # 만약에 여기까지 통과했다면 이제 여기 아래부터는 지각을 하지 않은 직원
        if is_eligible:
            answer += 1

    return answer


if __name__ == "__main__":
    print("Hello")
