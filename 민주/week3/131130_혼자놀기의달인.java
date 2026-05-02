import java.util.*;

class Solution {
    public int solution(int[] cards) {
        // int answer = 0;
        boolean[] selected = new boolean[cards.length];
        int cnt = 0;
        
        ArrayList<Integer> ans = new ArrayList<>();
        
        for(int idx=0; idx<cards.length; idx++){
            if(selected[idx]) continue;
            
            HashSet<Integer> set = new HashSet<>();
            while(!selected[idx]){
                selected[idx] = true;
                set.add(cards[idx]);
                idx = cards[idx]-1;
                
            }
            ans.add(set.size());
        } //for idx
        
        int[] answer = ans.stream().sorted(Collections.reverseOrder()).mapToInt(i->i).toArray();
        System.out.println(Arrays.toString(answer));
        
        if(answer.length < 2){
            return 0;
        }
        return answer[0] * answer[1];
    }
}