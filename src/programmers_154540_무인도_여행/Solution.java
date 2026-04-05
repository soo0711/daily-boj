package programmers_154540_무인도_여행;

/**
 문제이해
 무인도에서 최대 며칠씩 머물 수 있는지 알아내
 섬을 결정하려고하는데
 최대 머물 수 있는 섬들을 오름차순으로 댬아서 return해라
 만약 무인도가 없으면 -1

 제한사항
 1. 오름차순으로 출력
 2. 없으면 -1로 출력
 3. X, 1~9 자연수로 이루어짐
 4. X -> 바다
 5. 숫자 -> 머물 수 있는 날짜

 "X591X"
 "X1X5X"
 "X231X"
 "1XXX1"

 풀이과정
 1. 0,0 부터 시작해서 x가 아니라면 시작
 2. 무인도에 방문을 합니다.
 3. 5에서 방문하지 않은 상하좌우가 있는지 확인하고
 4. 있으면 상하좌우로 가면서 값을 더해줍니다.
 5. 갈 수 있는 곳이 없다면 머무는 숫자를 return합니다.

 **/

import java.util.*;

class Solution {

    // 상하좌우
    int[] dx = {-1, 1, 0 , 0};
    int[] dy = {0, 0, -1, 1};

    public int[] solution(String[] maps) {

        // bfs로 풀어보기
        // 입력: ["X591X","X1X5X","X231X", "1XXX1"]

        // 2차원 배열로 분리하기
        int n = maps.length;
        int m = maps[0].length();
        String[][] map = new String[n][m];

        for (int i = 0; i < n; i++) {
            map[i] = maps[i].split("");
        }

        // list에 값 저장해두기
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!map[i][j].equals("X") &&
                        !map[i][j].equals("0")) {
                    list.add(bfs(map, i, j));
                }
            }
        }

        // 오름차순
        Collections.sort(list);

        int[] answer = {-1};

        // list -> int[]
        if (!list.isEmpty()) {
            answer = new int[list.size()];
            for (int i = 0; i < list.size(); i++) {
                answer[i] = list.get(i);
            }
        }

        return answer;
    }

    int bfs (String[][] map, int x, int y) {
        Queue<Idx> que = new LinkedList<>();
        int cnt = 0;

        que.add(new Idx(x, y));
        cnt += Integer.parseInt(map[x][y]);
        map[x][y] = "0";

        while(!que.isEmpty()) {
            Idx idx = que.remove();
            int wx = idx.x;
            int wy = idx.y;

            for (int i = 0; i < 4; i++) {
                int cx = wx + dx[i];
                int cy = wy + dy[i];
                if (cx >= 0 && cx < map.length
                        && cy >= 0 && cy < map[0].length) {
                    if (!map[cx][cy].equals("X") &&
                            !map[cx][cy].equals("0")) {

                        que.add(new Idx(cx, cy));
                        cnt += Integer.parseInt(map[cx][cy]);
                        map[cx][cy] = "0";
                    }
                }
            }
        }

        return cnt;
    }

    class Idx {
        int x;
        int y;
        Idx(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
