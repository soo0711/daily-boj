package boj_4779_칸토어_집합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static char[] array;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line;
        while ((line = br.readLine()) != null) {
            int n = Integer.parseInt(line);
            array = new char[(int) Math.pow(3, n)];

            Arrays.fill(array, '-');

            cantor(0, array.length);
            System.out.println(array);
        }
    }

    static void cantor(int start, int length) {
        if (length == 1) return;

        int third = length / 3;

        for (int i = start + third; i < start + 2 * third; i++) {
            array[i] = ' ';
        }

        cantor(start, third);
        cantor(start + 2 * third, third);
    }
}
