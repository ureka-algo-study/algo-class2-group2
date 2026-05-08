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

    answer: List[int] = []
    parked: Dict = {}
    total_time: Dict = {}

    default_time, default_fee, unit_time, unit_fee = fees

    for record in records:
        time, car_num, in_out = record.split()

        if in_out == "IN":
            parked[car_num] = time
        elif in_out == "OUT":
            in_time: str = parked.pop(car_num)
            h, m = in_time.split(":")
            in_minutes = int(h) * 60 + int(m)

            out_h, out_m = time.split(":")
            out_minutes = int(out_h) * 60 + int(out_m)

            parking_time = out_minutes - in_minutes
            total_time[car_num] = total_time.get(car_num, 0) + parking_time

    for car_num, in_time in parked.items():
        h, m = in_time.split(":")
        in_minutes = int(h) * 60 + int(m)
        last_time = 23 * 60 + 59    # 1439 분
        parking_time = last_time - in_minutes
        total_time[car_num] = total_time.get(car_num, 0) + parking_time

    for car_num in sorted(total_time):
        t: int = total_time[car_num]

        if t <= default_time:
            fee = default_fee
        else:
            fee = default_fee + math.ceil((t - default_time) / unit_time) * unit_fee

        answer.append(fee)

    return answer

if __name__ == "__main__":
    feeds_arr: List[int] = [180, 5000, 10, 600]

    record_arr: List[str] = ["05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT",
                  "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN",
                  "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"]

    print(solution(feeds_arr, record_arr))