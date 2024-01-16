import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.*;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuffer sb = new StringBuffer();

        int X = Integer.parseInt(br.readLine());
        int[] arr = new int[10];

        String s = String.valueOf(X);
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 48]++;
        }

        int[] num = new int[10];
        for (int i = X + 1; i < Math.pow(10, s.length()); i++) {
            String ss = String.valueOf(i);
            boolean flag = true;

            for (int j = 0; j < ss.length(); j++) {
                num[ss.charAt(j) - 48]++;

                if (arr[ss.charAt(j) - 48] < num[ss.charAt(j) - 48]) {
                    Arrays.fill(num, 0);
                    flag = false;
                    break;
                }
            }

            if (flag) {
                System.out.println(i);
                System.exit(0);
            }
        }
        System.out.println(0);
    }
}