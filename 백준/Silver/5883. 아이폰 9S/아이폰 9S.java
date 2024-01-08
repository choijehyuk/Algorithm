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
        int[] arr = new int[N];
        int answer = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            boolean rem = false;
            int cnt = 1;
            int remoNum = -1;

            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] == num) {
                    cnt++;
                } else {
                    if (!rem) {
                        remoNum = arr[j];
                        rem = true;
                        continue;
                    } else if (rem && arr[j] == remoNum) {
                        continue;
                    } else {
                        break;
                    }
                }
            }

            answer = Math.max(answer, cnt);
        }
        System.out.println(answer);
    }
}