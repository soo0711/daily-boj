package programmers_42587_프로세스;

/**
 문제이해
 운영체제의 규칙에 따라 프로세스를 관리한다.
 특정 위치의 프로세스가 몇번째로 실행되는지 알아내라.

 제한사항
 priorities의 길이는 1 이상 100 이하
 priorities의 원소는 1 ~ 9
 priorities의 원소는 우선순위를 나타내며 숫자가 클 수록 우선순위가 높습니다.


 풀이과정
 2, 1, 3, 2
 a b c d
 숫자가 클수록 중요함
 a b c d
 b c d a
 c d a b
 c 1
 if (p[location] == que){
 return cnt;
 }
 1. class Node -> location, 우선순위
 2. que에 넣는다.
 3. que에서 꺼낸다.
 4. 이 우선순위보다 for문을 돌아서 큰 우선순위가 있는지 찾는다.
 5. 잇으면 뒤로 add, continue;
 6. 없으면 cnt++, if location이 같으면 return cnt;


 **/
import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {

        Queue<Node> que = new LinkedList<>();
        for (int i = 0; i < priorities.length; i++) {
            que.add(new Node(i, priorities[i]));
        }

        int answer = 0;
        while(!que.isEmpty()) {
            Node node = que.remove();

            int max = node.prior;
            boolean flag = true;

            for (int p : priorities) {
                if (max < p) {
                    que.add(node);
                    flag = false;
                    break;
                }
            }

            if (flag) {
                priorities[node.idx] = -1;
                answer++;
                if (node.idx == location) {
                    return answer;
                }
            }
        }
        return answer;
    }

    class Node {
        int idx;
        int prior;

        Node(int idx, int prior) {
            this.idx = idx;
            this.prior = prior;
        }
    }
}

