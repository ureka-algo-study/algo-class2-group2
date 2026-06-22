package 종수.week10;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;

        // 모든 스킬트리를 검사
        for (String skillTree : skill_trees) {

            // 선행 스킬만 저장
            StringBuilder sb = new StringBuilder();

            // 스킬트리의 문자를 하나씩 확인
            for (char c : skillTree.toCharArray()) {

                // 선행 스킬에 포함되어 있으면 저장
                if (skill.indexOf(c) != -1) {
                    sb.append(c);
                }
            }

            // 추출한 문자열이 skill의 앞부분이면 가능한 스킬트리
            // .equals를 사용하면 아예 똑같아야함. CB나 C만 있을 경우에는 오답처리
            if (skill.startsWith(sb.toString())) {
                answer++;
            }
        }

        return answer;
    }
}