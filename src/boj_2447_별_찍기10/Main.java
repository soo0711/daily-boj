package boj_2447_별_찍기10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static char[][] array;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        array = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                array[i][j] = ' ';
            }
        }

        star(0, 0, n);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(array[i][j]);
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }

    public static void star(int x, int y, int size) {
        if (size == 1) {
            array[x][y] = '*';
            return;
        }

        int small = size / 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == 1 && j == 1) continue;
                star(x + i * small, y + j * small, small);
            }
        }
    }
}
