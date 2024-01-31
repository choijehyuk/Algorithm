import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuffer sb = new StringBuffer();

        int N = Integer.parseInt(br.readLine());
        String s = br.readLine();

        char first = s.charAt(0);

        int idx = 1;
        int cnt = 1;
        while (idx < s.length()) {
            if (s.charAt(idx) != first) {
                cnt++;
                idx++;
                while (idx < s.length()) {
                    if (s.charAt(idx) == first) break;
                    idx++;
                }
            } else {
                idx++;
            }
        }
        System.out.println(cnt);
    }
}