package boj_10814_나이순_정렬;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        Person[] person = new Person[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            person[i] = new Person(Integer.parseInt(st.nextToken()), st.nextToken());
        }

        Arrays.sort(person, (p1, p2) -> p1.age - p2.age);

        for (int i = 0; i < n; i++) {
            sb.append(person[i].age).append(" ").append(person[i].name).append("\n");
        }

        bw.append(sb);
        bw.flush();
        bw.close();
        br.close();

    }

    public static class Person {
        int age;
        String name;

        Person(int age, String name){
            this.age = age;
            this.name = name;
        }
    }
}
