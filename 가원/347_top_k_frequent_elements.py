# 리트코드: top-k frequent

# 리트코드 : top-k frequent

from typing import List

class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        # 1. 빈도수 계산
        count_map = {}
        for num in nums:
            count_map[num] = count_map.get(num, 0) + 1

        # 2. 인덱스 = 빈도수, 값 = 숫자들의 리스트
        # 빈도수는 0부터 len(nums)까지 가능하므로 크기는 len(nums) + 1
        buckets = [[] for _ in range(len(nums) + 1)]

        for num, freq in count_map.items():
            buckets[freq].append(num)

        # 3. 빈도수가 높은 쪽(뒤에서부터) 정답 채우기
        result = []
        for i in range(len(buckets) -1, -1, -1):
            for num in buckets[i]:
                result.append(num)
                if len(result) == k:
                    return result

        # 4. 출력

        # print(count_map)
        # print(*buckets)
        # print(result)

        # return []


if __name__ == "__main__":
    # 1. 테스트할 입력 데이터 준비 (1차원 배열과 k값)
    test_nums = [1, 1, 1, 2, 2, 3]
    test_k = 2

    # 2. Solution 클래스의 객체(인스턴스) 생성
    solution_object = Solution()

    # 3. 생성한 객체의 함수를 호출하며 데이터 전달하기
    # 함수가 반환하는 값(여기서는 임시로 [])을 변수에 저장합니다.
    result = solution_object.topKFrequent(test_nums, test_k)

    print("최종 반환 값:", result)
