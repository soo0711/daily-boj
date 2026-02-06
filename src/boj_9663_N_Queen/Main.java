package boj_9663_N_Queen;

import java.io.*;

public class Main {

    static int n;
    static boolean[] isVisited;
    static int cnt = 0;
    static boolean[] cross1;
    static boolean[] cross2;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        isVisited = new boolean[n];
        cross1 = new boolean[2 * n];
        cross2 = new boolean[2 * n];

        dfs(0);

        System.out.println(cnt);
    }

    public static void dfs(int queen) {
        if (queen == n) {
            cnt++;
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!isVisited[i] && !cross1[i + queen] && !cross2[queen - i + n - 1]) {
                isVisited[i] = true;
                cross1[i + queen] = true;
                cross2[queen - i + n - 1] = true;

                dfs(queen + 1);

                isVisited[i] = false;
                cross1[i + queen]  = false;
                cross2[queen - i + n - 1] = false;
            }
        }
    }
}
