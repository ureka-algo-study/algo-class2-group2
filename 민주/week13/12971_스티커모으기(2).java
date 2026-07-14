class Solution {
    public int solution(int sticker[]) {
        int answer = 0;

        int[] dpo = new int[sticker.length+1];
        int[] dpx = new int[sticker.length+1];
        
        if(sticker.length == 1){
            return sticker[0];
        }
        dpo[0] = sticker[0];
        dpo[1] = sticker[0];
        dpx[0] = 0;
        dpx[1] = sticker[1];
        
        for(int i=2; i<sticker.length; i++){
            
            dpx[i] = Math.max(dpx[i-1], dpx[i-2] + sticker[i]);
            
            if(i==sticker.length-1) continue;
            dpo[i] = Math.max(dpo[i-1], dpo[i-2] + sticker[i]);
        }
        
        

        return Math.max(dpx[sticker.length-1], dpo[sticker.length-2]);
    }
}