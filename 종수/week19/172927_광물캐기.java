package 프로그래머스;

import java.util.*;

class Solution {
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;

        int pick_cnt = 0;
        for (int n : picks) {
            pick_cnt += n;
        }

        pick_cnt *= 5; // 총 캘 수 있는 광물 수

        int max = pick_cnt <= minerals.length ? pick_cnt : minerals.length;

        int stone = 1, iron = 5, dia = 25;

        // 총 그룹 개수
        int groupCnt = (max + 4) / 5;

        // [그룹][0: 다이아 개수, 1: 철 개수, 2: 돌 개수, 3: 난이도]
        int[][] groups = new int[groupCnt][4];

        int groupIndex = 0;

        for (int i = 0; i < max; i++) {
            // groups[groupIndex][0] -> 다이아의 갯수
            if (minerals[i].equals("diamond")) {
                groups[groupIndex][0]++;
                groups[groupIndex][3] += dia;
            // groups[groupIndex][1] -> 철의 갯수
            } else if (minerals[i].equals("iron")) {
                groups[groupIndex][1]++;
                groups[groupIndex][3] += iron;
            // groups[groupIndex][2] -> 돌의 갯수
            } else {
                groups[groupIndex][2]++;
                groups[groupIndex][3] += stone;
            }
            // groups[groupIndex][3] -> 5개의 광물의 가중치? 암튼
            // 5개를 다 봤으면 다음 그룹으로 이동
            if (i % 5 == 4) {
                groupIndex++;
            }
        }

        // 난이도가 높은 그룹부터 정렬
        Arrays.sort(groups, (a, b) -> b[3] - a[3]);

        groupIndex = 0;

        // 다이아 곡괭이
        while (picks[0] > 0 && groupIndex < groups.length) {

            answer += groups[groupIndex][0]
                    + groups[groupIndex][1]
                    + groups[groupIndex][2];

            groupIndex++;
            picks[0]--;
        }

        // 철 곡괭이
        while (picks[1] > 0 && groupIndex < groups.length) {

            answer += groups[groupIndex][0] * 5
                    + groups[groupIndex][1]
                    + groups[groupIndex][2];

            groupIndex++;
            picks[1]--;
        }

        // 돌 곡괭이
        while (picks[2] > 0 && groupIndex < groups.length) {

            answer += groups[groupIndex][0] * 25
                    + groups[groupIndex][1] * 5
                    + groups[groupIndex][2];

            groupIndex++;
            picks[2]--;
        }

        return answer;
    }
}