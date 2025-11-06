package boj_2231_분해합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int min = n;

        for (int i = n; i > 0; i--){
            int abc = 0;
            int div = i;
            while (true){
                abc += div % 10;
                div /= 10;
                if (div == 0){
                    break;
                }
            }
            int sum = i + abc;
            if (min > i  && n == sum){
                min = i;
            }
        }
        if (n == min){
            System.out.println(0);
        } else {
            System.out.println(min);
        }
    }
}
