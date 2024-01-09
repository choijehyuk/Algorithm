import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuffer sb = new StringBuffer();

        int N = Integer.parseInt(br.readLine());
        char[][] map = new char[N][N];

        int heartLine = 0;
        int leftArm = 0;
        int rightArm = 0;
        int waist = 0;
        int leftLeg = 0;
        int rightLeg = 0;
        int heartRow = 0;
        int heartCol = 0;

        int legLine = 0;
        boolean legCheck = false;
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            int cnt = 0;
            for (int j = 0; j < N; j++) {
                map[i][j] = s.charAt(j);
                if (map[i][j] == '*') {
                    cnt++;
                }
            }
            if (cnt >= 3) {
                heartLine = i;
            }
            if (cnt == 2 && !legCheck) {
                legLine = i;
                legCheck = true;
            }
        }

        //print(map);

        int armCnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == heartLine && map[i][j] == '*') {
                    armCnt++;
                    if (map[i - 1][j] == '*') {
                        heartRow = i;
                        heartCol = j;
                        leftArm = armCnt - 1;
                        armCnt = 0;
                    }
                }
                if (i >= legLine) {
                    if (map[i][j] == '*') {
                        if (j < heartCol) {
                            leftLeg++;
                        } else {
                            rightLeg++;
                        }
                    }

                }
            }
            if (i == heartLine) {
                rightArm = armCnt;
            }
        }

        waist = legLine - heartLine - 1;
        heartRow++;
        heartCol++;

        System.out.println(heartRow + " " + heartCol);
        System.out.println(leftArm + " " + rightArm + " " + waist + " " + leftLeg + " " + rightLeg);

    }

    private static void print(char[][] map) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
}