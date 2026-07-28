import java.util.*;
class Solution {
    public String solution(int n) {
        /*
        17 -> 5...2 [2]
        5 -> 1... 2 [2,2]
        1 -> 0... 1 [1,2,2]
        3^0 * 2 + 3^1 * 2 + 3^2 * 1 = 2 + 6 + 9 = 17
        */
        List<Integer> list = new ArrayList<>();
        while(n > 0) {
            int remain = n % 3;
            if(remain == 0) {
                list.addFirst(4);
                n = n / 3 - 1;
            } else if(remain == 1) {
                list.addFirst(1);
                n /= 3;
            } else if(remain == 2) {
                list.addFirst(2);
                n /= 3;
            }
        } //while
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
        }
        return sb.toString();
        
    }
}
