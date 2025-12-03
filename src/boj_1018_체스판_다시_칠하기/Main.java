package boj_1018_체스판_다시_칠하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        String[] board = new String[n];

        for (int i = 0; i < n; i++) {
            board[i] = br.readLine();
        }

        int min = n * m;

        String[] white = {"WBWBWBWB", "BWBWBWBW"};
        String[] black = {"BWBWBWBW", "WBWBWBWB"};

        for (int i = 0; i <= n - 8; i++) {
            for (int j = 0; j <= m - 8; j++) {
                int w = count(board, i, j, white);
                int b = count(board, i, j, black);

                min = Math.min(min, Math.min(w, b));
            }
        }

        System.out.println(min);
    }

    public static int count (String[] board, int startRow, int startCol, String[] pattern) {
        int count = 0;

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[startRow + i].charAt(startCol + j) != pattern[i % 2].charAt(j)) {
                    count++;
                }
            }
        }

        return count;
    }
}
