package programmers_42888_오픈채팅방;

import java.util.*;

class Solution {
    public String[] solution(String[] record) {

        Map<String, String> map = new HashMap<>();
        int cnt = 0;

        // 키-값 저장
        for (int i = 0; i < record.length; i++) {
            String[] word = record[i].split(" ");
            String status = word[0];
            if (status.equals("Leave")) {
                cnt++;
                continue;
            }
            String userId = word[1];
            String name = word[2];

            if (status.equals("Change")) {
                map.replace(userId, name);
                continue;
            }

            map.put(userId, name);
            cnt++;
        }

        String[] answer = new String[cnt];

        cnt = 0;
        for (int i = 0; i < record.length; i++) {
            String[] word = record[i].split(" ");
            String status = word[0];
            if (status.equals("Change")) {
                continue;
            }

            String userId = word[1];

            if (status.equals("Enter")) {
                answer[cnt] = map.get(userId) + "님이 들어왔습니다.";
            } else if (status.equals("Leave")) {
                answer[cnt] = map.get(userId) + "님이 나갔습니다.";
            }
            cnt++;
        }

        return answer;
    }
}

