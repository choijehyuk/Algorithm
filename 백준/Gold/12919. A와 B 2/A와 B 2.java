import java.io.*;
import java.util.*;

public class Main {
    static String S, T;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        S = br.readLine();
        T = br.readLine();

        dfs(T);

        System.out.println(answer);

    }

    private static void dfs(String str) {
        if (str.equals(S)) {
            answer = 1;
            return;
        }

        if (str.length() == S.length()) {
            return;
        }

        if (str.charAt(str.length() - 1) == 'A') {
            dfs(str.substring(0, str.length() - 1));
        }

        if (str.charAt(0) == 'B') {
            dfs(new StringBuilder(str.substring(1)).reverse().toString());
        }
    }
}
