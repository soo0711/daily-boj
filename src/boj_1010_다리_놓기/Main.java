package boj_1010_다리_놓기;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());



        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());


            long sum = 1;
            n = Math.min(n, m - n);

            for (int j = 1; j <= n; j++) {
                sum = sum * (m - j + 1) / j;
            }

            bw.write(sum + "\n");
        }

        bw.flush();
        br.close();
    }
}
