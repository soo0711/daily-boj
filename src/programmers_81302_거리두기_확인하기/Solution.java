package programmers_81302_거리두기_확인하기;

class Solution {
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        int distance = 0;

        for (int i = 0; i < 5; i++) {
            // String 1차원 배열
            String[] array = places[i];

            // 2차원 배열 char로 바꾸기
            char[][] place = new char[5][5];
            for (int j = 0; j < 5; j ++) {
                place[j] = array[j].toCharArray();
            }

            // 거리 지키기 여부
            boolean flag = false;

            place_for:
            for (int j = 0; j < 5; j++) {
                for (int z = 0; z < 5; z++) {
                    if (place[j][z] == 'P') {
                        // (x + 2, y), (x, y + 2),
                        // (x + 1, y + 1),
                        // (x + 1, y), (y + 1, x)에 P가 있으면 안된다.

                        // (x + 1, y), (y + 1, x)에 P가 있으면 안된다.
                        if (j < 4 && place[j + 1][z] == 'P') {

                            flag = true;
                            break place_for;
                        }

                        if (z < 4 && place[j][z + 1] == 'P') {

                            flag = true;
                            break place_for;
                        }

                        // (x + 2, y), (x, y + 2)이면 (x + 1, y), (x, y + 1) 장애물 있으면 넘어감
                        if (j < 3 && place[j + 2][z] == 'P') {
                            if (place[j + 1][z] == 'X') {
                                continue;

                            }
                            flag = true;
                            break place_for;
                        }

                        if (z < 3 && place[j][z + 2] == 'P') {

                            if (place[j][z + 1] == 'X') {
                                continue;
                            }

                            flag = true;
                            break place_for;
                        }

                        // (x + 1, y + 1) 이면 (x + 1, y), (x, y + 1) 장애물 있으면 넘어감
                        if (j < 4 && z < 4 && place[j + 1][z + 1] == 'P') {
                            if (place[j][z + 1] == 'X' && place[j + 1][z] == 'X') {

                                continue;

                            }
                            flag = true;
                            break place_for;
                        }

                        // (x + 1, y - 1) 이면 (x + 1, y), (x, y - 1) 장애물 있으면 넘어감
                        if (j < 4 && z > 0 && place[j + 1][z - 1] == 'P') {
                            if (place[j][z - 1] == 'X' && place[j + 1][z] == 'X') {
                                continue;
                            }
                            flag = true;
                            break place_for;
                        }
                    }
                }
            }
            if (flag) {
                answer[i] = 0;
            } else {
                answer[i] = 1;
            }
        }

        return answer;
    }

}
