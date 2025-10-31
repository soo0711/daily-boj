package boj_5073_삼각형과_세_변;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (a == b && b == c && a == c) {
                if (a == 0){
                    break;
                }
                System.out.println("Equilateral");
            } else {
                int max = Math.max(Math.max(a, b), c);
                if (a + b + c - max <= max) {
                    System.out.println("Invalid");
                } else {
                    if (a == b || b == c || a == c) {
                        System.out.println("Isosceles");
                    } else {
                        System.out.println("Scalene");
                    }
                }
            }
        }
    }
}
