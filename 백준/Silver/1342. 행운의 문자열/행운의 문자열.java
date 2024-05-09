import java.io.*;
import java.util.*;

public class Main {
    static int[] eng;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        String s = br.readLine();

        eng = new int[26];

        for (int i = 0; i < s.length(); i++) {
            eng[s.charAt(i) - 'a']++;
        }

        dfs(0, ' ', s.length());

        System.out.println(answer);

    }

    private static void dfs(int depth, char prev, int len) {
        if (depth == len) {
            answer++;
            return;
        }


        for (int i = 0; i < 26; i++) {
            if (eng[i] == 0) continue;

            if (prev != (char) (i + 'a')) {
                eng[i]--;
                dfs(depth + 1, (char) (i + 'a'), len);
                eng[i]++;
            }

        }
    }
}