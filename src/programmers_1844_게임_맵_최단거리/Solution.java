package programmers_1844_게임_맵_최단거리;

/**
 문제이해
 최단거리를 구해라

 고려사항
 상대방진영에 도착할 수 있는 경우의 수가 없으면 -1]
 벽 = 0, 벽x = 1
 내 자리 (1,1)
 상대 자리 (n, m)
 **/

import java.util.*;

class Solution {

    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    int[][] dist;
    Queue<Path> que;

    class Path {
        int x;
        int y;

        Path(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;

        dist = new int[n][m];
        que = new LinkedList<>();

        que.add(new Path(0, 0));
        dist[0][0] = 1;

        // bfs는 que가 빌 때까지 반복하는 것
        while(!que.isEmpty()) {
            Path path = que.poll();

            for (int i = 0; i < 4; i++) {
                int nx = path.x + dx[i];
                int ny = path.y + dy[i];

                if (nx >= 0 && nx < n &&
                        ny >=0 && ny < m) {
                    if (maps[nx][ny] == 1 && dist[nx][ny] == 0) {
                        dist[nx][ny] = dist[path.x][path.y] + 1;
                        que.add(new Path(nx, ny));
                    }
                }
            }
        }

        int answer = -1;

        if (dist[n - 1][m - 1] != 0) {
            answer = dist[n - 1][m - 1];
        }

        return answer;
    }
}
