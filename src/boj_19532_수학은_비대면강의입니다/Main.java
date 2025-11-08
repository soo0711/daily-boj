package boj_19532_수학은_비대면강의입니다;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] num = br.readLine().split(" ");
        int[] n = new int[num.length];
        for (int i = 0; i < num.length; i++){
            n[i] = Integer.parseInt(num[i]);
        }

        int de = (n[0] * n[4] -  n[1] * n[3]);
        int x = (n[2] * n[4] -  n[1] * n[5]) / de;
        int y = (n[0] * n[5] -  n[2] * n[3]) / de;

        System.out.println(x + " " + y);
        br.close();
    }
}
