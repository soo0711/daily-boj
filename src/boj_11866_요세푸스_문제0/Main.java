package boj_11866_요세푸스_문제0;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            queue.addLast(i);
        }

        bw.write("<");
        while(!queue.isEmpty()) {
            for (int i = 0; i < k - 1; i++) {
                queue.addLast(queue.pollFirst());
            }
            bw.write(String.valueOf(queue.pollFirst()));
            if (!queue.isEmpty()){
                bw.write(", ");
            }
        }

        bw.write(">");
        bw.flush();
        br.close();
    }
}
