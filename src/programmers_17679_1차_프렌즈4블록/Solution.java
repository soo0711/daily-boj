package programmers_17679_1차_프렌즈4블록;

class Solution {

    static char[][] boards;
    public int solution(int m, int n, String[] board) {

        // String[] 배열 쪼개기
        boards = new char[m][n];
        for(int i = 0; i < m; i++) {
            char[] arr = board[i].toCharArray();
            for(int j = 0; j < n; j++) {
                boards[i][j] = arr[j];
            }
        }

        // 종료 조건 더이상 없을때 지울 블록이 없을 때
        // 지울 블록이 없으면 flag = true로 변경
        int answer = 0;
        boolean flag = false;
        while(!flag) {
            // 지울 곳 체크
            boolean[][] check = new boolean[m][n];

            // 2x2 찾기
            for(int i = 0; i < m-1; i++) {
                for(int j = 0; j < n-1; j++) {
                    char block = boards[i][j];
                    if (block != 0 &&
                            block==boards[i + 1][j] &&
                            block==boards[i][j + 1] &&
                            block==boards[i + 1][j + 1]) {

                        check[i][j] = true;
                        check[i+1][j+1] = true;
                        check[i][j+1] = true;
                        check[i+1][j] = true;
                    }
                }
            }

            // 체크된 부분 지우기(값을 0으로)
            int cnt = 0;
            for(int i = 0; i < m; i++) {
                for(int j = 0; j < n; j++) {
                    if (check[i][j]) {
                        cnt++;
                        boards[i][j] = 0;
                    }
                }
            }

            // 지우기 X 였다면 flag true로 변경
            if (cnt == 0) {
                flag = true;
            }

            // 체크된 부분 answer에 더하기
            answer += cnt;

            // 열 기준으로 아래로 내리기
            reArrange(m, n);
        }

        return answer;
    }

    static void reArrange(int m, int n) {
        for (int j = 0; j < n; j++) { // 열
            for (int i = m - 1; i > 0; i--) { // 행: 아래에서 위로
                if (boards[i][j] == 0) {
                    for (int k = i - 1; k >= 0; k--) { // 0이 아닌 것과 교환
                        if (boards[k][j] != 0) {
                            boards[i][j] = boards[k][j];
                            boards[k][j] = 0;
                            break;
                        }
                    }
                }
            }
        }
    }
}