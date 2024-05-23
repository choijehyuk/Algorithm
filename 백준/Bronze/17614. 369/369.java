import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        int answer = 0;
        for (int i = 3; i <= N; i++) {
            String s = String.valueOf(i);
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == '3' || s.charAt(j) == '6' || s.charAt(j) == '9') {
                    answer += 1;
                }
            }
        }
        System.out.println(answer);
    }
}