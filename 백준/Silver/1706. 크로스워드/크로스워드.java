import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.*;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuffer sb = new StringBuffer();

        st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        ArrayList<String> list = new ArrayList<>();

        char[][] map = new char[R][C];
        for (int i = 0; i < R; i++) {
            String s = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = s.charAt(j);
            }
        }
        boolean[][] garo = new boolean[R][C];
        boolean[][] sero = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            String word = "";
            for (int j = 0; j < C; j++) {
                if (map[i][j] != '#' && !garo[i][j]) {
                    word += map[i][j];
                    garo[i][j] = true;
                } else {
                    if (word.length() > 1) {
                        list.add(word);
                    }
                    word = "";
                }
            }
            if (word.length() > 1) {
                list.add(word);
            }
        }

        for (int i = 0; i < C; i++) {
            String word = "";
            for (int j = 0; j < R; j++) {
                if (map[j][i] != '#' && !sero[j][i]) {
                    word += map[j][i];
                    sero[j][i] = true;
                } else {
                    if (word.length() > 1) {
                        list.add(word);
                    }
                    word = "";
                }
            }
            if (word.length() > 1) {
                list.add(word);
            }
        }

        Collections.sort(list);
        System.out.println(list.get(0));

    }

}