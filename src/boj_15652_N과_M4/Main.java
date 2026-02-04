package boj_15652_N과_M4;

import java.io.*;
import java.util.*;

public class Main {

    static int n, m;
    static StringBuilder sb = new StringBuilder();

    static int[] array;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        array = new int[m];

        dfs(0, 0);

        System.out.println(sb);
    }

    public static void dfs(int depth, int start) {
        if (depth == m) {
            for (int i = 0; i < array.length; i++) {
                sb.append(array[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (i >= start) {
                array[depth] = i;
                dfs(depth + 1, i);
            }
        }
    }

}
