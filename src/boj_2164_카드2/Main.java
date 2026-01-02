package boj_2164_카드2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            queue.addFirst(i);
        }

        while(queue.size() > 1) {
            queue.removeLast();
            queue.addFirst(queue.removeLast());
        }

        System.out.println(queue.getLast());
    }
}
