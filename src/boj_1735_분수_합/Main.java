package boj_1735_분수_합;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] a = new int[2];
        int[] b = new int[2];

        for (int i = 0; i < 2; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            a[i] = Integer.parseInt(st.nextToken());
            b[i] = Integer.parseInt(st.nextToken());
        }

        long result = gcd(b[0], b[1]);
        long lcm = (long) b[0] * b[1] / result;
        long sum = (lcm * a[0] / b[0]) + (lcm * a[1] / b[1]);
        long gcdResult = gcd(sum, lcm);
        System.out.println(sum / gcdResult + " " + lcm / gcdResult);
    }

    public static long gcd (long a, long b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}
