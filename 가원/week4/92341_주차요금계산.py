# 프로그래머스 92341 주차 요금 계산

import math

from typing import List, Dict

def solution(fees: List[int], records: List[str]) -> List[int]:
    '''
    Params:
        - feeds : 주차 요금을 나타내는 정수 1차원 배열 feeds
        - records : 자동차 입/출차 내역을 나타내는 문자열 배열
            - time : IN or OUT 에 따라서 입 출차 시간
            - car_num : 차량 번호
    '''

    # 답안 리스트, 입차 기록 딕셔너리, 총 주차 시간 딕셔너리
    answer: List[int] = []
    parked: Dict = {}
    total_time: Dict = {}

    # 주차 요금 계산을 위한 기본 시간, 기본 요금, 단위 시간, 단위 요금  
    default_time, default_fee, unit_time, unit_fee = fees
    
    # STEP1 : 입출차 기록 처리
    # 입차 기록이 있으면 parked 딕셔너리에 차량 번호와 입차 시간 저장
    # 출차 기록이 있으면 parked 딕셔너리에서 차량 번호로 입차 시간 가져와서 출차 시간과 비교하여 
    # 주차 시간 계산 후 total_time 딕셔너리에 누적 주차 시간 저장
    for record in records:
        time, car_num, in_out = record.split()

        # 입차 기록이 있으면 parked 딕셔너리에 차량 번호와 입차 시간 저장
        if in_out == "IN":
            parked[car_num] = time
        
        # 출차 기록이 있으면 parked 딕셔너리에서 차량 번호로 입차 시간 가져와서
        # 출차 시간과 비교하여 주차 시간 계산 후 total_time 딕셔너리에 누적 주차 시간 저장
        elif in_out == "OUT":
            in_time: str = parked.pop(car_num)
            h, m = in_time.split(":")
            in_minutes = int(h) * 60 + int(m)

            # 출차 시간 계산
            out_h, out_m = time.split(":")
            out_minutes = int(out_h) * 60 + int(out_m)

            # 주차 시간 계산
            parking_time = out_minutes - in_minutes
            total_time[car_num] = total_time.get(car_num, 0) + parking_time

    # STEP2 : 미 출차 차량 처리
    # 주차장에 남아있는 차량은 23:59에 출차된 것으로 간주하여 주차 시간 계산 후 
    # total_time 딕셔너리에 누적 주차 시간 저장
    for car_num, in_time in parked.items():
        # 23:59에 출차된 것으로 간주하여 주차 시간 계산
        h, m = in_time.split(":")
        in_minutes = int(h) * 60 + int(m)
        last_time = 23 * 60 + 59    # 1439 분

        # 주차 시간 계산
        parking_time = last_time - in_minutes
        total_time[car_num] = total_time.get(car_num, 0) + parking_time

    # STEP3 : 주차 요금 계산
    # total_time 딕셔너리를 차량 번호 순으로 정렬하여 주차 요금 계산 후 답안 리스트에 저장
    # 주차 요금 계산은 기본 시간과 기본 요금을 기준으로 주차 시간이 기본 시간을 초과하는 경우 
    # 단위 시간마다 단위 요금이 추가되는 방식으로 계산
    for car_num in sorted(total_time):
        t: int = total_time[car_num]

        # 주차 요금 계산
        if t <= default_time:
            fee = default_fee
        # 주차 시간이 기본 시간을 초과하는 경우 단위 시간마다 단위 요금이 추가되는 방식으로 계산
        else:
            fee = default_fee + math.ceil((t - default_time) / unit_time) * unit_fee

        answer.append(fee)

    return answer

if __name__ == "__main__":
    feeds_arr: List[int] = [180, 5000, 10, 600]

    record_arr: List[str] = [
                "05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT",
                "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN",
                "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"
            ]

    print(solution(feeds_arr, record_arr))