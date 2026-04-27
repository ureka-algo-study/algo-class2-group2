import java.util.*;
class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        boolean[] gift = new boolean[schedules.length];
        
        Arrays.fill(gift, true);

        for(int i=0; i<schedules.length; i++){
            schedules[i]+=10;
            if(schedules[i] % 100 >=60){
                int hour = schedules[i] / 100;
                hour++;
                int min = (schedules[i] % 100) - 60;
                schedules[i] = hour * 100 + min;

            }
        }
        for(int i=0; i<schedules.length; i++){
            for(int j=0; j<timelogs[0].length; j++){
                if((startday-1+j) % 7 >= 5) continue;
                if(timelogs[i][j] > schedules[i]){
                    gift[i] = false;
                    break;
                }
            }
        }

        for(int i=0; i<gift.length; i++){
            if(gift[i]) answer++;
        }
        return answer;
    }
}