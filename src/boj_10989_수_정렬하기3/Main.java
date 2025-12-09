package boj_10989_수_정렬하기3;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] num = new int[10001];

        for (int i = 0; i < n; i++) {
            num[Integer.parseInt(br.readLine())]++;
        }
        br.close();

        for (int i = 0 ; i < 10001; i++) {
            while(num[i] > 0) {
                bw.write(i + "\n");
                num[i]--;
            }
        }

        bw.flush();
        bw.close();
    }
}
