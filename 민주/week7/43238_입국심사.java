class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        long mid = 0;
        long l = 0;
        long r = 0;
        for(int i=0; i<times.length; i++){
            r = (long) Math.max(r, times[i]);
        }
        r *= n;
        
        int test = 0;
        while(l <= r){ // 
            mid = (long) (l+r)/2;
            System.out.print(l + " " + answer + " " + r);
            long cnt = 0;
            for(int i=0; i<times.length; i++){
                cnt += mid/times[i];
            }
            System.out.println(" : " + cnt);
            
            if(cnt >= n){
                answer = mid;
                r = mid-1;
            }
            else{
                l = mid+1;
            }
        }
        return answer;
    }
}