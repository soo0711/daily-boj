package boj_2485_가로수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] array = new int[n];

        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(br.readLine());
        }

        int result = array[1] - array[0];
        for (int i = 2; i < n; i++) {
            result = gcd(result, array[i] - array[i-1]);
        }

        int cnt = 0;
        for (int i = 1; i < n; i++) {
            cnt += (array[i] - array[i-1]) / result - 1;
        }

        System.out.println(cnt);
    }

    public static int gcd (int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}
