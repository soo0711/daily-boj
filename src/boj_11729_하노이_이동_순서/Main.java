package boj_11729_하노이_이동_순서;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static StringBuilder sb;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        sb.append((int) Math.pow(2, n) - 1).append("\n");

        hanoi(n, 1, 3, 2);
        System.out.println(sb);
    }

    public static void hanoi (int num, int start, int end, int via) {
        if (num == 1) {
            sb.append(start).append(" ").append(end).append("\n");
            return;
        }
        hanoi(num - 1, start, via, end);
        sb.append(start).append(" ").append(end).append("\n");
        hanoi(num - 1, via, end, start);
    }
}
