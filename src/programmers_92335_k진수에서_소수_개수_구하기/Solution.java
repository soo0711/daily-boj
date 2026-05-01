package programmers_92335_k진수에서_소수_개수_구하기;

/**
 문제이해
 n의 수가 주어지고 이를 k진수로 바꿀 때, 조건에 맞는 소수가 몇 개인지 출력해라

 제한사항
 조건
 1. 0p0
 2. p0
 3.0p
 4. p
 5. p는 0 포함 X

 1 ≤ n ≤ 1,000,000
 3 ≤ k ≤ 10

 풀이과정
 110011 -> 10 = 110011 -> 11/11 -> 11은 소수 -> 2개
 1. n을 k 진수로 변환
 (어떻게?..)
 437674 -> k로 나눈 나머지
 211020101011

 2. 변환 된 숫자를 0으로 쪼갠다.
 3. 다시 10진수로 변환시킨다.
 4. 그 숫자가 소수인지 확인하고 소수면 개수에 추가한다.

 **/
class Solution {
    public int solution(int n, int k) {

        // 진수 변환 후 조건 추출
        System.out.println(toK(n, k, ""));
        String[] parse = toK(n, k, "").split("0");
        for (String p : parse) {
            System.out.print(p + " ");
        }

        // 추출된 숫자 소수인지 확인
        int answer = 0;

        for (String p : parse) {
            if (p.equals("")) {
                continue;
            }

            long num = Long.parseLong(p);
            if (num == 1) {
                continue;
            }

            if (isPrimary(num)) {
                answer++;
            }
        }

        return answer;
    }

    // 진수 변환
    String toK (int n, int k, String num) {
        if (n == 0) {
            return "";
        }

        return toK(n/k, k, num) + n % k;
    }

    // 소수 체크
    boolean isPrimary(long n) {
        if (n == 1 || n == 0) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }
}
