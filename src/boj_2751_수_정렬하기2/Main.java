package boj_2751_수_정렬하기2;

import java.io.*;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] num = new int[n];

        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(num);

        for (int i = 0; i < n; i++) {
            bw.append(num[i] + "\n");
        }

        bw.flush();;
        bw.close();
        br.close();
    }
}
