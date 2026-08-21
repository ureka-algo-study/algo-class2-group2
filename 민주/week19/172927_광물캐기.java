import java.util.*;


class Solution {
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        
        int all_picks = picks[0] + picks[1] + picks[2];
        
        int minerals_size = minerals.length % 5 == 0 ? minerals.length/5 : minerals.length/5 + 1;
        int max = (all_picks * 5 > minerals.length) ? minerals_size : all_picks;
        
        // System.out.println("max : " + minerals_size + " , " + all_picks + " = " + max);
        int[][] minerals_cnt = new int[max][3];
        
        
        for(int i=0; i<Math.min(max * 5, minerals.length); i++){
            int idx = 0;
            if(minerals[i].equals("diamond")){
                idx = 0;
            }
            else if(minerals[i].equals("iron")){
                idx = 1;
            }
            else{
                idx = 2;
            }
            minerals_cnt[i/5][idx] += 1;
        }
        
        Arrays.sort(minerals_cnt, (a,b) -> b[2] - a[2]);
        Arrays.sort(minerals_cnt, (a,b) -> b[1] - a[1]);
        Arrays.sort(minerals_cnt, (a,b) -> b[0] - a[0]);
        
        // for(int i=0; i<minerals_cnt.length; i++){
        //     System.out.println(Arrays.toString(minerals_cnt[i]));
        // }
        
        int idx = 0;
        for(int i=0; i<max; i++){
            while(picks[idx] <= 0 && idx <= 2){
                idx ++;
            }

            if(idx > 3) break;
            if(idx == 0){
                answer += minerals_cnt[i][0];
                answer += minerals_cnt[i][1];
                answer += minerals_cnt[i][2];
            }
            else if (idx == 1){
                answer += minerals_cnt[i][0] * 5;
                answer += minerals_cnt[i][1];
                answer += minerals_cnt[i][2];
            }
            else if (idx == 2){
                answer += minerals_cnt[i][0] * 25;
                answer += minerals_cnt[i][1] * 5;
                answer += minerals_cnt[i][2];
            }
            picks[idx] -= 1;
            
        }
        return answer;
    }
}