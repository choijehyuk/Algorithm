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

        int left = 1;
        int right = 1;
        int sum = 1;
        int cnt = 1;

        if(N == 1 || N == 2){
            System.out.println(1);
            System.exit(0);
        }

        while (right < N / 2 + 2) {
            if (sum == N) {
                cnt++;
                right++;
                sum += right;
            } else if (sum < N) {
                right++;
                sum += right;
            } else {
                sum -= left;
                left++;
            }
        }
        System.out.println(cnt);
    }


}