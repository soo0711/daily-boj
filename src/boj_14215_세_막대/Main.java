package boj_14215_세_막대;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int max = Math.max(Math.max(a, b), c);
        int total = a + b + c - max;

        if (total <= max) {
            System.out.println((total * 2) -1);
        } else {
            System.out.println(a + b + c);
        }
    }
}
