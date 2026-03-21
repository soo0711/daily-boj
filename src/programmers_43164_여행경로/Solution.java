package programmers_43164_여행경로;

/**
 문제이해
 여행경로를 찾아서 경로를 출력해라

 제한사항
 모든 티켓을 사용해야함

 풀이과정
 티켓 -> 연결된 곳 (bfs/dfs)
 dfs로 풀이

 1. 방문했는지
 2. node에 출발하는 곳, 경로
 3. ticket모두 안 쓰면 false
 **/
import java.util.*;

class Solution {
    int length;
    List<String> path;
    boolean[] visit;
    public String[] solution(String[][] tickets) {
        length = tickets.length;
        visit = new boolean[length];

        // 정렬
        Arrays.sort(tickets, (x1, x2) -> {
            if (x1[0].equals(x2[0])) {
                return x1[1].compareTo(x2[1]);
            }
            return x1[0].compareTo(x2[0]);
        });

        dfs(tickets, "", "ICN", 0, new ArrayList<>());
        String[] answer = path.toArray(new String[0]);
        return answer;
    }


    boolean dfs(String[][] tickets, String start, String end, int cnt, List<String> path) {
        if (tickets.length == cnt) {
            path.add(end);
            this.path = path;
            return true;
        }

        for (int i = 0; i < length; i++) {
            if (!visit[i] && end.equals(tickets[i][0])) {
                visit[i] = true;
                path.add(end);
                if (dfs(tickets, tickets[i][0], tickets[i][1], cnt + 1, path)) {
                    return true;
                }
                visit[i] = false;
                path.remove(path.size() - 1);
            }
        }

        return false;
    }
}


