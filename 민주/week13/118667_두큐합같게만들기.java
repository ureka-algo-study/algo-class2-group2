import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = -1;
        
        long sum1 = 0;
        long sum2 = 0;
        
        for(int i=0; i<queue1.length; i++){
            sum1 += queue1[i];
            sum2 += queue2[i];
        }
        
        int test = 0;
        int idx1 = 0;
        int idx2 = 0;
        
        while(idx1 < queue1.length * 2 && idx2 < queue2.length * 2){
            if(sum1 == sum2){
                return test;
            }
            if(sum1 > sum2){
                // System.out.println("===================");
                // System.out.println(sum1 + ", " + sum2);
                
                if(idx1 >= queue1.length) {
                    sum1 -= queue2[idx1-queue1.length];
                    sum2 += queue2[idx1-queue1.length];
                }
                else{
                    sum1 -= queue1[idx1];
                    sum2 += queue1[idx1];
                }
                idx1++;
                test++;
                
            }
            else{
                if(idx2 >= queue2.length) {
                    sum1 += queue1[idx2-queue2.length];
                    sum2 -= queue1[idx2-queue2.length];
                }
                else{
                    sum1 += queue2[idx2];
                    sum2 -= queue2[idx2];
                }
                
                // System.out.println("q2 poll : " + queue2[idx2]);
                // System.out.println(sum1 + ", " + sum2);
                // System.out.println("===================");
                idx2 ++;
                test++;
            }
        }
        
        return (sum1 == sum2) ? test : -1;
    }
}