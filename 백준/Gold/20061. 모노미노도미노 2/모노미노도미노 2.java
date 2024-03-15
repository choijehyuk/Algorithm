import javax.swing.*;
import java.io.*;
import java.util.*;

public class Main {
    static class Block {
        int t, x, y;

        public Block(int t, int x, int y) {
            this.t = t;
            this.x = x;
            this.y = y;
        }
    }

    static int[][] greenMap;
    static int[][] blueMap;
    static ArrayList<Block> list;
    static int score;
    static int greenRemoveCnt;
    static int blueRemoveCnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        greenMap = new int[6][4];
        blueMap = new int[4][6];

        list = new ArrayList<>();
        // 6 x 4 모양 그린
        // 4 x 6 모양 블루
        /*
         블루는 오른쪽으로 이동 , 그린은 아래로 이동
         블루는 열이 다 차면 삭제 , 그린은 행이 다 차면 삭제
           ->  이렇게 되면 점수 + 1
         블루는 0 , 1 열에 블록이 있으면 오른쪽에서 그만큼 삭제
         그린은 0 , 1 행에 블록이 있으면 아래에서 그만큼 삭제

        얻은 점수와 초록색 보드와 파란색 보드에 타일이 있는 칸의 개수
         */
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            // t == 1 , 1 x 1
            // t == 2 , 1 x 2
            // t == 3 , 2 x 1
            int t = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            list.add(new Block(t, x, y));
        }

        for (int i = 0; i < list.size(); i++) {
            // 게임 시작
            game(i);
        }

        System.out.println(score);

        int blockSum = 0;
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 4; j++) {
                if (greenMap[i][j] == 1) blockSum++;
                if (blueMap[j][i] == 1) blockSum++;
            }
        }

//        System.out.println("--- greenMap ---");
//        print(greenMap);
//        System.out.println("----");
//        System.out.println("--- blueMap ---");
//        print(blueMap);
//        System.out.println("----");
        System.out.println(blockSum);
    }

    private static void print(int[][] map) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void game(int idx) {
        Block block = list.get(idx);

        // 블록 좌표 가지고 초록색으로 블록 이동
        moveGreenBlock(block);

        // 블록 좌표 가지고 파란색으로 블록 이동
        moveBlueBlock(block);

        // 초록색 행 체크
        int removeGreenLine = checkGreenLine();

        // 파란색 열 체크
        int removeBlueLine = checkBlueLine();

        // 초록색 아래로 이동
        greenDown(removeGreenLine);

        // 파란색 오른쪽으로 이동
        blueDown(removeBlueLine);
        // 초록색 연한 곳 처리
        greenLight();

        // 파란색 연한 곳 처리
        blueLight();

        greenRemoveCnt = 0;
        blueRemoveCnt = 0;

//        System.out.println(block.t + " " + block.x + " " + block.y);
//        print(greenMap);
//        System.out.println();
//        print(blueMap);
//        System.out.println("----");
    }

    private static void blueLight() {
        int cnt = 0;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 4; j++) {
                if (blueMap[j][i] == 1) {
                    cnt++;
                    break;
                }
            }
        }

        if (cnt == 0) return;

//        System.out.println("파란색 연한곳에 있는 열 수 : " + cnt);
//        print(blueMap);

        // 하얀곳 열만큼 끝에서 삭제
        for (int i = 0; i < cnt; i++) {
            for (int j = 0; j < 4; j++) {
                blueMap[j][5 - i] = 0;
            }
        }

//        System.out.println("끝에서 삭제 후 ");
//        print(blueMap);


        // 오른쪽으로 이동
        // cnt만큼 오른쪽으로 이동
        for (int j = 5 - cnt; j >= 0; j--) {
            for (int k = 0; k < 4; k++) {
                blueMap[k][j + cnt] = blueMap[k][j];
            }
        }


        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 4; j++) {
                blueMap[j][i] = 0;
            }
        }


//        System.out.println("이동 후 ");
//        print(blueMap);
    }

    private static void greenLight() {
        int cnt = 0;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 4; j++) {
                if (greenMap[i][j] == 1) {
                    cnt++;
                    break;
                }
            }
        }

        if (cnt == 0) return;

//        System.out.println("초록색 연한곳에 있는 수 " + cnt );
//        print(greenMap);
//        System.out.println();

        // 하얀곳 줄만큼 끝에서 삭제
        for (int i = 0; i < cnt; i++) {
            for (int j = 0; j < 4; j++) {
                greenMap[5 - i][j] = 0;
            }
        }

        // 아래로 내리기
        // cnt만큼 아래로 내리기
        for (int j = 5 - cnt; j >= 0; j--) {
            for (int k = 0; k < 4; k++) {
                greenMap[j + cnt][k] = greenMap[j][k];
            }
        }


        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 4; j++) {
                greenMap[i][j] = 0;
            }
        }
    }

    private static void blueDown(int removeBlueLine) {
        if (blueRemoveCnt == 0) return;
//        System.out.println("removeBLueLine : " + removeBlueLine + "removeBlueCnt" + " " + blueRemoveCnt);
        for (int i = removeBlueLine - blueRemoveCnt; i >= 0; i--) {
            for (int j = 0; j < 4; j++) {
                if (blueMap[j][i] == 1) {
                    blueMap[j][i] = 0;

                    blueMap[j][i + blueRemoveCnt] = 1;
                }
            }
        }
    }

    private static void greenDown(int removeGreenLine) {
//        System.out.println("그린다운전");
//        print(greenMap);
//        System.out.println("그린다운전끝 + 라인 , 카운트 " + removeGreenLine + " " + greenRemoveCnt);
        if (greenRemoveCnt == 0) return;
//        System.out.println("removeGreenLine : " + removeGreenLine);
        for (int i = removeGreenLine - greenRemoveCnt; i >= 0; i--) {
            for (int j = 0; j < 4; j++) {
                if (greenMap[i][j] == 1) {
                    greenMap[i][j] = 0;
                    greenMap[i + greenRemoveCnt][j] = 1;
                }
            }
        }

//        System.out.println("그린 다운");
//        print(greenMap);
//        System.out.println("그린 다운 끝 ");
    }

    private static int checkBlueLine() {
        int removeLine = 0;

        for (int i = 2; i < 6; i++) {
            int cnt = 0;
            for (int j = 0; j < 4; j++) {
                if (blueMap[j][i] == 1) cnt++;
            }

            // 한줄이 꽉차있으면 삭제
            if (cnt == 4) {
                removeLine = i;
                blueRemoveCnt++;
                score++;
                for (int j = 0; j < 4; j++) {
                    blueMap[j][i] = 0;
                }
            }
        }

        return removeLine;
    }

    private static int checkGreenLine() {
        int removeLine = 0;
        greenRemoveCnt = 0;

        for (int i = 2; i < 6; i++) {
            int cnt = 0;
            for (int j = 0; j < 4; j++) {
                if (greenMap[i][j] == 1) cnt++;
            }

            // 한줄이 꽉차있으면 삭제
            if (cnt == 4) {
                removeLine = i;
                greenRemoveCnt++;
                score++;
                for (int j = 0; j < 4; j++) {
                    greenMap[i][j] = 0;
                }
            }
        }
//        System.out.println("행 체크 삭제");
//        print(greenMap);
//        System.out.println("행 체크 삭제 끝");
        return removeLine;
    }

    private static void moveBlueBlock(Block block) {

        // 1 x 1 블록
        if (block.t == 1) {
            int r = block.x;
            int c = 0;

            blueMap[r][c] = 1;

            while (true) {

                // 범위 밖
                if (c + 1 >= 6) break;

                // 이미 블록이 있으면
                if (blueMap[r][c + 1] == 1) break;
                    // 없으면 이동
                else {
                    blueMap[r][c] = 0;
                    blueMap[r][c + 1] = 1;
                    c++;
                }
            }
        }

        // 1 x 2 블록
        else if (block.t == 2) {
            int r = block.x;
            int c = 0;

            blueMap[r][c] = 1;
            while (true) {

                // 범위 밖
                if (c + 1 >= 6) break;

                // 이미 블록이 있으면
                if (blueMap[r][c + 1] == 1) break;
                    // 없으면 이동
                else {
                    blueMap[r][c] = 0;
                    blueMap[r][c + 1] = 1;
                    c++;
                }
            }

            blueMap[r][c - 1] = 1;
        }

        // 2 x 1 블록
        else if (block.t == 3) {
            int r = block.x;
            int c = 0;

            blueMap[r][c] = 1;
            blueMap[r + 1][c] = 1;

            while (true) {

                // 범위 밖
                if (c + 1 >= 6) break;

                // 이미 블록이 있으면
                if (blueMap[r][c + 1] == 1 || blueMap[r + 1][c + 1] == 1) break;
                    // 없으면 이동
                else {
                    blueMap[r][c] = 0;
                    blueMap[r + 1][c] = 0;

                    blueMap[r][c + 1] = 1;
                    blueMap[r + 1][c + 1] = 1;

                    c++;
                }

            }
        }
    }

    private static void moveGreenBlock(Block block) {

        // 1 x 1 블록
        if (block.t == 1) {
            int r = 0;
            int c = block.y;

            greenMap[r][c] = 1;

            while (true) {

                // 범위 밖
                if (r + 1 >= 6) break;

                // 이미 블록이 있으면
                if (greenMap[r + 1][c] == 1) break;
                    // 없으면 이동
                else {
                    greenMap[r][c] = 0;
                    greenMap[r + 1][c] = 1;
                    r++;
                }
            }

        }
        // 1 x 2 블록
        else if (block.t == 2) {
            int r = 0;
            int c = block.y;

            greenMap[r][c] = 1;
            greenMap[r][c + 1] = 1;

            while (true) {

                if (r + 1 >= 6) break;

                if (greenMap[r + 1][c] == 1 || greenMap[r + 1][c + 1] == 1) break;
                else {
                    greenMap[r][c] = 0;
                    greenMap[r][c + 1] = 0;

                    greenMap[r + 1][c] = 1;
                    greenMap[r + 1][c + 1] = 1;

                    r++;
                }
            }

        }

        // 2 x 1 블록
        else if (block.t == 3) {
            int r = 0;
            int c = block.y;

            greenMap[r][c] = 1;

            while (true) {

                // 범위 밖
                if (r + 1 >= 6) break;

                // 이미 블록이 있으면
                if (greenMap[r + 1][c] == 1) break;
                    // 없으면 이동
                else {
                    greenMap[r][c] = 0;
                    greenMap[r + 1][c] = 1;
                    r++;
                }
            }
            greenMap[r - 1][c] = 1;
        }
    }
}