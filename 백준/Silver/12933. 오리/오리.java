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
        int[] arr = new int[6];
        int max = Integer.MIN_VALUE;
        arr[0] = s.length();

        for (int i = 0; i < s.length(); i++) {
            int check = 0;
            if (s.charAt(i) == 'q') {
                check = 1;
            }
            if (s.charAt(i) == 'u') {
                check = 2;
            }
            if (s.charAt(i) == 'a') {
                check = 3;
            }
            if (s.charAt(i) == 'c') {
                check = 4;
            }
            if (s.charAt(i) == 'k') {
                check = 5;
            }

            if (arr[check - 1] == 0) {
                System.out.println("-1");
                System.exit(0);
            }
            arr[check]++;
            arr[check - 1]--;
            max = Math.max(max, arr[1] + arr[2] + arr[3] + arr[4]);
        }

        if (arr[5] * 5 != s.length()) {
            System.out.println("-1");
            System.exit(0);
        }
        System.out.println(max);
    }
}