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

        String pattern = br.readLine();
        String[] str = pattern.split("\\*");

        for (int i = 0; i < N; i++) {
            String s = br.readLine();

            if (s.length() < pattern.length() - 1) {
                sb.append("NE\n");
                continue;
            }

            if (s.substring(0, str[0].length()).equals(str[0]) && s.substring(s.length() - str[1].length()).equals(str[1])) {
                sb.append("DA\n");
            } else sb.append("NE\n");

        }

        System.out.println(sb);
    }


}