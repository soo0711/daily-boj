package boj_1929_소수_구하기;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        boolean[] array = new boolean[n + 1];
        array[0] = array[1] = true;

        int limit = (int) Math.sqrt(n);
        for (int i = 2; i <= limit; i++) {
            if (!array[i]) {
                for (int j = i * i; j < array.length; j+=i) {
                    array[j] = true;
                }
            }
        }

        for (int i = m; i <= n; i++) {
            if (!array[i]) {
                bw.write(i + "\n");
            }
        }

        bw.flush();
        br.close();
    }
}
