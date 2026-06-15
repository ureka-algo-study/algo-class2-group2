class Solution {
    public int solution(int[] stones, int k) {
        int answer = 0;
        int cnt;
        int l = 0;
        int mid = 0;
        int r = 0;
        for(int i=0; i<stones.length; i++){
            r = Math.max(r, stones[i]);
        }
        // int test = 0;
        while(l<=r){ //
            cnt = 0;
            mid = (l+r)/2;
            
            int max = 0;
            for(int i=0; i<stones.length; i++){
                if(stones[i]<mid){
                    cnt++;
                }
                else{
                    max = Math.max(cnt, max);
                    cnt = 0 ;
                }
            }
            max = Math.max(cnt, max);
            // System.out.println(l + " " + mid + " " + r + " : " + max);
            
            if(max >= k){
                r = mid -1;
            }
            else{
                l = mid+1;
                answer = mid;
            }
        }
        return answer;
    }
}