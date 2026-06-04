# 프로그래머스 43163 단어변환

from collections import deque
from typing import List


def solution(begin: str, target: str, words: List[str]) -> int:
    if target not in words:
        return 0
    
    queue = deque([(begin, 0)])  # (현재 단어, 변환 횟수)
    visited = set()  # 방문한 단어 집합
    
    while queue:
        word, step = queue.popleft()

        if word == target:
            return step
        
        for next_word in words:
            diff = sum(a != b for a, b in zip(word, next_word))
            if diff == 1 and next_word not in visited:
                visited.add(next_word)
                queue.append((next_word, step + 1))

    return 0


if __name__ == "__main__":
    main_begin: str = "hit"
    main_target: str = "cog"
    main_words: List[str] = ["hot", "dot", "dog", "lot", "log", "cog"]

    print(solution(main_begin, main_target, main_words))