package boj_4949_균형잡힌_세상;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            String input = br.readLine();
            if (input.equals(".")) {
                break;
            }

            char[] array = input.toCharArray();
            Deque<Character> ps = new ArrayDeque<>();
            boolean isValid = true;

            for (int i = 0; i < array.length; i++) {
                char c = array[i];
                switch (c) {
                    case '(':
                    case '[':
                        ps.push(c);
                        break;
                    case ')':
                        if (ps.isEmpty() || ps.peek().equals('[')) {
                            isValid = false;
                        } else {
                            ps.pop();
                        }
                        break;
                    case ']':
                        if (ps.isEmpty() || ps.peek().equals('(')) {
                            isValid = false;
                        } else {
                            ps.pop();
                        }
                        break;
                }
                if (!isValid) {
                    break;
                }
            }
            if (isValid && ps.isEmpty()) {
                bw.write("yes\n");
            } else {
                bw.write("no\n");
            }
        }

        bw.flush();
        br.close();
    }
}
