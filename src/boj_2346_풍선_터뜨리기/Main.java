package boj_2346_풍선_터뜨리기;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 1; i <= n ; i++) {
            deque.addFirst(i);
        }

        int[] move = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            move[i] = Integer.parseInt(st.nextToken());
        }

        int remove = deque.removeLast();
        bw.write(remove + " ");
        int num = move[remove - 1];
        while (!deque.isEmpty()) {
            if (num > 0) {
                for (int i = 0; i < num - 1; i++) {
                    deque.addFirst(deque.removeLast());
                }
                remove = deque.removeLast();
            } else {
                for (int i = num + 1; i < 0; i++) {
                    deque.addLast(deque.removeFirst());
                }
                remove = deque.removeFirst();
            }

            bw.write(remove + " ");
            num = move[remove - 1];
        }
        bw.flush();
        br.close();
    }
}
