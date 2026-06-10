package 종수.week8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public String[] solution(String[] record) {
        String[] answer;

        Map<String, String> map = new HashMap<>();
        List<String[]> list = new ArrayList<>();

        for (int i = 0; i < record.length; i++) {

            String[] info = new String[3];

            if(record[i].startsWith("Leave")){

                info = record[i].split(" ");
                list.add(info);

            }else{

                info = record[i].split(" ");
                map.put(info[1], info[2]);

                if(record[i].startsWith("Enter"))
                    list.add(info);
            }



        }

        answer = new String[list.size()];

        int idx = 0;
        for (int i = 0; i < list.size(); i++) {
            String action = list.get(i)[0];
            String uid = list.get(i)[1];

            String nickname = map.get(uid);

            if (action.equals("Enter")) {
                answer[idx++] = nickname + "님이 들어왔습니다.";
            } else {
                answer[idx++] = nickname + "님이 나갔습니다.";
            }
        }

        return answer;
    }
}