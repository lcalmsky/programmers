package io.lcalmsky.programmers.오픈채팅방;

import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        List<String> logs = new ArrayList<>();
        Map<String, String> userMap = new HashMap<>();

        for (String log : record) {
            StringTokenizer st = new StringTokenizer(log);
            String command = st.nextToken();
            String userId = st.nextToken();
            String nickname = !command.equals("Leave") ? st.nextToken() : "";
            switch (command) {
                case "Enter":
                    userMap.put(userId, nickname);
                    logs.add(userId + "님이 들어왔습니다.");
                    break;
                case "Leave":
                    logs.add(userId + "님이 나갔습니다.");
                    break;
                case "Change":
                    userMap.put(userId, nickname);
                    break;
            }
        }

        String[] answer = new String[logs.size()];
        int logIdx = 0;
        for (String str : logs) {
            String userId = str.substring(0, str.indexOf("님"));
            answer[logIdx++] = str.replace(userId, userMap.get(userId));
        }

        return answer;
    }
}
