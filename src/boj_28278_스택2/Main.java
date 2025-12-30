package boj_28278_스택2;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            switch (Integer.parseInt(st.nextToken())){
                case 1: stack.push(Integer.parseInt(st.nextToken())); break;
                case 2: bw.write(stack.isEmpty()? "-1 \n" : stack.pop() + "\n"); break;
                case 3: bw.write(stack.size() + "\n"); break;
                case 4: bw.write(stack.isEmpty()? "1 \n" :  "0 \n"); break;
                case 5: bw.write(stack.isEmpty()? "-1 \n" : stack.peek() + "\n"); break;
            }
        }

        bw.flush();
        br.close();
    }
}
