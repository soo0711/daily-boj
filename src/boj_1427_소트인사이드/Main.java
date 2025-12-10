package boj_1427_소트인사이드;

import java.io.*;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        char[] num = br.readLine().toCharArray();

        Arrays.sort(num);

        for (int i = num.length - 1; i >= 0; i--) {
            bw.append(num[i]);
        }

        bw.flush();;
        bw.close();
        br.close();

    }
}
