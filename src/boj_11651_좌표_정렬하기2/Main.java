package boj_11651_좌표_정렬하기2;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[][] num = new int[n][2];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            num[i][0] = Integer.parseInt(st.nextToken());
            num[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(num, (a1, a2) -> {
            if (a1[1] != a2[1]) {
                return a1[1] - a2[1];
            } else {
                return a1[0] - a2[0];
            }
        });

        for (int i = 0; i < n; i++) {
            sb.append(num[i][0] + " " + num[i][1] + "\n");
        }

        bw.append(sb);
        bw.flush();
        bw.close();
        br.close();
    }
}
