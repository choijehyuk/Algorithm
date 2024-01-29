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

        String s = br.readLine();
        int cnt = s.length();

        for (int i = 0; i < s.length(); i++) {
            if (isPalin(s.substring(i))) {
                break;
            }
            cnt++;
        }
        System.out.println(cnt);
    }

    private static boolean isPalin(String substring) {
        char[] c = substring.toCharArray();

        for (int i = 0; i < Math.floor(substring.length() / 2); i++) {
            if (c[i] != c[substring.length() - 1 - i]) {
                return false;
            }
        }
        return true;
    }
}