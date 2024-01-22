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

        int G = Integer.parseInt(br.readLine());

        long[] arr = new long[100000];
        HashSet<Long> set = new HashSet<>();

        for (int i = 1; i < arr.length; i++) {
            arr[i] = (long) Math.pow(i, 2);
            set.add(arr[i]);
        }
        boolean flag = false;

        for (int i = 1; i < arr.length; i++) {
            if (set.contains(arr[i] - G)) {
                System.out.println((long) Math.sqrt(arr[i]));
                flag = true;
            }
        }

        if (!flag) System.out.println("-1");
    }
}