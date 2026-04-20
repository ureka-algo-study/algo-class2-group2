class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        int [] count = new int[schedules.length];
        for(int i = 0; i < schedules.length; i++){
            for(int j = 0; j < 7; j++){
                if((j + startday) % 7 == 0 || (j + startday) % 7 == 6){
                    count[i] += 1;
                }else {
                    if (((timelogs[i][j] / 100 * 60) + (timelogs[i][j] % 100)) 
                         <= ((schedules[i] / 100 * 60) + (schedules[i] % 100) + 10)) {
                        count[i] += 1;
                    }
                }
            }
        }
        for(int t = 0; t < count.length; t++){
            if(count[t] == 7){
                answer++;
            }
        }
        return answer;
    }
}