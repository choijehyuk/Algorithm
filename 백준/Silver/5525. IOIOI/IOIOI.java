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
        int M = Integer.parseInt(br.readLine());
        String s = br.readLine();

        String ioi = "I";

        for (int i = 0; i < N; i++) {
            ioi += "OI";
        }

        int size = N * 2 + 1;
        int answer = 0;

        for (int i = 0; i < s.length() - size + 1; i++) {
            if (s.substring(i, i + size).equals(ioi)) {
                answer++;
            }
        }
        System.out.println(answer);


    }
}