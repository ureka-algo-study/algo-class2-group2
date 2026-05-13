import java.util.*;

class Solution {
    public String[] solution(String[][] plans) {
        String[] answer = new  String[plans.length];
        
        int[][] numplans = new int[plans.length][plans[0].length];
        
        for(int i=0; i<plans.length; i++){
            StringTokenizer token = new StringTokenizer(plans[i][1],":");
            numplans[i][0] = i;
            numplans[i][1] = Integer.parseInt(token.nextToken()) * 60 + Integer.parseInt(token.nextToken());
            numplans[i][2] = Integer.parseInt(plans[i][2]);
        }
        
        Stack<int[]> stk = new Stack<>();
        
        Arrays.sort(numplans, (a, b) -> a[1] - b[1]);
        
        // for(int i=0; i<plans.length; i++){
        //     System.out.println(Arrays.toString(numplans[i]));
        // }
        
        int idx = 0;
        for(int i=0; i<numplans.length-1; i++){
            int remainTime = numplans[i+1][1] - numplans[i][1];
            if(numplans[i][2] == remainTime){ // 시간이 딱 맞으면
                answer[idx++] = plans[numplans[i][0]][0];
                continue;
            }
            else if(numplans[i][2] < remainTime){ // 시간 남음
                remainTime -= numplans[i][2];
                answer[idx++] = plans[numplans[i][0]][0];
                
                if(stk.isEmpty()) continue;
                while(!stk.isEmpty() && remainTime >= stk.peek()[1]){ // 안끝난 일들 마무리
                    int[] pop = stk.pop();
                    answer[idx++] = plans[pop[0]][0];
                    remainTime -= pop[1];
                }
                if(!stk.isEmpty() && remainTime > 0){
                    int[] pop = stk.pop();
                    stk.push(new int[] {pop[0], pop[1] - remainTime});
                }
            }
            else{ // 시간 모자람
                stk.push(new int[]{numplans[i][0], numplans[i][2]-remainTime});
            }
        }
        stk.push(new int[] {numplans[numplans.length-1][0], numplans[numplans.length-1][2]});
        while(!stk.isEmpty()){
            int[] pop = stk.pop();
            answer[idx++] = plans[pop[0]][0];
        }
        return answer;
    }
}