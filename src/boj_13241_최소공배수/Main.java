package boj_13241_최소공배수;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int result = gcd(a, b);
        System.out.println((long) a * b / result);

        br.close();
    }

    public static int gcd (int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}