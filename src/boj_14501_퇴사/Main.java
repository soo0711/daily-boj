package boj_14501_퇴사;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] t = new int[n + 1];
        int[] p = new int[n + 1];

        // 입력: 시간 T와 공간 P를 따로 저장한다.
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            t[i] = Integer.parseInt(st.nextToken());
            p[i] = Integer.parseInt(st.nextToken());
        }

        int[] money = new int[n + 2];

        for (int i = 1; i <= n; i++) {
            // 상담을 안 했을 경우
            money[i + 1] = Math.max(money[i + 1], money[i]);

            // 상담을 했을 경우
            if (i + t[i] <= n + 1) {
                money[i + t[i]] = Math.max(money[i + t[i]], money[i] + p[i]);
            }
        }

        System.out.println(money[n + 1]);
    }
}
