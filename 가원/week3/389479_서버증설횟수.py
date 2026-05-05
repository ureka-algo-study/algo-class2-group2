# 프로그래머스 - 서버 증설 횟수

from typing import List


def solution(players: List[int], m: int, k: int) -> int:
    needed: List[int] = []
    added: List[int] = [0] * 24

    answer: int = 0
    for i, p in enumerate(players):
        needed.append(p // m)
        live_server = sum(added[max(0, i - k + 1): i + 1])
        added[i] = max(0, needed[i] - live_server)
        answer += added[i]

    return answer


if __name__ == "__main__":
    players_args: List[int] = [0, 2, 3, 3, 1, 2, 0, 0, 0, 0, 4, 2, 0, 6, 0, 4, 2, 13, 3, 5, 10, 0, 1, 5]
    m: int = 3
    k: int = 5

    result: int = solution(players_args, m, k)
    print(result)
    # needed = []
    # for p in players_args:
    #     needed.append(p // m)
    #
    # print(needed)

