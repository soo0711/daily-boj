package boj_24267_알고리즘의_수행_시간6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long n = Integer.parseInt(br.readLine());
        System.out.println(n*(n-1)*(n-2)/6);
        System.out.println(3);
    }
}
