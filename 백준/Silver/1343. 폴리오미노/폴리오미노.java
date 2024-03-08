import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        String s = br.readLine();

        L:
        for (int i = 0; i < s.length(); ) {
            if (s.charAt(i) == 'X') {
                int cnt = 1;
                for (int j = i + 1; j < s.length(); j++) {
                    if (s.charAt(j) == 'X') cnt++;
                    else break;
                }

                i += cnt;

                while (cnt >= 4) {
                    sb.append("AAAA");
                    cnt -= 4;
                }

                while (cnt >= 2) {
                    sb.append("BB");
                    cnt -= 2;
                }

                if (cnt != 0) {
                    sb = new StringBuilder();
                    sb.append("-1");
                    break L;
                }
            } else {
                if (s.charAt(i) == '.') {
                    sb.append(".");
                    i++;
                }
            }
        }
        System.out.println(sb);
    }
}