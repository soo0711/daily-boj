package programmers_12905_가장_큰_정사각형_찾기;

/**
### 문제이해
1로 되어있는 가장 큰 정사각형을 찾아서
넓이를 출력해라.

        ### 제한사항
표는 2차원 배열
행: 1,000
열: 1,000
값은 0, 1

        [0,1,1,1]
        [0,1,1,1]
        [1,1,1,1]
        [0,0,1,0]

        ### 풀이방법 (1)
정사각형이 되기 위한 조건을 생각해본다.

1  2  3  4
        5  6  7  8
        9  10 11 12
        13 14 15 16

        0  1  2  3
        4  5  6  7
        8  9  10 11
        12 13 14 15

가장 큰 정사각형은
행 4, 열 2
        2 * 2 = 4
그럼 2개씩 있는 곳을 찾고 있으면
return -> 4
없으면 -> 1

행 4, 열4
가장 큰 사각형은
4,4 -> 없으면 -> 3,3 1이 3개로 시작하는 행을 찾음, 4-1 =3 1행이라도 어긋나면 break
        2,2 -> 없으면 -> 1,1


        [0,0,1,1]
        [1,1,1,1]

        => 시간초과가 발생

### 풀이방법 (2)
넓이가 1일 때는 자기 자신만 1
넓이가 2일 때는 왼쪽, 위쪽, 왼쪽 대각선의 가장 작은 숫자 + 1가 된 것
넓이가 3일 때는 왼쪽, 위쪽, 왼쪽 대각선의 가장 작은 숫자 + 2가 된 것

**/

class Solution
{
    public int solution(int [][]board)
    {
        int answer = 0;
        int row = board.length;
        int col = board[0].length;

        // 행이나 열이 1이면 직접 확인해야함
        if (row < 2 || col < 2) {
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (board[i][j] == 1) return 1;
                }
            }
            return 0;
        }

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (board[i][j] == 1) {
                    board[i][j] =
                            Math.min(Math.min(board[i - 1][j], board[i][j - 1]),
                                    board[i - 1][j - 1]) + 1;
                    if (answer < board[i][j]) answer = board[i][j];
                }
            }
        }

        return answer * answer;
    }

}
