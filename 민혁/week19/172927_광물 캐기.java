import java.util.*;

class Solution {
    
    //최솟값을 구하기 위한 비교값
    static int Min = Integer.MAX_VALUE;
    static int[] Picks;
    static List<List<String>> PartitionedMinerals = new ArrayList<>();
    
    public int solution(int[] picks, String[] minerals) {
        //곡괭이별로 5개까지만 캘수있음
        //광물은 주어진 순서로만 캘수있음
        //곡괭이를 한번 선택하면 광물5개를 연속으로 캐야만함(중간에 못바꾸는듯)
        //다이아 철 돌 곡괭이를 0~5개 가지고있음(곡괭이가 0개인경우는없음)
        //광물은 다이아,철,돌로 이루어져있음
        //작업을 끝내기위한 최소한의 피로도를 구해라
        //가지고있는곡괭이로 작업을 못끝내면?
        
        //완전탐색으로 가능한지 먼저 확인
        // 3^10 ~= 66000 -> 아마도 가능
        
        Picks = picks;
        
        // minerals을 5개씩 묶어서 조각내기
        int length = minerals.length;
        int partition = length / 5;
        int remain = length % 5;

        for (int i = 0; i < partition; i++) {
            List<String> partitioned = new ArrayList<>();

            for (int j = 0; j < 5; j++) {
                partitioned.add(minerals[i * 5 + j]);
            }

            PartitionedMinerals.add(partitioned);
        }

        if (remain > 0) {
            List<String> partitioned = new ArrayList<>();

            for (int i = 0; i < remain; i++) {
                partitioned.add(minerals[length - remain + i]);
            }

            PartitionedMinerals.add(partitioned);
        }
        
        // 각 조각을 곡괭이로 뿌리기
        dfs(0, 0);

        return Min;
    }
    
    public void dfs(int groupIndex, int fatigue) {
        // 이미 현재 최솟값보다 피로도가 크면 더 볼 필요 없음
        if (fatigue >= Min) {
            return;
        }

        // 모든 묶음을 캤거나, 곡괭이를 모두 썼을 때
        if (groupIndex == PartitionedMinerals.size()
                || (Picks[0] == 0 && Picks[1] == 0 && Picks[2] == 0)) {
            Min = Math.min(Min, fatigue);
            return;
        }

        // 0다이아 1철 2돌 곡괭이
        for (int pickType = 0; pickType < 3; pickType++) {
            if (Picks[pickType] == 0) {
                continue;
            }

            // 현재 묶음에 이 곡괭이를 사용
            Picks[pickType]--;
            // 이번턴에 캘 광물 묶음
            List<String> partitionedMinerals = PartitionedMinerals.get(groupIndex);
            
            int currentFatigue = getFatigue(
                partitionedMinerals,
                pickType
            );

            dfs(groupIndex + 1, fatigue + currentFatigue);

            // 다른 경우의 수를 위해 원상복구
            Picks[pickType]++;
        }
    }
    
    // 곡괭이로 캐는데 드는 피로도
    public int getFatigue(List<String> minerals, int pickType) {
        int fatigue = 0;

        for (String mineral : minerals) {
            if (pickType == 0) { // 다이아 곡괭이
                fatigue += 1;
            } else if (pickType == 1) { // 철 곡괭이
                if (mineral.equals("diamond")) {
                    fatigue += 5;
                } else {
                    fatigue += 1;
                }
            } else { // 돌 곡괭이
                if (mineral.equals("diamond")) {
                    fatigue += 25;
                }
                else if (mineral.equals("iron")) {
                    fatigue += 5;
                }
                else {
                    fatigue += 1;
                }
            }
        }

        return fatigue;
    }
}
