import java.util.*;

class Solution {
    public String[] solution(String[] records) {
        /*
        user_id와 이름 등록(최종 user_id와 이름만이 남음)
        enter -> user_id + 님이 들어왔습니다.
        leave -> user_id + 님이 나갔습니다.
        */

        Map<String, String> users = new HashMap<>();
        for(String record : records) {
            //parsedRecord ["Enter", "uid1234", " Muzi"]
            String[] pr = record.split(" ");
            if(pr[0].equals("Enter") || pr[0].equals("Change")) {
                users.put(pr[1],pr[2]);
            }
        } //for

        List<String> result = new ArrayList<>();

        for(String record : records) {
            String[] pr = record.split(" ");
            String userId = pr[1];
            String userName = users.get(userId);

            if(pr[0].equals("Enter")) {
                result.add(userName + "님이 들어왔습니다.");
            } else if(pr[0].equals("Leave")) {
                result.add(userName + "님이 나갔습니다.");
            }
        } //for

        return result.stream().toArray(String[]::new);
    }
}