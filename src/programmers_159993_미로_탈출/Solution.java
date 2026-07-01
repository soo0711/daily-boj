package programmers_159993_미로_탈출;

/**
 문제이해
 미로를 최대한 빨리 나갈 수 있는 시간을 구하여라.

 제한사항
 - 5 ≤ maps의 길이 ≤ 100
 - maps[i]는 다음 5개의 문자들로만 이루어져 있습니다.
 S : 시작 지점
 E : 출구
 L : 레버
 O : 통로
 X : 벽
 - 모든 통로, 출구, 레버, 시작점은 여러 번 지나갈 수 있습니다.

 풀이과정
 1. 출발점에서 레버를 당기는 곳까지 bfs를 통해 먼저가기
 2. 이후에 레버가 출발점이 되어 다시 bfs로 출구로 나가기
 ["SOOOL","XXXXO","OOOOO","OXXXX","OOOOE"]

 **/
import java.util.*;

class Solution {
    public int solution(String[] maps) {
        // 상하좌우
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        // 제한
        int n = maps.length;
        int m = maps[0].length();

        boolean[][] visited = new boolean[n][m];
        Queue<int[]> queue = new LinkedList<>();

        // S 위치 찾기
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (maps[i].charAt(j) == 'S') {
                    queue.add(new int[] {i, j, 0});
                    visited[i][j] = true;
                    break;
                }
            }
        }

        // 경로 찾았는지 여부
        boolean foundLever = false;
        boolean foundExit = false;

        // bfs
        int answer = 0;
        int x = 0;
        int y = 0;
        int dist = 0;
        while(!queue.isEmpty()) {
            int[] curr = queue.poll();
            x = curr[0];
            y = curr[1];
            dist = curr[2];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || ny < 0
                        || nx >= n || ny >= m) continue;

                if (!visited[nx][ny]
                        && maps[nx].charAt(ny) == 'L') {
                    x = nx;
                    y = ny;
                    dist++;
                    foundLever = true;
                    queue.clear();
                    break;
                }

                if (!visited[nx][ny]
                        && maps[nx].charAt(ny) != 'X') {
                    queue.add(new int[] {nx, ny, dist + 1});
                    visited[nx][ny] = true;
                }
            }
        }

        visited = new boolean[n][m];
        queue.add(new int[] {x, y, dist});
        visited[x][y] = true;

        while(!queue.isEmpty()) {
            int[] curr = queue.poll();
            x = curr[0];
            y = curr[1];
            dist = curr[2];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || ny < 0
                        || nx >= n || ny >= m) continue;

                if (!visited[nx][ny]
                        && maps[nx].charAt(ny) == 'E') {
                    dist++;
                    foundExit = true;
                    queue.clear();
                    break;
                }

                if (!visited[nx][ny]
                        && maps[nx].charAt(ny) != 'X') {
                    queue.add(new int[] {nx, ny, dist + 1});
                    visited[nx][ny] = true;
                }
            }
        }

        if (!foundLever || !foundExit) {
            answer = -1;
        } else {
            answer = dist;
        }

        return answer;
    }
}
