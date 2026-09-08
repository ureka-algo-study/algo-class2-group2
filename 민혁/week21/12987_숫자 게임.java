import java.util.*;
class Solution {
    public int solution(int[] A, int[] B) {
        // B의 가장 작은 수와 A의 가장 작은 수를 비교
        
        Arrays.sort(A);
        Arrays.sort(B);
        
        int count = 0;
        int aPointer = 0;
        int bPointer = 0;
        
        for(int i = 0; i < B.length; i ++) {
            if(B[bPointer] > A[aPointer]) {
                count ++;
                bPointer++;
                aPointer++;
            } else {
                bPointer++;
            }
        }
        
        return count;
        
        
    }
}
