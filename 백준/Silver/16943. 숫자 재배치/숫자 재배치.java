import java.io.*;
import java.util.*;

public class Main {
    static String A;
    static int B;
    static int[] arr;
    static int answer = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        A = st.nextToken();
        B = Integer.parseInt(st.nextToken());

        arr = new int[A.length()];

        for (int i = 0; i < A.length(); i++) {
            arr[i] = A.charAt(i) - '0';
            //System.out.print(arr[i] + " ");
        }

        per(new int[arr.length], 0, new boolean[arr.length]);

        System.out.println(answer);
    }

    private static void per(int[] sel, int idx, boolean[] v) {
        if (idx == arr.length) {
            int num = 0;

            if (sel[0] == 0) return;

            for (int i = 0; i < sel.length; i++) {
                num += sel[i] * Math.pow(10, (sel.length - i - 1));
            }

            if (num < B && answer < num) {
                answer = num;
            }

            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (!v[i]) {
                v[i] = true;
                sel[idx] = arr[i];
                per(sel, idx + 1, v);
                v[i] = false;
            }
        }

    }
}