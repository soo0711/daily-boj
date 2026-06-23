package programmers_388353_지게차와_크레인;

/**
 문제이해
 컨테이너 요청을 순서대로 완료한 후 남은 컨테이너 수를 출력해라

 제한사항
 2 ≤ storage의 길이 = n ≤ 50
 storage[i][j]는 알파벳 대문자
 1 ≤ requests의 길이 ≤ 100
 requests[i]의 길이가 1이면 지게차를 이용한 출고 요청을,
 2이면 크레인을 이용한 출고 요청

 풀이과정
 ["AZWQY",
 "CAABX",
 "BBDDA",
 "ACACA"]
 상하좌우 중 한 곳이 비어있으면 요청을 꺼낼 수 있음.
 요청의 길이가 2이면 지게차를 사용해서 상관없이 꺼낼 수 있음.

 1. 외부에서 들어갈 수 있는 지 확인
 2. 테두리와 판을 만들자
 3. 요청을 반복
 4. 길이가 2면 모두 꺼낼 수 있음 -> 모두 0으로 만들기
 5. 길이가 1이면 외부에서 상하좌우 갈 수 있는 곳으로 가기 -> bfs
 6. 먼저 지우면 큐에 넣어질 수 있으니 모아서 한번에 지우기
 7. 반복 후에 0이 아닌 것들 개수 세기

 **/

import java.util.*;

class Solution {

    public int solution(String[] storage, String[] requests) {
        int n = storage.length;
        int m = storage[0].length();

        // 상하좌우
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        // 테두리 + 판
        char[][] map = new char[n + 2][m + 2];
        for (int i = 0; i < n + 2; i++) {
            Arrays.fill(map[i], '0');
        }

        // 원래 값 넣기
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i + 1][j + 1] = storage[i].charAt(j);
            }
        }

        // 요청 처리
        for (String request : requests) {
            char target = request.charAt(0);

            if (request.length() == 2) {
                // 해당 문자 전부 제거
                for (int i = 1; i <= n; i++) {
                    for (int j = 1; j <= m; j++) {
                        if (map[i][j] == target) {
                            map[i][j] = '0';
                        }
                    }
                }
            } else {
                // 외부에서 접근 가능한 문자만 제거
                List<int[]> toRemove = new ArrayList<>();
                boolean[][] visited = new boolean[n + 2][m + 2];
                Queue<int[]> queue = new LinkedList<>();

                // 외부부터
                queue.add(new int[]{0, 0});
                visited[0][0] = true;

                while (!queue.isEmpty()) {
                    int[] curr = queue.poll();
                    int x = curr[0];
                    int y = curr[1];

                    for (int d = 0; d < 4; d++) {
                        int nx = x + dx[d];
                        int ny = y + dy[d];

                        // 격자 범위를 벗어나거나
                        if (nx < 0 || nx >= n + 2 ||
                                ny < 0 || ny >= m + 2)
                            continue;

                        // 이미 방문했다면 건너뜀
                        if (visited[nx][ny]) continue;

                        // 지나갈 수 있음
                        if (map[nx][ny] == '0') {
                            visited[nx][ny] = true;
                            queue.add(new int[]{nx, ny});

                        } else if (map[nx][ny] == target) {
                            visited[nx][ny] = true;
                            toRemove.add(new int[]{nx, ny});
                        }
                    }
                }

                // 찾은 상자들을 한 번에 빈 공간으로 변환
                for (int[] pos : toRemove) {
                    map[pos[0]][pos[1]] = '0';
                }
            }
        }

        // 남아있는 컨테이너 개수 계산
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (map[i][j] != '0') {
                    answer++;
                }
            }
        }

        return answer;
    }
}
