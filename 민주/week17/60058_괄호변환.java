class Solution {
    public String solution(String p) {
        String answer = "";

        
        
        
        return split(p);
    }
    
    String split(String str){
        if(str.equals("")) return new String("");
        
        int cnt = 0;
        
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i) == '('){
                cnt ++;
            }
            else{
                cnt --;
                
            }
            
            if(cnt == 0){
                String u = str.substring(0, i+1);
                String v = str.substring(i+1, str.length());
                if(isCorrect(u)){
                    v = split(v);
                    return u + v;
                }
                else{
                    String result = "(";
                    
                    result += split(v);
                    result += ")";
                    
                    for(int j=1; j<u.length()-1; j++){
                        if(u.charAt(j) == '(')
                            result += ")";
                        else
                            result += "(";
                    }
                    return result;
                }
            }
        }
        
        return "";
    }
    
    boolean isCorrect(String str){
        return (str.charAt(0) == ')') ? false: true;
    }
}