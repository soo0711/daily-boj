package boj_1934_최소공배수;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());


        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int result = gcd(a, b);
            bw.write(a * b / result + "\n");
        }

        bw.flush();
        br.close();
    }

    public static int gcd (int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}
