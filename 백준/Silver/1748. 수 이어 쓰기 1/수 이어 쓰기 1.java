import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuffer sb = new StringBuffer();

        int N = Integer.parseInt(br.readLine());

        int cnt = 1;
        int answer = 0;
        int length = 10;
        for (int i = 1; i <= N; i++) {
            if (i == length) {
                cnt++;
                length = length * 10;
            }
            answer += cnt;
        }
        System.out.println(answer);
    }
}